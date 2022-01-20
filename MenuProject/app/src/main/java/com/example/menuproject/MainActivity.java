package com.example.menuproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.compartir:
                Toast.makeText(this, "has pulsado la opcion compartir", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.generepdf:
                Toast.makeText(this, "has pulsado la opcion generar pdf", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.enviar:
                Toast.makeText(this, "has pulsado la opcion enviar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.imprimir:
                Toast.makeText(this, "has pulsado la opcion imprimir", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.marcarpagado:
                Toast.makeText(this, "has pulsado la opcion marcado como pagado", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}