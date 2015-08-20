package com.example.mimi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mimi.adapter.MyListViewAdapter;
import com.example.mimi.adapter.Mymenulistviewadapter;
import com.example.mimi.constant.MyConstant;
import com.example.mimi.entity.Media;
import com.example.mimi.list.Mylist;
import com.example.mimi.service.MusicService;

public class MainActivity extends Activity {
	private boolean flag = true;// flag暂停还是继续的标志
	private ListView listview;
	private MyListViewAdapter adapter;
	private Intent intent, broadcast;
	int position = 0;
	private IntentFilter intentFilter;
	private MyBroadcastReceiver myBroadcastReceiver;
	private TextView tv_artist;
	private TextView name;
	private TextView time;
	private ImageView album;
	private ImageButton id_play;
	private ImageView istrue;// list子布局
	private int playmode = 1;// 当前播放模式
	private View viewzibuju;// 获得listview 相应item子布局
	private LinearLayout isbj;
	private Media me = new Media();
	private int list_arr = 0;
	private ListView menu;
	private Mymenulistviewadapter mymenulistviewadapter;
	private NotificationManager systemService;
	private RemoteViews remoteViews;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview = (ListView) findViewById(R.id.listview);
		tv_artist = (TextView) findViewById(R.id.activity_main_tv_artist);
		name = (TextView) findViewById(R.id.activity_main_tv_name);
		time = (TextView) findViewById(R.id.activity_main_tv_time);
		album = (ImageView) findViewById(R.id.activity_iv_album);
		id_play = (ImageButton) findViewById(R.id.activity_main_ib_play);
		initmusic();
		initguangbo();
		initfuwu();
		initmenu();
		if(Mylist.medias.size()!=0){
		inittongzhi();
		}
		
		if (position >= listview.getFirstVisiblePosition()
				&& position <= listview.getLastVisiblePosition()) {
			viewzibuju = listview.getChildAt(position
					- listview.getFirstVisiblePosition());
		} else {
			if (istrue != null) {
				istrue.setImageBitmap(null);
				isbj.setBackgroundColor(0);
			}
		}
		listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				MainActivity.this.position = position;
				music_play(position, MyConstant.ACTION_LIST);
				itemview(view);
			}
		});
	}

	@Override
	protected void onDestroy() {
		unregisterReceiver(myBroadcastReceiver);// 注销广播
		listtosd();// 保存list到SD卡
		super.onDestroy();
	}
	//初始化通知
	public void inittongzhi(){
		systemService = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		texttongzhi();
		new Thread(){
			public void run() {
				while (true) {
					try {
						Thread.sleep(500);
						mhandle.sendEmptyMessage(0);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
	}
	Handler mhandle=new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==0){
				texttongzhi();
			}
		};
	};
	private void texttongzhi() {
		Notification notification = new Notification();
		notification.icon=R.drawable.ic_launcher;
		notification.when=System.currentTimeMillis();
		notification.tickerText="MIMI音乐已近启动";
		remoteViews = new RemoteViews(getPackageName(), R.layout.tongzhi);
		String a = islist(list_arr).get(position).getName();
		String[] split = a.split("-");
		switch (split[0]) {
		case "周杰伦 ":
			remoteViews.setImageViewResource(R.id.tongzhi_image, R.drawable.zjl);
			break;
		case "李荣浩 ":
			remoteViews.setImageViewResource(R.id.tongzhi_image, R.drawable.lrh);
			break;
		case "林俊杰 ":
			remoteViews.setImageViewResource(R.id.tongzhi_image, R.drawable.ljj);
			break;
		case "林俊杰、邓紫棋 ":
			remoteViews.setImageViewResource(R.id.tongzhi_image, R.drawable.ljj);
			break;
		case "何炅 ":
			remoteViews.setImageViewResource(R.id.tongzhi_image, R.drawable.hj);
			break;
		case "邓紫棋 ":
			remoteViews.setImageViewResource(R.id.tongzhi_image, R.drawable.dzq);
			break;
		case "TFBOYS ":
			remoteViews.setImageViewResource(R.id.tongzhi_image, R.drawable.tfboys);
			break;
		default:
			remoteViews.setImageViewResource(R.id.tongzhi_image, R.drawable.main_img_album);
			break;
		}
		remoteViews.setTextViewText(R.id.tongzhi_name, islist(list_arr).get(position).getName());
		remoteViews.setTextViewText(R.id.tongzhi_geshou, islist(list_arr).get(position).getSinger());
		remoteViews.setTextViewText(R.id.tongzhi_time, "时长:"+timeconvert(islist(list_arr).get(position).getDuration()));
		
			
		if(!flag){
			remoteViews.setImageViewResource(R.id.tongzhi_play, R.drawable.main_btn_pause);
		}else{
			remoteViews.setImageViewResource(R.id.tongzhi_play, R.drawable.main_btn_play);
		}
		Intent broadcast11 = new Intent();
		broadcast11.setAction(MyConstant.TONGZHI_ZHONGJIAN);
		PendingIntent intent2 = PendingIntent.getBroadcast(this, 1, broadcast11, 0);
		remoteViews.setOnClickPendingIntent(R.id.tongzhi_play, intent2);
		
		Intent broadcast1 = new Intent();
		broadcast1.setAction(MyConstant.TONGZHI_LAST);
		PendingIntent intent3 = PendingIntent.getBroadcast(this, 2, broadcast1, 0);
		remoteViews.setOnClickPendingIntent(R.id.tongzhi_previous, intent3);
		
		Intent broadcast2 = new Intent();
		broadcast2.setAction(MyConstant.TONGZHI_NEXT);
		PendingIntent intent4 = PendingIntent.getBroadcast(this, 3, broadcast2, 0);
		remoteViews.setOnClickPendingIntent(R.id.tongzhi_next, intent4);
		
		
		notification.contentView=remoteViews;
		systemService.notify(0, notification);
	}
	
	private void initmenu() {
		menu = (ListView) findViewById(R.id.listviewmenu);
		mymenulistviewadapter = new Mymenulistviewadapter(this);
		menu.setAdapter(mymenulistviewadapter);
		menu.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 0:
					Intent intent = new Intent(MainActivity.this,
							ScanningActivity.class);
					startActivity(intent);
					break;
				case 1:
					Intent intent1 = new Intent(MainActivity.this,
							ScanbjActivity.class);
					startActivity(intent1);
					break;
				case 2:

					break;
				case 3:

					break;
				case 4:
					Intent broadcastexit = new Intent();
					broadcastexit.setAction(MyConstant.ACTIVITY_EXIT);
					sendBroadcast(broadcastexit);
					Intent intentexit = new Intent(MainActivity.this, MusicService.class);
					stopService(intentexit);
					systemService.cancel(0);
					System.exit(0);
					break;
				}
			}
		});
	}

	private void initfuwu() {
		Intent service = new Intent(this, MusicService.class);
		startService(service);
	}

	public void toplayer(View v) {
		Intent intentplayer = new Intent(this, PlayerActivity.class);
		intentplayer.putExtra("index", position);
		intentplayer.putExtra("flag", flag);
		intentplayer.putExtra("playmode", playmode);
		intentplayer.putExtra("list", list_arr);
		startActivity(intentplayer);
	}

	/*
	 * 通过常量返回是那个集合
	 */
	public List<Media> islist(int list) {
		if (list == MyConstant.LIST_QB) {
			return Mylist.medias;
		} else if (list == MyConstant.LIST_love) {
			return Mylist.love;
		} else if (list == MyConstant.LIST_zuijin) {
			return Mylist.zuijin;
		} else if (list == MyConstant.LIST_ZHUANJI) {
			return Mylist.gequzj;
		} else {
			return Mylist.gequ;
		}
	}

	public void start(View v) {// 开始暂停按钮
		if (Mylist.medias.size() != 0) {
			if (flag) {
				// 发送播放广播
				sendBroadcastToService(MyConstant.ACTION_PLAY, 0, null);
				id_play.setImageResource(R.drawable.main_btn_pause);
			} else {
				// 发送暂停广播
				sendBroadcastToService(MyConstant.ACTION_PAUSE, 0, null);
				id_play.setImageResource(R.drawable.main_btn_play);
			}
			flag = !flag;
		}else{
			Toast.makeText(this, "当前列表没有歌曲", 0).show();
		}
	}

	public void shang(View v) {// 上一曲
		if (Mylist.medias.size() != 0) {
			try {
				if (position == 0) {
					position = islist(list_arr).size() - 1;

				} else {
					position -= 1;
				}
			} catch (Exception e) {
				if (position == 0) {
					position = Mylist.medias.size() - 1;

				} else {
					position -= 1;
				}
			}
			music_play(position, MyConstant.ACTION_LAST);
			if (position >= listview.getFirstVisiblePosition()
					&& position <= listview.getLastVisiblePosition()) {
				viewzibuju = listview.getChildAt(position
						- listview.getFirstVisiblePosition());
				itemview(viewzibuju);
			} else {
				if (istrue != null) {
					istrue.setImageBitmap(null);
					isbj.setBackgroundColor(0);
				}
			}
		}else{
			Toast.makeText(this, "当前列表没有歌曲", 0).show();
		}
	}

	public void xia(View v) {// 下一曲
		if (Mylist.medias.size() != 0) {
			// 如果当前播放歌曲的位置是最后一首，就跳到第一首
			try {
				if (position == islist(list_arr).size() - 1) {
					position = 0;
				} else {
					position += 1;
				}
			} catch (Exception e) {
				if (position == Mylist.medias.size() - 1) {
					position = 0;
				} else {
					position += 1;
				}
			}
			music_play(position, MyConstant.ACTION_NEXT);
			if (position >= listview.getFirstVisiblePosition()
					&& position <= listview.getLastVisiblePosition()) {
				viewzibuju = listview.getChildAt(position
						- listview.getFirstVisiblePosition());
				itemview(viewzibuju);
			} else {
				if (istrue != null) {
					istrue.setImageBitmap(null);
					isbj.setBackgroundColor(0);
				}
			}
		}else{
			Toast.makeText(this, "当前列表没有歌曲", 0).show();
		}
	}

	/**
	 * 给服务发送广播
	 */
	public void sendBroadcastToService(String action, int intExtra,
			String stringExtra) {
		broadcast = new Intent();
		broadcast.setAction(action);
		broadcast.putExtra("index", intExtra);
		broadcast.putExtra("date", stringExtra);
		broadcast.putExtra("list", list_arr);
		sendBroadcast(broadcast);
	}

	/**
	 * @param index歌曲的索引下标
	 * @param action按键动作
	 */
	public void music_play(int index, String action) {
		broadcast = new Intent();
		broadcast.setAction(action);
		broadcast.putExtra("index", index);
		sendBroadcast(broadcast);
		if (flag) {
			flag = !flag;
		}
	}

	/*
	 * 单机条目改变歌曲
	 */
	private void initguangbo() {
		myBroadcastReceiver = new MyBroadcastReceiver();
		intentFilter = new IntentFilter();
		intentFilter.addAction(MyConstant.ACTION_PlAYING_STATE);
		intentFilter.addAction(MyConstant.ACTION_SERVICR_PUASE);
		intentFilter.addAction(MyConstant.ACTION_MUSIC_PLAN);
		intentFilter.addAction(MyConstant.ACTION_ACTIVITY_INITLIST);
		registerReceiver(myBroadcastReceiver, intentFilter);
	}

	private void initmusic() {// 初始化歌曲读取
		if (Mylist.medias.size() == 0) {
			FileOutputStream fileOutputStream = null;
			ObjectOutputStream objectOutputStream = null;
			FileInputStream fileInputStream = null;
			ObjectInputStream objectInputStream = null;
			try {
				File file = new File(Environment.getExternalStorageDirectory()
						.toString()
						+

						File.separator
						+ "ContactBackup"
						+ File.separator
						+ "backup.dat");

				if (!file.exists()) {
					file.createNewFile();
				}

				// 取出数据
				fileInputStream = new FileInputStream(file.toString());
				objectInputStream = new ObjectInputStream(fileInputStream);
				ArrayList<Media> savedArrayList = (ArrayList<Media>) objectInputStream
						.readObject();

				for (int i = 0; i < savedArrayList.size(); i++) {
					Mylist.medias.add(savedArrayList.get(i));
				}
			} catch (Exception e) {
				System.out.println("集合读取错误");
				e.printStackTrace();
			} finally {
				if (objectOutputStream != null) {
					try {
						objectOutputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (fileOutputStream != null) {
					try {
						fileOutputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (objectInputStream != null) {
					try {
						objectInputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (fileInputStream != null) {
					try {
						fileInputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			if(Mylist.medias.size()!=0){
			initshuju();
			}
		}
		adapter = new MyListViewAdapter(MainActivity.this, Mylist.medias);
		listview.setAdapter(adapter);
	}

	/**
	 * 设置播放界面歌曲的相关信息
	 */
	public void setPlayText(int index) {
		name.setText(islist(list_arr).get(index).getName());
		tv_artist.setText(islist(list_arr).get(index).getSinger());
	}

	/**
	 * 自定义的广播接收者
	 */
	public class MyBroadcastReceiver extends BroadcastReceiver {
		private int index;

		@Override
		public void onReceive(Context context, Intent intent) {
			if (MyConstant.ACTION_PlAYING_STATE.equals(intent.getAction())) {
				list_arr = intent.getIntExtra("list", 0);
				index = intent.getIntExtra("media", 0);
				position = index;
				id_play.setImageResource(R.drawable.main_btn_pause);
				flag = false;

			} else if (MyConstant.ACTION_SERVICR_PUASE.equals(intent
					.getAction())) {
				// 收到服务播放的歌曲暂停的广播
				id_play.setImageResource(R.drawable.main_btn_play);
				flag = true;
			} else if (MyConstant.ACTION_ACTIVITY_INITLIST.equals(intent
					.getAction())) {
				boolean isDelete = intent.getBooleanExtra("isDelete", false);
				if (isDelete) {
					initshuju();
				} else {
					initmusic();
				}
			}
			else if (MyConstant.ACTION_MUSIC_PLAN.equals(intent.getAction())) {
				list_arr = intent.getIntExtra("list", 0);
				// 收到服务发送的播放歌曲进度的意图
				int playerPosition = intent.getIntExtra("playerPosition", 0);
				int index1 = intent.getIntExtra("index", 0);
				position = index1;
				playmode = intent.getIntExtra("playmode", 1);
				String playerTime = timeconvert(playerPosition);
				setPlayText(index1);// 通过收到的下标，设置播放界面的音乐信息，比如：歌名，歌手等
				time.setText(playerTime + "--"
						+ timeconvert(Mylist.medias.get(index1).getDuration()));
				if (position >= listview.getFirstVisiblePosition()
						&& position <= listview.getLastVisiblePosition()) {
					viewzibuju = listview.getChildAt(position
							- listview.getFirstVisiblePosition());
					itemview(viewzibuju);
				} else {
					if (istrue != null) {
						istrue.setImageBitmap(null);
						isbj.setBackgroundColor(0);
					}
				}
				setPlayText(index);// 通过收到的下标，设置播放界面的音乐信息，比如：歌名，歌手等
				// time.setText(timeconvert(Mylist.medias.get(index).getDuration()));//设置播放界面的歌曲总时长
				// sb_music.setMax(Mylist.medias.get(index).getDuration());//设置进度条最大值
				int album_id = Mylist.medias.get(index).getAlbum_id();// 通过下标拿到当前服务播放歌曲的专辑图片所在资源中的id
				String albumArt = getAlbumArt(album_id);// 再通过资源id拿到专辑的实际路径
				Bitmap bm = null;
				// 如果专辑的路径是空的，就设置专辑图片为默认图片
				if (albumArt != null) {
					bm = BitmapFactory.decodeFile(albumArt);// 同过BitmapFactory.decodeFile拿到具体位图
					BitmapDrawable bmpDraw = new BitmapDrawable(bm);
					album.setImageDrawable(bmpDraw); // 设置专辑图片
				} else {
					imagename(); // 设置专辑图片
				}
			}
		}

		/*
		 * 人物头像初始化
		 */
		public void imagename() {
			String a = islist(list_arr).get(position).getName();
			String[] split = a.split("-");
			switch (split[0]) {
			case "周杰伦 ":
				album.setImageResource(R.drawable.zjl);
				break;
			case "李荣浩 ":
				album.setImageResource(R.drawable.lrh);
				break;
			case "林俊杰 ":
				album.setImageResource(R.drawable.ljj);
				break;
			case "林俊杰、邓紫棋 ":
				album.setImageResource(R.drawable.ljj);
				break;
			case "何炅 ":
				album.setImageResource(R.drawable.hj);
				break;
			case "邓紫棋 ":
				album.setImageResource(R.drawable.dzq);
				break;
			case "TFBOYS ":
				album.setImageResource(R.drawable.tfboys);
				break;
			default:
				album.setImageResource(R.drawable.main_img_album);
				break;
			}
		}

		/**
		 * 拿到专辑图片的路径
		 */
		private String getAlbumArt(int album_id) {
			String mUriAlbums = "content://media/external/audio/albums";
			String[] projection = new String[] { "album_art" };
			Cursor cur = MainActivity.this.getContentResolver().query(
					Uri.parse(mUriAlbums + "/" + Integer.toString(album_id)),
					projection, null, null, null);
			String album_art = null;
			if (cur.getCount() > 0 && cur.getColumnCount() > 0) {
				cur.moveToNext();
				album_art = cur.getString(0);
			}
			cur.close();
			cur = null;
			return album_art;
		}
	}

	private void itemview(View view1) {
		try {
			if (istrue != null) {
				istrue.setImageBitmap(null);
				isbj.setBackgroundColor(0);
			}
			istrue = (ImageView) view1.findViewById(R.id.listview_zibuju_true);
			isbj = (LinearLayout) view1.findViewById(R.id.listview_zibuju_head);
			isbj.setBackgroundResource(R.drawable.img_background_post_pressed);
			istrue.setImageResource(R.drawable.istrue);
		} catch (Exception e) {
			System.out.println("播放出错了");
		}
	}

	/*
	 * 序列化list 保存到SD卡
	 */

	public void listtosd() {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			File file = new File(Environment.getExternalStorageDirectory()
					.toString() +

			File.separator + "ContactBackup" + File.separator + "backup.dat");

			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}

			if (!file.exists()) {
				file.createNewFile();
			}

			fileOutputStream = new FileOutputStream(file.toString());
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(Mylist.medias);

		} catch (Exception e) {
			System.out.println("集合保存错误");
		} finally {
			if (objectOutputStream != null) {
				try {
					objectOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (objectInputStream != null) {
				try {
					objectInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void initshuju() {
		Mylist.love.removeAll(Mylist.love);
		Mylist.zuijin.removeAll(Mylist.zuijin);
		Mylist.geshou.removeAll(Mylist.geshou);
		Mylist.zhuanji.removeAll(Mylist.zhuanji);
		Media gs = null;
		Media zj = null;
		for (Media me : Mylist.medias) {

			System.out.println(me.getSinger());
			if (me.isIsplar()) {
				Mylist.zuijin.add(me);
			}
			if (me.isLove()) {
				Mylist.love.add(me);
			}
			if (gs == null) {
				gs = me;
			} else {
				if (!gs.getSinger().equals(me.getSinger())) {
					Mylist.geshou.add(me);
					gs = me;
				}
			}
			if (zj == null) {
				zj = me;
			} else {
				if (!zj.getAlbum().equals(me.getAlbum())) {
					Mylist.zhuanji.add(me);
					zj = me;
				}
			}
		}
	}

	/**
	 * 歌曲时间格式转换
	 */
	public String timeconvert(int time) {
		int min = 0, hour = 0;
		time /= 1000;
		min = time / 60;
		time %= 60;
		return min + ":" + time;
	}

}
