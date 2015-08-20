package com.example.mimi.adapter;

import java.util.List;

import com.example.mimi.R;
import com.example.mimi.adapter.MygeshoulistviewAdapter.viewholder;
import com.example.mimi.entity.Media;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Myzhuanjilistviewadapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private List<Media> medias;
	private Context context;

	public Myzhuanjilistviewadapter(Context context, List<Media> medias) {
		this.medias = medias;
		mInflater = LayoutInflater.from(context);
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return medias == null ? 0 : medias.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return medias.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		viewholder holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_geshou, null);
			holder = new viewholder();
			holder.name = (TextView) convertView
					.findViewById(R.id.text_geshou_name);
			holder.image = (ImageView) convertView
					.findViewById(R.id.image_geshou);
		} else {
			holder = (viewholder) convertView.getTag();
		}
		try {
			holder.name.setText(isgszj(medias.get(position).getName()));
		} catch (Exception e) {
			holder.name.setText("未知专辑");
		}
		holder.image.setBackgroundResource(imagename(medias.get(position)
				.getName()));
		return convertView;
	}

	public class viewholder {
		public TextView name;
		public ImageView image;
	}

	/*
	 * 获得歌手名字 和专辑名字
	 */
	public String isgszj(String a) {
		String[] split = a.split("-");
		try {
			switch (split[1]) {
			case " 青春修炼手册":
				return "青春修炼手册";
			case " 栀子花开":
				return "可以爱";
			case "青花瓷":
				return "我很忙";
			case "李白":
				return "模特";
			case " 可惜没如果":
				return "新地球";
			case " 手心的蔷薇":
				return "新地球";
			case " 他说":
				return "新地球";
			case " 喜欢你":
				return "喜欢你";
			default:
				return "未知专辑";
			}
		} catch (Exception e) {
			return "未知专辑";
		}
	}

	public int imagename(String a) {
		String[] split = a.split("-");
		switch (split[0]) {
		case "周杰伦 ":
			return R.drawable.zjl;
		case "李荣浩 ":
			return R.drawable.lrh;
		case "林俊杰 ":
			return R.drawable.ljj;
		case "林俊杰、邓紫棋 ":
			return R.drawable.ljj;
		case "何炅 ":
			return R.drawable.hj;
		case "邓紫棋 ":
			return R.drawable.dzq;
		case "TFBOYS ":
			return R.drawable.tfboys;
		default:
			return R.drawable.main_img_album;
		}
	}
}
