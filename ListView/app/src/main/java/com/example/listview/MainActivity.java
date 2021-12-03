package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String OPERATIVE_SYSTEM = "";
    private static final String OPERATIVE_SYSTEM_TYPE = "";

    TextView txtOS;

    RadioGroup osTypes;

    RadioButton operativeSystem1, operativeSystem2, operativeSystem3;

    EditText nameTheOs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize() {

        txtOS = (TextView) findViewById(R.id.tvOS);

        osTypes = (RadioGroup) findViewById(R.id.rg_osTypes);

        nameTheOs = (EditText) findViewById(R.id.et_nameOs);

        operativeSystem1 = (RadioButton) findViewById(R.id.rb_os1);
        operativeSystem2 = (RadioButton) findViewById(R.id.rb_os2);
        operativeSystem3 = (RadioButton) findViewById(R.id.rb_os3);

        ListView lv_sistemas = (ListView) findViewById(R.id.lv_OsList);

        osTypes.setVisibility(View.GONE);
        nameTheOs.setVisibility(View.GONE);

        String[] lista_Os = {"Windows", "Linux", "iOS", "Others"};

        ArrayAdapter aa_Frutas = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista_Os);

        lv_sistemas.setAdapter(aa_Frutas);


        lv_sistemas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String selectedOption = parent.getItemAtPosition(i).toString();

                txtOS.setText(selectedOption);
                Toast.makeText(parent.getContext(), "Has seleccionado " + selectedOption, Toast.LENGTH_SHORT).show();


                switch (selectedOption) {
                    case "Windows":
                        osTypes.setVisibility(View.VISIBLE);
                        nameTheOs.setVisibility(View.GONE);
                        operativeSystem1.setText("Windows7");
                        operativeSystem2.setText("Windows10");
                        operativeSystem3.setText("Windows11");
                        break;
                    case "Linux":
                        osTypes.setVisibility(View.VISIBLE);
                        nameTheOs.setVisibility(View.GONE);
                        operativeSystem1.setText("Ubuntu");
                        operativeSystem2.setText("RedHat");
                        operativeSystem3.setText("Others");
                        break;
                    case "iOS":
                        osTypes.setVisibility(View.VISIBLE);
                        nameTheOs.setVisibility(View.GONE);
                        operativeSystem1.setText("macOS 10.15 Catalina (Jazz)");
                        operativeSystem2.setText("macOS 11 Big Sur");
                        operativeSystem3.setText("macOS 12 Monterey");
                        break;
                    case "Others":
                        nameTheOs.setVisibility(View.VISIBLE);
                        osTypes.setVisibility(View.GONE);
                        break;
                }
            }
        });
    }

}
