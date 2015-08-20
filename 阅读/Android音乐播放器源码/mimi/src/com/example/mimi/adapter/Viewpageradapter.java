package com.example.mimi.adapter;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class Viewpageradapter extends PagerAdapter {
	private List<View> list;
	private Context context;

	public Viewpageradapter(List<View> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		// ҳ������
		return list.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// ��ʼ����Ŀ
		View view = list.get(position);
		// ��view��ӵ�viewpager������
		ViewGroup parent = (ViewGroup) view.getParent();
		if (parent != null) {
			parent.removeAllViews();
		}
		container.addView(view);
		// container.addView(view);
		return view;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// ������Ŀ
		container.removeView(list.get(position));
	}

}
