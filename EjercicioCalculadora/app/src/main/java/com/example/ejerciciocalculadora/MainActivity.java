package com.example.ejerciciocalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText eNum1, eNum2;
    private TextView tValorRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eNum1 = (EditText) findViewById(R.id.etNum1);
        eNum2 = (EditText) findViewById(R.id.etNum2);

        tValorRes = (TextView) findViewById(R.id.tValorRes);
    }

    public void cargarSuma(View v) {

        if (eNum1.getText().toString().isEmpty() || eNum2.getText().toString().isEmpty())
        { tValorRes.setText("Introduce los números"); }
        else {
            String sNum1 = eNum1.getText().toString();
            String sNum2 = eNum2.getText().toString();

            int num1 = Integer.parseInt(sNum1);
            int num2 = Integer.parseInt(sNum2);

            int res = num1 + num2;
            tValorRes.setText(Integer.toString(res));
        }
    }

    public void cargarResta(View v) {

        if (eNum1.getText().toString().isEmpty() || eNum2.getText().toString().isEmpty())
        { tValorRes.setText("Introduce los números"); }
        else {
            String sNum1 = eNum1.getText().toString();
            String sNum2 = eNum2.getText().toString();

            int num1 = Integer.parseInt(sNum1);
            int num2 = Integer.parseInt(sNum2);

            int res = num1 - num2;
            tValorRes.setText(Integer.toString(res));
        }
    }

    public void cargarMulti(View v) {

        if (eNum1.getText().toString().isEmpty() || eNum2.getText().toString().isEmpty())
        { tValorRes.setText("Introduce los números"); }
        else {
            String sNum1 = eNum1.getText().toString();
            String sNum2 = eNum2.getText().toString();

            int num1 = Integer.parseInt(sNum1);
            int num2 = Integer.parseInt(sNum2);

            int res = num1 * num2;
            tValorRes.setText(Integer.toString(res));
        }
    }

    public void cargarDiv(View v) {
        if (eNum1.getText().toString().isEmpty() || eNum2.getText().toString().isEmpty())
        { tValorRes.setText("Introduce los números"); }
        else {
            String sNum1 = eNum1.getText().toString();
            String sNum2 = eNum2.getText().toString();

            int num1 = Integer.parseInt(sNum1);
            int num2 = Integer.parseInt(sNum2);

            int res = num1 / num2;
            tValorRes.setText(Integer.toString(res));
        }

    }

    public void reset(View v) {

        eNum1.setText(" ");
        eNum2.setText(" ");
        tValorRes.setText(" ");
    }
}