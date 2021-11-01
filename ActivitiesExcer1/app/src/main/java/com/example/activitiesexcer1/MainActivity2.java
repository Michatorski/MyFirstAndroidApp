package com.example.activitiesexcer1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView name, surname, age, licence;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String nameMessage = intent.getStringExtra(MainActivity.MAINACTIVITY_NAME);
        String surnameMessage = intent.getStringExtra(MainActivity.MAINACTIVITY_SURNAME);
        String ageMessage = intent.getStringExtra(MainActivity.MAINACTIVITY_AGE);

        String licenceMessage = intent.getStringExtra(MainActivity.MAINACTIVITY_LICENCE);

        name = (TextView) findViewById(R.id.tv_name);
        name.setText(nameMessage);
        surname = (TextView) findViewById(R.id.tv_surname);
        surname.setText(surnameMessage);
        age = (TextView) findViewById(R.id.tv_age);
        age.setText(ageMessage);
        licence = (TextView) findViewById(R.id.tv_carne);
        licence.setText(licenceMessage);
    }

}