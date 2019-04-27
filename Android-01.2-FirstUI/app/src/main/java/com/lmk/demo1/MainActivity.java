package com.lmk.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int localCount = 0;

    private TextView countView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get textview by id
        countView = (TextView) findViewById(R.id.Show);
    }


    public void showToast(View view) {
        Toast toast = Toast.makeText(this,R.string.toast_message,Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countV(View view) {
        if (countView!=null){
            localCount++;
            countView.setText(Integer.toString(localCount));
        }else{
            countView.setText(0);
        }
    }
}
