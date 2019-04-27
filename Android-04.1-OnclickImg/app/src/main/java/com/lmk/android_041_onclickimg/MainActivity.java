package com.lmk.android_041_onclickimg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static final String EXTRA_MESS = "com.lmk.android.EXTRA.MESSAGE";

    private String orderMessage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private void ToastString(String message){
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
    }

    public void OrderTian(View view) {
        orderMessage = "你购买了甜甜圈，Good Choice！";
        ToastString(orderMessage);
    }


    public void OrderIce(View view) {
        orderMessage = "你购买了冰淇淋，Good Choice！";
        ToastString(orderMessage);
    }


    public void OrderBook(View view) {
        orderMessage = "你购买了书，Good Choice！";
        ToastString(orderMessage);
    }

    public void OrderAction(View view) {
        Intent intent = new Intent(this,OrderActivity.class);

        intent.putExtra(EXTRA_MESS,orderMessage);

        startActivity(intent);
    }
}
