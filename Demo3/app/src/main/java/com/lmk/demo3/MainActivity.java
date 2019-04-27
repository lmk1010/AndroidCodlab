package com.lmk.demo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String log_tag = "Demo3";

    private TextView tx1 = null;
    private TextView tx2 = null;
    private TextView tx3 = null;
    private TextView tx4 = null;
    private TextView tx5 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx1 = findViewById(R.id.textView);
        tx2 = findViewById(R.id.textView1);
        tx3 = findViewById(R.id.textView2);
        tx4 = findViewById(R.id.textView3);
        tx5 = findViewById(R.id.textView4);

        ArrayList<TextView> viewGroup = new ArrayList<>();

        viewGroup.add(tx1);
        viewGroup.add(tx2);
        viewGroup.add(tx3);
        viewGroup.add(tx4);
        viewGroup.add(tx5);

        Log.d(log_tag,"---onCreate启动");

        Intent intent = getIntent();

        String goods = intent.getStringExtra("goods");

        if (goods!=null){
            Log.d(log_tag,"goods接收成功!开始遍历");
            for (TextView t : viewGroup){
                if ("暂无商品".equals(t.getText())){
                    t.setText(goods);
                    break;
                }else{
                    Log.d(log_tag,t.getText().toString());
                }
            }
        }

//        if (savedInstanceState!=null){
//            Log.d(log_tag,"开始接收savedInstanceState数据");
//
//            String goods = savedInstanceState.getString("goods");
//
//            Log.d(log_tag,"接收到"+goods);
//            if (goods==null){
//                Toast.makeText(this,"没有接收到商品", Toast.LENGTH_SHORT).show();
//            }
//            tx1.setText(goods);
//        }
//        if (savedInstanceState==null){
//            Log.d(log_tag,"---savedInstanceState为空");
//        }



    }

    public void toSelectGood(View view) {

        Intent intent = new Intent(this,GoodActivity.class);

        startActivity(intent);

    }
}
