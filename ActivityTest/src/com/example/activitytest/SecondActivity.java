package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
public class SecondActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		Log.d("FirstActivity", "second Task id is"+getTaskId());
		setContentView(R.layout.second_layout);
		Intent intent = getIntent();
		if(intent!=null){
			String data = intent.getStringExtra("extra_data");
		}
		Button button2 = (Button) findViewById(R.id.button_2);
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
				startActivity(intent);
			}
		});
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.putExtra("data_return", "from second to first");
		setResult(RESULT_OK,intent);
		finish();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("SecondActivity" ,"ondestory");
	}
}
