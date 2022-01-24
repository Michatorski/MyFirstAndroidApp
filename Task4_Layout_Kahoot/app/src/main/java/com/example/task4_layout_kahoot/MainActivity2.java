package com.example.task4_layout_kahoot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    protected static final String CHOSEN_ANSWER = "com.example.chosen_answer";

    String nickname_activity1;

    Button answerA, answerB, answerC, answerD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initialize();

    }

    public void initialize() {

        answerA = (Button) findViewById(R.id.btn1);
        answerB = (Button) findViewById(R.id.btn2);
        answerC = (Button) findViewById(R.id.btn3);
        answerD = (Button) findViewById(R.id.btn4);



    }

    public void getData() {
        Intent intentMainAct1 = getIntent();
        nickname_activity1 = intentMainAct1.getStringExtra(MainActivity.NICKNAME);
    }

    public void sendAnswer(View v) {
        getData();

        Intent intent = new Intent(this, MainActivity3.class);

        intent.putExtra(MainActivity.NICKNAME, nickname_activity1);

        if (answerA.isPressed()) {
            intent.putExtra(CHOSEN_ANSWER, answerA.getText().toString());
        } else if (answerB.isPressed()) {
            intent.putExtra(CHOSEN_ANSWER, answerB.getText().toString());
        } else if (answerC.isPressed()) {
            intent.putExtra(CHOSEN_ANSWER, answerC.getText().toString());
        } else if (answerD.isPressed()) {
            intent.putExtra(CHOSEN_ANSWER, answerD.getText().toString());
        }
        startActivity(intent);

    }
}