package com.example.sujin;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		final Intent localIntent = new Intent(this, ListActivity.class);  
	    Timer timer = new Timer();  
	    TimerTask tast = new TimerTask() {  
	        @Override  
	        public void run() {  
	            startActivity(localIntent);  
	            finish();
	        }  
	    };  
	    timer.schedule(tast, 1500);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
