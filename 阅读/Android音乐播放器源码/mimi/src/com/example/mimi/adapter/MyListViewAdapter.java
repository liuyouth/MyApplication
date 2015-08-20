/**
 * 
 */
package com.example.mimi.adapter;

import java.util.List;

import com.example.mimi.R;
import com.example.mimi.MainActivity;
import com.example.mimi.PlayerActivity;
import com.example.mimi.TabActivity;
import com.example.mimi.constant.MyConstant;
import com.example.mimi.dialog.DeleteDialog;
import com.example.mimi.dialog.Fengxiang;
import com.example.mimi.dialog.InfoDialog;
import com.example.mimi.dialog.MenuDialog;
import com.example.mimi.entity.Media;
import com.example.mimi.list.Mylist;
import com.example.mimi.service.MusicService;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class MyListViewAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private List<Media> medias;
	private Context context;

	public MyListViewAdapter(Context context, List<Media> medias) {
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
			convertView = mInflater.inflate(R.layout.listview_zibuju, null);
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
			holder.fx = (ImageButton) convertView.findViewById(R.id.zbj_fx);
			holder.ls = (ImageButton) convertView.findViewById(R.id.zbj_ls);
			holder.sc = (ImageButton) convertView.findViewById(R.id.zbj_sc);
			holder.xq = (ImageButton) convertView.findViewById(R.id.zbj_xq);
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

		}else{
			holder.love
			.setImageResource(R.drawable.music_item_btn_favourite_normal);
		}
		holder.fx.setOnClickListener(new myonclick(3, position));
		holder.sc.setOnClickListener(new myonclick(0, position));
		holder.ls.setOnClickListener(new myonclick(2, position));
		holder.xq.setOnClickListener(new myonclick(1, position));

		return convertView;
	}

	private class ViewHolder {
		public TextView songName, songId, singer, songTime;
		public ImageView istrue, love;
		public ImageButton sc, fx, xq, ls;
	}

	// 歌曲时间格式转换
	public String timeconvert(int time) {
		int min = 0, hour = 0;
		time /= 1000;
		min = time / 60;
		time %= 60;
		return min + ":" + time;
	}

	public class myonclick implements OnClickListener {
		int s;
		int p;

		public myonclick(int s, int p) {
			this.s = s;
			this.p = p;
		}

		@Override
		public void onClick(View v) {
			switch (s) {
			case 0:
				DeleteDialog deleteDialog = new DeleteDialog(context);
				deleteDialog.show();
				deleteDialog.setMedia(medias.get(p));
				break;
			case 1:
				InfoDialog infoDialog = new InfoDialog(context);
				infoDialog.show();
				infoDialog.setInfo(medias.get(p));
				break;
			case 2:
				MenuDialog menuDialog = new MenuDialog(context);
				menuDialog.show();
				menuDialog.setDialogTitle(medias.get(p));
				break;
			case 3:
				Fengxiang fengxiang = new Fengxiang(context);
				fengxiang.show();
				break;

			default:
				break;
			}
		}
	}
}
