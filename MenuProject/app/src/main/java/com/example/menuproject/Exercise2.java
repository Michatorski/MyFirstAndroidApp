package com.example.menuproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class Exercise2 extends AppCompatActivity {

    protected final static String NAMEACT1 = "com.example.nameact1";

    TextView nameFromAct2B;
    EditText nameAct1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);

        nameAct1 = (EditText) findViewById(R.id.etNameAct2A);
        nameFromAct2B=(TextView) findViewById(R.id.tvNameFromAct2B);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}