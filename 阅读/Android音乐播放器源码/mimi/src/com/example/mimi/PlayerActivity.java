package com.example.mimi;

import java.util.ArrayList;
import java.util.List;

import com.example.mimi.R;
import com.example.mimi.adapter.Viewpageradapter;
import com.example.mimi.constant.MyConstant;
import com.example.mimi.constant.Myhandler;
import com.example.mimi.entity.Media;
import com.example.mimi.list.Mylist;
import com.example.mimi.lyr.LrcView;
import com.example.mimi.lyr.LyricItem;
import com.example.mimi.lyr.LyricParser;
import com.example.mimi.pagerstay.ZoomOutPageTransformer;
import com.example.mimi.service.MusicService;
import com.example.mimi.spectrum.VisualizerView;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class PlayerActivity extends Activity {
	private static final String Spinner = null;
	boolean flag = true;// �ж��ǲ��Ż�����ͣ
	private TextView name;
	private TextView kstime;
	private TextView jstime;
	private SeekBar seek;
	private ImageButton mode;
	private ImageView start;
	int position = 0;
	private MyBroadcastReceiver myBroadcastReceiver;
	private IntentFilter intentFilter;
	private Intent broadcast;
	private List<LyricItem> parser = null;// ��ʼ���
	private int playerPosition;// ��ǰ���Ž���
	private int list_arr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);
		name = (TextView) findViewById(R.id.player_id_name);
		kstime = (TextView) findViewById(R.id.player_id_kstime);
		jstime = (TextView) findViewById(R.id.player_tv_jstime);
		seek = (SeekBar) findViewById(R.id.player_seek);
		mode = (ImageButton) findViewById(R.id.player_ib_mode);// ѭ��ģʽ
		start = (ImageView) findViewById(R.id.player_ib_play);// ������ͣ
		iv_love = (ImageView) findViewById(R.id.player_iv_love);
		flipper2 = (ViewFlipper) findViewById(R.id.play_flipper);
		loveimage = (ImageButton) findViewById(R.id.player_ib_favorite);
		play_bj = (LinearLayout) findViewById(R.id.play_bj);
		Intent intentfuwu = new Intent(this, MusicService.class);
		startService(intentfuwu);
		initviewpager();// ��ʼ��viewpager
		initspq();// ע��㲥
		init();// ��MainActivity��������س�ʼ��
		if (Mylist.medias.size() != 0) {
			imagename();// ��ʼ������ͼƬ
			lrcint();// ��ʼ�����
			// ��ʼ��������
			p3_vlv.setupVisualizerFx(islist(list_arr).get(position)
					.getAudioSessionId());
		}
		seek.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				Intent intent = new Intent();
				intent.setAction(MyConstant.ACTION_PLAN_CURRENT);
				intent.putExtra("index", seekBar.getProgress());
				sendBroadcast(intent);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
			}
		});
	}

	private void init() {
		Intent intent = getIntent();
		int index1 = intent.getIntExtra("index", 0);
		boolean flag1 = intent.getBooleanExtra("flag", false);
		int playmode = intent.getIntExtra("playmode", 1);
		list_arr = intent.getIntExtra("list", 0);
		position = index1;
		bomode = playmode;
		switch (playmode) {
		case 1:
			mode.setImageResource(R.drawable.player_btn_mode_normal_style);
			break;
		case 2:
			mode.setImageResource(R.drawable.player_btn_mode_random_style);// ���
			break;
		case 3:
			mode.setImageResource(R.drawable.player_btn_mode_repeat_all_style);// ѭ��
			break;
		case 4:
			mode.setImageResource(R.drawable.player_btn_mode_repeat_one_style);// ����
			break;
		}
		bomode = playmode;
		if (flag1 != flag) {
			flag = flag1;
			start.setImageResource(R.drawable.player_btn_pause_style);
		}
		if (Mylist.medias.size() != 0) {
			name.setText(islist(list_arr).get(index1).getName());
			jstime.setText(timeconvert(islist(list_arr).get(index1)
					.getDuration()));// ���ò��Ž���ĸ�����ʱ��
			seek.setMax(islist(list_arr).get(index1).getDuration());
			if (islist(list_arr).get(position).isLove()) {
				loveimage
						.setImageResource(R.drawable.player_btn_favorite_star_style);
			}
			new myinit().start();
		}
	}

	Handler mhandler = new Handler() {// �����߳�
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case Myhandler.INIT_LOVE_TRUE:
				loveimage
						.setImageResource(R.drawable.player_btn_favorite_star_style);
				break;
			case Myhandler.INIT_LOVE_FLOAT:
				loveimage
						.setImageResource(R.drawable.player_btn_favorite_nostar_style);
				break;
			}
		};
	};

	class myinit extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Message message = mhandler.obtainMessage();
					if (islist(list_arr).get(position).isLove()) {
						mhandler.sendEmptyMessage(Myhandler.INIT_LOVE_TRUE);
					} else {
						mhandler.sendEmptyMessage(Myhandler.INIT_LOVE_FLOAT);
					}
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void initviewpager() {
		viewlist = new ArrayList<View>();
		// ��ʼ��viewpager
		viewpager = (ViewPager) findViewById(R.id.player_id_viewpager);
		// ������Ч
		viewpager.setPageTransformer(true, new ZoomOutPageTransformer());
		page1 = View.inflate(this, R.layout.page1, null);
		page2 = View.inflate(this, R.layout.page2, null);
		page3 = View.inflate(this, R.layout.page3, null);
		viewlist.add(page1);
		viewlist.add(page2);
		viewlist.add(page3);
		Viewpageradapter viewpageradapter = new Viewpageradapter(viewlist, this);
		viewpager.setAdapter(viewpageradapter);
		tv_lrc = (LrcView) page2.findViewById(R.id.lrcShowView);
		tv_lrc1 = (TextView) page1.findViewById(R.id.tv);
		tv_lrc11 = (TextView) page1.findViewById(R.id.tv1);
		p3_tv = (TextView) page3.findViewById(R.id.tv);
		p3_tv1 = (TextView) page3.findViewById(R.id.tv1);
		p3_tv3 = (TextView) page3.findViewById(R.id.tv2);
		p3_tv2 = (TextView) page3.findViewById(R.id.tv3);
		p3_vlv = (VisualizerView) page3.findViewById(R.id.vlv);
		flipper = (ViewFlipper) page3.findViewById(R.id.flipper);
		flipper.startFlipping();
		flipper.setInAnimation(AnimationUtils.loadAnimation(
				PlayerActivity.this, R.anim.push_up_in));
		flipper.setOutAnimation(AnimationUtils.loadAnimation(
				PlayerActivity.this, R.anim.push_up_out));

	}

	private void initspq() {
		myBroadcastReceiver = new MyBroadcastReceiver();
		intentFilter = new IntentFilter();
		intentFilter.addAction(MyConstant.ACTION_PlAYING_STATE);
		intentFilter.addAction(MyConstant.ACTION_SERVICR_PUASE);
		intentFilter.addAction(MyConstant.ACTION_MUSIC_PLAN);
		registerReceiver(myBroadcastReceiver, intentFilter);

	}

	public void retyrn_player(View v) {// ���ؼ�
		initlistview();
		finish();
	}

	public void initlistview() {// ���͸���listview�㲥
		broadcast = new Intent();
		broadcast.setAction(MyConstant.ACTION_INITLIST);
		sendBroadcast(broadcast);
	}

	public void start(View v) {// ��ʼ��ͣ��ť
		if (Mylist.medias.size() != 0) {
			if (flag) {
				// ���Ͳ��Ź㲥
				sendBroadcastToService(MyConstant.ACTION_PLAY, 0, null);
				start.setImageResource(R.drawable.player_btn_pause_style);
			} else {
				// ������ͣ�㲥
				sendBroadcastToService(MyConstant.ACTION_PAUSE, 0, null);
				start.setImageResource(R.drawable.player_btn_play_style);
			}
			flag = !flag;
		} else {
			Toast.makeText(this, "��ǰ�б�û�и���", 0).show();
		}
	}

	public void shang(View v) {// ��һ��
		if (Mylist.medias.size() != 0) {
			if (position == 0) {
				position = islist(list_arr).size() - 1;

			} else {
				position -= 1;
			}
			music_play(position, MyConstant.ACTION_LAST);
		} else {
			Toast.makeText(this, "��ǰ�б�û�и���", 0).show();
		}
	}

	public void xia(View v) {// ��һ��
		if (Mylist.medias.size() != 0) {
			// �����ǰ���Ÿ�����λ�������һ�ף���������һ��
			if (position == islist(list_arr).size() - 1) {
				position = 0;
			} else {
				position += 1;
			}
			music_play(position, MyConstant.ACTION_NEXT);
		} else {
			Toast.makeText(this, "��ǰ�б�û�и���", 0).show();
		}
	}

	int bomode = 1;
	private ViewPager viewpager;
	private Intent playmode;
	private ImageView iv_love;
	private ImageButton loveimage;
	private LrcView tv_lrc;
	private View page2;
	private View page1;
	private View page3;
	private List<View> viewlist;
	private TextView tv_lrc1;
	private TextView tv_lrc11;

	public void xhms(View v) {// ѭ��ģʽ
		bomode++;
		if (bomode > 4) {
			bomode = 1;
		}
		switch (bomode) {
		case 1:
			mode.setImageResource(R.drawable.player_btn_mode_normal_style);
			Toast.makeText(this, "˳�򲥷�", 0).show();
			break;
		case 2:
			mode.setImageResource(R.drawable.player_btn_mode_random_style);// ���
			Toast.makeText(this, "�������", 0).show();
			break;
		case 3:
			mode.setImageResource(R.drawable.player_btn_mode_repeat_all_style);// ѭ��
			Toast.makeText(this, "ѭ������", 0).show();
			break;
		case 4:
			mode.setImageResource(R.drawable.player_btn_mode_repeat_one_style);// ����
			Toast.makeText(this, "����ѭ��", 0).show();
			break;
		}
		play_mode(bomode, MyConstant.ACTION_BFMODE);
	}

	public void shoucang(View v) {// �ղ�
		if (Mylist.medias.size() != 0) {
			if (!islist(list_arr).get(position).isLove()) {
				ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv_love,
						"alpha", 0, 1.0f);
				// ���ö���������ʱ��
				objectAnimator.setDuration(500);
				// ����������
				objectAnimator.start();
				ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(
						iv_love, "alpha", 1.0f, 0);
				objectAnimator1.setStartDelay(500);
				// ���ö���������ʱ��
				objectAnimator1.setDuration(500);
				// ����������
				objectAnimator1.start();
				loveimage
						.setImageResource(R.drawable.player_btn_favorite_star_style);
				islist(list_arr).get(position).setLove(true);
			} else {
				loveimage
						.setImageResource(R.drawable.player_btn_favorite_nostar_style);
				islist(list_arr).get(position).setLove(false);
			}
		} else {
			Toast.makeText(this, "��ǰ�б�û�и���", 0).show();
		}
	}

	/**
	 * �Զ���Ĺ㲥������
	 */
	@SuppressLint("SdCardPath")
	public class MyBroadcastReceiver extends BroadcastReceiver {
		private int index;

		@Override
		public void onReceive(Context context, Intent intent) {

			if (MyConstant.ACTION_PlAYING_STATE.equals(intent.getAction())) {
				list_arr = intent.getIntExtra("list", 0);
				index = intent.getIntExtra("media", 0);
				position = index;
				start.setImageResource(R.drawable.player_btn_pause_style);
				flag = false;

				lrcint();// ��ʼ�����
				imagename();// ��ʼ������ͼƬ
				tv_lrc1.setText(islist(list_arr).get(position).getName());
				tv_lrc11.setText(islist(list_arr).get(position).getSinger());
				p3_vlv.setupVisualizerFx(islist(list_arr).get(position)
						.getAudioSessionId());
			} else if (MyConstant.ACTION_SERVICR_PUASE.equals(intent
					.getAction())) {

				imagename();// ��ʼ������ͼƬ
				// �յ����񲥷ŵĸ�����ͣ�Ĺ㲥
				start.setImageResource(R.drawable.player_btn_play_style);
				flag = true;
			}
			else if (MyConstant.ACTION_MUSIC_PLAN.equals(intent.getAction())) {
				list_arr = intent.getIntExtra("list", 0);
				playerPosition = intent.getIntExtra("playerPosition", 0);
				int playmode = intent.getIntExtra("playmode", 1);
				int index1 = intent.getIntExtra("index", 0);
				String playerTime = timeconvert(playerPosition);
				kstime.setText(playerTime);
				seek.setProgress(playerPosition);
				name.setText(islist(list_arr).get(index1).getName());
				jstime.setText(timeconvert(islist(list_arr).get(index1)
						.getDuration()));// ���ò��Ž���ĸ�����ʱ��
				seek.setMax(islist(list_arr).get(index1).getDuration());
				switch (playmode) {
				case 1:
					mode.setImageResource(R.drawable.player_btn_mode_normal_style);
					break;
				case 2:
					mode.setImageResource(R.drawable.player_btn_mode_random_style);// ���
					break;
				case 3:
					mode.setImageResource(R.drawable.player_btn_mode_repeat_all_style);// ѭ��
					break;
				case 4:
					mode.setImageResource(R.drawable.player_btn_mode_repeat_one_style);// ����
					break;
				}
				lrcint();
				if (playerPosition < 1000) {
					flipper2.startFlipping();
					flipper2.setInAnimation(AnimationUtils.loadAnimation(
							PlayerActivity.this, R.anim.push_left_in));
					flipper2.setOutAnimation(AnimationUtils.loadAnimation(
							PlayerActivity.this, R.anim.push_left_out));
				} else {
					flipper2.stopFlipping();
				}

			}
		}

	}

	int xian = 0;
	int indexfu = 0;
	int indexfu1 = 0;
	private TextView p3_tv1;
	private TextView p3_tv;
	private VisualizerView p3_vlv;
	private ViewFlipper flipper;
	private TextView p3_tv3;
	private TextView p3_tv2;
	private ViewFlipper flipper2;
	private LinearLayout play_bj;

	private void lrcxiao() {
		if (xian == 0) {
			tv_lrc1.setText(parser.get(0).getLyric());
			tv_lrc11.setText(parser.get(1).getLyric());
		}
		int index = lrcIndex();
		System.out.println(index + "``" + indexfu + "``" + indexfu1 + "``"
				+ xian);
		if (index < parser.size() - 1) {
			if (indexfu != index) {
				if (xian == 0) {
					xian = 1;
				}
				if (xian == 1) {
					xian = 2;
					indexfu = index;
				} else {
					xian = 1;
					indexfu = index;
					indexfu1 = index;
				}

				if (xian == 1) {
					tv_lrc11.setText(parser.get(indexfu1 + 1).getLyric());
					ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
							tv_lrc1, "alpha", 1.0f, 0);
					// ���ö���������ʱ��
					objectAnimator.setDuration(parser.get(lrcIndex() + 1)
							.getTime() - parser.get(lrcIndex()).getTime());
					// ����������
					objectAnimator.start();
					ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(
							tv_lrc11, "alpha", 0, 1.0f);
					// ���ö���������ʱ��
					objectAnimator1.setDuration(parser.get(lrcIndex() + 1)
							.getTime() - parser.get(lrcIndex()).getTime());
					// ����������
					objectAnimator1.start();
				} else if (xian == 2) {
					ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
							tv_lrc11, "alpha", 1.0f, 0);
					// ���ö���������ʱ��
					objectAnimator.setDuration(parser.get(lrcIndex() + 1)
							.getTime() - parser.get(lrcIndex()).getTime());
					// ����������
					objectAnimator.start();
					ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(
							tv_lrc1, "alpha", 0, 1.0f);
					// ���ö���������ʱ��
					objectAnimator1.setDuration(parser.get(lrcIndex() + 1)
							.getTime() - parser.get(lrcIndex()).getTime());
					// ����������
					objectAnimator1.start();
					tv_lrc1.setText(parser.get(indexfu + 1).getLyric());
				}
			}
		} else {
			xian = 0;
			indexfu = 0;
			indexfu1 = 0;
		}
	}

	@Override
	protected void onDestroy() {
		p3_vlv.releaseVisualizerFx();
		unregisterReceiver(myBroadcastReceiver);
		initlistview();
		super.onDestroy();
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
	 * ����ʱ���ʽת��
	 */
	public String timeconvert(int time) {
		int min = 0, hour = 0;
		time /= 1000;
		min = time / 60;
		time %= 60;
		return min + ":" + time;
	}

	/*
	 * ����ģʽ
	 */
	public void play_mode(int index, String action) {
		playmode = new Intent();
		playmode.setAction(action);
		playmode.putExtra("index", index);
		sendBroadcast(playmode);
	}

	/**
	 * @param index�����������±�
	 * @param action��������
	 */
	public void music_play(int index, String action) {
		broadcast = new Intent();
		broadcast.setAction(action);
		broadcast.putExtra("index", index);
		broadcast.putExtra("list", list_arr);
		sendBroadcast(broadcast);
		if (flag) {
			flag = !flag;
		}
	}

	/*
	 * ����ͷ���ʼ��
	 */
	public void imagename() {
		String a = islist(list_arr).get(position).getName();
		String[] split = a.split("-");
		System.out.println(split[0] + "```````````````````");
		switch (split[0]) {
		case "�ܽ��� ":
			play_bj.setBackgroundResource(R.drawable.bj_zjl);
			break;
		case "���ٺ� ":
			play_bj.setBackgroundResource(R.drawable.bj_lrh);
			break;
		case "�ֿ��� ":
			play_bj.setBackgroundResource(R.drawable.bj_ljj);
			break;
		case "�ֿ��ܡ������� ":
			play_bj.setBackgroundResource(R.drawable.bj_ljj);
			break;
		case "���� ":
			play_bj.setBackgroundResource(R.drawable.bj_hj);
			break;
		case "������ ":
			play_bj.setBackgroundResource(R.drawable.bjdzq);
			break;
		case "TFBOYS ":
			play_bj.setBackgroundResource(R.drawable.bj_tfboys);
			break;
		default:
			play_bj.setBackgroundResource(R.drawable.ba2);
			break;
		}
	}

	/*
	 * ��ʵĳ�ʼ��
	 */
	public void lrcint() {
		try {
			String a = islist(list_arr).get(position).getUri();
			String[] split = a.split(islist(list_arr).get(position).getName()
					+ ".mp3");
			String url = split[0] + "lyrics/"
					+ islist(list_arr).get(position).getName() + ".lrc";
			LyricParser lyricParser = new LyricParser(url);
			System.out.println(url + "���·��");
			parser = lyricParser.parser();
			lrcxianshi();
			lrcxiao();
		} catch (Exception e) {
			System.out.println("��ʴ�ӡ�쳣");
			tv_lrc.seterror(false);
			tv_lrc1.setText(islist(list_arr).get(position).getName());
			tv_lrc11.setText(islist(list_arr).get(position).getSinger());
		}
		p3_tv.setText("��ǰ����:" + islist(list_arr).get(position).getName());
		p3_tv1.setText("������:" + islist(list_arr).get(position).getSinger());
		p3_tv2.setText("��ǰ����:" + timeconvert(playerPosition));
		p3_tv3.setText("��ʱ��:"
				+ timeconvert(islist(list_arr).get(position).getDuration()));
	}

	public void lrcxianshi() {
		tv_lrc.seterror(true);
		tv_lrc.setmLrcList(parser);
		tv_lrc.setIndex(lrcIndex());
		int[] indexInfo = {
				playerPosition,
				parser.get(lrcIndex() + 1).getTime()
						- parser.get(lrcIndex()).getTime(),
				parser.get(lrcIndex()).getTime() };
		tv_lrc.setIndex1(indexInfo);
		// tv_lrc.invalidate();
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

	/*
	 * ��õ�ǰ���
	 */
	public int lrcIndex() {
		int index = 1;
		if (playerPosition < islist(list_arr).get(position).getDuration()) {
			for (int i = 0; i < parser.size(); i++) {
				if (i < parser.size() - 1) {
					if (playerPosition < parser.get(i).getTime() && i == 0) {
						index = i;
					}
					if (playerPosition > parser.get(i).getTime()
							&& playerPosition < parser.get(i + 1).getTime()) {
						index = i;
					}
				}
				if (i == parser.size() - 1
						&& playerPosition > parser.get(i).getTime()) {
					index = i;
				}
			}
		}
		return index;
	}
}
