package com.example.sqllite_bbdd_formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText fullName, email, age, address, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        DbHelper dbHelperUser = new DbHelper(this);
        Toast.makeText(this, "Creando base de datos users.sqlite", Toast.LENGTH_SHORT).show();
        SQLiteDatabase database = dbHelperUser.getWritableDatabase();

        Toast.makeText(this, "Creando la tabla Users", Toast.LENGTH_SHORT).show();
        String createUsers = "CREATE TABLE IF NOT EXISTS " +
                Users.UsersEntry.TABLE_NAME +"(" + Users.UsersEntry.ID + " INTEGER " +
                "PRIMARY KEY AUTOINCREMENT, " +
                Users.UsersEntry.FULL_NAME + " VARCHAR(50), "+
                Users.UsersEntry.AGE +" INTEGER," + 
                Users.UsersEntry.EMAIL +" VARCHAR(100)," +
                Users.UsersEntry.ADDRESS +" VARCHAR(100)," +
                Users.UsersEntry.PHONE +" INTEGER)";
        database.execSQL(createUsers);
        Toast.makeText(this, "Tabla Users ha sido creada", Toast.LENGTH_SHORT).show();
    }


    public void initialize(){
        fullName = (EditText) findViewById(R.id.etFullName);
        age = (EditText) findViewById(R.id.etAgeNumber);
        email = (EditText) findViewById(R.id.etEmail);
        address = (EditText) findViewById(R.id.etAddress);
        phone = (EditText) findViewById(R.id.etPhone);
    }

    public void insertData(View view){
        DbHelper dbHelperCustom = new DbHelper(this, DbHelper.DATABASE_NAME, null, 1);
        SQLiteDatabase getDataBase = dbHelperCustom.getWritableDatabase();

        String getFullName = fullName.getText().toString();
        String getAge = age.getText().toString();
        String getEmail = email.getText().toString();
        String getAddress = address.getText().toString();
        String getPhone = phone.getText().toString();

        
        if (!(getFullName.isEmpty() && getAge.isEmpty() && getEmail.isEmpty()
                && getAddress.isEmpty() && getPhone.isEmpty())){

            ContentValues userValues = new ContentValues();

            userValues.put(Users.UsersEntry.FULL_NAME, getFullName);
            userValues.put(Users.UsersEntry.AGE, getAge);
            userValues.put(Users.UsersEntry.EMAIL, getEmail);
            userValues.put(Users.UsersEntry.ADDRESS, getAddress);
            userValues.put(Users.UsersEntry.PHONE, getPhone);

            getDataBase.insert(Users.UsersEntry.TABLE_NAME, null, userValues);

            getDataBase.close();

            Toast.makeText(this, "Se han insertado los datos.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Introduce datos en todos los campos.", Toast.LENGTH_SHORT).show();
        }
        
    }
}