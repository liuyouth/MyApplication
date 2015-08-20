package com.example.mimi.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.mimi.R;
import com.example.mimi.R.layout;
import com.example.mimi.adapter.MyListViewAdapter;
import com.example.mimi.adapter.MyListViewAdapter1;
import com.example.mimi.adapter.MygeshoulistviewAdapter;
import com.example.mimi.constant.MyConstant;
import com.example.mimi.entity.Media;
import com.example.mimi.list.Mylist;
import com.example.mimi.listview.ActionSlideExpandableListView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;

/**
 * 歌手
 * 
 */
public class Fragment_geshou extends Fragment {

	private ListView listview_geshou;
	private MyListViewAdapter1 adapter;
	View view = null;
	private MygeshoulistviewAdapter adapter2;
	private Intent broadcast;
	private ImageView istrue;// list子布局
	private LinearLayout isbj;
	boolean isllist = false;
	private FragmentManager fm;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		fm = getFragmentManager();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.fragment_geshou, null);
		isllist = false;
		listview_geshou = (ListView) view.findViewById(R.id.listview_geshou);
		adapter2 = new MygeshoulistviewAdapter(getActivity(), Mylist.geshou);
		listview_geshou.setAdapter(adapter2);
		listview_geshou.setOnItemClickListener(new OnItemClickListener() {

			private FragmentTransaction ft;

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (!isllist) {

					if (Mylist.gequ.size() != 0) {
						Mylist.gequ.removeAll(Mylist.gequ);
					}
					if (Mylist.gequ.size() == 0) {
						for (Media m : Mylist.medias) {
							if (isgszj(Mylist.geshou.get(position).getName())
									.equals(isgszj(m.getName()))) {
								Mylist.gequ.add(m);
							}
						}
						adapter = new MyListViewAdapter1(getActivity(),
								Mylist.gequ);
						listview_geshou.setAdapter(adapter);
						isllist = true;
					}
				} else {
					music_play(position, MyConstant.ACTION_LIST);
				}

			}

		});
		return view;
	}

	public String isgszj(String a) {
		String[] split = a.split("-");
		return split[0];// 设置得到艺术家
	}

	public void music_play(int index, String action) {
		broadcast = new Intent();
		broadcast.setAction(action);
		broadcast.putExtra("index", index);
		broadcast.putExtra("list", MyConstant.LIST_gequ);
		getActivity().sendBroadcast(broadcast);
	}

}
