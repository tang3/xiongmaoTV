package com.example.mypanda.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mypanda.R;
import com.example.mypanda.Utils.DPPXUtile;
import com.example.mypanda.XiangQingActivity;
import com.example.mypanda.adapter.YouXiRecyclerAdapter;
import com.example.mypanda.entieny.AllTitle;
import com.example.mypanda.view.SuperRecyclerView;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 红超 on 2017/2/17.
 */

public class YouXiFragment extends BaseNavigationFragment {
    View view;
    private SuperRecyclerView recyclerView;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_youxi, container, false);
        intData();

        return view;
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            initAllView(view);
            return true;
        }
    });

    private AllTitle allTitle;
    private void intData() {
        String s = "http://api.m.panda.tv/index.php?method=category.list&type=game&__version=2.1.9.1736&__plat=android";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(s).get().build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "onFailure: " + e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                allTitle = gson.fromJson(string, AllTitle.class);
                handler.sendEmptyMessage(0);
            }
        });
    }

    private void initAllView(View view) {
        GridLayoutManager manager = new GridLayoutManager(context, 3);

        recyclerView = (SuperRecyclerView) view.findViewById(R.id.youxifragmentrecycler);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new YouXiRecyclerAdapter(allTitle,context));

        recyclerView.addItemDecoration(new MyItemPadding());
        recyclerView.setOnItemClickListener(new SuperRecyclerView.OnItemClickListenr() {
            @Override
            public void onItemClick(RecyclerView recyclerView, View view, int position,int headCount) {
                Intent intent =new Intent(context, XiangQingActivity.class);
                AllTitle.DataBean dataBean = allTitle.getData().get(position);
                intent.putExtra("alltitle",dataBean);
                startActivity(intent);
            }
        });
    }
    public  class MyItemPadding extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int i = DPPXUtile.Dp2Px(context, 2);
            outRect.top= i;
            outRect.bottom=i;
            outRect.right=i;
            outRect.left=i;
        }
    }
}
