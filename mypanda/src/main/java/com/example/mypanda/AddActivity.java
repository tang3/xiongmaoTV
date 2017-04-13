package com.example.mypanda;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mypanda.adapter.MySupRecyclerViewAdapter;
import com.example.mypanda.entieny.AllTitle;
import com.example.mypanda.entieny.Name;
import com.example.mypanda.view.MyTextView;
import com.example.mypanda.view.SuperRecyclerView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IllegalFormatCodePointException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 红超 on 2017/2/21.
 */


public class AddActivity extends BaseActivity {
    private SuperRecyclerView top;
    private SuperRecyclerView bottom;
    boolean tag = true;
    private GridLayoutManager manager;
    private GridLayoutManager manager1;
    public ArrayList<AllTitle> topList;
    public ArrayList<AllTitle> bottomList;
    private AllTitle topname;
    private RelativeLayout linear;
    private List<String> bottomstring;
    private List<String> topstring;
    private Rect frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        RecyclerView.ItemDecoration itemDecoration = new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.top = 30;
                outRect.right=30;

            }
        };

//        Bundle bundle = getIntent().getExtras();
//        String a = bundle.getString("a");
//        Log.e("abc", "onCreate: "+a );
        linear = (RelativeLayout) findViewById(R.id.linear);

        String topna = getIntent().getStringExtra("topname");
        AllTitle allTi = new Gson().fromJson(topna, AllTitle.class);
//        this.topname = bundle.getParcelable("topname");
        topname = allTi;
        Log.e("TAG", "initData: ----------------->" + this.topname.toString());
        initData();

        top = (SuperRecyclerView) findViewById(R.id.recyclertop);
        top.addItemDecoration(itemDecoration);


        bottom = (SuperRecyclerView) findViewById(R.id.recyclerbottom);
        bottom.addItemDecoration(itemDecoration);
        topList = new ArrayList<>();
        bottomList = new ArrayList<>();

        manager = new GridLayoutManager(this, 3);
        manager1 = new GridLayoutManager(this, 3);
        top.setLayoutManager(manager1);
        bottom.setLayoutManager(manager);
        top.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Log.e(TAG, "onDrag: " );
                return false;
            }
        });
        frame = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        initListener();

    }














    private static final String TAG = "AddActivity";
    boolean isTach=false;
    private void initListener() {
        top.setOnItemClickListener(new SuperRecyclerView.OnItemClickListenr() {



            @Override
            public void onItemClick( RecyclerView recyclerView,  View view,  int position) {
                Bottom(view, position,bottom,bottomstring,top,topstring);
                Log.e(TAG, "onItemClick: "+position );


            }


        });

        bottom.setOnItemClickListener(new SuperRecyclerView.OnItemClickListenr() {
            @Override
            public void onItemClick(RecyclerView recyclerView, View view, int position) {
//                int lastVisibleItemPosition = manager.findLastVisibleItemPosition();
//                Log.e("TAG", "onItemClick: position" +position+"------" +lastVisibleItemPosition);
//                topname.getData().add(data.get(position));
//                data.remove(position);
//                recyclerView.getAdapter().notifyDataSetChanged();
//                top.getAdapter().notifyDataSetChanged();
                Bottom(view,position,top,topstring,bottom,bottomstring);


            }
        });
    }

    public void Bottom(final View view, final int position, final SuperRecyclerView recycler, final List<String> stringList, final SuperRecyclerView recycler2, final List<String> stringlist2) {
        final int itemCount = recycler.getAdapter().getItemCount();

        if (isTach==true) return;
        isTach=true;
        stringList.add("aa");
        recycler.getAdapter().notifyDataSetChanged();

        isTach=false;
        recycler.post(new Runnable() {
            @Override
            public void run() {
                Log.e("TAG", "onItemClick:bottom.getAdapter().getItemCount() "+recycler.getAdapter().getItemCount() );
                TextView childAt = (TextView) recycler.getChildAt(recycler.getAdapter().getItemCount()-1);
                Log.e(TAG, "run:"+ childAt.getText());
                if (childAt==null){
                    Log.e(TAG, "run: =========31======kong" );
                }
                int [] bottomloca=new int[2];
                childAt.getLocationInWindow(bottomloca);
//                childAt.getLocationOnScreen(bottomloca);
                //点击的时候先在上方初始化一个view将该view移动到bottom,bottom notify
                final TextView textView = new MyTextView(AddActivity.this);
                //该view的位置是当前position上的view的位置

                int statusBarHeight = frame.top;
                int [] lacation=new int[2];
                //拿到最后一个view的位置了
                view.getLocationOnScreen(lacation);
                RelativeLayout.LayoutParams layoutParams =new RelativeLayout.LayoutParams(view.getWidth(),view.getHeight());
                layoutParams.leftMargin=lacation[0];
                layoutParams.topMargin=lacation[1]-statusBarHeight;
                 //下一个位置

                textView.setText(stringlist2.get(position));

                Log.e("TAG", "onItemClick: "+lacation[0]+"----"+lacation[1] );
                //view消失
                textView.setLayoutParams(layoutParams);

                //延迟后消失


                linear.addView(textView);

                PropertyValuesHolder hx = PropertyValuesHolder.ofFloat("translationX", bottomloca[0]-lacation[0]);
                PropertyValuesHolder hy = PropertyValuesHolder.ofFloat("translationY", bottomloca[1]-lacation[1]);

                ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(textView, hx, hy);
                animator.setDuration(300);
                animator.start();

                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        stringList.remove(itemCount);
                        stringList.add(stringlist2.get(position));
                        stringlist2.remove(position);
                        recycler2.getAdapter().notifyDataSetChanged();
                        recycler.getAdapter().notifyDataSetChanged();
                        linear.removeView(textView);
                        isTach=false;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }
                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }
        });
    }
    private AllTitle allTitle;
    private List<AllTitle.DataBean> data;

    private void initData() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().get().url("http://api.m.panda.tv/index.php?method=category.list&type=game&__version=2.1.9.1736&__plat=android").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "onFailure: 失败" + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                allTitle = new Gson().fromJson(string, AllTitle.class);
                data = allTitle.getData();
                handler.sendEmptyMessage(100);
            }
        });

    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 100) {
                for (int i = 0; i < topname.getData().size(); i++) {
                    if (data.contains(topname.getData().get(i))) {
                        data.remove(topname.getData().get(i));
                    }
                }
                topstring = new ArrayList<>();

                for (AllTitle.DataBean dataBean : topname.getData()) {
                    topstring.add(dataBean.getCname());

                }
                bottomstring = new ArrayList<>();
                for (AllTitle.DataBean dataBean : data) {
                    bottomstring.add(dataBean.getCname());

                }

                top.setAdapter(new MySupRecyclerViewAdapter(topstring, AddActivity.this));
                bottom.setAdapter(new MySupRecyclerViewAdapter(bottomstring, AddActivity.this));
                tag = false;
            }
            return false;
        }
    });

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences preferences = getSharedPreferences("DATA", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("cname", new Gson().toJson(topname));
//        edit.putString("top", String.valueOf(topList.toArray()));
        edit.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
