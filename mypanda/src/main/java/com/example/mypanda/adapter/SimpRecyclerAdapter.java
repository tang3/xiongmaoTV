package com.example.mypanda.adapter;

import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mypanda.PlayerActivity;
import com.example.mypanda.R;
import com.example.mypanda.Utils.DPPXUtile;
import com.example.mypanda.Utils.GetData;
import com.example.mypanda.entieny.AllEntity;
import com.example.mypanda.entieny.TypeEntity;
import com.example.mypanda.view.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 红超 on 2017/3/5.
 */

public class SimpRecyclerAdapter extends RecyclerView.Adapter<SimpRecyclerAdapter.MyViewholer> implements SuperRecyclerView.OnItemClickListenr, View.OnClickListener {
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
    public void onBindViewHolder(MyViewholer holder, final int position) {
        List<TypeEntity.DataBean.ItemsBean> items = typeEntity.getData().get(position).getItems();
        holder.view.setText(typeEntity.getData().get(position).getType().getCname());
        GridLayoutManager manager=new GridLayoutManager(context,2);
        holder.recyclerView.setLayoutManager(manager);
        holder.recyclerView.addItemDecoration(new itemPadding());
        holder.recyclerView.setAdapter(new TypeRecyclerAdapter(items,context));


    }

    @Override
    public int getItemCount() {
        return typeEntity.getData().size();
    }

    private static final String TAG = "SimpRecyclerAdapter";
    @Override
    public void onItemClick(RecyclerView recyclerView, View view, int position,int headCount) {
//        Log.e(TAG, "onItemClick: "+position+headCount );
//        String room_key = typeEntity.getData().get(position-headCount).getItems().get(position).getRoom_key();
//        String id = typeEntity.getData().get(position-headCount).getItems().get(position).getId();
//        if (room_key == "") {
//            GetData.GetRootKey(id, context);
//        } else {
//            Intent intent = new Intent(context, PlayerActivity.class);
//            intent.putExtra("key", room_key);
//            Log.e("TAG", "o-----------nItemClick: "+room_key );
//            context.startActivity(intent);
//        }
//        Log.e(TAG, "onItemClick: "+position );
    }

    @Override
    public void onClick(View v) {
        Log.e(TAG, "onClick: ======================item" );
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
    public  class itemPadding extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int i = DPPXUtile.Dp2Px(context, 2);
            int i1 = DPPXUtile.Dp2Px(context, 5);
            outRect.top=i1;
            outRect.bottom=i1;
            outRect.left=i;
            outRect.right=i;
        }
    }
}
