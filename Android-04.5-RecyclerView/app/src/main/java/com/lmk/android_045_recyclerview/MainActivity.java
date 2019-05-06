package com.lmk.android_045_recyclerview;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.LinkedList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerItemAdapter recyclerItemAdapter;

    private  RecyclerView recyclerView;

    private LinkedList<String> itemList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //拿到floatingActionButton
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);

        //为List添加word
        for (int i = 0;i<50;i++){
            itemList.add("word"+new Random().nextInt(10));
        }
        //拿到recyclerView
        recyclerView = findViewById(R.id.recyclerView);
        //初始化adapter
        recyclerItemAdapter = new RecyclerItemAdapter(this,itemList);
        //关联适配器
        recyclerView.setAdapter(recyclerItemAdapter);
        //为recyclerView设置一个适配器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    //FAB添加item
    public void WriteAdd(View view) {

        int itemListSize = itemList.size();

        itemList.addLast("insert "+itemListSize);
        //获取adapter 增加一个string
        recyclerView.getAdapter().notifyItemInserted(itemListSize);
        //添加完成之后 滑动到添加的那个string位置
        recyclerView.smoothScrollToPosition(itemListSize);

    }
}
