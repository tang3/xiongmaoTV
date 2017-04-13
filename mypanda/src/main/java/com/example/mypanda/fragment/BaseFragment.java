package com.example.mypanda.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypanda.R;
import com.example.mypanda.entieny.AllTitle;

import java.util.ArrayList;

/**
 * Created by 红超 on 2017/2/16.
 */

public abstract class BaseFragment extends Fragment {
    private ArrayList<AllTitle.DataBean> top;
    protected Context context;
    protected View root;
    //onattach 是在fragment第一次被放入fragment中的时候调用的紧接着调用oncreat方法
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context= context;
    }
    //oncreat 方法是在onattach方法之后但是在oncreateview方法之前被调用,也可以在
    //fragment的activity的正在被oncreate的时候调用
    protected   boolean ischange=true;
    private static final String TAG = "tag";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("TGAG", "onCreateView: "+ischange );

        if (root==null){
            Log.e("TGAG", "onCreateView: 进入了" );
            //如果root是空的那么就开始做初始化的操作防止多次的添加
            root=init(inflater,container);
            initData();
            initAdapter();
            return root;
        }
//
        return root;

    }
    public void setIschange(boolean tag){
        ischange=tag;
    };
    public  void initAdapter(){};

    public void initData(){};



    /**
     * 对fragment进行初始化
     * @param inflater
     * @param container
     * @return
     */
    public abstract View init(LayoutInflater inflater, ViewGroup container);
}
