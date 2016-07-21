package com.mars.mymobilemanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends  Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
 
	
	public void click1(View view){
		Toast.makeText(getApplicationContext(), "可以了", 0).show();
	}

}
