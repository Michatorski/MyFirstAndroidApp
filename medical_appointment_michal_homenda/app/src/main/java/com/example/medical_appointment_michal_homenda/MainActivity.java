package com.example.medical_appointment_michal_homenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;

    EditText day, hour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
    public void init(){

        day = (EditText) findViewById(R.id.etDay);
        hour = (EditText) findViewById(R.id.etHour);

        pref = getSharedPreferences("date", Context.MODE_PRIVATE);


    }

    public void saveAndNext(View view){
        Intent intent = new Intent( this, MainActivity2.class);

        SharedPreferences.Editor editor = pref.edit();
        
        if (!(day.getText().toString().isEmpty() && hour.getText().toString().isEmpty()))
        {
            editor.putString(getString(R.string.shared_day), day.getText().toString());
            editor.putString(getString(R.string.shared_hour), hour.getText().toString());

            editor.commit();

            startActivity(intent);
        } else {
            Toast.makeText(this, "Debes rellenar todos los campos del formulario.", Toast.LENGTH_SHORT).show();
        }

       


    }
}