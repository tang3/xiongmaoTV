package com.example.mypanda.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypanda.R;
import com.example.mypanda.view.SuperRecyclerView;

/**
 * Created by 红超 on 2017/2/18.
 */

public abstract class BaseAllEntityFrgment extends Fragment {
    protected Context context;
    private ViewGroup root;

    //onattach 是在fragment第一次被放入fragment中的时候调用的紧接着调用oncreat方法
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context= context;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       if (root==null) {
           root = (ViewGroup) inflater.inflate(R.layout.allentity_fragment, null);
           initView(root);
           initData();
           Log.e("TAG", "onCreateView: zai ci dioa yong ");
           return root;
       }
        return root;
       }

    @Override
    public void onStart() {
        super.onStart();
    }

    protected abstract void initView(ViewGroup root);

    protected abstract void initData();

}
