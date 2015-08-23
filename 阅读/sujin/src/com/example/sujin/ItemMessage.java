package com.example.sujin;

import android.R.integer;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.ContactsContract.CommonDataKinds.Identity;

public class ItemMessage {

	private String name;
	private int id;
	
	public ItemMessage(String name , int id) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.id = id;
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	
}
