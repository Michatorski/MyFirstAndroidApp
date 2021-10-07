package com.example.controlescheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton tb_activacion = (ToggleButton) findViewById(R.id.tb_activation);
        // Cambiar el texto muestra el boton dependiendo del estado
        tb_activacion.setTextOff("Desactivado");
        tb_activacion.setTextOn("Activar");


        // Activamos el botón al iniciar la app
        //tb_activacion.setChecked(false);
    }

    public void cargar(View v) {
        ToggleButton tb_activation = (ToggleButton)  findViewById(R.id.tb_activation);
        TextView tv_activation = (TextView)  findViewById(R.id.tv_prueba);

        if (tb_activation.isChecked()){
            //Si esta activado.
            tv_activation.setText("ToggleButton activado");
        } else if (!tb_activation.isChecked()){
            //si esta desactivado
            tv_activation.setText("ToggleButton desactivado");
        }
    }
}