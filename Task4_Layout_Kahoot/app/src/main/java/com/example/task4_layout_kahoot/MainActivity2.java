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

        initializa();
    }

    public void initializa() {

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

        if (answerA.callOnClick()) {
            intent.putExtra(CHOSEN_ANSWER, answerA.getText().toString());
        } else if (answerB.callOnClick()) {
            intent.putExtra(CHOSEN_ANSWER, answerB.getText().toString());
        } else if (answerC.callOnClick()) {
            intent.putExtra(CHOSEN_ANSWER, answerC.getText().toString());
        } else if (answerD.callOnClick()) {
            intent.putExtra(CHOSEN_ANSWER, answerD.getText().toString());
        }
        startActivity(intent);

    }
}