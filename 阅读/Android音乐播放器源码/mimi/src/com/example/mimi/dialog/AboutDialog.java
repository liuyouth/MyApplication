package com.example.mimi.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mimi.R;

/**
 * By CWD 2013 Open Source Project
 * 
 * <br>
 * <b>���ڶԻ���</b></br>
 * 
 * <br>
 * �����ӻ�����Ч���ĵ����Ի���</br>
 * 
 * @author CWD
 * @version 2013.08.05 v1.0 ��ʾ�Ի������
 */
public class AboutDialog extends TVAnimDialog {

	private Button button;

	public AboutDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public AboutDialog(Context context, int theme) {
		super(context, theme);
		// TODO Auto-generated constructor stub
	}

	protected AboutDialog(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_about);

		button = (Button) findViewById(R.id.dialog_about_btn_ok);
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dismiss();
			}
		});

	}

}
