package com.example.sharedpreferences_radomizergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText number;
    int myNumber;
    TextView howClose;
    Button guess;

    Random r = new Random();
    int valueNumber = r.nextInt(9)+1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    public void initialize(){
        number = (EditText) findViewById(R.id.etNumber);

        howClose = (TextView) findViewById(R.id.tvHowClose);
        guess = (Button) findViewById(R.id.btnGuess);
    }

    public void guessNumber (View view){
        myNumber = Integer.parseInt(number.getText().toString());
        if (myNumber > 11){
            Toast.makeText(this, "No puede ser mayor de 10", Toast.LENGTH_SHORT).show();
        } else {
            while (myNumber != valueNumber){
                if (myNumber > valueNumber){
                    howClose.setText("Incorrecto! es mas grande que el numero");
                } else if (myNumber < valueNumber){
                    howClose.setText("Incorrecto!  es mas pequeño que el numero");
                } else if (myNumber == valueNumber){
                    howClose.setText("¡HAS ACERTADO");
                }
            }
        }


    }
}