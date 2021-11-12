package com.example.unidad2c_ejercicio2_formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    protected final static String  NAME = "com.example.name";
    protected final static String  SURNAME = "com.example.surname";
    protected final static String  SPORT = "com.example.sport";
    protected final static String  MOBILE = "com.example.mobile";
    protected final static String  EMAIL = "com.example.email";
    protected final static String  POSITION = "com.example.position";

    Spinner spinContacts, spinSports;

    ArrayAdapter<String> adapter1 , adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void initialize(){

        String[] contactType = {"Movil", "Correo electronico"};
        String[] sport = {"Futbol", "Baloncesto"};

        spinContacts = (Spinner) findViewById(R.id.sContact);
        spinSports = (Spinner) findViewById(R.id.sSports);

        adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, contactType);
        spinContacts.setAdapter(adapter1);

        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sport);
        spinSports.setAdapter(adapter2);


        Intent intent = new Intent(this, MainActivity2.class);

        spinContacts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}