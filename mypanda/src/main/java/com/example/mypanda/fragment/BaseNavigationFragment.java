package com.example.mypanda.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mypanda.R;
import com.example.mypanda.entieny.AllTitle;

import java.util.ArrayList;

/**
 * Created by 红超 on 2017/2/16.
 */

public abstract class BaseNavigationFragment extends BaseFragment {

    @Override
    public View init(LayoutInflater inflater, ViewGroup container) {
        View view = initView(inflater, container);


        return view;
    }

    @Override
    public void initData() {
        super.initData();

    }

    @Override
    public void initAdapter() {
        super.initAdapter();
    }

    public abstract View initView(LayoutInflater inflater, ViewGroup container);

}
