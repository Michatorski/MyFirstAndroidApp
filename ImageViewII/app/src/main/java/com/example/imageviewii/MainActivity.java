package com.example.imageviewii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText searcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searcher = (EditText) findViewById( R.id.et_letra);
    }

    public void chargeImagen(View v){
        ImageView iv_frutas = (ImageView) findViewById(R.id.iv_frutas);

        switch (searcher.getText().toString()){
            case "m":
                Toast.makeText(this, "has escogido una manzana", Toast.LENGTH_SHORT).show();
                iv_frutas.setImageResource(R.drawable.apple);
                break;
            case "a":
                Toast.makeText(this, "has escogido un aguacate", Toast.LENGTH_SHORT).show();
                iv_frutas.setImageResource(R.drawable.avocado);
                break;
            case "c":
                Toast.makeText(this, "has escogido una cereza", Toast.LENGTH_SHORT).show();
                iv_frutas.setImageResource(R.drawable.cherry);
                break;
            default:
                Toast.makeText(this, "No se a encontrado ninguna fruta", Toast.LENGTH_SHORT).show();
                iv_frutas.setImageResource(R.drawable.fruta);
                break;
        }


    }
}