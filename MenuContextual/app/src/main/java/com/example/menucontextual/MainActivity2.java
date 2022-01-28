package com.example.menucontextual;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<String> list ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    public void initializer(){
        ListView elementList = (ListView) findViewById(R.id.lv_elements);

        list = new ArrayList<String>();
        list.add("Water");
        list.add("Fire");
        list.add("Air");
        list.add("Earth");
        list.add("Sun");
        list.add("Moon");
    }
}