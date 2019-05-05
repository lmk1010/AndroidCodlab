package com.lmk.android_044_navigation;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ChildrenActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children);

        //首先初始化toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //初始化fab
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"只是个测试fab",Snackbar.LENGTH_SHORT)
                        .setAction("action",null).show();
            }
        });

        //初始化DrawerLayout
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close
        );
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //初始化导航拦
        NavigationView navigationView = (NavigationView) findViewById(R.id.design_navigation_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        switch (menuItem.getItemId()){
            case(R.id.fun1):
                drawerLayout.closeDrawer(GravityCompat.START);
                Toast.makeText(this,"点击拦wifi", Toast.LENGTH_SHORT).show();
                return true;
            case(R.id.fun2):
                drawerLayout.closeDrawer(GravityCompat.START);
                Toast.makeText(this,"点击拦移动网络", Toast.LENGTH_SHORT).show();
                return true;
            case(R.id.fun3):
                drawerLayout.closeDrawer(GravityCompat.START);
                Toast.makeText(this,"点击拦GPS", Toast.LENGTH_SHORT).show();
                return true;
            case(R.id.fun4):
                drawerLayout.closeDrawer(GravityCompat.START);
                Toast.makeText(this,"点击拦蓝牙", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        if (drawerLayout!=null){
            if (drawerLayout.isDrawerOpen(GravityCompat.START)){
                drawerLayout.closeDrawer(GravityCompat.START);
            }else{
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.action_setting){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
