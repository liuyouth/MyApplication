package com.example.mimi.adapter;

import java.util.List;

import com.example.mimi.R;
import com.example.mimi.entity.Media;
import com.example.mimi.list.Mylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MygeshoulistviewAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private List<Media> medias;
	private Context context;

	public MygeshoulistviewAdapter(Context context, List<Media> medias) {
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
		holder.name.setText(isgszj(medias.get(position).getName()));
		holder.image.setBackgroundResource(imagename(medias.get(position)
				.getName()));
		return convertView;
	}

	public class viewholder {
		public TextView name;
		public ImageView image;
	}

	/*
	 * ��ø������� ��ר������
	 */
	public String isgszj(String a) {
		String[] split = a.split("-");
		return split[0];// ���õõ�������
	}

	public int imagename(String a) {
		String[] split = a.split("-");
		switch (split[0]) {
		case "�ܽ��� ":
			return R.drawable.zjl;
		case "���ٺ� ":
			return R.drawable.lrh;
		case "�ֿ��� ":
			return R.drawable.ljj;
		case "�ֿ��ܡ������� ":
			return R.drawable.ljj;
		case "���� ":
			return R.drawable.hj;
		case "������ ":
			return R.drawable.dzq;
		case "TFBOYS ":
			return R.drawable.tfboys;
		default:
			return R.drawable.main_img_album;
		}
	}

}
