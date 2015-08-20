package com.example.mimi.dialog;

import java.io.File;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mimi.R;
import com.example.mimi.constant.MyConstant;
import com.example.mimi.entity.Media;

/**
 * By CWD 2013 Open Source Project
 * 
 * <br>
 * <b>�����б�˵��Ի���</b></br>
 * 
 * <br>
 * �����ӻ�����Ч���ĵ����˵�</br>
 * 
 * @author CWD
 * @version 2013.07.31 v1.0 ��ʾ�Ի������
 */
public class MenuDialog extends TVAnimDialog implements
		android.view.View.OnClickListener {

	private TextView title;
	private TextView remove;
	private TextView delete;
	private TextView info;
	private Button button;

	public MenuDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public MenuDialog(Context context, int theme) {
		super(context, theme);
		// TODO Auto-generated constructor stub
	}

	protected MenuDialog(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_menu);

		title = (TextView) findViewById(R.id.dialog_menu_tv_title);
		remove = (TextView) findViewById(R.id.dialog_menu_tv_remove);
		delete = (TextView) findViewById(R.id.dialog_menu_tv_delete);
		info = (TextView) findViewById(R.id.dialog_menu_tv_info);
		button = (Button) findViewById(R.id.dialog_menu_btn_return);
		remove.setOnClickListener(this);
		delete.setOnClickListener(this);
		info.setOnClickListener(this);
		button.setOnClickListener(this);
	}

	/**
	 * ���öԻ������
	 * 
	 * @param text
	 *            ����
	 */
	Media m;

	public void setDialogTitle(Media m) {
		this.m = m;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.dialog_menu_tv_remove:
			setMyRingtone(m.getUri());
			break;

		case R.id.dialog_menu_tv_delete:
			setMyNotification(m.getUri());
			break;

		case R.id.dialog_menu_tv_info:
			setMyAlarm(m.getUri());
			break;

		default:
			setDialogId(MyConstant.DIALOG_DISMISS);
			break;
		}
		dismiss();
	}

	// ����--�����ľ��巽��
	public void setMyRingtone(String path) {
		File sdfile = new File(path);
		ContentValues values = new ContentValues();
		values.put(MediaStore.MediaColumns.DATA, sdfile.getAbsolutePath());
		values.put(MediaStore.MediaColumns.TITLE, sdfile.getName());
		values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/*");
		values.put(MediaStore.Audio.Media.IS_RINGTONE, false);
		values.put(MediaStore.Audio.Media.IS_NOTIFICATION, false);
		values.put(MediaStore.Audio.Media.IS_ALARM, true);
		values.put(MediaStore.Audio.Media.IS_MUSIC, false);
		Uri uri = MediaStore.Audio.Media.getContentUriForPath(sdfile
				.getAbsolutePath());
		Uri newUri = getContext().getContentResolver().insert(uri, values);
		RingtoneManager.setActualDefaultRingtoneUri(getContext(),
				RingtoneManager.TYPE_RINGTONE, newUri);
		Toast.makeText(getContext(), "�������������ɹ���", Toast.LENGTH_SHORT).show();
	}

	// ����--��ʾ���ľ���ʵ�ַ���
	public void setMyNotification(String path) {

		File sdfile = new File(path);
		ContentValues values = new ContentValues();
		values.put(MediaStore.MediaColumns.DATA, sdfile.getAbsolutePath());
		values.put(MediaStore.MediaColumns.TITLE, sdfile.getName());
		values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/*");
		values.put(MediaStore.Audio.Media.IS_RINGTONE, false);
		values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
		values.put(MediaStore.Audio.Media.IS_ALARM, false);
		values.put(MediaStore.Audio.Media.IS_MUSIC, false);

		Uri uri = MediaStore.Audio.Media.getContentUriForPath(sdfile
				.getAbsolutePath());
		Uri newUri = getContext().getContentResolver().insert(uri, values);

		RingtoneManager.setActualDefaultRingtoneUri(getContext(),
				RingtoneManager.TYPE_NOTIFICATION, newUri);
		Toast.makeText(getContext(), "����֪ͨ�����ɹ���", Toast.LENGTH_SHORT).show();
	}

	// ����--�������ľ���ʵ�ַ���
	public void setMyAlarm(String path) {
		File sdfile = new File(path);
		ContentValues values = new ContentValues();
		values.put(MediaStore.MediaColumns.DATA, sdfile.getAbsolutePath());
		values.put(MediaStore.MediaColumns.TITLE, sdfile.getName());
		values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/*");
		values.put(MediaStore.Audio.Media.IS_RINGTONE, false);
		values.put(MediaStore.Audio.Media.IS_NOTIFICATION, false);
		values.put(MediaStore.Audio.Media.IS_ALARM, true);
		values.put(MediaStore.Audio.Media.IS_MUSIC, false);

		Uri uri = MediaStore.Audio.Media.getContentUriForPath(sdfile
				.getAbsolutePath());
		Uri newUri = getContext().getContentResolver().insert(uri, values);
		RingtoneManager.setActualDefaultRingtoneUri(getContext(),
				RingtoneManager.TYPE_ALARM, newUri);
		Toast.makeText(getContext(), "�������������ɹ���", Toast.LENGTH_SHORT).show();
	}

}
