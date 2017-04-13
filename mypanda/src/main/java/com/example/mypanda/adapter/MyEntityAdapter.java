package com.example.mypanda.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.mypanda.R;
import com.example.mypanda.entieny.AllEntity;

import java.util.List;

/**
 * Created by 红超 on 2017/2/18.
 */
public class MyEntityAdapter extends RecyclerView.Adapter<MyViewHolder> {
    List<AllEntity.DataBean.ItemsBean> list;
    Context context;
    List<AllEntity.DataBean.BannersBean> beanList;
    public MyEntityAdapter(List<AllEntity.DataBean.ItemsBean> allEntityList, Context context, List<AllEntity.DataBean.BannersBean> banners) {
        list = allEntityList;
        this.context = context;
        this.beanList=banners;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(View.inflate(context,R.layout.entity_item,null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AllEntity.DataBean.ItemsBean itemsBean = list.get(position);
        holder.bigTitle.setText(itemsBean.getName());
        holder.title.setText(itemsBean.getUserinfo().getNickName());
        Glide.with(context).load(itemsBean.getPictures().getImg()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
