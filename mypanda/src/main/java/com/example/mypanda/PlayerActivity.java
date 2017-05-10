package com.example.mypanda;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import java.io.IOException;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/**
 * Created by 红超 on 2017/2/19.
 */

public class PlayerActivity extends AppCompatActivity {
    private SurfaceView surfaceView;
    private IjkMediaPlayer mediaPlayer;
    private static final String TAG = "PlayerActivity";
    private PowerManager pm;
    private DisplayMetrics metrics;
    private int width;
    private int height;
    private Window window;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        window = getWindow();
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.player_activity);
        surfaceView = (SurfaceView) findViewById(R.id.surface);
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
        mediaPlayer = new IjkMediaPlayer();
        Intent intent = getIntent();
        String sign = intent.getStringExtra("sign");
        String ts = intent.getStringExtra("ts");
        String key = getIntent().getStringExtra("key");
        String pl = getIntent().getStringExtra("pl");

        if (pl==null){
            pl="3";

        }

        /***
         *http://124.164.8.31/pl3.live.panda.tv/live_panda/22833dc41cd9ecfc9a68db08d44b6beb.flv?sign=a7fbdfb52597d126e50c113c4e63d331&ts=58b834ab&rid=-26655802&wshc_tag=0&wsts_tag=58b834ac&wsid_tag=de812b7d&wsiphost=ipdbm
         * http://124.167.222.59/pl3.live.panda.tv/live_panda/8c686fab1b66766d251d406c36baf48c.flv?sign=eee0ef2bb6ad77c5818b88d648d105aa&ts=58b834ee&rid=-43454522&wshc_tag=0&wsts_tag=58b834ef&wsid_tag=de812b7d&wsiphost=ipdbm
         *http://124.167.236.17/pl3.live.panda.tv/live_panda/aaf6fcca15133042356d9119a79a4266.flv?sign=744e50cec095c39d5d048c37023f6dc8&ts=58b834ca&rid=-2099111&wshc_tag=0&wsts_tag=58b834cb&wsid_tag=de812b7d&wsiphost=ipdbm
         */
        //http://221.204.220.134/pl8.live.panda.tv/live_panda/d484e9848e75e85be0859ba29f0c6850.flv?sign=de37b5f254cb090ae24066610eb94ce9&ts=58b83426&rid=-99277426
        String url ="http://pl"+pl+".live.panda.tv/live_panda/" + key + ".flv?sign="+sign+"&ts="+ts;

        metrics = new DisplayMetrics();
        try {
            mediaPlayer.setDataSource(url);

        } catch (IOException e) {
            e.printStackTrace();
            // 释放资源了
        }
        // 异步准备
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Log.e(TAG, "surfaceCreated: " );
                pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
                PowerManager.WakeLock wakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My TAG");
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, 800);
//                params.height=200;
//                params.width=150;
                params.setMargins(0, (height / 2)-400,width,(height / 2) + (400));
                surfaceView.setLayoutParams(params);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                Log.e(TAG, "surfaceChanged: ");


            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                Log.e(TAG, "surfaceDestroyed: ");

            }
        });
        mediaPlayer.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                mediaPlayer.setDisplay(surfaceView.getHolder());
                mediaPlayer.start();
            }

        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
        if (mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public int dp2px(int dp) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dp * 1.0f * scale + 0.5f);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: " );
        mediaPlayer.prepareAsync();
        if (!mediaPlayer.isPlaying())
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: " );
        if (mediaPlayer != null&&mediaPlayer.isPlaying()) {
            // 手动释放
            mediaPlayer.stop();

        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Player Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
