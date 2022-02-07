package com.example.getdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    EditText name, surname, age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initilizer();
    }

    public void initilizer(){
        name = (EditText) findViewById(R.id.etName);
        name = (EditText) findViewById(R.id.etSurname);
        name = (EditText) findViewById(R.id.etAge);
    }

    public void save (View view){
        Intent intent = new Intent(this, MainActivity3.class);

        SharedPreferences prefItem = getSharedPreferences("personData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorItem = prefItem.edit();

        editorItem.putString("name", name.getText().toString());
        editorItem.putString("surname", surname.getText().toString());
        editorItem.putString("age", age.getText().toString());

        editorItem.commit();

        startActivity(intent);
    }
}