package com.lmk.android_042_inputcomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private Spinner spinner = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        if(spinner!=null){
            spinner.setOnItemSelectedListener(this);
        }
        //现在进行spinner的初始化赋值
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.labels_array,
                android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    private void toastMessage(String message){
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
    }

    public void OnclickButton(View view) {
        boolean checked = ((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.radioButton:
                if (checked){
                    toastMessage(getString(R.string.todayDe));
                }
                break;
            case R.id.radioButton2:
                if (checked){
                    toastMessage(getString(R.string.NextDay));
                }
                break;
            case R.id.radioButton4:
                if (checked){
                    toastMessage(getString(R.string.CustomerDay));
                }
                break;
                default:
                    break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinnerLabel = parent.getItemAtPosition(position).toString();
        toastMessage(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
