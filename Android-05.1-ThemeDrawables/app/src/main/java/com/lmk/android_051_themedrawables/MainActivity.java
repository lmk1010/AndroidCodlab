package com.lmk.android_051_themedrawables;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private int score1 = 0;
    private int score2 = 0;

    private TextView textView = null;
    private TextView textView1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //初始化textview
        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView1);
//        //设置初始值
        textView.setText(String.valueOf(score1));
        textView1.setText(String.valueOf(score2));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //切换菜单中的文字 白天模式 和 夜间模式
        int nightMode = AppCompatDelegate.getDefaultNightMode();

        if (nightMode==AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.action_settings).setTitle(R.string.DayMode);
        }else{
            menu.findItem(R.id.action_settings).setTitle(R.string.DarkMode);
        }

        return true;
    }

    private void toastMessge(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            //默认为白天模式
            int nightMode = AppCompatDelegate.getDefaultNightMode();

            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                toastMessge("已关闭夜间模式");
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                toastMessge("已开启夜间模式");
            }

            recreate();

        }


        return true;
    }

    //降低分数
    public void descore(View view) {

        int btnId = view.getId();

        switch (btnId){
            case(R.id.imageButton0):
                score1 = score1 - 1;
                textView.setText(String.valueOf(score1));
                break;
            case(R.id.imageButton2):
                score2 = score2 - 1;
                textView1.setText(String.valueOf(score2));
                break;
            default:
                break;
        }


    }

    public void inscore(View view) {

        int btnId = view.getId();

        switch (btnId){
            case(R.id.imageButton1):
                score1 = score1 + 1;
                textView.setText(String.valueOf(score1));
                break;
            case(R.id.imageButton3):
                score2 = score2 + 1;
                textView1.setText(String.valueOf(score2));
                break;
            default:
                break;
        }
    }
}
