package com.example.sujin;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListAdaptersujin extends BaseAdapter {
	private ArrayList<ItemMessage> list ;
	private LayoutInflater inflater=null;
	
	public ListAdaptersujin(Context context) {
		// TODO Auto-generated constructor stub
		ItemMessage im;
		list = new ArrayList<ItemMessage>();
		im = new ItemMessage("±øµ∞£¨Œ“œ≤ª∂ƒ„∞°£°",12);
		for (int i = 0; i < 12; i++) {
			
			list.add(im);
		}
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0).getId();
	}

	@Override
	public View getView( int position, View convertView, ViewGroup parent) {
		
		 final ViewHolder holder;
			if (convertView==null) {
			    holder = new ViewHolder();
			    if ((position %2) ==1) {
			    	convertView =  inflater.inflate(R.layout.item,  null);
				}else {
					convertView =  inflater.inflate(R.layout.item1,  null);
				}
			    holder.text = (TextView) convertView.findViewById(R.id.item_name);
				convertView.setTag(holder);
				
				
			}else {
				holder = (ViewHolder) convertView.getTag();
			}
		holder.text.setText(list.get(position).getName());
		
		
		return convertView;
	}

	public final class ViewHolder {
		public TextView text;
		public TextView singer;

		
	}
	
}
