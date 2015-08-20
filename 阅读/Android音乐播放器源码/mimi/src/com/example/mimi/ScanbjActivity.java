package com.example.mimi;

import com.example.mimi.adapter.Myscanbjadapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class ScanbjActivity extends Activity {

	private ListView scanbj_list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scanbj);
		scanbj_list = (ListView) findViewById(R.id.scanbj_list);
		Myscanbjadapter myscanbjadapter = new Myscanbjadapter(this);
		scanbj_list.setAdapter(myscanbjadapter);
	}
	/*
	 * ±≥æ∞”¶”√∞¥≈•
	 */
	public void scanmusic(View v){
		
	}
	public void retyrn_player(View v){
		finish();
	}
}
