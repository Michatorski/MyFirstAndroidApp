package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtOS;

    RadioGroup osTypes;

    RadioButton operativeSystem1, operativeSystem2, operativeSystem3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize() {

        txtOS = (TextView) findViewById(R.id.tvOS);

        osTypes = (RadioGroup) findViewById(R.id.rg_osTypes);

        operativeSystem1 = (RadioButton) findViewById(R.id.rb_os1);
        operativeSystem2 = (RadioButton) findViewById(R.id.rb_os2);
        operativeSystem3 = (RadioButton) findViewById(R.id.rb_os3);

        ListView lv_sistemas = (ListView) findViewById(R.id.lv_OsList);

        String[] lista_Os = {"Windows", "Linux", "iOS", "Others"};

        ArrayAdapter aa_Frutas = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista_Os);

        lv_sistemas.setAdapter(aa_Frutas);


        lv_sistemas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String selectedOption = parent.getSelectedItem().toString();

                txtOS.setText(selectedOption);
                Toast.makeText( parent.getContext(), "Has seleccionado " + selectedOption, Toast.LENGTH_SHORT).show();


                switch (i){
                    case 0:
                      osTypes.setVisibility(View.VISIBLE);
                      operativeSystem1.setText("Windows7");
                      operativeSystem2.setText("Windows10");
                      operativeSystem3.setText("Windows11");
                        break;
                    case 1:
                        osTypes.setVisibility(View.VISIBLE);
                        operativeSystem1.setText("Ubuntu");
                        operativeSystem2.setText("RedHat");
                        operativeSystem3.setText("Others");
                        break;
                    default:
                       osTypes.setVisibility(View.GONE);
                        break;
                }
            }
        });
    }

}
