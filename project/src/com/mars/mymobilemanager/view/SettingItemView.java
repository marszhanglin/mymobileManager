package com.mars.mymobilemanager.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mars.mymobilemanager.R;
import com.mars.mymobilemanager.constant.Const;

public class SettingItemView extends RelativeLayout {

	private TextView tvSet;
	private CheckBox checkBox;

	public SettingItemView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView(attrs);
	}

	public SettingItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(attrs);
		/*int attrcount = attrs.getAttributeCount();
		for (int i = 0; i < attrcount; i++) {
			System.out.println(attrs.getAttributeName(i)+"="+attrs.getAttributeValue(i));
		}*/
		
	}

	 

	private void initView(AttributeSet attrs) {
		// this的作用是 将view_relativelayout_setting塞到this（RelativeLayout）中
		View view = View.inflate(getContext(),
				R.layout.view_relativelayout_setting, this);
		tvSet = (TextView) view.findViewById(R.id.tv_set);
		checkBox = (CheckBox) view.findViewById(R.id.chk_set);
		
		boolean chkIsOn=attrs.getAttributeBooleanValue(R.attr.chk_is_on, false);
		checkBox.setChecked(chkIsOn);
		String titleText=attrs.getAttributeValue(Const.SP_CONFIG_KEY_ISWHEREMOBILENUM_ON, "title_text");
		tvSet.setText(titleText);
		
	}

	public void setTitle(String title) {
		tvSet.setText(title);
	}

	public boolean isChecked() {
		return checkBox.isChecked();
	}

	public void click() {
		if (isChecked()) {
			checkBox.setChecked(false);
		} else {
			checkBox.setChecked(true);
		}
	}

	public void checked(boolean ifcheck) {
		checkBox.setChecked(ifcheck);
	}

}
