package com.example.sqllite_bbdd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Permite envio de datos personalizados
        DbHelper dbHelper = new DbHelper(this, "test.db",
                null, 2);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database.close();
        //coger los datos/statics de la clase
        DbHelper dbHelper1 = new DbHelper(this);
    }
}