package com.example.mimi.qqmenu;

import com.example.mimi.qqmenu.DragLayout.Status;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MyLinearLayout extends LinearLayout {

	private DragLayout mDragLayout;

	public MyLinearLayout(Context context) {
		super(context);
	}

	public MyLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setDraglayout(DragLayout mDragLayout) {
		this.mDragLayout = mDragLayout;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		// �����ǰ�ǹر�״̬, ��֮ǰ�����ж�
		if (mDragLayout.getStatus() == Status.Close) {
			return super.onInterceptTouchEvent(ev);
		} else {
			return true;
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// �����ǰ�ǹر�״̬, ��֮ǰ��������
		if (mDragLayout.getStatus() == Status.Close) {
			return super.onTouchEvent(event);
		} else {
			// ��ָ̧��, ִ�йرղ���
			if (event.getAction() == MotionEvent.ACTION_UP) {
				mDragLayout.close();
			}

			return true;
		}
	}

}
