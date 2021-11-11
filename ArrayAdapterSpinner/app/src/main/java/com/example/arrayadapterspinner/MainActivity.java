package com.example.arrayadapterspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sFrutas;
    ArrayAdapter<String> adapter;

    ImageView fruits, apple, avocado, cherry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize(){
        fruits = (ImageView) findViewById(R.id.imgFruits);

        String[] frutas ={"Seleccione","fruta","manzana","aguacate","cereza"};

        sFrutas = (Spinner) findViewById(R.id.spinFrutas);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                frutas);
        sFrutas.setAdapter(adapter);
    }

    public void showPicture(View v){

        String selectedOption = sFrutas.getSelectedItem().toString();
        String selectedPosition = String.valueOf(sFrutas.getSelectedItemId());

        switch (sFrutas.getSelectedItem().toString()){

            case "fruta":
                fruits.setImageResource(R.drawable.fruta);
                Toast.makeText(this, "Cargando " + selectedOption + "("+ selectedPosition +")", Toast.LENGTH_SHORT).show();
                break;
            case "manzana":
                fruits.setImageResource(R.drawable.apple);
                Toast.makeText(this, "Cargando " + selectedOption + "("+ selectedPosition+")", Toast.LENGTH_SHORT).show();
                break;
            case "aguacate":
                fruits.setImageResource(R.drawable.avocado);
                Toast.makeText(this, "Cargando " + selectedOption + "("+ selectedPosition+")", Toast.LENGTH_SHORT).show();
                break;
            case "cereza":
                fruits.setImageResource(R.drawable.cherry);
                Toast.makeText(this, "Cargando " + selectedOption + "("+ selectedPosition+")", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}