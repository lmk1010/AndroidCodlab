package com.lmk.demo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DesityActivity extends AppCompatActivity {


    private TextView receiveText;

    private Button replyBtn;

    private EditText replyText;

    public static final String EXTRA_REPLY =
            "com.lmk.demo2.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desity);

        //获得控件显示
        receiveText = findViewById(R.id.textView);
        //获取传递的意图
        Intent intent = getIntent();
        //获取到接受的数据
        String receiveData = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //设置数据显示到textView
        receiveText.setText(receiveData.toString());

        //获取到Btn按钮
        replyBtn = findViewById(R.id.button);
        //获取到返回的String信息
        replyText = findViewById(R.id.editText2);

    }

    public void ReplyMessage(View view) {
        //获取要返回的信息
        String replyMessage = replyText.getText().toString();
        //check null
        if (replyMessage.isEmpty() || replyMessage==null){
            Toast toast = Toast.makeText(this,"must input some message!",Toast.LENGTH_SHORT);
            toast.show();
        }
        //
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY,replyMessage);
        //设定结果状态码
        setResult(RESULT_OK,replyIntent);
        finish();


    }
}
