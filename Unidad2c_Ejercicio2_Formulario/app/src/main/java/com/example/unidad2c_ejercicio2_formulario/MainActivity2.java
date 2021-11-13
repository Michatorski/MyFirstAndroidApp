package com.example.unidad2c_ejercicio2_formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView name, surname, contact, sport, position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initialize();
    }

    public void initialize() {
        name = (TextView) findViewById(R.id.tvResName_main2);
        surname = (TextView) findViewById(R.id.tvResSurname_main2);
        contact = (TextView) findViewById(R.id.tvResContacto_Main2);
        sport = (TextView) findViewById(R.id.tvResSports_Main2);
        position = (TextView) findViewById(R.id.tvResPosition_Main2);

        infoRecived();

    }

    public  void infoRecived(){
        Intent intent = getIntent();
        String nameResString = intent.getStringExtra(MainActivity.NAME);
        String surnameResString = intent.getStringExtra(MainActivity.SURNAME);
        String mobileResString = intent.getStringExtra(MainActivity.MOBILE);
        String emailResString = intent.getStringExtra(MainActivity.EMAIL);
        String sportResString = intent.getStringExtra(MainActivity.SPORT);
        String positionResString = intent.getStringExtra(MainActivity.POSITION);

        name.setText(nameResString);
        surname.setText(surnameResString);

        if (!mobileResString.equals("")){
            contact.setText(mobileResString);
        }
        if (!emailResString.equals("")){
            contact.setText(emailResString);
        }

        sport.setText(sportResString);
        position.setText(positionResString);

    }
}