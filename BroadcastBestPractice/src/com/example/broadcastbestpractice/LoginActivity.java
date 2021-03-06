package com.example.broadcastbestpractice;

import android.R.bool;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BestActivity {
	private EditText accountEdit;
	private EditText passwordEdit;
	private Button loginButton;
	private CheckBox remember;
	private SharedPreferences pref;
	private SharedPreferences.Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		accountEdit = (EditText) findViewById(R.id.edit_username);
		passwordEdit = (EditText) findViewById(R.id.edit_password);
		loginButton = (Button) findViewById(R.id.login_button);
		remember = (CheckBox) findViewById(R.id.remember);
		pref= PreferenceManager.getDefaultSharedPreferences(this);
		Boolean isRemember = pref.getBoolean("remember_password", false);
		if(isRemember){
			String username = pref.getString("username", "");
			String password = pref.getString("password", "");
			accountEdit.setText(username);
			passwordEdit.setText(password);
			remember.setChecked(true);
		}
		loginButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String username = accountEdit.getText().toString();
				String passward = passwordEdit.getText().toString();
				if(username.equals("admin") && passward.equals("123456")){
					editor = pref.edit();
					if(remember.isChecked()){
						editor.putString("username", username);
						editor.putString("password", passward);
						editor.putBoolean("remember_password",true);
					}
					else {
						editor.clear();
					}
					editor.commit();
					Intent intent = new Intent(LoginActivity.this,MainActivity.class);
					startActivity(intent);
					finish();
				}
				else {
					Toast.makeText(LoginActivity.this,"account or passward is invalid" ,Toast.LENGTH_LONG).show();
				}
				
			}
		});
	} 

}
