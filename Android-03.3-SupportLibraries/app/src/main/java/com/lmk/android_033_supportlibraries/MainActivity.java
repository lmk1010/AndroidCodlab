package com.lmk.android_033_supportlibraries;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tx1);

        if (savedInstanceState!=null){
            textView.setTextColor(savedInstanceState.getInt("color"));
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("color",textView.getCurrentTextColor());
    }

    public void cColor(View view) {
        //创建随机数
        Random random = new Random();
        //创建颜色16进制 0xFF000000 前缀固定
        StringBuilder colorRandom = new StringBuilder();
        //设定前缀和前2位
        int base = 0xFF000000;
        //随机出后6位
        for (int i=0;i<6;i++){
            colorRandom.append(random.nextInt(10));
        }
        //转为int
        int randomAdd = Integer.valueOf(colorRandom.toString());
        //拼接完毕
        Log.d("Demo8","mess:"+(base+randomAdd)+" string :"+colorRandom.toString());
        //设定颜色
        textView.setTextColor(base+randomAdd);

    }
}
