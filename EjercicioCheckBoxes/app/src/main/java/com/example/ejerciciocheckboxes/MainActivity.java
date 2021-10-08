package com.example.ejerciciocheckboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CheckBox boxBel, boxLib, boxCar, boxEdu, boxEve,
            boxFam, boxCom, boxVid, boxDep, boxArt;
    private TextView checkText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boxBel = (CheckBox) findViewById(R.id.cbBelleza);
        boxLib = (CheckBox) findViewById(R.id.cbLibros);
        boxCar = (CheckBox) findViewById(R.id.cbCarrera);
        boxEve = (CheckBox) findViewById(R.id.cbEventos);
        boxFam = (CheckBox) findViewById(R.id.cbFamilia);
        boxCom = (CheckBox) findViewById(R.id.cbComida);
        boxVid = (CheckBox) findViewById(R.id.cbVideojuegos);
        boxDep = (CheckBox) findViewById(R.id.cbDeportes);
        boxArt = (CheckBox) findViewById(R.id.cbArte);

        checkText = (TextView) findViewById(R.id.tvChecked);
    }

    public void cargarInfo(View v){

        List<String> intereses = new ArrayList<>();

        if (boxBel.isChecked()){
            intereses.add(boxBel.getText().toString());
        }
        if (boxLib.isChecked()){
            intereses.add(boxLib.getText().toString());
        }
        if (boxCar.isChecked()){
            intereses.add(boxCar.getText().toString());
        }
        if (boxEve.isChecked()){
            intereses.add(boxEve.getText().toString());
        }
        if (boxFam.isChecked()){
            intereses.add(boxFam.getText().toString());
        }
        if (boxCom.isChecked()){
            intereses.add(boxCom.getText().toString());
        }
        if (boxVid.isChecked()){
            intereses.add(boxVid.getText().toString());
        }
        if (boxDep.isChecked()){
            intereses.add(boxDep.getText().toString());
        }
        if (boxArt.isChecked()){
            intereses.add(boxArt.getText().toString());
        }


        checkText.setText("Has seleccionado: " + intereses.toString());

//        if (boxArt.isChecked()){
//            checkText.setText( "Arte");
//        } else {
//            checkText.setText("No has seleccionado nada.");
//        }


    }
}