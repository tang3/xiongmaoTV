package com.example.mypanda;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.mypanda.entieny.Name;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by 红超 on 2017/2/22.
 */

public class SplashActivity  extends BaseActivity{
    List<Name> nameList=new ArrayList<>();
    Handler handler =new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Intent intent =new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
    });
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        ImageView viewById = (ImageView) findViewById(R.id.splash);
        Glide.with(this).load(R.mipmap.welcome).into(viewById);
        SharedPreferences sp = getSharedPreferences("DATA", Context.MODE_PRIVATE);
        String strings = sp.getString("cname", null);
    }
    @Override
    protected void onResume() {
        super.onResume();
        handler.sendEmptyMessageDelayed(0,000);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*
         *在销毁本界面的同时销毁本界面的Handler。
         * 防止Handler持有该activity导致内存泄漏，
         * 防止用户在该界面点击返回按钮导致退出程序后任然启动下一个界面。
         */
        handler.removeCallbacksAndMessages(null);
    }
}
