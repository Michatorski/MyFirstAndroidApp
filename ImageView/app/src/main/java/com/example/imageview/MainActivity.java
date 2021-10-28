package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cambiarImagen(View v){
        ImageView iv_frutas = (ImageView) findViewById(R.id.iv_frutas);

        switch (v.getId()){
            case R.id.btnApple:
                iv_frutas.setImageResource(R.drawable.apple);
                break;
            case R.id.btnAvocado:
                iv_frutas.setImageResource(R.drawable.avocado);
                break;
            case R.id.btnCherry:
                iv_frutas.setImageResource(R.drawable.cherry);
                break;
        }


    }
}