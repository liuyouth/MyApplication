package com.example.sujin;

import java.util.ArrayList;

import android.app.Application;

public class AppDate extends Application {
	private ArrayList<ItemMessage> list ;

	public ArrayList<ItemMessage> getList() {
		return list;
	}

	public void setList(ArrayList<ItemMessage> list) {
		this.list = list;
	}
	

}
