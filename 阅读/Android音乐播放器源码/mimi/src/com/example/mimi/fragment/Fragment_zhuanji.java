package com.example.mimi.fragment;

import com.example.mimi.R;
import com.example.mimi.R.layout;
import com.example.mimi.adapter.MyListViewAdapter;
import com.example.mimi.adapter.MyListViewAdapter1;
import com.example.mimi.adapter.MygeshoulistviewAdapter;
import com.example.mimi.adapter.Myzhuanjilistviewadapter;
import com.example.mimi.constant.MyConstant;
import com.example.mimi.entity.Media;
import com.example.mimi.list.Mylist;
import com.example.mimi.listview.ActionSlideExpandableListView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * ×¨¼­
 * 
 */
@SuppressLint("InflateParams")
public class Fragment_zhuanji extends Fragment {

	private ListView listview_zhuanji;
	private MyListViewAdapter1 adapter;
	private View view;
	private Intent broadcast;
	private Myzhuanjilistviewadapter adapter22;
	boolean isllist1 = false;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.fragment_zhuanji, null);

		listview_zhuanji = (ListView) view.findViewById(R.id.listview_zhuanji);
		adapter22 = new Myzhuanjilistviewadapter(getActivity(), Mylist.zhuanji);
		listview_zhuanji.setAdapter(adapter22);
		listview_zhuanji.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (!isllist1) {

					if (Mylist.gequzj.size() != 0) {
						Mylist.gequzj.removeAll(Mylist.gequzj);
						isllist1 = true;
					}
					if (Mylist.gequzj.size() == 0) {
						for (Media m : Mylist.medias) {
							if (Mylist.zhuanji.get(position).getAlbum()
									.equals(m.getAlbum())) {
								Mylist.gequzj.add(m);
							}
						}
						adapter = new MyListViewAdapter1(getActivity(),
								Mylist.gequzj);
						listview_zhuanji.setAdapter(adapter);
						isllist1 = true;
					}
				} else {
					music_play(position, MyConstant.ACTION_LIST);
				}
			}

		});
		return view;
	}

	public void music_play(int index, String action) {
		broadcast = new Intent();
		broadcast.setAction(action);
		broadcast.putExtra("index", index);
		broadcast.putExtra("list", MyConstant.LIST_ZHUANJI);
		getActivity().sendBroadcast(broadcast);
	}

}
