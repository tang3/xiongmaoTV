package com.example.mypanda.adapter;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mypanda.R;
import com.example.mypanda.entieny.AllTitle;
import com.example.mypanda.entieny.Name;
import com.example.mypanda.view.MyTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 红超 on 2017/2/21.
 */

public class MySupRecyclerViewAdapter extends RecyclerView.Adapter<MySupRecyclerViewAdapter.MySupViewHolder> {
    List<String> strings=new ArrayList<>();
    Context context;
    private GridLayoutManager.LayoutParams layoutParams;

    public MySupRecyclerViewAdapter(List<String> strings, Context context) {
        this.strings = strings;
        this.context = context;

    }



    @Override
    public MySupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MySupViewHolder(View.inflate(context,R.layout.recycleritemtext,null));
    }

    @Override
    public void onBindViewHolder(final MySupViewHolder holder, int position) {
        holder.view.setText(strings.get(position));

//        holder.view.setTag(strings.get(position));
//        holder.view.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                ClipData.Item item = new ClipData.Item((CharSequence)v.getTag());
//                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
//
//                ClipData dragData = new ClipData(v.getTag().toString(),mimeTypes, item);
//                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(holder.view);
//
//                v.startDrag(dragData,myShadow,null,0);
//                return true;
//            }
//        });
//        holder.itemView.setOnDragListener(new View.OnDragListener() {
//            @Override
//            public boolean onDrag(View v, DragEvent event) {
//                switch(event.getAction()) {
//                    case DragEvent.ACTION_DRAG_STARTED:
//                        layoutParams = (GridLayoutManager.LayoutParams) v.getLayoutParams();
//                        Log.d(TAG, "Action is DragEvent.ACTION_DRAG_STARTED");
//
//                        // Do nothing
//                        break;
//
//                    case DragEvent.ACTION_DRAG_ENTERED:
//                        Log.d(TAG, "Action is DragEvent.ACTION_DRAG_ENTERED");
//                        int x_cord = (int) event.getX();
//                        int y_cord = (int) event.getY();
//                        break;
//
//                    case DragEvent.ACTION_DRAG_EXITED :
//                        Log.d(TAG, "Action is DragEvent.ACTION_DRAG_EXITED");
//                        x_cord = (int) event.getX();
//                        y_cord = (int) event.getY();
//                        layoutParams.leftMargin = x_cord;
//                        layoutParams.topMargin = y_cord;
//                        v.setLayoutParams(layoutParams);
//                        break;
//
//                    case DragEvent.ACTION_DRAG_LOCATION  :
//                        Log.d(TAG, "Action is DragEvent.ACTION_DRAG_LOCATION");
//                        x_cord = (int) event.getX();
//                        y_cord = (int) event.getY();
//                        break;
//
//                    case DragEvent.ACTION_DRAG_ENDED   :
//                        Log.d(TAG, "Action is DragEvent.ACTION_DRAG_ENDED");
//
//                        // Do nothing
//                        break;
//
//                    case DragEvent.ACTION_DROP:
//                        Log.d(TAG, "ACTION_DROP event");
//
//                        // Do nothing
//                        break;
//                    default: break;
//                }
//                return true;
//            }
//        });
    }

    private static final String TAG = "MySupRecyclerViewAdapte";
    @Override
    public int getItemCount() {

        return strings.size();
    }

    public class MySupViewHolder extends RecyclerView.ViewHolder{
        MyTextView view=new MyTextView(context);
        public MySupViewHolder(View itemView) {
            super(itemView);
            view= (MyTextView) itemView;
        }
    }
}
