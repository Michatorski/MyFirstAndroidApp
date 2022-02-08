package com.example.getdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView itemAct3, nameAct3, surnameAct3, ageAct3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        initialize();
    }

    public void initialize(){
        itemAct3 = (TextView) findViewById(R.id.tvAct3_Item);
        nameAct3 = (TextView) findViewById(R.id.tvAct3_Name);
        surnameAct3 = (TextView) findViewById(R.id.tvAct3_Surname);
        ageAct3 = (TextView) findViewById(R.id.tvAct3_Age);

        SharedPreferences prefItem = getSharedPreferences(getString(R.string.configItem), Context.MODE_PRIVATE);

        String savedItem = prefItem.getString(getString(R.string.itemName), getString(R.string.defaultValue));
        itemAct3.setText(savedItem);

        String savedName = prefItem.getString(getString(R.string.name), getString(R.string.defaultValue));
        nameAct3.setText(savedName);

        String savedSurname = prefItem.getString(getString(R.string.surname), getString(R.string.defaultValue));
        surnameAct3.setText(savedSurname);

        String savedAge = prefItem.getString(getString(R.string.age), getString(R.string.defaultValue));
        ageAct3.setText(savedAge);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_previous, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent previous = new Intent(this, MainActivity2.class);
        switch (item.getItemId()){
            case R.id.itBackwards:
                startActivity(previous);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}