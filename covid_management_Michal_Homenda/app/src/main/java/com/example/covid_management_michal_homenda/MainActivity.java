package com.example.covid_management_michal_homenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected final static String PERSONAL_DNI = "com.example.personal_dni";
    protected final static String PERSONAL_NAME = "com.example.personal_name";
    protected final static String PERSONAL_SURNAME = "com.example.personal_surname";

    CheckBox accept;
    EditText name, surname, dni;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }
    public void initialize(){

        send = (Button) findViewById(R.id.btnSend);
        accept = (CheckBox) findViewById(R.id.cbAccept);
        name = (EditText) findViewById(R.id.etName);
        surname = (EditText) findViewById(R.id.etSurname);
        dni = (EditText) findViewById(R.id.etnDni);


    }

    public void sendPersonalInfo(View v){

        Intent intent = new Intent(this, DatosCovidCiudadano.class);

        if (dni.getText().toString().isEmpty()|| name.getText().toString().isEmpty()|| surname.getText().toString().isEmpty()){
            Toast.makeText(this, "Tienes que rellenar todos los espacios", Toast.LENGTH_SHORT).show();
        } else {
            intent.putExtra(PERSONAL_NAME, name.getText().toString());
            intent.putExtra(PERSONAL_SURNAME, surname.getText().toString());
            intent.putExtra(PERSONAL_DNI, dni.getText().toString());

            if (!accept.isChecked()){
                Toast.makeText(this, "Debes aceptar los terminos", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(intent);
            }
        }


    }
}