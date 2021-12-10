package com.example.listview_custom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    TextView res;

    int amount1 = 0;
    int amount2 = 0;
    int amount3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initialize();
    }

    public void initialize() {
        res = (TextView) findViewById(R.id.tv_Res);

        Intent getIntent = getIntent();

        ArrayList<String> array = getIntent.getStringArrayListExtra(MainActivity.LIST_GRAPHIC_CARD);

        for (String card : array){
            if(card.equals("Geforce RTX3090")){
                amount1++;
            } else if(card.equals("MSI AMD Radeon X 6800")){
                amount2++;
            } else  if ( card.equals("Geforce RTX3060")){
                amount3++;
            }
        }
        res.setText("GeForce RTX3090: " + amount1 + "\n MSI AMD Radeon X 6800: " + amount2 + "\n Geforce RTX3060: " + amount3);

    }
}