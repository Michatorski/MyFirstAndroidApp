package com.example.accumulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView result;

    EditText editNum;

    Button substractButton, addButton, resetButton;

    ToggleButton onOffButtons;

    CheckBox negaCountCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.tvNumberResult);

        editNum = (EditText) findViewById(R.id.etNum);


        substractButton = (Button) findViewById(R.id.btnSub);
        addButton = (Button) findViewById(R.id.btnAdd);


        onOffButtons = (ToggleButton) findViewById(R.id.tbShowButtons);

        resetButton = (Button) findViewById(R.id.btnReset);
        resetButton.setVisibility(View.INVISIBLE);


        negaCountCheck = (CheckBox) findViewById(R.id.cbNegaCount);
        negaCountCheck.setVisibility(View.INVISIBLE);

        onOffButtons.setChecked(false);
        negaCountCheck.setChecked(true);

    }

    public void addNumber(View v) {

        if (TextUtils.isEmpty(editNum.getText().toString())) {
            Toast.makeText(MainActivity.this,
                    "Es necesario introducir un numero",
                    Toast.LENGTH_SHORT).show();
        } else {
            String stNum = editNum.getText().toString();
            double newNum = Double.parseDouble(stNum);

            String stRes = result.getText().toString();
            double newRes = Double.parseDouble(stRes);
            newRes += newNum;

            if (newNum > 100) {
                Toast.makeText(this, "No se puede más de 100", Toast.LENGTH_SHORT).show();
            } else {
                result.setText("" + newRes);
            }
        }

    }

    public void substractNumber(View v) {
        if (TextUtils.isEmpty(editNum.getText().toString())) {
            Toast.makeText(MainActivity.this,
                    "Es necesario introducir un numero",
                    Toast.LENGTH_SHORT).show();
        } else {
            String stNum = editNum.getText().toString();
            double newNum = Double.parseDouble(stNum);

            String stRes = result.getText().toString();
            double newRes = Double.parseDouble(stRes);
            newRes -= newNum;

            if (newNum > 100) {
                Toast.makeText(this, "No se puede más de 100", Toast.LENGTH_SHORT).show();
            } else if (newRes < 0) {
                Toast.makeText(this, "El resultado es un numero negativo", Toast.LENGTH_SHORT).show();
            } else {
                result.setText("" + newRes);
            }
        }


    }

    public void hideSubstract(View v) {


        if (negaCountCheck.isChecked()) {
            Toast.makeText(this, "El boton RESTA ha aparecido", Toast.LENGTH_SHORT).show();
            substractButton.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this, "El boton RESTA esta oculto", Toast.LENGTH_SHORT).show();
            substractButton.setVisibility(View.GONE);
        }
    }

    public void showAdditionalButtons(View v) {

        if (onOffButtons.isChecked()) {
            Toast.makeText(this, "Se han mostrado opciones adicionales", Toast.LENGTH_SHORT).show();
            resetButton.setVisibility(View.VISIBLE);
            negaCountCheck.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this, "Se han ocultado opciones adicionales", Toast.LENGTH_SHORT).show();
            resetButton.setVisibility(View.GONE);
            negaCountCheck.setVisibility(View.GONE);
        }
    }

    public void resetNumbers(View v) {
        result.setText(" ");
        editNum.setText(" ");
    }
}