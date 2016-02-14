package com.example.broadcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BestActivity {
	private EditText accountEdit;
	private EditText passwordEdit;
	private Button loginButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		accountEdit = (EditText) findViewById(R.id.edit_username);
		passwordEdit = (EditText) findViewById(R.id.edit_password);
		loginButton = (Button) findViewById(R.id.login_button);
		loginButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String username = accountEdit.getText().toString();
				String passward = passwordEdit.getText().toString();
				if(username.equals("admin") && passward.equals("123456")){
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
