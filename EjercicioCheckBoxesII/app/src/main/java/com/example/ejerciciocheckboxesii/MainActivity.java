package com.example.ejerciciocheckboxesii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etTexto;

    CheckBox boxTv, boxRad, boxNews, boxFri, boxOther;

    TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTexto = (EditText) findViewById(R.id.etCualOtros);

        boxTv = (CheckBox) findViewById(R.id.cbTv);
        boxRad = (CheckBox) findViewById(R.id.cbRadio);
        boxNews = (CheckBox) findViewById(R.id.cbPeriodico);
        boxFri = (CheckBox) findViewById(R.id.cbAmigo);
        boxOther = (CheckBox) findViewById(R.id.cbOtros);

        etTexto.setVisibility(View.INVISIBLE);

        tvText = (TextView) findViewById(R.id.tvText);
    }

    public void cargarInfo(View v){
        if (boxTv.isChecked()){
            tvText.setText("Gracias por la informacion");
            etTexto.setVisibility(View.INVISIBLE);
        }
        if (boxRad.isChecked()){
            tvText.setText("Gracias por la informacion");
            etTexto.setVisibility(View.INVISIBLE);
        }
        if (boxNews.isChecked()){
            tvText.setText("Gracias por la informacion");
            etTexto.setVisibility(View.INVISIBLE);
        }
        if (boxFri.isChecked()){
            tvText.setText("Gracias por la informacion");
            etTexto.setVisibility(View.INVISIBLE);
        }
        if ( boxOther.isChecked()){
            tvText.setText("¿Cuáles otros?");
            etTexto.setVisibility(View.VISIBLE);
        }

    }

}