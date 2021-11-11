package com.example.unidad2c_ejercicio2_formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    protected final static String  NAME = "com.example.name";
    protected final static String  SURNAME = "com.example.surname";
    protected final static String  SPORT = "com.example.sport";
    protected final static String  MOBILE = "com.example.mobile";
    protected final static String  EMAIL = "com.example.email";
    protected final static String  POSITION = "com.example.position";

    Spinner sContacts, sSports;

    ArrayAdapter<String> adapter1 , adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void initialize(){

        String[] contactType = {"Movil", "Correo electronico"};
        String[] sport = {"Futbol", "Baloncesto"};

        sContacts = (Spinner) findViewById(R.id.sContact);
        sSports = (Spinner) findViewById(R.id.sSports);

        adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, contactType);
        sContacts.setAdapter(adapter1);

        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sport);
        sSports.setAdapter(adapter2);


        Intent intent = new Intent(this, MainActivity2.class);


    }
}