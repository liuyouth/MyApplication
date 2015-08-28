package com.example.sujin;

import java.util.ArrayList;

import android.R.integer;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdaptersujin extends BaseAdapter {
	private ArrayList<ItemMessage> list;
	private LayoutInflater inflater = null;
	final int VIEW_TYPE = 2;
	final int TYPE_1 = 0;
	final int TYPE_2 = 1;

	public ListAdaptersujin(Context context,ArrayList<ItemMessage> list) {
		// TODO Auto-generated constructor stub
		this.list =list;

		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getItemViewType(int position) {
		int p = position % 2;
		if (p == 0)
			return TYPE_1;
		else if (p == 1)
			return TYPE_2;
		else
			return TYPE_1;

	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
//		return list.size();
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
		return Integer.parseInt(list.get(arg0).getId());
	}

	private int[] colors = new int[] { 0x30FF0000, 0x300000FF };

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder1 holder1 = null;
		holder1 = new ViewHolder1();
		 ViewHolder2 holder2 = null;
		 holder2 = new ViewHolder2();
		 
		int type = getItemViewType(position);
		if (convertView == null) {
			switch (type) {  
            case TYPE_1:  
                convertView = inflater.inflate(R.layout.item,  
                        parent, false);  
                holder1.name = (TextView) convertView.findViewById(R.id.item_name);
                holder1.date = (TextView) convertView.findViewById(R.id.item_date);
                holder1.sdate = (TextView) convertView.findViewById(R.id.item_sdate);
                holder1.length = (TextView) convertView.findViewById(R.id.lab_length);
                holder1.like = (TextView) convertView.findViewById(R.id.lab_like);
                holder1.see = (TextView) convertView.findViewById(R.id.lab_see);
                convertView.setTag(holder1);  
                break;  
            case TYPE_2:  
                convertView = inflater.inflate(R.layout.item1,  
                        parent, false);  
                holder2.name = (TextView) convertView.findViewById(R.id.item_name);
                holder2.date = (TextView) convertView.findViewById(R.id.item_date);
                holder2.sdate = (TextView) convertView.findViewById(R.id.item_sdate);
                holder2.length = (TextView) convertView.findViewById(R.id.lab_length);
                holder2.like = (TextView) convertView.findViewById(R.id.lab_like);
                holder2.see = (TextView) convertView.findViewById(R.id.lab_see);
                convertView.setTag(holder2);  
                break;  
			}
		}
              switch(type) {  
                case TYPE_1:  
                    holder1 = (ViewHolder1) convertView.getTag();  
                    break;  
                case TYPE_2:  
                    holder2 = (ViewHolder2) convertView.getTag();  
                    break;  
                }  
              
            switch (type) {  
              case TYPE_1:  
            	  holder1.name.setText(list.get(position).getName());
            	  holder1.sdate.setText(list.get(position).getDate());
            	  holder1.date.setText(list.get(position).getTimedate());
            	  holder1.length.setText(list.get(position).getLength());
            	  holder1.like.setText(list.get(position).getLikenmb());
            	  holder1.see.setText(list.get(position).getSeenmb());
                  break;  
              case TYPE_2:  
            	  holder2.name.setText(list.get(position).getName());
            	  holder2.sdate.setText(list.get(position).getDate());
            	  holder2.date.setText(list.get(position).getTimedate());
            	  holder2.length.setText(list.get(position).getLength());
            	  holder2.like.setText(list.get(position).getLikenmb());
            	  holder2.see.setText(list.get(position).getSeenmb());
                  break;  
			}
		
		
	
		return convertView;
		}

	public final class ViewHolder1 {
		public TextView name,sdate,date,like,length,see;
		public ImageView img;

	}

	public final class ViewHolder2 {
		public TextView name,sdate,date,like,length,see;
		public ImageView img;

	}

}
