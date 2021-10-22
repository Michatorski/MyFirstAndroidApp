package com.example.task2_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TextView counter;

    Button addButton, substractButton, resetButton;

    ToggleButton onOffButtons;

    CheckBox negaCountCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = (TextView) findViewById(R.id.tvCountTotal);

        addButton = (Button) findViewById(R.id.bPlus);
        substractButton = (Button) findViewById(R.id.bMinus);
        resetButton = (Button) findViewById(R.id.bReset);

        onOffButtons = (ToggleButton) findViewById(R.id.tbUnderButons);

        negaCountCheck = (CheckBox) findViewById(R.id.cbNegaCount);



    }

    public void addNumber(View v) {

    }

    public void substractNumber (View v){

    }

    public void hideSubstract(View v){

    }

    public void hideAdditionalButtons(View v){

    }

    public void resetNumbers(View v){

    }
}