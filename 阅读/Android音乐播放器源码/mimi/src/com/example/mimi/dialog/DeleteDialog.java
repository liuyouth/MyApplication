package com.example.mimi.dialog;

import com.example.mimi.R;
import com.example.mimi.TabActivity;
import com.example.mimi.constant.MyConstant;
import com.example.mimi.entity.Media;
import com.example.mimi.list.Mylist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * By CWD 2013 Open Source Project
 * 
 * <br>
 * <b>删除歌曲对话框</b></br>
 * 
 * <br>
 * 带电视机开关效果的弹出对话框</br>
 * 
 * @author CWD
 * @version 2013.07.31 v1.0 显示对话框界面
 */
public class DeleteDialog extends TVAnimDialog implements
		android.view.View.OnClickListener {

	private Button positive;
	private Button negative;

	public DeleteDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public DeleteDialog(Context context, int theme) {
		super(context, theme);
		// TODO Auto-generated constructor stub
	}

	protected DeleteDialog(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_delete);

		positive = (Button) findViewById(R.id.dialog_delete_btn_positive);
		negative = (Button) findViewById(R.id.dialog_delete_btn_negative);
		positive.setOnClickListener(this);
		negative.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.dialog_delete_btn_positive:
			setDialogId(MyConstant.DIALOG_DELETE);
			deldete(m);
			break;

		case R.id.dialog_delete_btn_negative:
			setDialogId(MyConstant.DIALOG_DISMISS);
			break;
		}
		dismiss();
	}

	Media m;

	public void setMedia(Media m) {
		this.m = m;
	}

	public void deldete(Media m) {
		Mylist.medias.remove(m);
		Intent intent = new Intent();
		intent.setAction(MyConstant.ACTION_ACTIVITY_INITLIST);
		intent.putExtra("isDelete", true);
		getContext().sendBroadcast(intent);
		Toast.makeText(getContext(), "成功移除", 0).show();
	}
}
