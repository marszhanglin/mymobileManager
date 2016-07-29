package com.mars.mymobilemanager.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;


/**
 * 获取焦点的TextView
 * @author mars_zhang
 *
 */
public class FocusedTextView extends TextView {
	public FocusedTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public FocusedTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public FocusedTextView(Context context) {
		super(context);
	}
	
	/**
	 * 跑马灯认这个true
	 */
	@Override
	public  boolean isFocused(){
//		return super.isFocused();
		return true;
	}

}
