package com.example.mimi.fragment;

import com.example.mimi.R;
import com.example.mimi.MainActivity.MyBroadcastReceiver;
import com.example.mimi.adapter.MyListViewAdapter;
import com.example.mimi.constant.MyConstant;
import com.example.mimi.list.Mylist;
import com.example.mimi.listview.ActionSlideExpandableListView;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * 所有音乐
 * 
 */
@SuppressLint("InflateParams")
public class Fragment_qb extends Fragment {

	private ActionSlideExpandableListView listview_qb;
	private MyListViewAdapter adapter;
	private View view;
	private Intent broadcast;
	private ImageView istrue;// list子布局
	private LinearLayout isbj;
	private IntentFilter intentFilter;
	private MyBroadcastReceiver myBroadcastReceiver;
	int position = 0;// 当前播放歌曲
	private View viewzibuju;// 获得listview 相应item子布局

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
		getActivity().unregisterReceiver(myBroadcastReceiver);
		super.onDestroy();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_qb, null);
		listview_qb = (ActionSlideExpandableListView) view
				.findViewById(R.id.listview_qb);
		textcjz();
		return view;
	}

	private void textcjz() {
		adapter = new MyListViewAdapter(getActivity(), Mylist.medias);
		listview_qb.setAdapter(adapter);
		listview_qb.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				music_play(position, MyConstant.ACTION_LIST);
				itemview(view);

			}
		});
	}

	/**
	 * @param index歌曲的索引下标
	 * @param action按键动作
	 */
	public void music_play(int index, String action) {
		broadcast = new Intent();
		broadcast.setAction(action);
		broadcast.putExtra("index", index);
		broadcast.putExtra("list", MyConstant.LIST_QB);
		getActivity().sendBroadcast(broadcast);
	}

	private void itemview(View view1) {
		try {
			if (istrue != null) {
				istrue.setImageBitmap(null);
				isbj.setBackgroundColor(0);
			}
			istrue = (ImageView) view1.findViewById(R.id.listview_zibuju_true);
			isbj = (LinearLayout) view1.findViewById(R.id.listview_zibuju_head);
			isbj.setBackgroundResource(R.drawable.img_background_post_pressed);
			istrue.setImageResource(R.drawable.istrue);
		} catch (Exception e) {
			System.out.println("播放出错了");
		}
	}

	private int list_arr;

	/**
	 * 自定义的广播接收者
	 */
	public class MyBroadcastReceiver extends BroadcastReceiver {
		private int index;

		@Override
		public void onReceive(Context context, Intent intent) {
			if (MyConstant.ACTION_MUSIC_PLAN.equals(intent.getAction())) {
				list_arr = intent.getIntExtra("list", 0);
				// 收到服务发送的播放歌曲进度的意图
				int playerPosition = intent.getIntExtra("playerPosition", 0);
				int index1 = intent.getIntExtra("index", 0);
				position = index1;
				int playmode = intent.getIntExtra("playmode", 1);
				if (list_arr == MyConstant.LIST_QB) {
					if (position >= listview_qb.getFirstVisiblePosition()
							&& position <= listview_qb.getLastVisiblePosition()) {
						viewzibuju = listview_qb.getChildAt(position
								- listview_qb.getFirstVisiblePosition());
						itemview(viewzibuju);
					} else {
						if (istrue != null) {
							istrue.setImageBitmap(null);
							isbj.setBackgroundColor(0);
						}
					}
				}
			} else if (MyConstant.ACTION_ACTIVITY_INITLIST.equals(intent
					.getAction())) {
				boolean isDelete = intent.getBooleanExtra("isDelete", false);
				if (isDelete) {
					textcjz();
				}
			}
		}
	}
}
