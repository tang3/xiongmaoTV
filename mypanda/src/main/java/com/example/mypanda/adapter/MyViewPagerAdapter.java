package com.example.mypanda.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.mypanda.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 红超 on 2017/2/18.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> list = new ArrayList<>();
    Context context;
    List<String> cName = new ArrayList<>();

    @Override
    public CharSequence getPageTitle(int position) {
        Drawable image = context.getResources().getDrawable(R.mipmap.ic_launcher);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        SpannableString sb = new SpannableString(cName.get(position));
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return null;

    }

    public MyViewPagerAdapter(Context context, FragmentManager fm, List<Fragment> list, List<String> cName) {
        super(fm);
        this.context = context;
        this.list = list;
        this.cName = cName;
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
