package com.example.ejerciciocheckboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

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
        boxEdu = (CheckBox) findViewById(R.id.cbEducacion);
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
            intereses.add(boxBel.getText().toString() + "\n");
        }
        if (boxLib.isChecked()){
            intereses.add(boxLib.getText().toString()  + "\n");
        }
        if (boxCar.isChecked()){
            intereses.add(boxCar.getText().toString() + "\n");
        }
        if (boxEdu.isChecked()){
            intereses.add(boxEdu.getText().toString() + "\n");
        }
        if (boxEve.isChecked()){
            intereses.add(boxEve.getText().toString() + "\n");
        }
        if (boxFam.isChecked()){
            intereses.add(boxFam.getText().toString() + "\n");
        }
        if (boxCom.isChecked()){
            intereses.add(boxCom.getText().toString() + "\n");
        }
        if (boxVid.isChecked()){
            intereses.add(boxVid.getText().toString() + "\n");
        }
        if (boxDep.isChecked()){
            intereses.add(boxDep.getText().toString() + "\n");
        }
        if (boxArt.isChecked()){
            intereses.add(boxArt.getText().toString() + "\n");
        }

        String list = intereses.toString().replace("[", "");
        list = list.replace("]", "");
        list = list.replace(",", "");

        checkText.setText("Has seleccionado: " + list);

        String aviso = "Has seleccionado:" + list;
        Toast.makeText(this, aviso, Toast.LENGTH_LONG).show();


    }
}