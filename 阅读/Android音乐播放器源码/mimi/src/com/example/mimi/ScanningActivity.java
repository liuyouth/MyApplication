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
		// ֡����
		drawable = (AnimationDrawable) image.getBackground();
		seekbarjt();
		size = Mylist.medias.size();
	}

	public void scanmusic(View v) {
		if(!isanxia){
			drawable.start();
			btn_scan.setText("ɨ����");
			scan_text.setText("...����ɨ����...");
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
	private class CustomAsyncQueryHandler extends AsyncQueryHandler {// ��ȡ����
		public CustomAsyncQueryHandler(ContentResolver cr) {
			super(cr);
		}

		@Override
		protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
			for (int i = 0; i < cursor.getCount(); i++) {
				cursor.moveToNext();
				if (cursor.getInt(cursor
						.getColumnIndex(MediaStore.Audio.Media.IS_MUSIC)) == 1) {
					// cursor.getColumnIndex:�õ�ָ��������������,����˵����ֶ��ǵڼ���
					// cursor.getString(columnIndex) ���Եõ���ǰ�еĵڼ��е�ֵ
					Media media = new Media();// ʵ����ý�����
					media.setId(cursor.getString(cursor
							.getColumnIndex(MediaStore.Audio.Media._ID)));// ���ø������
					media.setName(cursor.getString(cursor
							.getColumnIndex(MediaStore.Audio.Media.TITLE)));// ���õõ���������
					media.setDuration(cursor.getInt(cursor
							.getColumnIndex(MediaStore.Audio.Media.DURATION)));// ���õõ�����ʱ��
					media.setUri(cursor.getString(cursor
							.getColumnIndex(MediaStore.Audio.Media.DATA)));// ���õõ�����·��
					media.setAlbum_id(cursor.getInt(cursor
							.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID)));
					try {
						isgszj(media, cursor.getString(cursor
								.getColumnIndex(MediaStore.Audio.Media.TITLE)));
					} catch (Exception e) {
						media.setSinger(cursor.getString(cursor
								.getColumnIndex(MediaStore.Audio.Media.ARTIST)));// ���õõ�������
						media.setAlbum("δ֪ר��");
						e.printStackTrace();
					}
					Mylist.medias.add(media);
				}
			}
			initshuju();
			btn_scan.setText("ɨ�����");
			if(Mylist.medias.size()>size){
				scan_text.setText("...ɨ�����!��������"+(Mylist.medias.size()-size)+"��...");
			}else if(Mylist.medias.size()==size){
				scan_text.setText("...ɨ�����!δ�ҵ��¸���...");
			}else{
				scan_text.setText("...ɨ�����!��������"+Mylist.medias.size()+"��...");
			}
		}
	}
	/*
	 * ��ø������� ��ר������
	 */
	public void isgszj(Media media, String a) {
		String[] split = a.split("-");
		System.out.println(split[0] + "```````````````````" + split[1] + "``");
		media.setSinger(split[0]);// ���õõ�������
		switch (split[1]) {
		case " �ഺ�����ֲ�":
			media.setAlbum("�ഺ�����ֲ�");
			break;
		case " ���ӻ���":
			media.setAlbum("���԰�");
			break;
		case "�໨��":
			media.setAlbum("�Һ�æ");
			break;
		case "���":
			media.setAlbum("ģ��");
			break;
		case " ��ϧû���":
			media.setAlbum("�µ���");
			break;
		case " ���ĵ�Ǿޱ":
			media.setAlbum("�µ���");
			break;
		case " ��˵":
			media.setAlbum("�µ���");
			break;
		case " ϲ����":
			media.setAlbum("ϲ����");
			break;
		default:
			media.setAlbum("δ֪ר��");
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
