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
        apple = (ImageView) findViewById(R.id.imgApple);
        avocado = (ImageView) findViewById(R.id.imgAvocado);
        cherry = (ImageView) findViewById(R.id.imgCherry);

        fruits.setVisibility(View.GONE);
        apple.setVisibility(View.GONE);
        avocado.setVisibility(View.GONE);
        cherry.setVisibility(View.GONE);

        String[] frutas ={"Seleccione","fruta","manzana","avocado","cereza"};

        sFrutas = (Spinner) findViewById(R.id.spinFrutas);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                frutas);
        sFrutas.setAdapter(adapter);
    }

    public void showPicture(View v){

        String selectedOption = sFrutas.getSelectedItem().toString();
        String selectedPosition = String.valueOf(sFrutas.getSelectedItem());

        if (selectedOption.equals("fruta")){
            fruits.setVisibility(View.VISIBLE);
        } else {
            fruits.setVisibility(View.GONE);
        }

        if (selectedOption.equals("manzana")){
            apple.setVisibility(View.VISIBLE);
        }else {
            apple.setVisibility(View.GONE);
        }

        if (selectedOption.equals("avocado")){
            avocado.setVisibility(View.VISIBLE);
        }else {
            avocado.setVisibility(View.GONE);
        }

        if (selectedOption.equals("cereza")){
            cherry.setVisibility(View.VISIBLE);
        }else {
            cherry.setVisibility(View.GONE);
        }

        Toast.makeText(this, selectedPosition + " " + selectedOption, Toast.LENGTH_SHORT).show();
    }
}