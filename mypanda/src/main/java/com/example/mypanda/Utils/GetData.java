package com.example.mypanda.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.example.mypanda.PlayerActivity;
import com.example.mypanda.entieny.GetRootKey;
import com.example.mypanda.entieny.YuLeTitle;
import com.example.mypanda.service.ResOrFail;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 红超 on 2017/2/18.
 */

public class GetData {
    public static void GetRootKey(String root_id, final Context context) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().get().url("http://api.m.panda.tv/ajax_get_liveroom_baseinfo?roomid=" + root_id).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                GetRootKey getRootKey = gson.fromJson(string, GetRootKey.class);
                GetRootKey.DataBean.InfoBean.VideoinfoBean videoinfo = getRootKey.getData().getInfo().getVideoinfo();
                String room_key = videoinfo.getRoom_key();
                String plflag = videoinfo.getPlflag();
                String sign = videoinfo.getSign();
                String ts = videoinfo.getTs();
                String[] split = plflag.split("_");
                String s = split[1];
                Log.e("TAG", "onResponse:----------- " + s);
                //http://221.204.220.132/pl8.live.panda.tv/live_panda/92d768563027d708b0cb81793d93b3bf.flv?sign=a34be6de419dee9d942e4b17d87a2e96&ts=58bec4d9&rid=-15260104
                String url = "http://pl" + split[1] + ".live.panda.tv/live_panda/" + room_key + ".flv?sign=" + sign + "&ts=" + ts;


                Intent intent = new Intent(context, PlayerActivity.class);
                intent.putExtra("pl", s);
                intent.putExtra("url", url);
                Log.e("TAG", "onItem-------------------Click: " + room_key);
                intent.putExtra("key", room_key);
                context.startActivity(intent);
            }
        });
    }

    //http://api.m.panda.tv/index.php?method=category.list&type=game&__version=2.1.9.1736&__plat=android
    public static String GetData(String string, final Context context, final Handler handler) {


        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().get().url(string).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(context, "获取数据失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string1 = response.body().string();
                Message message = new Message();
                message.obj = string1;
                handler.sendMessage(message);
            }
        });

        return null;
    }

    ;

    //http://api.m.panda.tv/index.php?method=category.list&type=yl&mixed=1&__version=2.1.9.1736&__plat=android
    public static void GetYuLeTitle(String url, Context context, final ResOrFail resOrFail) {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "GetYuLeTitleonFailure: ");
                resOrFail.Faile(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("TAGGGG", "onResponse: "+string );
                resOrFail.Respond(string);

            }
        });
    }
    //http://api.m.panda.tv/ajax_get_liveroom_baseinfo?roomid="+root_id
//http://api.m.panda.tv/ajax_get_live_list_by_cate?cate=yzdr&pageno=1&pagenum=20&sproom=1&__version=2.1.9.1736&__plat=android
    public static void GetYuLeContent(String url, Context context, final ResOrFail resOrFail) {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "GetYuLeTitleonFailure: ");
                resOrFail.Faile(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("TAGGGG", "onResponse: "+string );
                resOrFail.Respond(string);

            }
        });
    }
}
