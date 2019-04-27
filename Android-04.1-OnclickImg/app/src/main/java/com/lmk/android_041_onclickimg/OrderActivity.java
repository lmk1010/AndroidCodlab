package com.lmk.android_041_onclickimg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    private TextView orderInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        orderInfo = findViewById(R.id.textView5);

        Intent intent = getIntent();
        String orderMessage = intent.getStringExtra(MainActivity.EXTRA_MESS);

        orderInfo.setText(orderMessage);
    }



}
