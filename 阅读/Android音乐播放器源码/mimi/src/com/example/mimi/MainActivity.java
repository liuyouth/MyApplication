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
	private boolean flag = true;// flag��ͣ���Ǽ����ı�־
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
	private ImageView istrue;// list�Ӳ���
	private int playmode = 1;// ��ǰ����ģʽ
	private View viewzibuju;// ���listview ��Ӧitem�Ӳ���
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
		unregisterReceiver(myBroadcastReceiver);// ע���㲥
		listtosd();// ����list��SD��
		super.onDestroy();
	}
	//��ʼ��֪ͨ
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
		notification.tickerText="MIMI�����ѽ�����";
		remoteViews = new RemoteViews(getPackageName(), R.layout.tongzhi);
		String a = islist(list_arr).get(position).getName();
		String[] split = a.split("-");
		switch (split[0]) {
		case "�ܽ��� ":
			remoteViews.setImageViewResource(R.id.tongzhi_image, R.drawable.zjl);
			break;
		case "���ٺ� ":
			remoteViews.setImageViewResource(R.id.tongzhi_image, R.drawable.lrh);
			break;
		case "�ֿ��� ":
			remoteViews.setImageViewResource(R.id.tongzhi_image, R.drawable.ljj);
			break;
		case "�ֿ��ܡ������� ":
			remoteViews.setImageViewResource(R.id.tongzhi_image, R.drawable.ljj);
			break;
		case "���� ":
			remoteViews.setImageViewResource(R.id.tongzhi_image, R.drawable.hj);
			break;
		case "������ ":
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
		remoteViews.setTextViewText(R.id.tongzhi_time, "ʱ��:"+timeconvert(islist(list_arr).get(position).getDuration()));
		
			
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
	 * ͨ�������������Ǹ�����
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

	public void start(View v) {// ��ʼ��ͣ��ť
		if (Mylist.medias.size() != 0) {
			if (flag) {
				// ���Ͳ��Ź㲥
				sendBroadcastToService(MyConstant.ACTION_PLAY, 0, null);
				id_play.setImageResource(R.drawable.main_btn_pause);
			} else {
				// ������ͣ�㲥
				sendBroadcastToService(MyConstant.ACTION_PAUSE, 0, null);
				id_play.setImageResource(R.drawable.main_btn_play);
			}
			flag = !flag;
		}else{
			Toast.makeText(this, "��ǰ�б�û�и���", 0).show();
		}
	}

	public void shang(View v) {// ��һ��
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
			Toast.makeText(this, "��ǰ�б�û�и���", 0).show();
		}
	}

	public void xia(View v) {// ��һ��
		if (Mylist.medias.size() != 0) {
			// �����ǰ���Ÿ�����λ�������һ�ף���������һ��
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
			Toast.makeText(this, "��ǰ�б�û�и���", 0).show();
		}
	}

	/**
	 * �������͹㲥
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
	 * @param index�����������±�
	 * @param action��������
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
	 * ������Ŀ�ı����
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

	private void initmusic() {// ��ʼ��������ȡ
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

				// ȡ������
				fileInputStream = new FileInputStream(file.toString());
				objectInputStream = new ObjectInputStream(fileInputStream);
				ArrayList<Media> savedArrayList = (ArrayList<Media>) objectInputStream
						.readObject();

				for (int i = 0; i < savedArrayList.size(); i++) {
					Mylist.medias.add(savedArrayList.get(i));
				}
			} catch (Exception e) {
				System.out.println("���϶�ȡ����");
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
	 * ���ò��Ž�������������Ϣ
	 */
	public void setPlayText(int index) {
		name.setText(islist(list_arr).get(index).getName());
		tv_artist.setText(islist(list_arr).get(index).getSinger());
	}

	/**
	 * �Զ���Ĺ㲥������
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
				// �յ����񲥷ŵĸ�����ͣ�Ĺ㲥
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
				// �յ������͵Ĳ��Ÿ������ȵ���ͼ
				int playerPosition = intent.getIntExtra("playerPosition", 0);
				int index1 = intent.getIntExtra("index", 0);
				position = index1;
				playmode = intent.getIntExtra("playmode", 1);
				String playerTime = timeconvert(playerPosition);
				setPlayText(index1);// ͨ���յ����±꣬���ò��Ž����������Ϣ�����磺���������ֵ�
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
				setPlayText(index);// ͨ���յ����±꣬���ò��Ž����������Ϣ�����磺���������ֵ�
				// time.setText(timeconvert(Mylist.medias.get(index).getDuration()));//���ò��Ž���ĸ�����ʱ��
				// sb_music.setMax(Mylist.medias.get(index).getDuration());//���ý��������ֵ
				int album_id = Mylist.medias.get(index).getAlbum_id();// ͨ���±��õ���ǰ���񲥷Ÿ�����ר��ͼƬ������Դ�е�id
				String albumArt = getAlbumArt(album_id);// ��ͨ����Դid�õ�ר����ʵ��·��
				Bitmap bm = null;
				// ���ר����·���ǿյģ�������ר��ͼƬΪĬ��ͼƬ
				if (albumArt != null) {
					bm = BitmapFactory.decodeFile(albumArt);// ͬ��BitmapFactory.decodeFile�õ�����λͼ
					BitmapDrawable bmpDraw = new BitmapDrawable(bm);
					album.setImageDrawable(bmpDraw); // ����ר��ͼƬ
				} else {
					imagename(); // ����ר��ͼƬ
				}
			}
		}

		/*
		 * ����ͷ���ʼ��
		 */
		public void imagename() {
			String a = islist(list_arr).get(position).getName();
			String[] split = a.split("-");
			switch (split[0]) {
			case "�ܽ��� ":
				album.setImageResource(R.drawable.zjl);
				break;
			case "���ٺ� ":
				album.setImageResource(R.drawable.lrh);
				break;
			case "�ֿ��� ":
				album.setImageResource(R.drawable.ljj);
				break;
			case "�ֿ��ܡ������� ":
				album.setImageResource(R.drawable.ljj);
				break;
			case "���� ":
				album.setImageResource(R.drawable.hj);
				break;
			case "������ ":
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
		 * �õ�ר��ͼƬ��·��
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
			System.out.println("���ų�����");
		}
	}

	/*
	 * ���л�list ���浽SD��
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
			System.out.println("���ϱ������");
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
	 * ����ʱ���ʽת��
	 */
	public String timeconvert(int time) {
		int min = 0, hour = 0;
		time /= 1000;
		min = time / 60;
		time %= 60;
		return min + ":" + time;
	}

}
