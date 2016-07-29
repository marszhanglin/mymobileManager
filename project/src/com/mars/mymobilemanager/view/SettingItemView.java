package com.mars.mymobilemanager.view;

import com.mars.mymobilemanager.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SettingItemView extends RelativeLayout {

	private TextView tvSet;
	private CheckBox checkBox;

	public SettingItemView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView();
	}

	public SettingItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	public SettingItemView(Context context) {
		super(context);
		initView();
	}
	
	private void initView() {
		// this的作用是 将view_relativelayout_setting塞到this（RelativeLayout）中
		View view = View.inflate(getContext(),
				R.layout.view_relativelayout_setting, this);
		tvSet = (TextView) view.findViewById(R.id.tv_set);
		checkBox = (CheckBox) view.findViewById(R.id.chk_set);
	}
	
	public void setTitle(String title){
		tvSet.setText(title);
	}
}
