package com.example.mimi.dialog;

import com.example.mimi.R;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fengxiang extends TVAnimDialog {

	private Button button;

	public Fengxiang(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	protected Fengxiang(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
		// TODO Auto-generated constructor stub
	}

	public Fengxiang(Context context, int theme) {
		super(context, theme);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_fengxian);
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
