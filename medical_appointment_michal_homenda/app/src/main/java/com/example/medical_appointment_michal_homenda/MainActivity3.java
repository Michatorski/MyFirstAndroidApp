package com.example.medical_appointment_michal_homenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    TextView day, hour, infoExtra;

    DbHelper dbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init();
    }

    public void init(){
        Intent getIntent = getIntent();

        day = (TextView) findViewById(R.id.tvDataDay);
        hour = (TextView) findViewById(R.id.tvDataHour);
        infoExtra = (TextView) findViewById(R.id.tvDataExtraInfo);

        SharedPreferences pref = getSharedPreferences("date", Context.MODE_PRIVATE);

        day.setText(pref.getString(getString(R.string.shared_day), getString(R.string.shared_default)));
        hour.setText(pref.getString(getString(R.string.shared_hour), getString(R.string.shared_default)));
        infoExtra.setText(getIntent.getStringExtra(MainActivity2.INFO_EXTRA));


       dbOpenHelper = new DbHelper(this);
        Toast.makeText(this, "Creando base de datos.", Toast.LENGTH_SHORT).show();
        SQLiteDatabase database = dbOpenHelper.getWritableDatabase();
        Toast.makeText(this, "Base de datos creada.", Toast.LENGTH_SHORT).show();



        Toast.makeText(this, "Creando tabla cita", Toast.LENGTH_SHORT).show();
        String createTableCommand = "CREATE TABLE IF NOT EXISTS appointment " +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "day INTEGER, " +
                "hour INTEGER, " +
                "speciality VARCHAR(20))";
        database.execSQL(createTableCommand);

        ContentValues appointmentValues = new ContentValues();
        appointmentValues.put("day", pref.getString(getString(R.string.shared_day), getString(R.string.shared_default)));
        appointmentValues.put("hour", pref.getString(getString(R.string.shared_hour), getString(R.string.shared_default)));
        appointmentValues.put("speciality", getIntent.getStringExtra(MainActivity2.INFO_EXTRA));
        database.insert("appointment", null, appointmentValues);
        Toast.makeText(this, "Valores insertados", Toast.LENGTH_SHORT).show();
    }
}