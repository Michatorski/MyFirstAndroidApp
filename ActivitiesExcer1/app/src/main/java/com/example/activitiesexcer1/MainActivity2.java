package com.example.activitiesexcer1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {
    protected  static  final String MAINACTIVITY_NAME = "com.example.activitiesexer1.name";
    protected  static  final String MAINACTIVITY_SURNAME = "com.example.activitiesexer1.surname";
    protected  static  final String MAINACTIVITY_AGE = "com.example.activitiesexer1.age";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void chargeInfo(View v){
        Intent pantallaSecundaia = new Intent(this, MainActivity2.class);

    }
}