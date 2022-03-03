package com.example.repaso_evau2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView name, surname, age, extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init();
    }

    public void init() {
        SharedPreferences sharedPref = getSharedPreferences("sharedFile", Context.MODE_PRIVATE);

        String getName = sharedPref.getString(getString(R.string.name), getString(R.string.def));
        String getSurname = sharedPref.getString(getString(R.string.surname), getString(R.string.def));
       String getAge = sharedPref.getString(getString(R.string.age), getString(R.string.def));
        String getExtra = sharedPref.getString(getString(R.string.extra), getString(R.string.def));

        name = (TextView) findViewById(R.id.tvDataName);
        surname = (TextView) findViewById(R.id.tvDataSurname);
        age = (TextView) findViewById(R.id.tvDataAge);
        extra = (TextView) findViewById(R.id.tvDataExtra);

        name.setText(getName);
        surname.setText(getSurname);
        age.setText(getAge);
        extra.setText(getExtra);
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