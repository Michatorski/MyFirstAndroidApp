package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize() {

        txtOS = (TextView) findViewById(R.id.tvOS);

        ListView lv_sistemas = (ListView) findViewById(R.id.lv_OsList);
        String[] lista_Os = {"Windows", "Linux", "iOS", "Others"};

        ArrayAdapter aa_Frutas = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista_Os);

        lv_sistemas.setAdapter(aa_Frutas);


        lv_sistemas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String selectedOption = parent.getSelectedItem().toString();

                switch (i) {
                    case 0:
                        txtOS.setText(selectedOption);
                        Toast.makeText( parent, "Has seleccionado " + selectedOption, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

}
