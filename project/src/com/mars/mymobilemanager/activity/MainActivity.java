package com.mars.mymobilemanager.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mars.mymobilemanager.R;
import com.mars.mymobilemanager.base.BaseActivity;

public class MainActivity extends BaseActivity {

	private ListView lvFuns;
	private List<String> listStr = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lvFuns = (ListView) findViewById(R.id.lv_funs);
		
		listStr = new ArrayList<String>();
		listStr.add("手机防盗");
		listStr.add("手机通讯");
		listStr.add("软件管理");
		listStr.add("进程管理");
		listStr.add("流量管理");
		listStr.add("手机杀毒");
		listStr.add("缓存管理");
		listStr.add("高级管理");
		listStr.add("设置中心");
		
		lvFuns.setAdapter(new FunsListAdapter());
		lvFuns.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 0://手机防盗
					toast(listStr.get(position), 0);
					break;
				case 1://设置中心
					toast(listStr.get(position), 0);
					break;
				case 2://设置中心
					toast(listStr.get(position), 0);
					break;
				case 3://设置中心
					toast(listStr.get(position), 0);
					break;
				case 4://设置中心
					toast(listStr.get(position), 0);
					break;
				case 5://设置中心
					toast(listStr.get(position), 0);
					break;
				case 6://设置中心
					toast(listStr.get(position), 0);
					break;
				case 7://设置中心
					toast(listStr.get(position), 0);
					break;
				case 8://设置中心
					toast(listStr.get(position), 0);
					Intent intent =new Intent(MainActivity.this, SettingActivity.class);
					startActivity(intent);
					break;
				default:
					break;
				}
			}
		});
	}

	/**
	 * 列表适配器
	 * 
	 * @author mars_zhang
	 * 
	 */
	class FunsListAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return listStr.size();
		}

		@Override
		public Object getItem(int position) { 
			return listStr.get(position);
		}

		@Override
		public long getItemId(int position) { 
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = View.inflate(MainActivity.this, R.layout.list_item_fun,
					null);
			TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
			tvTitle.setText(listStr.get(position));
			return view;
		}

	} 

}
