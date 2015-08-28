package com.example.sujin;

import java.util.ArrayList;

import android.R.integer;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
                holder1.text = (TextView) convertView.findViewById(R.id.item_name);
                convertView.setTag(holder1);  
                break;  
            case TYPE_2:  
                convertView = inflater.inflate(R.layout.item1,  
                        parent, false);  
                holder2.text = (TextView) convertView.findViewById(R.id.item_name);
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
            	  holder1.text.setText(list.get(position).getName());
                  break;  
              case TYPE_2:  
            	  
            	  holder2.text.setText(list.get(position).getName());
                  break;  
			}
		
		
	
		return convertView;
		}

	public final class ViewHolder1 {
		public TextView text;
		public TextView singer;

	}

	public final class ViewHolder2 {
		public TextView text;
		public TextView singer;

	}

}
