package com.lmk.android_043_menuandpicker;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/*
 这里使用info页面 进行任务5的实现 也就是日期
 */
public class InfoActivity extends AppCompatActivity {

    private TextView dateText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        dateText = findViewById(R.id.textView8);
    }

    public void dateSelector(View view) {
        DialogFragment dialogFragment = new DateFragment();

        dialogFragment.show(getSupportFragmentManager(),"datePicker");

    }

    public void setDate(int year,int month,int day){
        dateText.setText("year:"+year+" month:"+month+" day: "+day);
    }
}
