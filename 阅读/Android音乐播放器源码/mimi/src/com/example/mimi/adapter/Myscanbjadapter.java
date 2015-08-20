package com.example.mimi.adapter;

import com.example.mimi.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Myscanbjadapter extends BaseAdapter{
	private String[] names={"简约","风景","个性","清新","萌物","动漫","酷黑","盛夏","诡异"};
	private int[] imageid={R.drawable.img_daily_hot_mv_tag1,R.drawable.img_daily_hot_mv_tag2,R.drawable.img_daily_hot_mv_tag3,R.drawable.img_daily_hot_mv_tag4,R.drawable.img_daily_hot_mv_tag5,R.drawable.img_daily_hot_mv_tag6,
			R.drawable.img_daily_hot_mv_tag7,R.drawable.img_daily_hot_mv_tag8,R.drawable.img_daily_hot_mv_tag9};
	private Context context;
	private ImageView btn;
	private TextView text;
	
	public Myscanbjadapter(Context context) {
		super();
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return names.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return names[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView==null){
			convertView=View.inflate(context, R.layout.scanbj_zibuju, null);
		}
		btn = (ImageView) convertView.findViewById(R.id.scan_btn_scan);
		text = (TextView) convertView.findViewById(R.id.scan_text_scan);
		text.setText(names[position]);
		btn.setBackgroundResource(imageid[position]);
		return convertView;
	}
}
