package com.example.mypanda.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mypanda.R;
import com.example.mypanda.entieny.AllEntity;
import com.example.mypanda.entieny.YuleEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 红超 on 2017/3/17.
 */

public class MyYuLeAdapter extends RecyclerView.Adapter<MyYuLeAdapter.MyViewHolder>{
    List<YuleEntity.DataBean.ItemsBean> items=new ArrayList<>();
    Context context;
    public MyYuLeAdapter(List<YuleEntity.DataBean.ItemsBean> items, Context context) {
        this.items=items;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyYuLeAdapter.MyViewHolder(View.inflate(context, R.layout.entity_item, null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.topTitle.setText(items.get(position).getName());
        holder.bottomTitle.setText(items.get(position).getUserinfo().getNickName());
        Glide.with(context).load(items.get(position).getPictures().getImg()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView topTitle;
        TextView bottomTitle;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            topTitle = (TextView) itemView.findViewById(R.id.allitemtitle);
            imageView = (ImageView) itemView.findViewById(R.id.allitemimmage);
            bottomTitle = (TextView) itemView.findViewById(R.id.allitembigtitle);
        }
    }
}
