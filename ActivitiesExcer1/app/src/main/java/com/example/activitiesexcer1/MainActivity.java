package com.example.activitiesexcer1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected static final String MAINACTIVITY_NAME = "com.example.activitiesexer1.name";
    protected static final String MAINACTIVITY_SURNAME = "com.example.activitiesexer1.surname";
    protected static final String MAINACTIVITY_AGE = "com.example.activitiesexer1.age";
    protected static final String MAINACTIVITY_LICENCE = "com.example.activitiesexer1.licence";

    EditText name, surname, age;
    CheckBox checkCarne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.et_name);
        surname = (EditText) findViewById(R.id.et_surname);
        age = (EditText) findViewById(R.id.et_age);
        checkCarne = (CheckBox) findViewById(R.id.cb_carne);
    }

    public void chargeInfo(View v) {
        Intent intent = new Intent(this, MainActivity2.class);

        String nameMessage = name.getText().toString();

        String surnameMessage = surname.getText().toString();

        String ageMessage = age.getText().toString();

        String licenceMessage = "Tiene carne de conducir";
        String noLicenceMessage = "No tiene carne de conducir";


        intent.putExtra(MAINACTIVITY_NAME, nameMessage);


        intent.putExtra(MAINACTIVITY_SURNAME, surnameMessage);


        intent.putExtra(MAINACTIVITY_AGE, ageMessage);


        if (checkCarne.isChecked()) {
            intent.putExtra(MAINACTIVITY_LICENCE, licenceMessage);
        } else {
            intent.putExtra(MAINACTIVITY_LICENCE, noLicenceMessage);
        }

        if (nameMessage.isEmpty()) {
            Toast.makeText(this, "Se necesta rellenar el NOMBRE", Toast.LENGTH_SHORT).show();
        } else if (ageMessage.isEmpty()) {
            Toast.makeText(this, "Se necesta rellenar la EDAD", Toast.LENGTH_SHORT).show();
        } else if (surnameMessage.isEmpty()) {
            Toast.makeText(this, "Se necesta rellenar los APELLIDOS", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(intent);
        }


    }
}