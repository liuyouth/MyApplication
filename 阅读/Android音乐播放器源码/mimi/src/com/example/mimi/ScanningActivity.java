package com.example.mimi;

import android.app.Activity;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.example.mimi.constant.MyConstant;
import com.example.mimi.entity.Media;
import com.example.mimi.list.Mylist;

public class ScanningActivity extends Activity {
	private boolean isanxia=false;
	private SeekBar seekbar;
	private TextView seekbartext;
	private TextView scan_text;
	private Button btn_scan;
	private ImageView image;
	private AnimationDrawable drawable;
	private CustomAsyncQueryHandler queryHandler;
	private int size;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scanning);
		seekbar = (SeekBar) findViewById(R.id.seekBar1);
		scan_text = (TextView) findViewById(R.id.acyivity_scan_text);
		btn_scan = (Button) findViewById(R.id.activity_scan_btn_scan);
		image = (ImageView) findViewById(R.id.imageView2);
		seekbartext = (TextView) findViewById(R.id.activity_seekbar_text);
		// 帧动画
		drawable = (AnimationDrawable) image.getBackground();
		seekbarjt();
		size = Mylist.medias.size();
	}

	public void scanmusic(View v) {
		if(!isanxia){
			drawable.start();
			btn_scan.setText("扫描中");
			scan_text.setText("...玩命扫描中...");
			scanmusiclist();
			isanxia=true;
		}else{
			Intent intent = new Intent();
			intent.setAction(MyConstant.ACTION_ACTIVITY_INITLIST);
			intent.putExtra("isDelete", true);
			sendBroadcast(intent);
			finish();
		}
	}
	public void scanmusiclist() {
		Mylist.medias.removeAll(Mylist.medias);
		Mylist.love.removeAll(Mylist.love);
		Mylist.zuijin.removeAll(Mylist.zuijin);
		Mylist.geshou.removeAll(Mylist.geshou);
		Mylist.zhuanji.removeAll(Mylist.zhuanji);
		queryHandler = new CustomAsyncQueryHandler(getContentResolver());
		 queryHandler.startQuery(0, null,
		 MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null,
		 "DURATION > ?", new String[] { 6*seekbar.getProgress()+"" },
		 MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
	}
	private class CustomAsyncQueryHandler extends AsyncQueryHandler {// 读取歌曲
		public CustomAsyncQueryHandler(ContentResolver cr) {
			super(cr);
		}

		@Override
		protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
			for (int i = 0; i < cursor.getCount(); i++) {
				cursor.moveToNext();
				if (cursor.getInt(cursor
						.getColumnIndex(MediaStore.Audio.Media.IS_MUSIC)) == 1) {
					// cursor.getColumnIndex:得到指定列名的索引号,就是说这个字段是第几列
					// cursor.getString(columnIndex) 可以得到当前行的第几列的值
					Media media = new Media();// 实例化媒体对象
					media.setId(cursor.getString(cursor
							.getColumnIndex(MediaStore.Audio.Media._ID)));// 设置歌曲编号
					media.setName(cursor.getString(cursor
							.getColumnIndex(MediaStore.Audio.Media.TITLE)));// 设置得到歌曲标题
					media.setDuration(cursor.getInt(cursor
							.getColumnIndex(MediaStore.Audio.Media.DURATION)));// 设置得到歌曲时长
					media.setUri(cursor.getString(cursor
							.getColumnIndex(MediaStore.Audio.Media.DATA)));// 设置得到歌曲路径
					media.setAlbum_id(cursor.getInt(cursor
							.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID)));
					try {
						isgszj(media, cursor.getString(cursor
								.getColumnIndex(MediaStore.Audio.Media.TITLE)));
					} catch (Exception e) {
						media.setSinger(cursor.getString(cursor
								.getColumnIndex(MediaStore.Audio.Media.ARTIST)));// 设置得到艺术家
						media.setAlbum("未知专辑");
						e.printStackTrace();
					}
					Mylist.medias.add(media);
				}
			}
			initshuju();
			btn_scan.setText("扫描完成");
			if(Mylist.medias.size()>size){
				scan_text.setText("...扫描完成!新增歌曲"+(Mylist.medias.size()-size)+"首...");
			}else if(Mylist.medias.size()==size){
				scan_text.setText("...扫描完成!未找到新歌曲...");
			}else{
				scan_text.setText("...扫描完成!新增歌曲"+Mylist.medias.size()+"首...");
			}
		}
	}
	/*
	 * 获得歌手名字 和专辑名字
	 */
	public void isgszj(Media media, String a) {
		String[] split = a.split("-");
		System.out.println(split[0] + "```````````````````" + split[1] + "``");
		media.setSinger(split[0]);// 设置得到艺术家
		switch (split[1]) {
		case " 青春修炼手册":
			media.setAlbum("青春修炼手册");
			break;
		case " 栀子花开":
			media.setAlbum("可以爱");
			break;
		case "青花瓷":
			media.setAlbum("我很忙");
			break;
		case "李白":
			media.setAlbum("模特");
			break;
		case " 可惜没如果":
			media.setAlbum("新地球");
			break;
		case " 手心的蔷薇":
			media.setAlbum("新地球");
			break;
		case " 她说":
			media.setAlbum("新地球");
			break;
		case " 喜欢你":
			media.setAlbum("喜欢你");
			break;
		default:
			media.setAlbum("未知专辑");
			break;
		}
	}

	public void initshuju() {
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
	private void seekbarjt() {
		seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				seekbartext.setText(seekBar.getProgress() + "/1000KB");
			}
		});
	}

	public void retyrn_player(View v) {
		finish();
	}
}
