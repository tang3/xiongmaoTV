package com.example.mypanda.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mypanda.PlayerActivity;
import com.example.mypanda.R;
import com.example.mypanda.Utils.DPPXUtile;
import com.example.mypanda.Utils.GetData;
import com.example.mypanda.entieny.TypeEntity;
import com.example.mypanda.service.MyitemClickListener;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.List;

/**
 * Created by 红超 on 2017/3/5.
 */

public class TypeRecyclerAdapter extends RecyclerView.Adapter<TypeRecyclerAdapter.MyViewHoler> {
    List<TypeEntity.DataBean.ItemsBean> data;
    Context context;
    private TypeEntity.DataBean.ItemsBean itemsBean;

    public TypeRecyclerAdapter(List<TypeEntity.DataBean.ItemsBean>  data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public MyViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHoler(View.inflate(context, R.layout.entity_item, null));
    }

    @Override
    public void onBindViewHolder(MyViewHoler holder, final int position) {

        itemsBean = data.get(position);
        Glide.with(context).load(itemsBean.getPictures().getImg()).error(R.mipmap.ic_launcher).into(holder.imageView);
        holder.topTitle.setText(itemsBean.getUserinfo().getNickName());
        holder.bottomTitle.setText(itemsBean.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String room_key = data.get(position).getRoom_key();
                String id = data.get(position).getId();
                if (room_key == "") {
                    Log.e(TAG, "onClick: "+id );
                    Log.e(TAG, "o-----------nItemClick: "+room_key );
                    GetData.GetRootKey(id, context);
                } else {
                    Log.e(TAG, "onClick: "+id );
                    Log.e(TAG, "o-----------nItemClick: "+room_key );
                    GetData.GetRootKey(id, context);
//                    Log.e(TAG, "onClick: "+id );
//                    Intent intent = new Intent(context, PlayerActivity.class);
//                    intent.putExtra("key", room_key);
//                    Log.e(TAG, "o-----------nItemClick: "+room_key );
//                    context.startActivity(intent);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private static final String TAG = "TypeRecyclerAdapter";

    class MyViewHoler extends RecyclerView.ViewHolder  {
        TextView topTitle;
        TextView bottomTitle;
        ImageView imageView;

        public MyViewHoler(View itemView) {
            super(itemView);
            topTitle = (TextView) itemView.findViewById(R.id.allitemtitle);
            imageView = (ImageView) itemView.findViewById(R.id.allitemimmage);
            bottomTitle = (TextView) itemView.findViewById(R.id.allitembigtitle);
        }


    }



}
