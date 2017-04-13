package com.example.activityshengming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by 红超 on 2017/2/26.
 */

public class teo extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(teo.this,thr.class);
                startActivity(intent);

            }
        });
    }
}
