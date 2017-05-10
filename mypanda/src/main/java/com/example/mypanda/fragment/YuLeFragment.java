package com.example.mypanda.fragment;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypanda.R;
import com.example.mypanda.Utils.DPPXUtile;
import com.example.mypanda.Utils.GetData;
import com.example.mypanda.adapter.MyViewPagerAdapter;
import com.example.mypanda.entieny.YuLeTitle;
import com.example.mypanda.entieny.YuleEntity;
import com.example.mypanda.service.ResOrFail;
import com.example.mypanda.view.SuperRecyclerView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * Created by 红超 on 2017/2/17.
 */

public class YuLeFragment extends BaseNavigationFragment {
    View view;
    private TabLayout tabLayout;

    private ViewPager viewPager;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_yule, container, false);
        initAllView(view);
        intData();

        return view;
    }


    Map<String, String> map = new HashMap<>();
    String url = "http://api.m.panda.tv/index.php?method=category.list&type=yl&mixed=1&__version=2.1.9.1736&__plat=android";
    List<Fragment> fragments =new ArrayList<>();
    List<String> cName=new ArrayList<>();
    List<String> eName =new ArrayList<>();
    private void intData() {
        GetData.GetYuLeTitle(url, context, new ResOrFail() {
            @Override
            public String Respond(String string) {
                Gson gson = new Gson();
                final YuLeTitle yuLeTitle = gson.fromJson(string, YuLeTitle.class);
                new Thread() {
                    public void run() {
                        //这儿是耗时操作，完成之后更新UI；
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //更新UI

                                for (YuLeTitle.DataBean dataBean : yuLeTitle.getData()) {
                                    if (dataBean.getEname().equals("yzdr")||dataBean.getEname().equals("xingyan"))
                                    continue;
                                    cName.add(dataBean.getCname());
                                    eName.add(dataBean.getEname());
                                    Log.e("TAGGG", "run: "+dataBean.getEname() );
                                    YuLeContent yuLeContent = new YuLeContent();
                                    yuLeContent.eName=dataBean.getEname();
                                    fragments.add(yuLeContent);


                                }
                                for (String s : cName) {
                                    TabLayout.Tab tab = tabLayout.newTab();
                                    View view = View.inflate(context, R.layout.tabview, null);
                                    ImageView tabimage = (ImageView) view.findViewById(R.id.tabimage);
                                    TextView tabtext = (TextView) view.findViewById(R.id.tabtext);
                                    tabimage.setImageResource(R.mipmap.ic_launcher);
                                    tabtext.setText(s);
                                    tab.setCustomView(view);

                                    tabLayout.addTab(tab);
                                }

                                    viewPager.setAdapter(new MyViewPagerAdapter(getContext(),getFragmentManager(),fragments,cName));


                            }

                        });
                    }
                }.start();


                return string;
            }

            @Override
            public String Faile(IOException e) {
                return e.getMessage();
            }
        });

    }

    private static final String TAG = "YuLeFragment";
    private void initAllView(final View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.yule_tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.yuleviewpager);
        Log.e(TAG, "initAllView: " );


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));




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

}
