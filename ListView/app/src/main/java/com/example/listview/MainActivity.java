package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    protected static final String OPERATIVE_SYSTEM = "";
    protected static final String OPERATIVE_SYSTEM_TYPE = "";

    TextView txtOS;

    RadioGroup osTypes;

    RadioButton operativeSystem1, operativeSystem2, operativeSystem3;

    EditText nameOtherOs;

    ListView lv_sistemas;

    String selectedOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        listOnClick();
    }

    public void initialize() {

        txtOS = (TextView) findViewById(R.id.tvOS);

        osTypes = (RadioGroup) findViewById(R.id.rg_osTypes);

        nameOtherOs = (EditText) findViewById(R.id.et_nameOs);

        operativeSystem1 = (RadioButton) findViewById(R.id.rb_os1);
        operativeSystem2 = (RadioButton) findViewById(R.id.rb_os2);
        operativeSystem3 = (RadioButton) findViewById(R.id.rb_os3);

        lv_sistemas = (ListView) findViewById(R.id.lv_OsList);

        osTypes.setVisibility(View.GONE);
        nameOtherOs.setVisibility(View.GONE);


    }

    public void listOnClick() {
        String[] lista_Os = {"Windows", "Linux", "iOS", "Others"};

        ArrayAdapter aa_OperativeSystems = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista_Os);

        lv_sistemas.setAdapter(aa_OperativeSystems);

        lv_sistemas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                selectedOption = parent.getItemAtPosition(i).toString();

                txtOS.setText(selectedOption);
                Toast.makeText(parent.getContext(), "Has seleccionado " + selectedOption, Toast.LENGTH_SHORT).show();


                switch (selectedOption) {
                    case "Windows":
                        osTypes.setVisibility(View.VISIBLE);
                        nameOtherOs.setVisibility(View.GONE);
                        operativeSystem1.setText("Windows7");
                        operativeSystem2.setText("Windows10");
                        operativeSystem3.setText("Windows11");
                        break;
                    case "Linux":
                        osTypes.setVisibility(View.VISIBLE);
                        nameOtherOs.setVisibility(View.GONE);
                        operativeSystem1.setText("Ubuntu");
                        operativeSystem2.setText("RedHat");
                        operativeSystem3.setText("Others");
                        break;
                    case "iOS":
                        osTypes.setVisibility(View.VISIBLE);
                        nameOtherOs.setVisibility(View.GONE);
                        operativeSystem1.setText("macOS 10.15 Catalina (Jazz)");
                        operativeSystem2.setText("macOS 11 Big Sur");
                        operativeSystem3.setText("macOS 12 Monterey");
                        break;
                    case "Others":
                        nameOtherOs.setVisibility(View.VISIBLE);
                        osTypes.setVisibility(View.GONE);
                        break;
                }
            }
        });
    }

    public void sendInfo(View v) {

        if(){

        }
        Intent intent = new Intent(this, MainActivity2.class);


        intent.putExtra(OPERATIVE_SYSTEM, selectedOption);

        if (operativeSystem1.isChecked()) {
            intent.putExtra(OPERATIVE_SYSTEM_TYPE, operativeSystem1.getText().toString());
        } else if (operativeSystem2.isChecked()) {
            intent.putExtra(OPERATIVE_SYSTEM_TYPE, operativeSystem2.getText().toString());
        } else if (operativeSystem3.isChecked()) {
            intent.putExtra(OPERATIVE_SYSTEM_TYPE, operativeSystem3.getText().toString());
        } else if (selectedOption.contains("Others")) {
            if(nameOtherOs.getText().toString().isEmpty()){
                Toast.makeText(this, "Rellena el nombre del sistema operativo", Toast.LENGTH_SHORT).show();
            } else {
                intent.putExtra(OPERATIVE_SYSTEM_TYPE, nameOtherOs.getText().toString());
            }
        } else {
            Toast.makeText(this, "Hay que escoger un tipo", Toast.LENGTH_SHORT).show();
        }


        startActivity(intent);

    }
}
