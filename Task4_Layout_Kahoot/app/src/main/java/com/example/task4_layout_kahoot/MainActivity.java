package com.example.task4_layout_kahoot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected static final String NICKNAME = "com.example.nickname";

    EditText nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nickname = (EditText) findViewById(R.id.etNickname);
    }

    public void startGame(View v){

        Intent intent = new Intent(this, MainActivity2.class);

        if(nickname.getText().toString().isEmpty()){
            Toast.makeText(this, "Tienes que rellenar el apodo", Toast.LENGTH_SHORT).show();
        } else {
            intent.putExtra(NICKNAME, nickname.getText().toString());

            startActivity(intent);
        }
    }
}