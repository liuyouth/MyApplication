package com.example.sujin;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.Manifest.permission;
import android.R.array;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class ListTask extends AsyncTask<Integer, Integer, String> {
	private String page = "1";
	private Handler handler ;
	private ArrayList< ItemMessage> list ;
	private AppDate app ;
	
	// 后面尖括号内分别是参数（例子里是线程休息时间），进度(publishProgress用到)，返回值 类型
	
	
	
	public ListTask(Handler handler, String page,AppDate app) {
		// TODO Auto-generated constructor stub
		this.handler =handler;
		this.page =page;
		this.app =app;
	}
	public ListTask(Handler handler, String page) {
		// TODO Auto-generated constructor stub
		this.handler =handler;
		this.page =page;
	}
	public ListTask(String page) {
		// TODO Auto-generated constructor stub
		this.page = page ;
	}
	public ListTask() {
		// TODO Auto-generated constructor stub
	}

	

	@Override
	protected void onPreExecute() {
		// 第一个执行方法
		System.out.println("onPreExecute   执行" );
		super.onPreExecute();
		

	}

	@Override
	protected String doInBackground(Integer... params) {
		System.out.println("doInBackground   执行" );
		// 第二个执行方法,onPreExecute()执行完后执行
		
		try {
			list=getText(page);
			app.setList(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "0";
		}
		return "1";
	}

	@Override
	protected void onProgressUpdate(Integer... progress) {
		// 这个函数在doInBackground调用publishProgress时触发，虽然调用时只有一个参数
		// 但是这里取到的是一个数组,所以要用progesss[0]来取值
		// 第n个参数就用progress[n]来取值
		System.out.println("onProgressUpdate   执行" );

		super.onProgressUpdate(progress[0]);
	}

	@Override
	public void onPostExecute(String result) {
		System.out.println("onPostExecute   执行" );
		// doInBackground返回时触发，换句话说，就是doInBackground执行完后触发
		// 这里的result就是上面doInBackground执行后的返回值，所以这里是"执行完毕"
		super.onPostExecute(result);
		try {
//			这里是更新 UI的
			if (result=="1") {
				Message m = handler.obtainMessage();
				m.what=1;
				handler.sendMessage(m);
				
			}
		
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		
		
	}
	
//   這是處理網絡數據的方法
	public static ArrayList<ItemMessage> getText(String page) throws Exception {
		ItemMessage im;
	    ArrayList<ItemMessage> list = new ArrayList<ItemMessage>();
	    
         URL url1 = new URL("http://guo.lu/page/" + page );
		HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
		conn.setConnectTimeout(6 * 1000);
		conn.setRequestMethod("GET");
		System.out.println("cooooooooo"+conn.getResponseCode());
		if (conn.getResponseCode() == 200) {
			InputStream inputStream = conn.getInputStream();
			byte[] data = readStream(inputStream);
			String html = new String(data, "UTF-8");
//			System.out.println(html);
//			開始拆分數據咯
			
		    Pattern	p=Pattern.compile("<div class=\"post\">[\\s\\S]*?</div");
			Matcher m = p.matcher(html);
			while (m.find()) {
				im = new ItemMessage();
//				System.out.println(m.group(0));
//				提取ID 文章标题
				Pattern p1 = Pattern.compile("<a data-id=\"(.*?)\" href=\"(.*?)\" title=\"(.*?)\">");
				Matcher m1 = p1.matcher(m.group());
				while (m1.find()) {
					im.setId(m1.group(1));
					im.setName(m1.group(3));
				}
//				提取文章配图链接
				Pattern p2 = Pattern.compile ("<img width=\"680\" height=\"440\" src=\"(.*?)\" class=\"cover\" />");
				Matcher m2 = p2.matcher(m.group());
				while (m2.find()) {
					im.setImgurl(m2.group(1));
				}
//				提取发布日期 以及内容缩略
				Pattern p3 = Pattern.compile ("<p>([\\s\\S]*)</p>[\\s\\S]*<p>([\\s\\S]*)</p>[\\s\\S]*</p>");
				Matcher m3 = p3.matcher(m.group());
				while (m3.find()) {
					im.setTimedate(m3.group(1));
					im.setDate(m3.group(2));
				}
//				提取喜欢人数
				Pattern p4 = Pattern.compile ("count\">(.*?)</span>");
				Matcher m4 = p4.matcher(m.group());
				while (m4.find()) {
					im.setLikenmb(m4.group(1));
				}
//				提取文章浏览
				Pattern p5 = Pattern.compile("class=\"icon-view\">(.*?)</span>");
				Matcher m5 = p5.matcher(m.group());
				while (m5.find()) {
				im.setSeenmb(m5.group(1)) ;
				}
//				提取文章长度
				Pattern p6 = Pattern.compile("icon-letter\">10(.*?)</span>");
				Matcher m6 = p6.matcher(m.group());
				while (m6.find()) {
					im.setSeenmb(m6.group(1)) ;
				}
				list.add(im);
				im=null;
			}
			
		}
			
		return list;

	}

	public static byte[] readStream(InputStream inputStream) throws Exception {
		byte[] buffer = new byte[1024];
		int len = -1;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		while ((len = inputStream.read(buffer)) != -1) {
			byteArrayOutputStream.write(buffer, 0, len);
		}

		inputStream.close();
		byteArrayOutputStream.close();
		return byteArrayOutputStream.toByteArray();
	}
	

}
