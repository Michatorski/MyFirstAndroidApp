package com.example.getdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText name, surname, age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initilizer();
    }

    public void initilizer() {
        name = (EditText) findViewById(R.id.etName);
        surname = (EditText) findViewById(R.id.etSurname);
        age = (EditText) findViewById(R.id.etAge);
    }

    public void save(View view) {
        Intent intent = new Intent(this, MainActivity3.class);

        SharedPreferences prefItem = getSharedPreferences(getString(R.string.configItem), Context.MODE_PRIVATE);
        SharedPreferences.Editor editorItem = prefItem.edit();

        if (name.getText().toString().isEmpty()) {
            Toast.makeText(this, "Debes rellenar este hueco", Toast.LENGTH_SHORT).show();
        } else {
            editorItem.putString(getString(R.string.name), name.getText().toString());
            editorItem.putString(getString(R.string.surname), surname.getText().toString());
            editorItem.putString(getString(R.string.age), age.getText().toString());

            editorItem.commit();
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE, 1, Menu.NONE, "Volver");
        menu.add(Menu.NONE, 2, Menu.NONE, R.string.guardar);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent previous = new Intent(this, MainActivity.class);

        switch (item.getItemId()){
            case 1:
                startActivity(previous);
                return  true;
            case 2:
                Intent nextPage = new Intent(this, MainActivity3.class);

                SharedPreferences prefItem = getSharedPreferences(getString(R.string.configItem), Context.MODE_PRIVATE);
                SharedPreferences.Editor editorItem = prefItem.edit();

                if (name.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Debes rellenar este hueco", Toast.LENGTH_SHORT).show();
                } else {
                    editorItem.putString(getString(R.string.name), name.getText().toString());
                    editorItem.putString(getString(R.string.surname), surname.getText().toString());
                    editorItem.putString(getString(R.string.age), age.getText().toString());

                    editorItem.commit();
                    startActivity(nextPage);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}