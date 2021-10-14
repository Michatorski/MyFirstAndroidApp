package com.example.controlescheckboxiii;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CheckBox boxVid, boxEdu, boxLol;

    private TextView checkText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boxVid = (CheckBox) findViewById(R.id.cbVid);
        boxEdu = (CheckBox) findViewById(R.id.cbEdu);
        boxLol = (CheckBox) findViewById(R.id.cbLol);

        checkText = (TextView) findViewById(R.id.tvCheck);


    }

    public void showToast(View v){
//        String aviso = "Iniciando descarga...";
//        //codigo equivalente
//        Toast.makeText(this, aviso, Toast.LENGTH_LONG).show();

//        //Mas alargado codigo
//        Toast avisoDescarga = Toast.makeText(this, aviso, Toast.LENGTH_LONG);
//        avisoDescarga.show();

        List<String> intereses = new ArrayList<>();


        if (boxVid.isChecked()){
            intereses.add(boxVid.getText().toString() + "\n");
        }
        if (boxEdu.isChecked()){
            intereses.add(boxEdu.getText().toString()  + "\n");
        }
        if (boxLol.isChecked()){
            intereses.add(boxLol.getText().toString() + "\n");
        }

        String list = intereses.toString().replace("[", "");
        list = list.replace("]", "");
        list = list.replace(",", "");

        checkText.setText("Has seleccionado: " + "\n"+ list);


        String aviso = list;
        Toast.makeText(this, aviso, Toast.LENGTH_LONG).show();


    }
}