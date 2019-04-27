package com.lmk.demo2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private EditText messageSend = null;

    private TextView receiveData = null;

    private Button sendBtn = null;

    public static final String EXTRA_MESSAGE =
            "com.lmk.demo2.extra.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("log-test","onCreate is running");
        messageSend = findViewById(R.id.editText);
        sendBtn = findViewById(R.id.send);
        receiveData = findViewById(R.id.textView3);

    }

    public void SendMessage(View view) {

        //新增意图
        Intent intent = new Intent(this,DesityActivity.class);
        //获取edittext的值
        String message = messageSend.getText().toString();
        if(message.isEmpty() || message==null){
            message = new String("no data!");
        }
        //将要传递的信息注入intent
        intent.putExtra(EXTRA_MESSAGE,message);
        //开启activity传递intent
        startActivityForResult(intent,1);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==1){
            if (resultCode==RESULT_OK){
                String replyMess = data.getStringExtra(DesityActivity.EXTRA_REPLY);
                receiveData.setText(replyMess.toString());
            }
            if (resultCode==RESULT_CANCELED){
                // todo
            }
        }
    }

    @Override
    protected void onStart() {
        Log.d("log-test","onStart is running");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("log-test","onStop is running");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("log-test","onDestroy is running");
        super.onDestroy();
    }

    @Override
    public void onContentChanged() {
        Log.d("log-test","onContent is running");
        super.onContentChanged();
    }

    @Override
    public void onBackPressed() {
        Log.d("log-test","onBack is running");
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        Log.d("log-test","onPause is running");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("log-test","onResume is running");
        super.onResume();
    }
}
