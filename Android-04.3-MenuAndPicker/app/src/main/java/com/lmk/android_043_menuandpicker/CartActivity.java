package com.lmk.android_043_menuandpicker;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CartActivity extends AppCompatActivity {


    private Map<String,Integer> res = new HashMap<>();

    private TextView t4 = null;

    private TextView t6 = null;

    private TextView t7 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        t4 = findViewById(R.id.textView4);

        t6 = findViewById(R.id.textView6);

        t7 = findViewById(R.id.textView7);

        Intent intent = getIntent();

        String orderJson = intent.getStringExtra(MainActivity.EXTRA_MESS);

        Log.d("Cart",orderJson);

        res = (Map<String, Integer>) JSONObject.parse(orderJson);

        Log.d("Cart",res.toString());

        if (res.containsKey("tiantian")){
            t4.setText("甜甜圈："+res.get("tiantian")+"个");
        }

        if (res.containsKey("ice")){
            t6.setText("冰淇淋："+res.get("ice")+"个");
        }

        if (res.containsKey("book")){
            t7.setText("书："+res.get("book")+"个");
        }

    }

    public void returnAction(View view) {
        //建立alertBuidler
        AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(CartActivity.this);

        //设置通知的标题
        myAlertBuilder.setTitle("确认");
        //设置通知的内容
        myAlertBuilder.setMessage("你确定要离开此页面,返回主界面吗？");
        //设置通知的按钮 确认 and 取消
        myAlertBuilder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // todo 写下要触发之后的动作 这里是调用wifi
                Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(intent);
            }
        });
        //设置注销按钮
        myAlertBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"已取消",Toast.LENGTH_SHORT).show();
            }
        });
        //让alert显示
        myAlertBuilder.show();
    }
}
