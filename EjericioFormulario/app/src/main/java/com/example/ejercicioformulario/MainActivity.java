package com.example.ejercicioformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cargar(View v){
        EditText etNombre = (EditText) findViewById(R.id.etNombre);
        EditText etApellido = (EditText) findViewById(R.id.etApellido);

        TextView tvValorNomreIntroducido = (TextView) findViewById(R.id.tvValorNombreIntrod);
        TextView tvValorApellidoIntroducido = (TextView) findViewById(R.id.tvValorApellidoIntrod);

        // Dos formas de recuperar  mostrar informacion de objetos

        String nombre = etNombre.getText().toString();
        tvValorNomreIntroducido.setText(nombre);

        tvValorApellidoIntroducido.setText(nombre + " " + etApellido.getText().toString());

    }
}