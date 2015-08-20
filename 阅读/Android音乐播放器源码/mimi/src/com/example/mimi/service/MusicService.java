package com.example.mimi.service;

import java.util.List;
import java.util.Random;

import com.example.mimi.R;
import com.example.mimi.constant.MyConstant;
import com.example.mimi.entity.Media;
import com.example.mimi.list.Mylist;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.IBinder;
import android.widget.RemoteViews;

public class MusicService extends Service implements OnPreparedListener,
		OnCompletionListener {
	boolean ischu = false;
	private MediaPlayer mplayer;
	// private List<Media> medias; // 媒体文件对象的集合
	private boolean isFirst_play = true;// 第一个 检查音乐是否准备完成
	int position = 0;
	private IntentFilter intentFilter;
	private MyBroadcastReceiver mbr;
	private int playmode = 1;// 判断是什么播放模式
	private Random ran = new Random();;
	private int list;// 是那个集合
	private RemoteViews remoteViews;
	private NotificationManager systemService;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mplayer = new MediaPlayer();
		intentFilter = new IntentFilter();
		intentFilter.addAction(MyConstant.ACTION_PLAY);
		intentFilter.addAction(MyConstant.ACTION_PAUSE);
		intentFilter.addAction(MyConstant.ACTION_NEXT);
		intentFilter.addAction(MyConstant.ACTION_LAST);
		intentFilter.addAction(MyConstant.ACTION_LIST);
		intentFilter.addAction(MyConstant.ACTIVITY_EXIT);
		intentFilter.addAction(MyConstant.TONGZHI_NEXT);
		intentFilter.addAction(MyConstant.TONGZHI_LAST);
		intentFilter.addAction(MyConstant.TONGZHI_ZHONGJIAN);
		intentFilter.addAction(MyConstant.ACTION_INITLIST);
		intentFilter.addAction(MyConstant.ACTION_BFMODE);
		intentFilter.addAction(MyConstant.ACTION_LIST_SEARCH);
		intentFilter.addAction(MyConstant.ACTION_PLAN_CURRENT);
		mbr = new MyBroadcastReceiver();// 创建一个广播接收者
		registerReceiver(mbr, intentFilter);// 注册广播接收者并添加过滤
		systemService = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	/**
	 * 自定义广播接收者。用来接收相对应的广播并执行相对动作
	 */
	private class MyBroadcastReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			if (MyConstant.ACTION_PLAY.equals(intent.getAction())) {
				list = intent.getIntExtra("list", 0);
				// 播放,如果播放器当前没有播放音乐
				if (!mplayer.isPlaying()) {
					if (isFirst_play) {
						position = intent.getIntExtra("index", 0);
						prepareMusic(position);
						isFirst_play = false;
					} else {
						mplayer.start();
						sendPlayingWord(position);
						sendCurrentPosition();
					}
				}
			} else if (MyConstant.ACTION_PAUSE.equals(intent.getAction())) {
				// 暂停
				if (mplayer.isPlaying()) {
					mplayer.pause();
					sendPause();
				}
			} else if (MyConstant.ACTION_NEXT.equals(intent.getAction())) {
				// 下一首
				if (playmode == 2) {
					position = ran.nextInt(islist(list).size());
				} else {
					position = intent.getIntExtra("index", 0);
				}
				prepareMusic(position);
			} else if (MyConstant.ACTION_LAST.equals(intent.getAction())) {
				// 上一首
				if (playmode == 2) {
					position = ran.nextInt(islist(list).size());
				} else {
					position = intent.getIntExtra("index", 0);
				}
				prepareMusic(position);
			} else if (MyConstant.ACTION_LIST.equals(intent.getAction())) {
				// 单击条目
				position = intent.getIntExtra("index", 0);
				list = intent.getIntExtra("list", 0);
				prepareMusic(position);
			} else if (MyConstant.ACTION_LIST_SEARCH.equals(intent.getAction())) {
				// 单击搜索界面的条目
				String id = intent.getStringExtra("id");
				for (int i = 0; i < islist(list).size(); i++) {
					if (id.equals(islist(list).get(i).getId())) {
						position = i;
						prepareMusic(position);
						break;
					}
				}
			} else if (MyConstant.ACTION_INITLIST.equals(intent.getAction())) {
				initlistview();
			} else if (MyConstant.ACTION_BFMODE.equals(intent.getAction())) {
				playmode = intent.getIntExtra("index", 1);
			} else if (MyConstant.ACTION_PLAN_CURRENT

			.equals(intent.getAction())) {
				// 拖动进度条
				mplayer.seekTo(intent.getIntExtra("index", 0));
			}else if (MyConstant.TONGZHI_NEXT.equals(intent.getAction())) {
				System.out.println("进去入了下");
				// 下一首
				if (playmode == 2) {
					position = ran.nextInt(islist(list).size());
				} else {
					try {
						if (position == islist(list).size() - 1) {
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
				}
				prepareMusic(position);
			} else if (MyConstant.TONGZHI_LAST.equals(intent.getAction())) {
				
				System.out.println("进去入了");
				// 上一首
				if (playmode == 2) {
					position = ran.nextInt(islist(list).size());
				} else {
					try {
						if (position == 0) {
							position = islist(list).size() - 1;

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
				}
				prepareMusic(position);
			} else if (MyConstant.TONGZHI_ZHONGJIAN.equals(intent.getAction())) {
				if (mplayer.isPlaying()) {
					mplayer.pause();
					sendPause();
				}else{
					if (isFirst_play) {
						prepareMusic(position);
						isFirst_play = false;
					} else {
						mplayer.start();
						sendPlayingWord(position);
						sendCurrentPosition();
					}
				}
			} else if(MyConstant.ACTIVITY_EXIT.equals(intent.getAction())){
				if (mplayer.isPlaying()) {
					mplayer.pause();
					sendPause();
				}
			}
		}
	}

	/*
	 * 发广播给activity歌曲刷新
	 */
	public void initlistview() {
		Intent intent = new Intent();
		intent.setAction(MyConstant.ACTION_ACTIVITY_INITLIST);
		sendBroadcast(intent);
	}

	/**
	 * 发送广播给activity歌曲已经暂停
	 */
	public void sendPause() {
		Intent intent = new Intent();
		intent.setAction(MyConstant.ACTION_SERVICR_PUASE);
		sendBroadcast(intent);
	}

	/**
	 * @param position
	 *            当前歌曲的位置； 每当服务开始播放音乐的时候就将当前播放的歌曲传给activity， 用于设置播放歌曲的相关信息
	 */
	public void sendPlayingWord(int position) {
		Intent intent = new Intent();
		intent.setAction(MyConstant.ACTION_PlAYING_STATE);
		intent.putExtra("media", position);
		intent.putExtra("list", list);
		sendBroadcast(intent);
		islist(list).get(position).setIsplar(true);
	}

	/**
	 * 准备音乐
	 * 
	 * @param index
	 *            需要准备的文件下标
	 */
	private void prepareMusic(int index) {
		mplayer.reset();
		String music_uri = islist(list).get(index).getUri();
		Uri songUri = Uri.parse(music_uri);
		mplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		try {
			mplayer.setDataSource(getApplicationContext(), songUri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mplayer.setOnPreparedListener(this);
		mplayer.setOnCompletionListener(this);
		mplayer.prepareAsync();
	}

	@Override
	public void onDestroy() {
		unregisterReceiver(mbr);// 注销广播
		// 服务销毁时
		mplayer.release();
		mplayer = null;
		super.onDestroy();
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
	 * 循环获取当前歌曲播放的进度并通过广播发送给activity
	 */
	public void sendCurrentPosition() {
		new Thread() {
			public void run() {
				Intent intent = new Intent();
				while (mplayer.isPlaying()) {
					islist(list).get(position).setAudioSessionId(
							mplayer.getAudioSessionId());
					int playerPosition = mplayer.getCurrentPosition();
					intent.setAction(MyConstant.ACTION_MUSIC_PLAN);
					intent.putExtra("playerPosition", playerPosition);
					intent.putExtra("index", position);
					intent.putExtra("playmode", playmode);
					intent.putExtra("list", list);
					sendBroadcast(intent);
					try {
						sleep(500);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		mplayer.start();
		isFirst_play = false;
		sendPlayingWord(position);
		sendCurrentPosition();

	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		switch (playmode) {
		case 1:
			if (mp != null) {
				if (position == islist(list).size() - 1) {
					position = 0;
				} else {
					position = position + 1;
				}
				prepareMusic(position);
			}
			break;
		case 2:
			position = ran.nextInt(islist(list).size());
			prepareMusic(position);
			break;
		case 3:
			if (mp != null) {
				if (position == islist(list).size() - 1) {
					position = 0;
				} else {
					position = position + 1;
				}
				prepareMusic(position);
			}
			break;
		case 4:
			prepareMusic(position);
			break;
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
