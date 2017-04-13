package com.example.activityshengming;

import android.app.Activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;



import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private RecyclerView bottom;
    private RecyclerView top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initData();
        GridLayoutManager topManger =new GridLayoutManager(this,3);
        GridLayoutManager bottomManager =new GridLayoutManager(this,3);

        bottom = (RecyclerView) findViewById(R.id.bottom);
        top = (RecyclerView) findViewById(R.id.top);
        bottom.setLayoutManager(bottomManager);
        top.setLayoutManager(topManger);
        top.setAdapter(new MyAdapter(this,strings));



    }


    private static final String TAG = "MainActivity";
    List<String> strings =new ArrayList<>();
    private void initData() {
        for (int i = 0; i < 90; i++) {

        strings.add("item"+i);
        }
    }


}
