package com.example.mypanda.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypanda.PlayerActivity;
import com.example.mypanda.R;
import com.example.mypanda.Utils.DPPXUtile;
import com.example.mypanda.Utils.GetData;
import com.example.mypanda.adapter.SimpRecyclerAdapter;
import com.example.mypanda.entieny.TypeEntity;
import com.example.mypanda.entieny.XingYan;
import com.example.mypanda.entieny.XingYanEntity;
import com.example.mypanda.view.SuperRecyclerView;
import com.google.gson.Gson;

import java.util.List;


/**
 * Created by 红超 on 2017/2/19.
 */

public class JingCaiTuiianFragment extends BaseAllEntityFrgment implements SwipeRefreshLayout.OnRefreshListener {
    SwipeRefreshLayout swip;
    SuperRecyclerView recyclerView;
    View view;
    private String url;
    private SimpRecyclerAdapter simpRecyclerAdapter;
    private String first;
    private String end;
    private int pagenumb;
    private TypeEntity typeEntity;

    @Override
    protected void initView(ViewGroup root) {
        first = "http://api.m.panda.tv/ajax_get_live_list_by_multicate?pagenum=";
        end = "&hotroom=1&sproom=1&__version=2.1.9.1736&__plat=android";
        pagenumb = 1;
        recyclerView = (SuperRecyclerView) root.findViewById(R.id.allentityfragment);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(manager);
        swip = (SwipeRefreshLayout) root.findViewById(R.id.swip);
        view = View.inflate(context, R.layout.allfragmenthead, null);
        swip.setOnRefreshListener(this);

    }


    Handler handler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
            String s = (String) msg.obj;
            Gson gson = new Gson();


            GridLayoutManager manager = new GridLayoutManager(context, 2);
//            if (simpRecyclerAdapter != null) {
//                XingYanEntity xingYanEntity = gson.fromJson(s, XingYanEntity.class);
//                simpRecyclerAdapter.notifyDataSetChanged();
//                return true;
//            }
            typeEntity = gson.fromJson(s, TypeEntity.class);
            simpRecyclerAdapter = new SimpRecyclerAdapter(context, typeEntity, manager);
            recyclerView.addItemDecoration(new itemPadding());
            recyclerView.setAdapter(simpRecyclerAdapter);

            return true;
        }
    });

    @Override
    protected void initData() {
        url = first + pagenumb+ end;
        GetData.GetData(url, context, handler);
    }

    boolean isRefresh = false;

    @Override
    public void onRefresh() {
//        if (!isRefresh) {
//            pagenumb++;
//            swip.setRefreshing(true);
//            url="http://m.api.xingyan.panda.tv/room/index?__version=2.1.9.1736&__plat=android&__channel=guanwang";
////            url =first+pagenumb+end;
//                    GetData.GetData(url, context, handler);
//            swip.setRefreshing(false);
//        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                swip.post(new Runnable() {
                    @Override
                    public void run() {
                        swip.setRefreshing(false);
                    }
                });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });
    }
    public  class itemPadding extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int i = DPPXUtile.Dp2Px(context, 2);
            int l = DPPXUtile.Dp2Px(context, 5);
            outRect.top=l;
            outRect.bottom=l;
            outRect.left=i;
            outRect.right=i;


        }
    }

}
