package com.example.mypanda.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mypanda.R;
import com.example.mypanda.Utils.DPPXUtile;
import com.example.mypanda.Utils.GetData;
import com.example.mypanda.adapter.MyEntityAdapter;
import com.example.mypanda.adapter.MyYuLeAdapter;
import com.example.mypanda.entieny.YuleEntity;
import com.example.mypanda.service.ResOrFail;
import com.example.mypanda.view.SuperRecyclerView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

/**
 * Created by 红超 on 2017/3/17.
 */

public class YuLeContent extends BaseAllEntityFrgment {


    private SuperRecyclerView recyclerView;
    private SwipeRefreshLayout swip;

    public String eName;
    private int anInt=1;
    private String url;
    private String string;
    private String string1;
    private String string2;

    @Override
    protected void initView(ViewGroup root) {

        string = "http://api.m.panda.tv/ajax_get_live_list_by_cate?cate=";
        string1 = "&pageno=";
        string2 = "&pagenum=20&sproom=1&__version=2.1.9.1736&__plat=android";
//        root = (ViewGroup) inflater.inflate(R.layout.allentity_fragment, null);
        recyclerView = (SuperRecyclerView) root.findViewById(R.id.allentityfragment);
        swip = (SwipeRefreshLayout) root.findViewById(R.id.swip);
        GridLayoutManager manager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new itemPadding());


    }
    public String setEname(String eName){
        this.eName=eName;
        return this.eName;
    }
    @Override
    protected void initData() {
        swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                anInt++;
                url="";
                url=string + eName + string1 + anInt + string2;
                getData(url);
            }
        });


        url = string + eName + string1 + anInt + string2;

        getData(url);


    }

    private void getData(final String url) {
        GetData.GetYuLeContent(url, context, new ResOrFail() {
            @Override
            public String Respond(String string) {
                if (!eName.equals("yzdr")&&!eName.equals("xingyan")) {
                    final YuleEntity yuleEntity = new Gson().fromJson(string, YuleEntity.class);
                    Log.e("recyclerView", "initData: " + url);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Log.e("recyclerView", "run: ");
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    YuleEntity.DataBean data = yuleEntity.getData();
                                    List<YuleEntity.DataBean.ItemsBean> items = data.getItems();
                                    Log.e("recyclerView", "run: ");
                                    if (anInt==1) {
                                        recyclerView.setAdapter(new MyYuLeAdapter(items, context));
                                    }
                                    else{
                                        recyclerView.getAdapter().notifyDataSetChanged();
                                    }
                                }
                            });
                        }
                    }).start();

                }
                return null;
            }

            @Override
            public String Faile(IOException e) {
                return null;
            }
        });
    }
    public  class itemPadding extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int i = DPPXUtile.Dp2Px(context, 2);
            int i1 = DPPXUtile.Dp2Px(context, 5);
            outRect.top=i1;
            outRect.bottom=i1;
            outRect.left=i;
            outRect.right=i;


        }
    }
}
