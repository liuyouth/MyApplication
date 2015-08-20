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
 * 自定义绘画歌词，产生滚动效果
 * 
 * @author wwj
 * 
 */
public class LrcView extends android.widget.TextView {
	private float width; // 歌词视图宽度
	private float height; // 歌词视图高度
	private Paint currentPaint; // 当前画笔对象
	private Paint notCurrentPaint; // 非当前画笔对象
	private float textHeight = 55; // 文本高度
	private float textSize = 30; // 文本大小
	private int index = 0; // list集合下标

	private int currentTime = 0;// 当前歌曲的播放位置
	private int dunringTime = 0;// 当前句歌词的持续时间
	private int startTime = 0;// 当前句歌词开始的时间
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
		setFocusable(true); // 设置可对焦

		// 高亮部分
		currentPaint = new Paint();
		currentPaint.setAntiAlias(true); // 设置抗锯齿，让文字美观饱满
		currentPaint.setTextAlign(Paint.Align.CENTER);// 设置文本对齐方式

		// 非高亮部分
		notCurrentPaint = new Paint();
		notCurrentPaint.setAntiAlias(true);
		notCurrentPaint.setTextAlign(Paint.Align.CENTER);
	}

	/**
	 * 绘画歌词
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
			// 向上滚动 这个是根据歌词的时间长短来滚动，整体上移
			canvas.translate(0, -plus);
			try {
				setText("");
				canvas.drawText(mLrcList.get(index).getLyric(), width / 2,
						height / 2, currentPaint);
				float tempY = height / 2;
				// 画出本句之前的句子
				for (int i = index - 1; i >= 0; i--) {
					// 向上推移
					tempY = tempY - textHeight;

					canvas.drawText(mLrcList.get(i).getLyric(), width / 2,
							tempY, notCurrentPaint);
				}
				tempY = height / 2;
				// 画出本句之后的句子
				for (int i = index + 1; i < mLrcList.size(); i++) {
					// 往下推移
					tempY = tempY + textHeight;
					if (tempY > height) {
						break;
					}
					canvas.drawText(mLrcList.get(i).getLyric(), width / 2,
							tempY, notCurrentPaint);
				}
			} catch (Exception e) {
				setText("...木有歌词文件，赶紧去下载...");
			}
		} else {
			setText("...木有找到歌词文件，赶紧去下载...");
		}
	}

	/**
	 * 当view大小改变的时候调用的方法
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
	 * 歌词索引信息
	 * 
	 * @param indexInfo
	 *            <b>{歌词索引,当前歌曲的播放位置,当前句歌词的持续时间,当前句歌词开始的时间}</b>
	 */
	public void setIndex1(int[] indexInfo) {
		// this.index = indexInfo[0];
		this.currentTime = indexInfo[0];
		this.startTime = indexInfo[1];
		this.dunringTime = indexInfo[2];
	}

}