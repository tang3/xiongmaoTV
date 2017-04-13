package com.example.mypanda;

import java.util.LinkedList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {
//    // 管理运行的所有的activity
//    public final static List<BaseActivity> mActivities = new LinkedList<BaseActivity>();
//    public static BaseActivity activity;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        synchronized (mActivities) {
//            mActivities.add(this);
//            Log.e("mactivity", "onCreate: "+mActivities );
//        }
//
//    }
//
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        activity = this;
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//    }
//    long a =0;
//    @Override
//    public void onBackPressed() {
////        long l = System.currentTimeMillis();
////        if (l-a>=3000){
////          if (!mActivities.get(0).getClass().equals(MainActivity.class))super.onBackPressed();
////            else {
////              Toast.makeText(activity, "再次点击退出", Toast.LENGTH_SHORT).show();
////          }
////            a=l;
////        }else if (l-a<3000){
////            Toast.makeText(activity, "再次点击退出程序1", Toast.LENGTH_SHORT).show();
////            killAll();
////        }
//
//    super.onBackPressed();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        synchronized (mActivities) {
//            mActivities.remove(this);
//        }
//    }
//
//    /**
//     * 一键退出的方法
//     */
//    public static void killAll() {
//        // 复制了一份mActivities 集合
//        List<BaseActivity> copy;
//        synchronized (mActivities) {
//            copy = new LinkedList<BaseActivity>(mActivities);
//        }
//        for (BaseActivity activity : copy) {
//            activity.finish();
//        }
//        // 杀死当前的进程
//        android.os.Process.killProcess(android.os.Process.myPid());
//    }
}