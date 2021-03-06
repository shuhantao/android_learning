package com.example.uiwidgettest;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FruitAdapter extends ArrayAdapter<Fruit>{
	private int resourseId;
	public FruitAdapter(Context context,int textViewResourseId,List<Fruit> object) {
		super(context,textViewResourseId,object);
		resourseId = textViewResourseId;
		// TODO Auto-generated constructor stub
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Fruit fruit = getItem(position);
		View view = convertView==null?LayoutInflater.from(getContext()).inflate(resourseId, null):convertView;
		ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
		TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
		fruitImage.setImageResource(fruit.getImageId());
		fruitName.setText(fruit.getName());
		return view;
	}
}
