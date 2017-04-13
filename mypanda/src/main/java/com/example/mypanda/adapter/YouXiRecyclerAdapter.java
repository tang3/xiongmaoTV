package com.example.mypanda.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mypanda.R;
import com.example.mypanda.entieny.AllTitle;

import java.util.List;

/**
 * Created by 红超 on 2017/3/2.
 */

public class YouXiRecyclerAdapter extends RecyclerView.Adapter<YouXiRecyclerAdapter.ViewHolder> {
    AllTitle allTitle;
    Context context;
    private final List<AllTitle.DataBean> data;

    public YouXiRecyclerAdapter(AllTitle allTitle, Context context) {
        this.allTitle = allTitle;
        this.context = context;
        data = allTitle.getData();
    }

    @Override
    public YouXiRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context,R.layout.youxi_recycler_item,null));
    }

    @Override
    public void onBindViewHolder(YouXiRecyclerAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(data.get(position).getImg()).error(R.mipmap.welcome).into(holder.imageView);
        holder.textView.setText(data.get(position).getCname());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.youxi_item_image);
            textView = (TextView) itemView.findViewById(R.id.youxi_item_text);
        }
    }
}
