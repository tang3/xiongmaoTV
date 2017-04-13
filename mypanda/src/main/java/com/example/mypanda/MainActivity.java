package com.example.mypanda;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.mypanda.entieny.AllTitle;

import com.example.mypanda.fragment.ShouYeFragment;
import com.example.mypanda.fragment.WoDeFragment;
import com.example.mypanda.fragment.YouXiFragment;
import com.example.mypanda.fragment.YuLeFragment;
import com.google.gson.Gson;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private RadioButton shouye;
    private RadioButton youxi;
    private RadioButton wode;
    private RadioButton yule;
    private RadioGroup buttonGroup;
    private FragmentManager manager;
    private ShouYeFragment shouYeFragment;
    private WoDeFragment wodeFragment;
    private YouXiFragment youXiFragment;
    private YuLeFragment yuLeFragment;
    private TextView toptext;
    public boolean fragtag = false;
    private AllTitle allTitle;

    public void setTag(boolean tag) {
        fragtag = tag;
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.e(TAG, "onAttachedToWindow: ------vvv ---------------");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ------------------------------");
        setContentView(R.layout.activity_main);
        Log.e("TAG", "onCreate: ");
        SharedPreferences sp = getSharedPreferences("DATA", Context.MODE_PRIVATE);
        String strings = sp.getString("cname", null);
        SharedPreferences.Editor edit = sp.edit();
        if (strings != null) {
            allTitle = new Gson().fromJson(strings, AllTitle.class);
        }
        initView();

    }

    private void initView() {
        toptext = (TextView) findViewById(R.id.toptext);
        manager = getSupportFragmentManager();
        shouye = (RadioButton) findViewById(R.id.shouye);
        shouye.setChecked(true);
        youxi = (RadioButton) findViewById(R.id.youxi);
        wode = (RadioButton) findViewById(R.id.wode);
        yule = (RadioButton) findViewById(R.id.yule);
        buttonGroup = (RadioGroup) findViewById(R.id.radioGroup);
        youXiFragment = new YouXiFragment();
        wodeFragment = new WoDeFragment();
        yuLeFragment = new YuLeFragment();
        shouYeFragment = new ShouYeFragment();
        shouye.setOnClickListener(this);
        youxi.setOnClickListener(this);
        wode.setOnClickListener(this);
        yule.setOnClickListener(this);
        if (allTitle != null)
            shouYeFragment.nameList = allTitle;
        manager.beginTransaction().replace(R.id.framelayout_themain, shouYeFragment).commit();

    }

    int tag;
    private static final String TAG = "TAG";

    @Override
    public void onClick(View v) {

        if (v.getId() == shouye.getId()) {
            if (tag == shouye.getId()) return;
            toptext.setText("首页");
            manager.beginTransaction().replace(R.id.framelayout_themain, shouYeFragment, "shouye").commit();
            tag = shouye.getId();
        } else if (v.getId() == wode.getId()) {
            if (tag == wode.getId()) return;
            tag = wode.getId();
            toptext.setText("我的");

            manager.beginTransaction().replace(R.id.framelayout_themain, wodeFragment).commit();
        } else if (v.getId() == youxi.getId()) {
            if (tag == youxi.getId()) return;
            tag = youxi.getId();
            toptext.setText("游戏");

            manager.beginTransaction().replace(R.id.framelayout_themain, youXiFragment).commit();
        } else {
            if (tag == yule.getId()) return;
            tag = yule.getId();
            toptext.setText("娱乐");
            manager.beginTransaction().replace(R.id.framelayout_themain, yuLeFragment).commit();
        }
    }
}
