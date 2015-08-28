package com.example.sujin;

import android.R.string;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.ContactsContract.CommonDataKinds.Identity;

public class ItemMessage {

	private String name,date,imgurl,timedate,id,likenmb,length,seenmb;
	
	
	public ItemMessage(String id,String name ,String date,String imgurl , String timedate,String length,String seenmb,String likenmb )  {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.date = date;
		this.timedate = timedate;
		this.imgurl = imgurl;
		this.length =length;
		this.likenmb = likenmb;
		this.seenmb = seenmb;
	}
	
	public ItemMessage() {
		// TODO Auto-generated constructor stub
	}
	public String getLikenmb() {
		return likenmb;
	}


	public void setLikenmb(String likenmb) {
		this.likenmb = likenmb;
	}


	public String getLength() {
		return length;
	}


	public void setLength(String length) {
		this.length = length;
	}


	public String getSeenmb() {
		return seenmb;
	}


	public void setSeenmb(String seenmb) {
		this.seenmb = seenmb;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getImgurl() {
		return imgurl;
	}


	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}


	public String getTimedate() {
		return timedate;
	}


	public void setTimedate(String timedate) {
		this.timedate = timedate;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
}
