package com.mars.mymobilemanager.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mars.mymobilemanager.R;
import com.mars.mymobilemanager.base.BaseFragment;
 

/**
 * 没有加onCreateView   因为基类做了 initView就是没有加onCreateView   initData就是onActivityCreated
 */
public class MenuFragment extends BaseFragment implements View.OnClickListener {

   
    @Override
    public void onClick(View v) {

    }

	@Override
	protected View initView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) { 
		View view=inflater.inflate(R.layout.fragment_menu,container,false);
		return view;
	}
}

