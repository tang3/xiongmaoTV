package com.example.mypanda.adapter;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mypanda.R;
import com.example.mypanda.entieny.AllEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 红超 on 2017/2/19.
 */
public class MySupViewPagerAdapter extends PagerAdapter {
    List<AllEntity.DataBean.BannersBean> list;

    //    List<TextView> list;
    Context context;
    private List<ImageView> imageViewList;
    List<ImageView> viewList = new ArrayList<>();

    public MySupViewPagerAdapter(List<AllEntity.DataBean.BannersBean> banners, Context context) {
        list = banners;
        this.context = context;
        imageViewList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
        Log.e(TAG, "MySupViewPagerA==================dapter: "+list.size() );
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(R.mipmap.ic_launcher);
            imageViewList.add(imageView);
        }

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
    boolean tag=true;
    private static final String TAG = "MySupViewPagerAdapter";
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view ;


        view = imageViewList.get(position % list.size());

        Glide.with(context).load(list.get(position % list.size()).getBigimg()).error(R.mipmap.ic_launcher).into((ImageView) view);
        tag=!tag;

        if (container != null) {
            container.removeView(view);
            container.addView(view);
        }
        return view;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
