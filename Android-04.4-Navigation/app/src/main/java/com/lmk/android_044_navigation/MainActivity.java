package com.lmk.android_044_navigation;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import com.lmk.android_044_navigation.adapter.PagerAdapter;

public class MainActivity extends AppCompatActivity implements FragmentThree.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置actionBar
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        //设置tabLayOut
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("星期一"));
        tabLayout.addTab(tabLayout.newTab().setText("星期二"));
        tabLayout.addTab(tabLayout.newTab().setText("星期三"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //拿到viewPager
        final ViewPager viewPager = findViewById(R.id.viewPager);
        //拿到页面适配器 并且注入参数和fragment
        final PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        //为viewPager注入适配器
        viewPager.setAdapter(pagerAdapter);
        //监听tab页切换
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //监听tab选中 触发的事件
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //当选中此tab时候，传递給viewPager当前tab的序号
                Log.d("tab","此时信息");
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //未选中不触发
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //重新选中触发
            }
        });

    }

    public void pageReturn(View view) {
        //跳转到子Activity
        //重点是配置Manifest中的android:parentActivityName标签 即刻出现箭头
        Intent intent = new Intent(this,ChildrenActivity.class);
        startActivity(intent);
    }

    //必须实现
    @Override
    public void onFragmentInteraction(Uri uri) {
        //可以留空 只是为了不报异常 必须要实现这个接口
        //此接口作为Fragment之间进行通行的桥梁
    }
}
