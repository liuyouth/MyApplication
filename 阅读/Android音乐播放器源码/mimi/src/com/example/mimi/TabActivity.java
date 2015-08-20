package com.example.mimi;

import java.util.ArrayList;
import java.util.List;
import com.example.mimi.MainActivity.MyBroadcastReceiver;
import com.example.mimi.R.color;
import com.example.mimi.adapter.MyFragmentAdapter;
import com.example.mimi.constant.MyConstant;
import com.example.mimi.dialog.TVAnimDialog.OnTVAnimDialogDismissListener;
import com.example.mimi.entity.Media;
import com.example.mimi.fragment.Fragment_geshou;
import com.example.mimi.fragment.Fragment_love;
import com.example.mimi.fragment.Fragment_qb;
import com.example.mimi.fragment.Fragment_zhuanji;
import com.example.mimi.fragment.Fragment_zuijin;
import com.example.mimi.list.Mylist;
import com.example.mimi.pagerstay.DepthPageTransformer;
import com.example.mimi.pagerstay.ZoomOutPageTransformer;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

public class TabActivity extends FragmentActivity implements
		OnPageChangeListener {
	private Class fragmentArray[] = { Fragment_qb.class, Fragment_love.class,
			Fragment_zhuanji.class, Fragment_geshou.class,
			Fragment_zhuanji.class };
	private List<Fragment> list;
	private String[] names = { "全部单曲", "我的最爱", "最近播放", "歌手", "专辑" };
	private ViewPager vp;
	private List<LinearLayout> viewlist = new ArrayList<LinearLayout>();
	private TextView name;
	private TextView tv_artist;
	private TextView nametab;
	private TextView time;
	private ImageView album;
	private ImageButton id_play;
	int position = 0;
	private MyBroadcastReceiver myBroadcastReceiver;
	private IntentFilter intentFilter;
	private boolean flag = true;// flag暂停还是继续的标志
	private int playmode = 1;// 当前播放模式
	private Intent broadcast;
	private Intent intent_frag;
	private int frag_id;
	private int list_arr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);
		list = new ArrayList<Fragment>();
		initView();
		initPage();
		initguangbo();

	}

	public void retyrn_player(View v) {// 返回键
		finish();
	}

	public void toplayer(View v) {
		Intent intentplayer = new Intent(this, PlayerActivity.class);
		intentplayer.putExtra("index", position);
		intentplayer.putExtra("flag", flag);
		intentplayer.putExtra("playmode", playmode);
		intentplayer.putExtra("list", list_arr);
		startActivity(intentplayer);
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
		if (position == 0) {
			position = islist(list_arr).size() - 1;

		} else {
			position -= 1;
		}
		music_play(position, MyConstant.ACTION_LAST);
		}else{
			Toast.makeText(this, "当前列表没有歌曲", 0).show();
		}
	}

	public void xia(View v) {// 下一曲
		if (Mylist.medias.size() != 0) {
		// 如果当前播放歌曲的位置是最后一首，就跳到第一首
		if (position == islist(list_arr).size() - 1) {
			position = 0;
		} else {
			position += 1;
		}
		music_play(position, MyConstant.ACTION_NEXT);
		}else{
			Toast.makeText(this, "当前列表没有歌曲", 0).show();
		}
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

	/**
	 * 给服务发送广播
	 */
	public void sendBroadcastToService(String action, int intExtra,
			String stringExtra) {
		broadcast = new Intent();
		broadcast.setAction(action);
		broadcast.putExtra("index", intExtra);
		broadcast.putExtra("date", stringExtra);
		sendBroadcast(broadcast);
	}

	/*
	 * 注册广播
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

	/**
	 * 控件初始化
	 */
	private void initView() {
		tv_artist = (TextView) findViewById(R.id.tab_main_tv_artist);
		nametab = (TextView) findViewById(R.id.tab_main_tv_name);
		time = (TextView) findViewById(R.id.tab_main_tv_time);
		album = (ImageView) findViewById(R.id.tab_iv_album);
		id_play = (ImageButton) findViewById(R.id.tab_main_ib_play);

		name = (TextView) findViewById(R.id.activity_tv_title);
		LinearLayout view1 = (LinearLayout) findViewById(R.id.hosv_view1);
		LinearLayout view2 = (LinearLayout) findViewById(R.id.hosv_view2);
		LinearLayout view3 = (LinearLayout) findViewById(R.id.hosv_view3);
		LinearLayout view4 = (LinearLayout) findViewById(R.id.hosv_view4);
		LinearLayout view5 = (LinearLayout) findViewById(R.id.hosv_view5);
		viewlist.add(view1);
		viewlist.add(view2);
		viewlist.add(view3);
		viewlist.add(view4);
		viewlist.add(view5);
		for (int i = 0; i < viewlist.size(); i++) {
			viewlist.get(i).setOnClickListener(new myonclick(i));
		}
		vp = (ViewPager) findViewById(R.id.pager);

		// 设置当前是第几个

	}

	/**
	 * 初始化Fragment
	 */
	private void initPage() {
		Fragment_qb fragment1 = new Fragment_qb();
		Fragment_love fragment2 = new Fragment_love();
		Fragment_zuijin fragment3 = new Fragment_zuijin();
		Fragment_geshou fragment4 = new Fragment_geshou();
		Fragment_zhuanji fragment5 = new Fragment_zhuanji();
		list.add(fragment1);
		list.add(fragment2);
		list.add(fragment3);
		list.add(fragment4);
		list.add(fragment5);
		vp.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), list));
		vp.setOnPageChangeListener(this);
		vp.setOffscreenPageLimit(0);
		intent_frag = getIntent();
		frag_id = intent_frag.getIntExtra("frag_id", 0);
		viewlist.get(frag_id).setBackgroundResource(color.tab_jiaodian);
		name.setText(names[frag_id]);
		vp.setCurrentItem(frag_id);
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
				setPlayText(index);// 通过收到的下标，设置播放界面的音乐信息，比如：歌名，歌手等
				// time.setText(timeconvert(islist(list_arr).get(index).getDuration()));//设置播放界面的歌曲总时长
				// sb_music.setMax(islist(list_arr).get(index).getDuration());//设置进度条最大值
				int album_id = islist(list_arr).get(index).getAlbum_id();// 通过下标拿到当前服务播放歌曲的专辑图片所在资源中的id
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
			} else if (MyConstant.ACTION_SERVICR_PUASE.equals(intent
					.getAction())) {
				// 收到服务播放的歌曲暂停的广播
				id_play.setImageResource(R.drawable.main_btn_play);
				flag = true;
			} else if (MyConstant.ACTION_MUSIC_PLAN.equals(intent.getAction())) {
				list_arr = intent.getIntExtra("list", 0);
				// 收到服务发送的播放歌曲进度的意图
				int playerPosition = intent.getIntExtra("playerPosition", 0);
				int index1 = intent.getIntExtra("index", 0);
				position = index1;
				playmode = intent.getIntExtra("playmode", 1);
				String playerTime = timeconvert(playerPosition);
				setPlayText(index1);// 通过收到的下标，设置播放界面的音乐信息，比如：歌名，歌手等
				time.setText(playerTime
						+ "--"
						+ timeconvert(islist(list_arr).get(index1)
								.getDuration()));
			}
		}

		/*
		 * 人物头像初始化
		 */
		public void imagename() {
			String a = islist(list_arr).get(position).getName();
			String[] split = a.split("-");
			System.out.println(split[0] + "```````````````````");
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
			Cursor cur = TabActivity.this.getContentResolver().query(
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

	@Override
	protected void onDestroy() {
		unregisterReceiver(myBroadcastReceiver);// 注销广播
		super.onDestroy();
	}

	/**
	 * 设置播放界面歌曲的相关信息
	 */
	public void setPlayText(int index) {
		nametab.setText(islist(list_arr).get(index).getName());
		tv_artist.setText(islist(list_arr).get(index).getSinger());
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		for (int i = 0; i < viewlist.size(); i++) {
			viewlist.get(i).setBackgroundResource(color.tab_bj);
		}
		viewlist.get(arg0).setBackgroundResource(color.tab_jiaodian);
		name.setText(names[arg0]);
	}

	@SuppressLint("ResourceAsColor")
	class myonclick implements OnClickListener {
		int i = 0;

		public myonclick(int i) {
			this.i = i;
		}

		@Override
		public void onClick(View v) {

			for (int i = 0; i < viewlist.size(); i++) {
				viewlist.get(i).setBackgroundResource(color.tab_bj);
			}
			v.setBackgroundResource(color.tab_jiaodian);
			vp.setCurrentItem(i);
			name.setText(names[i]);
		}
	}

}
