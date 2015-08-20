/**
 * 
 */
package com.example.mimi.adapter;

import java.util.List;

import com.example.mimi.R;
import com.example.mimi.MainActivity;
import com.example.mimi.PlayerActivity;
import com.example.mimi.entity.Media;
import com.example.mimi.list.Mylist;
import com.example.mimi.service.MusicService;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListViewAdapter1 extends BaseAdapter {
	private LayoutInflater mInflater;
	private List<Media> medias;
	private Context context;

	public MyListViewAdapter1(Context context, List<Media> medias) {
		this.medias = medias;
		mInflater = LayoutInflater.from(context);
		this.context = context;
	}

	@Override
	public int getCount() {
		return medias == null ? 0 : medias.size();
	}

	@Override
	public Object getItem(int position) {
		return medias.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.listview_zibuju1, null);
			holder = new ViewHolder();
			holder.istrue = (ImageView) convertView
					.findViewById(R.id.listview_zibuju_true);
			holder.songId = (TextView) convertView
					.findViewById(R.id.listview_zibuju_id);
			holder.songName = (TextView) convertView
					.findViewById(R.id.listview_zibuju_name);
			holder.singer = (TextView) convertView
					.findViewById(R.id.listview_zibuju_artist);
			holder.songTime = (TextView) convertView
					.findViewById(R.id.listview_zibuju_time);
			holder.love = (ImageView) convertView
					.findViewById(R.id.listview_zibuju_favorite);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.songName.setText(medias.get(position).getName());
		holder.songId.setText("" + (position + 1) + ":");
		holder.singer.setText(medias.get(position).getSinger());
		holder.songTime
				.setText(timeconvert(medias.get(position).getDuration()));
		if (medias.get(position).isLove()) {
			holder.love
					.setImageResource(R.drawable.music_item_btn_favourite_pressed);
		}

		return convertView;
	}

	private class ViewHolder {
		public TextView songName, songId, singer, songTime;
		public ImageView istrue, love;
	}

	// 歌曲时间格式转换
	public String timeconvert(int time) {
		int min = 0, hour = 0;
		time /= 1000;
		min = time / 60;
		time %= 60;
		return min + ":" + time;
	}
}
