package com.lmk.android_043_menuandpicker;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView goods1 = null;
    private ImageView goods2 = null;
    private ImageView goods3 = null;

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

        goods1 = findViewById(R.id.imageView);
        goods2 = findViewById(R.id.imageView2);
        goods3 = findViewById(R.id.imageView3);

        goods1.setOnClickListener(this);
        goods2.setOnClickListener(this);
        goods3.setOnClickListener(this);

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cart) {
            toastMessage("选中购物车");
            return true;
        }else if(id==R.id.action_orders) {
            toastMessage("选中订单");
            return true;
        }
        else if(id==R.id.action_favorite) {
            toastMessage("选中收藏");
            return true;
        }
        else if(id==R.id.action_communication) {
            toastMessage("选中联系");
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
                toastMessage("甜甜圈加入购物车");
            case(R.id.imageView2):
                toastMessage("冰淇淋加入购物车");
            case(R.id.imageView3):
                toastMessage("书本加入购物车");
        }

    }
}
