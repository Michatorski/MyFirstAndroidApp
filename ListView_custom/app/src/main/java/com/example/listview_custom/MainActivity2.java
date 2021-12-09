package com.example.listview_custom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    public void initialize (){
        res = (TextView) findViewById(R.id.tv_Res);

        Intent getIntent = getIntent();

        res.setText(getIntent.getStringExtra(MainActivity.LIST_GRAPHIC_CARD));

    }
}