package com.mars.mymobilemanager.base;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 基类fragment
 */
public abstract class BaseFragment extends Fragment {

    protected Activity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mActivity=getActivity();
        return initView(inflater, container, savedInstanceState);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected void initData() {
    }

    protected abstract View initView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState);

}
