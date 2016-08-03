package com.mars.mymobilemanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

import com.mars.mymobilemanager.R;
import com.mars.mymobilemanager.base.BaseActivity;
import com.mars.mymobilemanager.constant.Const;

/**
 * 
 * @author mars_zhang
 * 
 */
public class LostFindStep2Activity extends BaseActivity implements
		OnGestureListener {

	private GestureDetector gestureDetector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lostfind_step2);
		// ImageView imageView1=findViewById(R.)
		gestureDetector = new GestureDetector(this, this);
	}

	// 触碰事件
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// 3、将activity上的触碰事件onTouchEvent交给gestureDetector处理
		return gestureDetector.onTouchEvent(event);

	}

	// 4if2 当有scroll时要调这个方法
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// 同时将MotionEvent传给gestureDetector与scroll
		gestureDetector.onTouchEvent(ev);
		return super.dispatchTouchEvent(ev);

	}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		if (velocityX > Const.FLING_VALUE) {// 右滑动
			Intent intent = new Intent(instance, LostFindStep1Activity.class);
			startActivity(intent);
			finish();
			overridePendingTransition(R.anim.anim_step_in_reverse,
					R.anim.anim_step_out_reverse);
		} else if (velocityX < (-1) * Const.FLING_VALUE) {
			Intent intent = new Intent(instance, LostFindStep3Activity.class);
			startActivity(intent);
			finish();
			// 动画
			overridePendingTransition(R.anim.anim_step_in, R.anim.anim_step_out);
		}

		/*
		 * if (velocityY > 3000l) { toast("下", 0); } else if (velocityX >
		 * -3000l) { toast("上", 0); }
		 */
		return false;
	}
}
