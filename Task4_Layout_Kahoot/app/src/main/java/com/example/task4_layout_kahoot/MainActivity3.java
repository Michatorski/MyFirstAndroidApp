package com.example.task4_layout_kahoot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView correctAnswerText, textWinOrFail, wrong, right;
    String chosenAnswer, nick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initialize();
    }

    public void initialize(){
        correctAnswerText = (TextView) findViewById(R.id.tvResCorrect);
        wrong = (TextView) findViewById(R.id.tvWrong);
        right = (TextView) findViewById(R.id.tvCorrect);
        textWinOrFail = (TextView) findViewById(R.id.tvWinFail);

        correctAnswerText.setVisibility(View.GONE);
    wrong.setVisibility(View.GONE);
    }

    public void getTheResults(){
        Intent getIntent = getIntent();

        chosenAnswer = getIntent.getStringExtra(MainActivity2.CHOSEN_ANSWER);
        nick = getIntent.getStringExtra(MainActivity.NICKNAME);


        if(chosenAnswer.equals("Open source framework, usando para escribir y ejecutar tests")){
            textWinOrFail.setText("Enhorabuena, lo has logrado " + nick);
            right.setText("Open source framework, usando para escribir y ejecutar tests");
        } else {
            
        }
    }
}