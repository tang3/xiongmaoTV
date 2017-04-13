package com.example.mypanda.adapter;

import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mypanda.PlayerActivity;
import com.example.mypanda.R;
import com.example.mypanda.Utils.GetData;
import com.example.mypanda.entieny.AllEntity;
import com.example.mypanda.entieny.TypeEntity;
import com.example.mypanda.view.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 红超 on 2017/3/5.
 */

public class SimpRecyclerAdapter extends RecyclerView.Adapter<SimpRecyclerAdapter.MyViewholer> implements SuperRecyclerView.OnItemClickListenr {
    TypeEntity typeEntity;
    Context context;
    GridLayoutManager manager;
    public SimpRecyclerAdapter(Context context, TypeEntity typeEntity, GridLayoutManager manager) {
        this.typeEntity = typeEntity;
        this.context=context;
        this.manager=manager;
    }

    @Override
    public MyViewholer onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewholer( View.inflate(context, R.layout.simprecycleritem,null));
    }

    @Override
    public void onBindViewHolder(MyViewholer holder, int position) {
        List<TypeEntity.DataBean.ItemsBean> items = typeEntity.getData().get(position).getItems();
        holder.view.setText(typeEntity.getData().get(position).getType().getCname());
        GridLayoutManager manager=new GridLayoutManager(context,2);
        holder.recyclerView.setLayoutManager(manager);
        holder.recyclerView.setOnItemClickListener(this);
        holder.recyclerView.setAdapter(new TypeRecyclerAdapter(items,context));

    }

    @Override
    public int getItemCount() {
        return typeEntity.getData().size();
    }

    @Override
    public void onItemClick(RecyclerView recyclerView, View view, int position) {
        String room_key = typeEntity.getData().get(position).getItems().get(position).getRoom_key();
        String id = typeEntity.getData().get(position).getItems().get(position).getId();
        if (room_key == "") {
            GetData.GetRootKey(id, context);
        } else {
            Intent intent = new Intent(context, PlayerActivity.class);
            intent.putExtra("key", room_key);
            Log.e("TAG", "o-----------nItemClick: "+room_key );
            context.startActivity(intent);
        }
    }
    protected class MyViewholer extends RecyclerView.ViewHolder{
        TextView view=new TextView(context);
        SuperRecyclerView recyclerView=new SuperRecyclerView(context);
        public MyViewholer(View itemView) {
            super(itemView);
            view= (TextView) itemView.findViewById(R.id.type_title);
            recyclerView= (SuperRecyclerView) itemView.findViewById(R.id.type_recycler);
        }
    }
}
