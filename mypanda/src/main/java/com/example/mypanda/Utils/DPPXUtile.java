package com.example.mypanda.Utils;

import android.content.Context;

/**
 * Created by 红超 on 2017/5/10.
 */

public class DPPXUtile {
    public static int Px2Dp(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }
    public static int Dp2Px(Context context,int dp){
        float density = context.getResources().getDisplayMetrics().density;

        return (int) (dp*density);
    }
}
