package com.lmk.demo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GoodActivity extends AppCompatActivity implements View.OnClickListener{


    private Button btn1 = null;
    private Button btn2 = null;
    private Button btn3 = null;
    private Button btn4 = null;
    private Button btn5 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good);

        //找到组件
        btn1 = findViewById(R.id.button3);

        //添加监听事件
        btn1.setOnClickListener(this);

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void returnMainAct(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void returnMainActData(String goods){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("goods",goods);
        startActivity(intent);
    }

    private void toastSomething(String toastMessage){
        Toast toast = Toast.makeText(this,toastMessage,Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onClick(View v) {

        String messsage = null;
        switch (v.getId()){
            case R.id.button3:
                messsage = btn1.getText().toString();
            default:
                returnMainActData(messsage);
        }

    }
}
