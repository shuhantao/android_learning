package com.example.databasetest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button crateDatabase;
	private MyDatabaseHelper dbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		crateDatabase = (Button) findViewById(R.id.create_database);
		dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
		crateDatabase.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dbHelper.getWritableDatabase();
			}
		});
	}
}