/**
 * 
 */
package com.example.mimi.constant;

/**
 * 常量类
 * 
 */
public class MyConstant {
	/*
	 * 判断是否播放那个集合的歌曲
	 */
	public static final int LIST_QB = 0;
	public static final int LIST_love = 1;
	public static final int LIST_zuijin = 2;
	public static final int LIST_gequ = 3;
	public static final int LIST_ZHUANJI = 4;

	public static final int DIALOG_DISMISS = 0;// 对话框消失
	public static final int DIALOG_SCAN = 1;// 扫描对话框
	public static final int DIALOG_MENU_REMOVE = 2;// 歌曲列表移除对话框
	public static final int DIALOG_MENU_DELETE = 3;// 歌曲列表提示删除对话框
	public static final int DIALOG_MENU_INFO = 4;// 歌曲详情对话框
	public static final int DIALOG_DELETE = 5;// 歌曲删除对话框

	public static final String ACTION_INITLIST = "org.zhang.daydaysong.initlist";// 刷新listview
	public static final String ACTION_ACTIVITY_INITLIST = "org.zhang.daydaysong.activity_initlist";// 刷新listview
	public static final String ACTION_PLAY = "org.zhang.daydaysong.play"; // 播放
	public static final String ACTION_PAUSE = "org.zhang.daydaysong.pause";// 暂停
	public static final String ACTION_LAST = "org.zhang.daydaysong.last";// 上一个
	public static final String ACTION_NEXT = "org.zhang.daydaysong.next";// 下一个
	public static final String ACTION_BFMODE = "org.zhang.daydaysong.next1";// 播放模式
	public static final String ACTION_LIST = "org.zhang.daydaysong.list";// 单击listView条目
	public static final String ACTION_LIST_SEARCH = "org.zhang.daydaysong.list_search";// 单机搜索界面的listView条目
	public static final String ACTION_PlAYING_STATE = "org.zhang.daydaysong.playing";// 服务发给activity的播放意图
	public static final String ACTION_SERVICR_PUASE = "org.zhang.daydaysong.service.puase";// 服务发给activity的播放意图
	public static final String ACTION_MUSIC_PLAN = "org.zhang.daydaysong.music.plan";// 用来发送歌曲当前播放位置的意图
	public static final String ACTION_PLAN_CURRENT = "org.zhang.daydaysong.plan_current";// 用来发送进度条位置给服务的意图
	public static final String ACTIVITY_EXIT="org.zhang.daydaysong.exit";
	public static final String ACTIVITY_EXITALL="org.zhang.daydaysong.exitall";
	public static final String TONGZHI_LAST = "org.zhang.daydaysong.last1";// 上一个
	public static final String TONGZHI_NEXT = "org.zhang.daydaysong.next111";// 下一个
	public static final String TONGZHI_ZHONGJIAN = "org.zhang.daydaysong.zhongjian";// 下一个
}
