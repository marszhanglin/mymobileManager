package com.mars.mymobilemanager.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;

import com.mars.mymobilemanager.R;
import com.mars.mymobilemanager.base.BaseActivity;
import com.mars.mymobilemanager.constant.Const;
import com.mars.mymobilemanager.view.SettingItemView;
/**
 * 
 * @author mars_zhang
 *
 */
public class SettingActivity extends BaseActivity {
	
	private SettingItemView stvSettingWhereMobileNum;
	private SharedPreferences configSp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_setting);
		stvSettingWhereMobileNum = (SettingItemView) findViewById(R.id.stv_setting_wheremobile_num);
		configSp = getSharedPreferences(Const.SP_CONFIG_NAME, MODE_PRIVATE);
		if(configSp.getBoolean(Const.SP_CONFIG_KEY_ISWHEREMOBILENUM_ON, false)){
			stvSettingWhereMobileNum.setTitle("设置显示归属地号码已开启");
			stvSettingWhereMobileNum.checked(true);
		}else{	
			stvSettingWhereMobileNum.setTitle("设置显示归属地号码已关闭");
			stvSettingWhereMobileNum.checked(false);
		}
		stvSettingWhereMobileNum.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				stvSettingWhereMobileNum.click(); 
				Editor editor=configSp.edit();
				if(stvSettingWhereMobileNum.isChecked()){
					editor.putBoolean(Const.SP_CONFIG_KEY_ISWHEREMOBILENUM_ON, stvSettingWhereMobileNum.isChecked());
					stvSettingWhereMobileNum.setTitle("设置显示归属地号码已开启");
				}else{
					editor.putBoolean(Const.SP_CONFIG_KEY_ISWHEREMOBILENUM_ON, stvSettingWhereMobileNum.isChecked());
					stvSettingWhereMobileNum.setTitle("设置显示归属地号码已关闭");
				}
				editor.commit();
				toast(stvSettingWhereMobileNum.isChecked()+"", 0);
			} 
		});
	}
	
	
	
}



