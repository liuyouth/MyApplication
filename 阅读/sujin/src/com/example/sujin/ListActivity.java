package com.example.sujin;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class ListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		

		// 获取listview实例
		ListView listView = (ListView) findViewById(R.id.city_list);
		listView.setAdapter(new ListAdaptersujin(this));
		// 获取RefreshLayout实例

		
	}
}

