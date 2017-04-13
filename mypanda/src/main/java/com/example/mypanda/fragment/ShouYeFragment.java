package com.example.mypanda.fragment;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mypanda.AddActivity;
import com.example.mypanda.MainActivity;
import com.example.mypanda.MyApplication;
import com.example.mypanda.R;
import com.example.mypanda.adapter.MyViewPagerAdapter;
import com.example.mypanda.entieny.AllTitle;
import com.example.mypanda.entieny.Name;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.http.POST;

import static android.R.attr.data;

/**
 * 如何拿到网络上的数据
 * Created by 红超 on 2017/2/17.
 */

public class ShouYeFragment extends BaseNavigationFragment {
    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String ename;
    public boolean tag = true;
    private ArrayList<AllTitle.DataBean> top = new ArrayList<>();
    private MyViewPagerAdapter adapter;
    private FragmentManager manager;

    private ArrayList<AllTitle.DataBean> bottom;
    public AllTitle nameList;


    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.layout_shouye, container, false);
        initAllView(view);
        ImageView tianjia = (ImageView) view.findViewById(R.id.tianjia);
        tianjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddActivity.class);
                Gson gson = new Gson();
                String s = gson.toJson(nameList);
                intent.putExtra("topname", s);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return view;
    }

    @Override
    public void initData() {
        Log.e("TAG", "initData--------------======: ");
        if (nameList != null) {
            Log.e("TAG", "inafdafsditData: " + nameList.getData().size());
            Message message = new Message();
            message.obj = nameList;
            handler.sendMessage(message);
        } else {
            Log.e("TAG", "initData: ----------------->");
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().get().url("http://api.m.panda.tv/index.php?method=category.list&type=game&__version=2.1.9.1736&__plat=android").build();
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("TAG", "onFailure: ");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String string = response.body().string();
                    Gson gson = new Gson();
                    Log.e("TAG", "onResponse: ====================");
                    AllTitle allTitle = gson.fromJson(string, AllTitle.class);
                    nameList = allTitle;

                    Message message = new Message();
                    message.obj = nameList;
                    handler.sendMessage(message);
                }
            });
        }
        super.initData();
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.obj != null) {

                initTablayout(nameList.getData());
                initViewPager();
            }
            return true;
        }
    });

    @Override
    public void initAdapter() {
        super.initAdapter();
    }

    private List<Name> dataBeen;
    public List<String> cName=new ArrayList<>();

    private void initViewPager() {
        manager = getFragmentManager();
        adapter = new MyViewPagerAdapter(manager, strings,cName);
        viewPager.setAdapter(adapter);
    }

    private void initTablayout(List<AllTitle.DataBean> list) {
        initTabData(list);
    }

    List<Fragment> strings = new ArrayList<>();

    private void initTabData(List<AllTitle.DataBean> list) {
        tabLayout.removeAllTabs();
        strings.clear();
        for (int i = -1; i < list.size(); i++) {
            View view = View.inflate(context, R.layout.tablayout_item, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_image);
            TextView textView = (TextView) view.findViewById(R.id.item_title);
            if (i == -1) {
//                textView.setText("精彩推荐");
                cName.add("精彩推荐");
                JingCaiTuiianFragment jingCaiTuiianFragment = new JingCaiTuiianFragment();
                strings.add(jingCaiTuiianFragment);
//            } else if (i == -1) {
////                textView.setText("全部直播直播");
//                cName.add("全部直播");
//                QuanBuFragment quanBuFragment = new QuanBuFragment();
//                strings.add(quanBuFragment);
            } else {
                AllEntityFragment allEntityFragment = new AllEntityFragment();
                String cname = list.get(i).getCname();
                ename = list.get(i).getEname();
                allEntityFragment.ename = ename;
//                textView.setText(cname);
                cName.add(cname);
                strings.add(allEntityFragment);

            }
            imageView.setBackgroundResource(R.mipmap.ic_launcher);
//            TabLayout.Tab tab = tabLayout.newTab();
//            tab.setCustomView(textView);
//            tabLayout.setSelected(true);
//            tabLayout.addTab(tab);
        }
        if (viewPager.getAdapter() != null) {
            adapter.notifyDataSetChanged();
        }
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(viewPager);
        viewPager.removeOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }
        });
    }

    private void initAllView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tablelayoutshouye);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
    }
}
