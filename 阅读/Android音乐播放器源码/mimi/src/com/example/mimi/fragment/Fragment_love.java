package com.example.mimi.fragment;

import com.example.mimi.R;
import com.example.mimi.R.layout;
import com.example.mimi.adapter.MyListViewAdapter;
import com.example.mimi.constant.MyConstant;
import com.example.mimi.fragment.Fragment_qb.MyBroadcastReceiver;
import com.example.mimi.list.Mylist;
import com.example.mimi.listview.ActionSlideExpandableListView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 收藏
 * 
 */
@SuppressLint("InflateParams")
public class Fragment_love extends Fragment {

	private ActionSlideExpandableListView listview_love;
	private MyListViewAdapter adapter;
	private View view;
	private Intent broadcast;
	private ImageView istrue;// list子布局
	private LinearLayout isbj;
	private IntentFilter intentFilter;
	private MyBroadcastReceiver myBroadcastReceiver;
	int position = 0;// 当前播放歌曲
	private View viewzibuju;// 获得listview 相应item子布局
	private int list_arr;

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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.fragment_love, null);

		listview_love = (ActionSlideExpandableListView) view
				.findViewById(R.id.listview_love);
		adapter = new MyListViewAdapter(getActivity(), Mylist.love);
		textcjz();
		return view;
	}

	private void textcjz() {
		listview_love.setAdapter(adapter);
		listview_love.setOnItemClickListener(new OnItemClickListener() {

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
		broadcast.putExtra("list", MyConstant.LIST_love);
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

	@Override
	public void onDestroy() {
		getActivity().unregisterReceiver(myBroadcastReceiver);
		super.onDestroy();
	}

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
				if (list_arr == MyConstant.LIST_love) {
					if (position >= listview_love.getFirstVisiblePosition()
							&& position <= listview_love
									.getLastVisiblePosition()) {
						viewzibuju = listview_love.getChildAt(position
								- listview_love.getFirstVisiblePosition());
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
