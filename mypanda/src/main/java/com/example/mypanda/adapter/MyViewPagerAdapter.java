package com.example.mypanda.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 红超 on 2017/2/18.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> list=new ArrayList<>();
    Context context;
    List<String> cName=new ArrayList<>();
    @Override
    public CharSequence getPageTitle(int position) {

        return cName.get(position);
    }

    public MyViewPagerAdapter(FragmentManager fm, List<Fragment> list,List<String> cName) {
        super(fm);
       this.list=list;
        this.cName=cName;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

}
