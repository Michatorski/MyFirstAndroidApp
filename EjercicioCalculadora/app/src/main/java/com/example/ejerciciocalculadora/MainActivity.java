package com.example.ejerciciocalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cargarSuma(View v) {
        EditText eNum1 = (EditText) findViewById(R.id.etNum1);
        EditText eNum2 = (EditText) findViewById(R.id.etNum2);

        TextView tValorRes = (TextView) findViewById(R.id.tValorRes);

        String sNum1 = eNum1.getText().toString();
        String sNum2 = eNum2.getText().toString();

        int num1 = Integer.parseInt(sNum1);
        int num2 = Integer.parseInt(sNum2);

        int sum = num1 + num2;
        tValorRes.setText(Integer.toString(sum));
    }

    public void cargarResta(View v) {
        EditText eNum1 = (EditText) findViewById(R.id.etNum1);
        EditText eNum2 = (EditText) findViewById(R.id.etNum2);

        TextView tValorRes = (TextView) findViewById(R.id.tValorRes);

        String sNum1 = eNum1.getText().toString();
        String sNum2 = eNum2.getText().toString();

        int num1 = Integer.parseInt(sNum1);
        int num2 = Integer.parseInt(sNum2);

        int sum = num1 - num2;
        tValorRes.setText(Integer.toString(sum));
    }

    public void cargarMulti(View v) {
        EditText eNum1 = (EditText) findViewById(R.id.etNum1);
        EditText eNum2 = (EditText) findViewById(R.id.etNum2);

        TextView tValorRes = (TextView) findViewById(R.id.tValorRes);

        String sNum1 = eNum1.getText().toString();
        String sNum2 = eNum2.getText().toString();

        int num1 = Integer.parseInt(sNum1);
        int num2 = Integer.parseInt(sNum2);

        int sum = num1 * num2;
        tValorRes.setText(Integer.toString(sum));
    }

    public void cargarDiv(View v) {
        EditText eNum1 = (EditText) findViewById(R.id.etNum1);
        EditText eNum2 = (EditText) findViewById(R.id.etNum2);

        TextView tValorRes = (TextView) findViewById(R.id.tValorRes);

        String sNum1 = eNum1.getText().toString();
        String sNum2 = eNum2.getText().toString();

        int num1 = Integer.parseInt(sNum1);
        int num2 = Integer.parseInt(sNum2);

        int sum = num1 / num2;
        tValorRes.setText(Integer.toString(sum));
    }

    public void reset(View v) {
        EditText eNum1 = (EditText) findViewById(R.id.etNum1);
        EditText eNum2 = (EditText) findViewById(R.id.etNum2);

        TextView tValorRes = (TextView) findViewById(R.id.tValorRes);

        eNum1.setText(" ");
        eNum2.setText(" ");
        tValorRes.setText(" ");
    }
}