package com.example.activityshengming;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 红超 on 2017/4/13.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    List<String> strings;

    public MyAdapter(Context mainActivity, List<String> strings) {
        context=mainActivity;
        this.strings=strings;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(new TextView(context));

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(strings.get(position));

    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView ;
        public MyViewHolder(View itemView) {
            super(itemView);
           textView = (TextView) itemView;
        }
    }
}
