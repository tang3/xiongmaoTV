package com.example.mypanda.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypanda.PlayerActivity;
import com.example.mypanda.R;
import com.example.mypanda.Utils.GetData;
import com.example.mypanda.adapter.MyEntityAdapter;
import com.example.mypanda.adapter.MySupViewPagerAdapter;
import com.example.mypanda.entieny.AllEntity;
import com.example.mypanda.entieny.GetRootKey;
import com.example.mypanda.view.MySupViewPage;
import com.example.mypanda.view.SuperRecyclerView;
import com.example.mypanda.view.SuperViewPager;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 红超 on 2017/2/18.
 */

public class AllEntityFragment extends BaseAllEntityFrgment implements SuperRecyclerView.OnItemClickListenr, SwipeRefreshLayout.OnRefreshListener {
    private AllEntity allEntity;
    ViewGroup group;
    int pageno = 1;
    protected String ename;
    private String string;
    private String string1;
    private String string2;
    private String url;
    private SuperRecyclerView recyclerView;
    private OkHttpClient client;
    private SwipeRefreshLayout swip;
    private boolean isLod = false;
    private List<AllEntity.DataBean.BannersBean> banners;
    MyEntityAdapter adapter;
    private MySupViewPage viewpager;
    private View view;
    private List<AllEntity.DataBean.ItemsBean> items;
    private String room_key;

    @Override
    public void onItemClick(RecyclerView recyclerView, View view, int position) {

        String root_id = allEntityList.get(position).getId();
//        &&!isLod
        room_key = "";
        room_key = allEntityList.get(position).getRoom_key();
        if (room_key == "") {

//            http://api.m.panda.tv/ajax_get_liveroom_baseinfo?roomid=820866
            GetData.GetRootKey(root_id, context);

        } else {

            Intent intent = new Intent(context, PlayerActivity.class);
            Log.e(TAG, "onItemClick: " + room_key);
            intent.putExtra("key", room_key);
            startActivity(intent);
        }

    }

    @Override
    public void onRefresh() {
        addFooter();
    }

    public interface OnItemClickListener {
        String onItemClickListener(String ename);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        this.listener = clickListener;

    }


    public class SpaceItemDecoration extends RecyclerView.ItemDecoration{

        private int space;

        public SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

            if(parent.getChildPosition(view) != 0) {
                outRect.top = 5;
                outRect.left=space;
                outRect.right=space;
            }
        }
    }
    @Override
    protected void initView(ViewGroup root) {

        if (listener != null) {
            ename = listener.onItemClickListener(ename);
            Log.e(TAG, "initView:-----------------> " + ename);
        }
        string = "http://api.m.panda.tv/ajax_get_live_list_by_cate?cate=";
        string1 = "&pageno=";
        string2 = "&pagenum=20&sproom=1&__version=2.1.9.1736&__plat=android&banner=1&slider=1";
        group = root;
        client = new OkHttpClient();
        recyclerView = (SuperRecyclerView) group.findViewById(R.id.allentityfragment);
        recyclerView.addItemDecoration(new SpaceItemDecoration(10));
        final GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(manager);
        swip = (SwipeRefreshLayout) group.findViewById(R.id.swip);
        view = View.inflate(context, R.layout.allfragmenthead, null);
        viewpager = (MySupViewPage) view.findViewById(R.id.headviewpager);
        recyclerView.setOnItemClickListener(this);
        swip.setOnRefreshListener(this);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (manager.findLastVisibleItemPosition()==recyclerView.getAdapter().getItemCount()-1){
                    if (newState==0){
                        addFooter();
                    }
                }
                super.onScrollStateChanged(recyclerView, newState);
            }
        });

    }

    private void addFooter() {
        ++pageno;
        isLod = true;
        GetData(pageno, ename);
    }

    private void GetData(final int pageno, String ename) {
        url = "";
        url = string + ename + string1 + pageno + string2;
        Request request = new Request.Builder().get().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                allEntity = new Gson().fromJson(string, AllEntity.class);
                banners = allEntity.getData().getBanners();

                items = allEntity.getData().getItems();
                Log.e(TAG, "onResponse: " + items.toString());
                if (items.size() == 0) {

                    handler.sendEmptyMessage(102);
                    return;
                } else if (pageno == 1) {

                    allEntityList.addAll(items);
                    handler.sendEmptyMessage(100);
                } else {
                    if (swip.isRefreshing())
                        allEntityList.clear();
                    allEntityList.addAll(items);
                    handler.sendEmptyMessage(101);
                }
            }
        });
    }

    Bundle bundle;

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        bundle = args;
    }

    @Override
    protected void initData() {
        GetData(pageno, ename);
    }

    List<AllEntity.DataBean.ItemsBean> allEntityList = new ArrayList<>();
    Handler handler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 100) {
                if (banners.size() != 0) {
                    recyclerView.addHeadView(view);

                    viewpager.setAdapter(new MySupViewPagerAdapter(banners, context));
                }
                adapter = new MyEntityAdapter(allEntityList, context, banners);
                recyclerView.setAdapter(adapter);
            } else if (msg.what == 101) {
                Log.e(TAG, "handleMessage: "+recyclerView.getAdapter().getItemCount() );
                recyclerView.getAdapter().notifyDataSetChanged();
                swip.setRefreshing(false);
            } else if (msg.what == 102) {
                swip.setRefreshing(false);

                Toast.makeText(context, "没有更多数据", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    });
    private static final String TAG = "TGA";


}
