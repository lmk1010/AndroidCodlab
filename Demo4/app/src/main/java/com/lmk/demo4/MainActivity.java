package com.lmk.demo4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tx1 = null;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Demo4","onCreate启动！count"+count);
        tx1 = findViewById(R.id.textView);

        if (savedInstanceState!=null){
            count = savedInstanceState.getInt("count");
            tx1.setText(Integer.toString(count));
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("count",count);


    }

    public void countNumber(View view) {

        if (tx1!=null){
            count++;
            tx1.setText(Integer.toString(count));
        }
    }

    @Override
    protected void onStart() {
        Log.d("Demo4","onStart启动！count:"+count);
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("Demo4","onStop启动！count:"+count);
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.d("Demo4","onPause启动！couunt"+count);
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("Demo4","onResume启动！count"+count);
        super.onResume();
    }
}
