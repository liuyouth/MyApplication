package com.example.mimi.lyr;

import java.util.ArrayList;
import java.util.List;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * �Զ���滭��ʣ���������Ч��
 * 
 * @author wwj
 * 
 */
public class LrcView extends android.widget.TextView {
	private float width; // �����ͼ���
	private float height; // �����ͼ�߶�
	private Paint currentPaint; // ��ǰ���ʶ���
	private Paint notCurrentPaint; // �ǵ�ǰ���ʶ���
	private float textHeight = 55; // �ı��߶�
	private float textSize = 30; // �ı���С
	private int index = 0; // list�����±�

	private int currentTime = 0;// ��ǰ�����Ĳ���λ��
	private int dunringTime = 0;// ��ǰ���ʵĳ���ʱ��
	private int startTime = 0;// ��ǰ���ʿ�ʼ��ʱ��
	private boolean b = true;
	private List<LyricItem> mLrcList = new ArrayList<LyricItem>();

	public void setmLrcList(List<LyricItem> mLrcList) {
		this.mLrcList = mLrcList;
	}

	public void seterror(boolean b) {
		this.b = b;
	}

	public LrcView(Context context) {
		super(context);
		init();
	}

	public LrcView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public LrcView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init() {
		setFocusable(true); // ���ÿɶԽ�

		// ��������
		currentPaint = new Paint();
		currentPaint.setAntiAlias(true); // ���ÿ���ݣ����������۱���
		currentPaint.setTextAlign(Paint.Align.CENTER);// �����ı����뷽ʽ

		// �Ǹ�������
		notCurrentPaint = new Paint();
		notCurrentPaint.setAntiAlias(true);
		notCurrentPaint.setTextAlign(Paint.Align.CENTER);
	}

	/**
	 * �滭���
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (canvas == null) {
			return;
		}
		if (b) {
			currentPaint.setColor(Color.argb(255, 255, 255, 153));
			notCurrentPaint.setColor(Color.argb(255, 255, 255, 255));

			currentPaint.setTextSize(40);
			currentPaint.setTypeface(Typeface.SERIF);

			notCurrentPaint.setTextSize(textSize);
			notCurrentPaint.setTypeface(Typeface.DEFAULT);

			float plus = dunringTime == 0 ? 0
					: (((float) currentTime - (float) startTime) / (float) dunringTime)
							* (float) 150;
			// ���Ϲ��� ����Ǹ��ݸ�ʵ�ʱ�䳤������������������
			canvas.translate(0, -plus);
			try {
				setText("");
				canvas.drawText(mLrcList.get(index).getLyric(), width / 2,
						height / 2, currentPaint);
				float tempY = height / 2;
				// ��������֮ǰ�ľ���
				for (int i = index - 1; i >= 0; i--) {
					// ��������
					tempY = tempY - textHeight;

					canvas.drawText(mLrcList.get(i).getLyric(), width / 2,
							tempY, notCurrentPaint);
				}
				tempY = height / 2;
				// ��������֮��ľ���
				for (int i = index + 1; i < mLrcList.size(); i++) {
					// ��������
					tempY = tempY + textHeight;
					if (tempY > height) {
						break;
					}
					canvas.drawText(mLrcList.get(i).getLyric(), width / 2,
							tempY, notCurrentPaint);
				}
			} catch (Exception e) {
				setText("...ľ�и���ļ����Ͻ�ȥ����...");
			}
		} else {
			setText("...ľ���ҵ�����ļ����Ͻ�ȥ����...");
		}
	}

	/**
	 * ��view��С�ı��ʱ����õķ���
	 */
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		this.width = w;
		this.height = h;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * ���������Ϣ
	 * 
	 * @param indexInfo
	 *            <b>{�������,��ǰ�����Ĳ���λ��,��ǰ���ʵĳ���ʱ��,��ǰ���ʿ�ʼ��ʱ��}</b>
	 */
	public void setIndex1(int[] indexInfo) {
		// this.index = indexInfo[0];
		this.currentTime = indexInfo[0];
		this.startTime = indexInfo[1];
		this.dunringTime = indexInfo[2];
	}

}