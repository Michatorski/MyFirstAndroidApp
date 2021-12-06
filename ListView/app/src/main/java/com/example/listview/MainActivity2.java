package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView operativeSystemRes, operativeSystemTypeRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initialize();
    }

    public void initialize(){
        operativeSystemRes = (TextView) findViewById(R.id.tvSORes);
        operativeSystemTypeRes = (TextView) findViewById(R.id.tvSOTypeRes);

        Intent getdata = getIntent();

        operativeSystemRes.setText(getdata.getStringExtra(MainActivity.OPERATIVE_SYSTEM));
        operativeSystemTypeRes.setText(getdata.getStringExtra(MainActivity.OPERATIVE_SYSTEM_TYPE));
    }
}