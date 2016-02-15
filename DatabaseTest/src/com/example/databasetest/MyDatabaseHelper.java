package com.example.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper{
	public static final String CREATE_BOOK = "create table Book("
			+"id integer primary key autoincrement,"
			+ "author text,"
			+ "price real,"
			+ "pages integer,"
			+ "name text)";
	private Context mContext;
	public MyDatabaseHelper(Context context,String name,CursorFactory factory ,int version) {
		// TODO Auto-generated constructor stub
		super(context, name, factory, version);
		mContext = context;
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_BOOK);
		Toast.makeText(mContext, "create succeed", Toast.LENGTH_LONG).show();
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}