package com.mars.mymobilemanager.base;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

public class BaseActivity extends Activity {
	/** 实体对象 */
    public static BaseActivity instance = null;
	/** 日志允许的打印级别 */
	public int logLevel=2;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		instance=this;
		// 不要标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		
	}
	
	
    /** 土司 */
    protected void toast(String strMsg, int L1S0) {
        Toast.makeText(getApplicationContext(), strMsg, L1S0).show();
    }
	
    /**
     * 
     * @param strMsg
     * @param level
     */
    protected void log(String strMsg, int level) {
    	switch (level) {
		case 0:
			Log.e(this.getPackageName(), strMsg); 
			break;
		case 1:
			if(logLevel<1)return;
			Log.d(this.getPackageName(), strMsg); 
			break;
		case 2:
			if(logLevel<2)return;
			Log.i(this.getPackageName(), strMsg); 
			break;
		default:
			break;
		}
    }
}
