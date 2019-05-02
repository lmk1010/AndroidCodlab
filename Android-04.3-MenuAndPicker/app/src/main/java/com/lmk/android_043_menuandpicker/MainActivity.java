package com.lmk.android_043_menuandpicker;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView goods1 = null;
    private ImageView goods2 = null;
    private ImageView goods3 = null;

    private TextView tx1 = null;

    private Map<String,Integer> goodsOrders = new HashMap<>();

    public static final String EXTRA_MESS = "com.lmk.menu.mess";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //首先拿到toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        //重写父类的ActionBar
        setSupportActionBar(toolbar);
        //拿到FAB
        FloatingActionButton fab = findViewById(R.id.fab);
        //设置FAB的点击事件
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "操作已生效", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //编码挑战 完成textview的触摸事件弹出menu操作
        //这里以甜甜圈 textview作为测试事例
        tx1 = findViewById(R.id.textView2);
        //将textview作为组件 注册到菜单上下文中
        registerForContextMenu(tx1);

        goods1 = findViewById(R.id.imageView);
        goods2 = findViewById(R.id.imageView2);
        goods3 = findViewById(R.id.imageView3);

        goods1.setOnClickListener(this);
        goods2.setOnClickListener(this);
        goods3.setOnClickListener(this);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //获取菜单item的ID
        int id = item.getItemId();
        switch (id){
            case(R.id.action_edit):
                toastMessage("已编辑");
                break;
            case(R.id.action_copy):
                toastMessage("已复制");
                break;
            case(R.id.action_search):
                toastMessage("已搜索");
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 初始化menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //默认menu的click触发
        int id = item.getItemId();

        Intent intent = null;

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cart) {
            intent = new Intent(this,CartActivity.class);
            String ordersInfo = JSONObject.toJSONString(goodsOrders);
            Log.d("Main",ordersInfo);
            intent.putExtra(EXTRA_MESS,ordersInfo);
            startActivity(intent);
            return true;
        }else if(id==R.id.action_orders) {
            intent = new Intent(this,OrderActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id==R.id.action_favorite) {
            intent = new Intent(this,CartActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id==R.id.action_communication) {
            intent = new Intent(this,InfoActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void toastMessage(String messgae){
        Toast.makeText(this,messgae,Toast.LENGTH_SHORT).show();
    }

    //统一click事件响应
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case(R.id.imageView):
                if(goodsOrders.get("tiantian")==null){
                    goodsOrders.put("tiantian",1);
                    toastMessage("已将甜甜圈加入购物车");
                    break;
                }
                int tianCount = goodsOrders.get("tiantian")+1;
                goodsOrders.put("tiantian",tianCount);
                toastMessage("已将甜甜圈加入购物车"+tianCount);
                break;
            case(R.id.imageView2):
                if(goodsOrders.get("ice")==null){
                    goodsOrders.put("ice",1);
                    toastMessage("已将冰淇淋加入购物车");
                    break;
                }
                int iceCount = goodsOrders.get("ice")+1;
                goodsOrders.put("ice",iceCount);
                toastMessage("已将冰淇淋加入购物车"+iceCount);
                break;
            case(R.id.imageView3):
                if(goodsOrders.get("book")==null){
                    goodsOrders.put("book",1);
                    toastMessage("已将书本加入购物车");
                    break;
                }
                int bookCount = goodsOrders.get("book")+1;
                goodsOrders.put("book",bookCount);
                toastMessage("已将书本加入购物车"+bookCount);
                break;
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
