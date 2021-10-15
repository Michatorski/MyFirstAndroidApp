package com.example.imagebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected boolean isFruitVisible, isVegetableVisible;

    ImageButton imgBtnAlbaricoque,imgBtnPlatano, imgBtnPatata,
            imgBtnPimiento, imgBtnFruta, imgBtnVerdura;
    TextView tvAlbaricoque, tvPlatano, tvPatata, tvPimiento, tvCestaCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBtnAlbaricoque = (ImageButton) findViewById(R.id.ibAlba);
        imgBtnPlatano = (ImageButton) findViewById(R.id.ibPlatano);
        imgBtnPatata = (ImageButton) findViewById(R.id.ibPatata);
        imgBtnPimiento = (ImageButton) findViewById(R.id.ibPimiento);
        imgBtnFruta = (ImageButton) findViewById(R.id.ibFruta);
        imgBtnVerdura = (ImageButton) findViewById(R.id.ibVerdura);

        tvAlbaricoque = (TextView) findViewById(R.id.tAlbar);
        tvPlatano = (TextView) findViewById(R.id.tPlat);
        tvPatata = (TextView) findViewById(R.id.tPata);
        tvPimiento = (TextView) findViewById(R.id.tPimi);
        tvCestaCompra = (TextView) findViewById(R.id.tCestaComp);

        isFruitVisible = false;
        isVegetableVisible = false;
    }

    public void showFruta(View v){
       Toast toast = Toast.makeText(this, "Has elegido fruta", Toast.LENGTH_SHORT);
       toast.show();


        if(isFruitVisible){
            imgBtnAlbaricoque.setVisibility(View.INVISIBLE);
            tvAlbaricoque.setVisibility(View.INVISIBLE);

            imgBtnPlatano.setVisibility(View.INVISIBLE);
            tvPlatano.setVisibility(View.INVISIBLE);

            isFruitVisible = false;
        } else {
            imgBtnAlbaricoque.setVisibility(View.VISIBLE);
            tvAlbaricoque.setVisibility(View.VISIBLE);

            imgBtnPlatano.setVisibility(View.VISIBLE);
            tvPlatano.setVisibility(View.VISIBLE);

            isFruitVisible = true;
        }
    }

    public void showVerdura(View v){
        Toast toast = Toast.makeText(this, "Has elegido verdura", Toast.LENGTH_SHORT);
        toast.show();


        if(isVegetableVisible){
            imgBtnPatata.setVisibility(View.INVISIBLE);
            tvPatata.setVisibility(View.INVISIBLE);

            imgBtnPimiento.setVisibility(View.INVISIBLE);
            tvPimiento.setVisibility(View.INVISIBLE);

            isVegetableVisible = false;
        } else {
            imgBtnPatata.setVisibility(View.VISIBLE);
            tvPatata.setVisibility(View.VISIBLE);

            imgBtnPimiento.setVisibility(View.VISIBLE);
            tvPimiento.setVisibility(View.VISIBLE);

            isVegetableVisible = true;
        }
    }

}