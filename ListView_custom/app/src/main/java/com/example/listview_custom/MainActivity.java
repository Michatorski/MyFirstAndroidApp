package com.example.listview_custom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected final static String LIST_GRAPHIC_CARD = "com.example.listview_custom";

    ListView lv_sistemas;

    TextView resu;

    String selectedOption;

    String[] aux_Os = {"Geforce RTX3090", "MSI AMD Radeon X 6800", "Geforce RTX3060"};

    ArrayList fullCart = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

    }

    public void initialize() {
        resu = (TextView) findViewById(R.id.tv_Test);

        ArrayAdapter aa_OperativeSystems = new ArrayAdapter(this, R.layout.list_view_custom, R.id.tv_Aux, aux_Os);

        lv_sistemas = (ListView) findViewById(R.id.lv_sistemas);

        lv_sistemas.setAdapter(aa_OperativeSystems);

        lv_sistemas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                selectedOption = parent.getItemAtPosition(i).toString();

                Toast.makeText(parent.getContext(), "Has seleccionado " + selectedOption, Toast.LENGTH_SHORT).show();

                fullCart.add(selectedOption);

                resu.setText(fullCart.toString());
            }
        });
    }

    public void send(View v) {
        Intent intent = new Intent(this, MainActivity2.class);

        intent.putExtra(LIST_GRAPHIC_CARD, fullCart);

        startActivity(intent);
    }
}