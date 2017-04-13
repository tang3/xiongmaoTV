package com.example.mypanda.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

import com.example.mypanda.R;

/**
 * Created by 红超 on 2017/3/13.
 */

public class MyTextView extends TextView {
    public MyTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.setBackgroundResource(R.drawable.textbackground);


        this.setGravity(Gravity.CENTER);
        this.setTextSize(18);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
}
