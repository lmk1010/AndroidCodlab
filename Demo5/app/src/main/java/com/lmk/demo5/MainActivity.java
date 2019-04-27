package com.lmk.demo5;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private EditText t1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        t1 = findViewById(R.id.editText);
    }

    public void OpenUrl(View view) {
        if (t1==null){
            return;
        }
        String url = "http://www.baidu.com";

        Uri uri = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW,uri);

        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }else{
            Log.d("Demo5","no handle solve");
        }
    }
}
