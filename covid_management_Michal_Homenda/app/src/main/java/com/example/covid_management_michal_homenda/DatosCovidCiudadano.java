package com.example.covid_management_michal_homenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DatosCovidCiudadano extends AppCompatActivity {
    protected final static String COVID_VACCINATED = "com.example.covid_vaccinated";
    protected final static String COVID_VACCINE = "com.example.covid_vaccine";


    RadioGroup vaccines;
    RadioButton Astra, Pzifer, Other;
    Spinner yesNo;

    ArrayAdapter<String> spinerAdapter;
    String name, surname, dni;
    TextView textVaccine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_covid_ciudadano);
        initialize();

        spinerAdapter();
    }

    public void initialize() {
        vaccines = (RadioGroup) findViewById(R.id.rgVaccines);
        Astra = (RadioButton) findViewById(R.id.rbAstra);
        Pzifer = (RadioButton) findViewById(R.id.rbPzfier);
        Other = (RadioButton) findViewById(R.id.rbOther);
        yesNo = (Spinner) findViewById(R.id.sYesNo);

        textVaccine = (TextView) findViewById(R.id.tvVaccine);

        String[] spinner = {"Seleccionar opcion...", "No","Sí"};

         spinerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinner);
         yesNo.setAdapter(spinerAdapter);





    }

    public void spinerAdapter(){

        yesNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

                if(yesNo.getSelectedItem().equals("Sí")){
                    textVaccine.setVisibility(View.VISIBLE);
                    vaccines.setVisibility(View.VISIBLE);
                } else {

                    textVaccine.setVisibility(View.GONE);
                    vaccines.setVisibility(View.GONE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void sendInfo(View v){
        getData();

        Intent intent = new Intent(this, DatosEnviados.class);

        intent.putExtra(MainActivity.PERSONAL_DNI, dni);
        intent.putExtra(MainActivity.PERSONAL_NAME, name);
        intent.putExtra(MainActivity.PERSONAL_SURNAME, surname);


        if (yesNo.getSelectedItem().equals("Sí")){
            intent.putExtra(COVID_VACCINATED, yesNo.getSelectedItem().toString());


            if (Astra.isChecked()){
                intent.putExtra(COVID_VACCINE, Astra.getText().toString());

            } else if (Pzifer.isChecked()){
                intent.putExtra(COVID_VACCINE, Pzifer.getText().toString());

            } else if (Other.isChecked()){
                intent.putExtra(COVID_VACCINE, Other.getText().toString());

            } else {
                Toast.makeText(this, "Debes escoger una vacuna", Toast.LENGTH_SHORT).show();
            }
            startActivity(intent);


        } else if (yesNo.getSelectedItem().equals("No")) {
            intent.putExtra(COVID_VACCINATED, yesNo.getSelectedItem().toString());

            startActivity(intent);
        } else {
            Toast.makeText(this, "Debes decir si has sido vacunado o no", Toast.LENGTH_SHORT).show();
        }

    }

    public  void getData(){
        Intent intentMain = getIntent();
        name = intentMain.getStringExtra(MainActivity.PERSONAL_NAME);
        surname = intentMain.getStringExtra(MainActivity.PERSONAL_SURNAME);
        dni = intentMain.getStringExtra(MainActivity.PERSONAL_DNI);
    }
}