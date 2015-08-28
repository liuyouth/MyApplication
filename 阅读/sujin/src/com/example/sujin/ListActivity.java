package com.example.sujin;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;

public class ListActivity extends Activity {
	private AppDate app;
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		app = (AppDate) getApplication();

		Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				switch (msg.what) {
				case 1:

					listView.setAdapter(new ListAdaptersujin(ListActivity.this, app
							.getList()));
					break;

				default:
					break;
				}
			}

		};
		// »ñÈ¡listviewÊµÀý
		listView = (ListView) findViewById(R.id.city_list);

		ListTask listTask;
		listTask = new ListTask(handler, "1", app);
		listTask.execute(500);

	}
}
