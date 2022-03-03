package com.example.repaso_evau2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText user, userNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();
    }

    public void init() {
        user = (EditText) findViewById(R.id.etUser);
        userNumber = (EditText) findViewById(R.id.etUserNum);

        DbHelper dbHelper = new DbHelper(this);
        Toast.makeText(this, "Creado base de datos", Toast.LENGTH_SHORT).show();
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        Toast.makeText(this, "Base de datos creada", Toast.LENGTH_SHORT).show();

        Toast.makeText(this, "Creando tabla", Toast.LENGTH_SHORT).show();
        String users = "CREATE TABLE IF NOT EXISTS new_users ( " +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "user VARCHAN(20), " +
                "user_number INTEGER)";
        sqLiteDatabase.execSQL(users);

        Toast.makeText(this, "Creado tabla 'users'", Toast.LENGTH_SHORT).show();
    }

    public void insertUsersTableData(View view){
        Intent intent = new Intent( this, MainActivity3.class);

        DbHelper dbCustom = new DbHelper(this, "usersRepaso.sqlite", null, 1 );
        SQLiteDatabase getDataBase = dbCustom.getWritableDatabase();

        String getUser = user.getText().toString();
        String getUserNumber = userNumber.getText().toString();

        ContentValues contentValues = new ContentValues();
        contentValues.put("user", getUser);
        contentValues.put("user_number", getUserNumber);

        if (!(getUser.isEmpty() && getUserNumber.isEmpty())){
            getDataBase.insert("new_users", null, contentValues);

            Toast.makeText(this, "Se han insertado los nuevos datos!", Toast.LENGTH_SHORT).show();

            startActivity(intent);

        } else {
            Toast.makeText(this, "Hay que rellenar los huecos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu, menu);

        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

        return true;
    }
}