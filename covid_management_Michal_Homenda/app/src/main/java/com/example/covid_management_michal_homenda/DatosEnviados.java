package com.example.covid_management_michal_homenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DatosEnviados extends AppCompatActivity {

    TextView name, surname, dni, vaccine, vaccineText;

    ImageView check, uncheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_enviados);
        initialize();
    }

    public void initialize(){
        check = (ImageView) findViewById(R.id.imgCheck);
        uncheck = (ImageView) findViewById(R.id.imgUnCheck);

        name = (TextView) findViewById(R.id.tvResName);
        dni = (TextView) findViewById(R.id.tvResDni);
        surname = (TextView) findViewById(R.id.tvResSurname);
        vaccine = (TextView) findViewById(R.id.tvResVaccine);
        vaccineText = (TextView) findViewById(R.id.tvVaccineTextSend);

        Intent getData = getIntent();

        name.setText(getData.getStringExtra(MainActivity.PERSONAL_NAME));
        surname.setText(getData.getStringExtra(MainActivity.PERSONAL_SURNAME));
        dni.setText(getData.getStringExtra(MainActivity.PERSONAL_DNI));

        if (getData.getStringExtra(DatosCovidCiudadano.COVID_VACCINATED).equals("Sí")) {
            vaccineText.setVisibility(View.VISIBLE);

            vaccine.setText(getData.getStringExtra(DatosCovidCiudadano.COVID_VACCINE));
            vaccine.setVisibility(View.VISIBLE);

            check.setVisibility(View.VISIBLE);
            uncheck.setVisibility(View.GONE);
        } else if (getData.getStringExtra(DatosCovidCiudadano.COVID_VACCINATED).equals("No"))
        {
            vaccineText.setVisibility(View.GONE);

            vaccine.setVisibility(View.GONE);

            check.setVisibility(View.GONE);
            uncheck.setVisibility(View.VISIBLE);
        }

    }
}