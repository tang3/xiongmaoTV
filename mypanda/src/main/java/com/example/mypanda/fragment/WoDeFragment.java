package com.example.mypanda.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mypanda.R;

/**
 * Created by 红超 on 2017/2/17.
 */

public class WoDeFragment extends BaseNavigationFragment {

    private View view;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_wode, container, false);
        initAllView(view);
        intData();
        return view;
    }

    private void intData() {
    }

    private void initAllView(View view) {

    }
}
