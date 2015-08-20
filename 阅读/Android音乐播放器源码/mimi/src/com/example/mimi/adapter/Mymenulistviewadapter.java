package com.example.mimi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mimi.R;

public class Mymenulistviewadapter extends BaseAdapter {
	int[] image = { R.drawable.icon_search_dark,
			R.drawable.icon_change_background, R.drawable.icon_sleep_mode,
			R.drawable.icon_preferences_dark, R.drawable.icon_exit };
	String[] name = { "扫描歌曲", "更换背景", "定时退出", "设置", "退出" };
	private Context context;
	private ImageView image2;
	private TextView text;

	public Mymenulistviewadapter(Context context) {
		super();
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return name.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return name[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.menu_zibuju, null);
		}
		image2 = (ImageView) convertView.findViewById(R.id.menu_image);
		text = (TextView) convertView.findViewById(R.id.menu_Text);
		image2.setImageResource(image[position]);
		text.setText(name[position]);
		return convertView;
	}
}
