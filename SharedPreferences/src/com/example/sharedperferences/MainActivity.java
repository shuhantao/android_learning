package com.example.sharedperferences;

import com.example.sharedpreferences.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.test.PerformanceTestCase;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends Activity {
	private SharedPreferences pref;
	private Button login;
	private EditText username;
	private EditText password;
	private CheckBox remember;
	private String TAG = "forTest";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate");
		setContentView(R.layout.login);
		login= (Button) findViewById(R.id.login_button);
		username = (EditText) findViewById(R.id.edit_username);
		password = (EditText) findViewById(R.id.edit_password);
		remember = (CheckBox) findViewById(R.id.remember);
		pref = PreferenceManager.getDefaultSharedPreferences(this);
		
	}
}