package com.example.mypanda.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mypanda.R;

/**
 * Created by 红超 on 2017/2/18.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView bigTitle;
    TextView title;

    public MyViewHolder(View itemView) {
        super(itemView);
        bigTitle = (TextView) itemView.findViewById(R.id.allitembigtitle);
        imageView = (ImageView) itemView.findViewById(R.id.allitemimmage);
        title = (TextView) itemView.findViewById(R.id.allitemtitle);

    }
}
