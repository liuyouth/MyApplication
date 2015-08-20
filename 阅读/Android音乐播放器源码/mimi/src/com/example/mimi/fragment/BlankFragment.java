package com.example.mimi.fragment;

import com.example.mimi.R;
import com.example.mimi.R.layout;
import com.example.mimi.TabActivity;
import com.example.mimi.constant.MyConstant;
import com.example.mimi.constant.Myhandler;
import com.example.mimi.fragment.Fragment_love.MyBroadcastReceiver;
import com.example.mimi.list.Mylist;

import android.os.Bundle;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 首页显示的fragment
 * 
 */
public class BlankFragment extends Fragment {
	private GridView grid;
	private MyGridViewAdapter adapter;
	private MyBroadcastReceiver myBroadcastReceiver;
	private IntentFilter intentFilter;

	public BlankFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		myBroadcastReceiver = new MyBroadcastReceiver();
		intentFilter = new IntentFilter();
		intentFilter.addAction(MyConstant.ACTION_PlAYING_STATE);
		intentFilter.addAction(MyConstant.ACTION_SERVICR_PUASE);
		intentFilter.addAction(MyConstant.ACTION_MUSIC_PLAN);
		intentFilter.addAction(MyConstant.ACTION_ACTIVITY_INITLIST);
		getActivity().registerReceiver(myBroadcastReceiver, intentFilter);
		super.onCreate(savedInstanceState);
	}
	@Override
	public void onDestroy() {
		getActivity().unregisterReceiver(myBroadcastReceiver);// 注销广播
		super.onDestroy();
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment, null);
		grid = (GridView) view.findViewById(R.id.gridview);
		cjz();

		return view;
	}

	private void cjz() {
		adapter = new MyGridViewAdapter();
		grid.setAdapter(adapter);
	}

	/**
	 * 自定义的广播接收者
	 */
	public class MyBroadcastReceiver extends BroadcastReceiver {
		private int index;

		@Override
		public void onReceive(Context context, Intent intent) {
			if (MyConstant.ACTION_ACTIVITY_INITLIST.equals(intent.getAction())) {
				boolean isDelete = intent.getBooleanExtra("isDelete", false);
				if (isDelete) {
					cjz();
				}
			}
		}
	}

	private class MyGridViewAdapter extends BaseAdapter {

		private int[] drawable = new int[] { R.drawable.icon_local_music,
				R.drawable.icon_favorites, R.drawable.icon_folder_plus,
				R.drawable.icon_artist_plus, R.drawable.icon_album_plus };
		private String[] name = new String[] { "我的音乐", "我的最爱", "最近播放", "歌手",
				"专辑" };

		@Override
		public int getCount() {
			return 5;
		}

		@Override
		public Object getItem(int arg0) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {

			ViewHolder holder;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = getActivity().getLayoutInflater().inflate(
						R.layout.main_gridview_item, null);
				holder.iv = (ImageView) convertView
						.findViewById(R.id.gridview_item_iv);
				holder.nameTv = (TextView) convertView
						.findViewById(R.id.gridview_item_name);
				holder.numTv = (TextView) convertView
						.findViewById(R.id.gridview_item_num);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			switch (position) {
			case 0:// 我的音乐
				holder.numTv.setText("歌曲:" + Mylist.medias.size());
				break;
			case 1:// 我的最爱
				holder.numTv.setText("歌曲:" + Mylist.love.size());
				break;
			case 2:// 最近播放
				holder.numTv.setText("歌曲:" + Mylist.zuijin.size());
				break;
			case 3:// 歌手
				holder.numTv.setText("歌手:" + Mylist.geshou.size());
				break;
			case 4:// 专辑
				holder.numTv.setText("专辑:" + Mylist.zhuanji.size());
				break;
			}

			convertView.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(getActivity(), TabActivity.class);
					intent.putExtra("frag_id", position);
					startActivity(intent);
				}
			});

			holder.iv.setImageResource(drawable[position]);
			holder.nameTv.setText(name[position]);

			return convertView;
		}

		private class ViewHolder {
			ImageView iv;
			TextView nameTv, numTv;
		}
	}
}
