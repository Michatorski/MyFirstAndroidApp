package com.example.unidad2c_ejercicio2_formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected final static String NAME = "com.example.name";
    protected final static String SURNAME = "com.example.surname";
    protected final static String SPORT = "com.example.sport";
    protected final static String MOBILE = "com.example.mobile";
    protected final static String EMAIL = "com.example.email";
    protected final static String POSITION = "com.example.position";


    Spinner spinContacts, spinSports;

    ArrayAdapter<String> adapter1, adapter2;

    TextView tvEmail, tvMobile,choseText;
    EditText etEmail, etMobile, etName, etSurname;
    RadioButton position1, position2, position3, position4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();


    }

    public void initialize() {

        choseText = (TextView) findViewById(R.id.tvChoose);

        etName = (EditText) findViewById(R.id.etName);
        etSurname = (EditText) findViewById(R.id.etSurname);
        etMobile = (EditText) findViewById(R.id.tphoneNum);
        etEmail = (EditText) findViewById(R.id.etEmail);

        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvMobile = (TextView) findViewById(R.id.tvMobile);

        String[] contactType = {"Selecciona...", "Movil", "E-mail"};
        String[] sport = {"Selecciona...", "Fútbol", "Baloncesto"};

        spinContacts = (Spinner) findViewById(R.id.sContact);
        spinSports = (Spinner) findViewById(R.id.sSports);

        adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, contactType);
        spinContacts.setAdapter(adapter1);

        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sport);
        spinSports.setAdapter(adapter2);

        position1 = (RadioButton) findViewById(R.id.rbPosition1);
        position2 = (RadioButton) findViewById(R.id.rbPosition2);
        position3 = (RadioButton) findViewById(R.id.rbPosition3);
        position4 = (RadioButton) findViewById(R.id.rbPosition4);



        choseText.setVisibility(View.GONE);

        position1.setVisibility(View.GONE);
        position2.setVisibility(View.GONE);
        position3.setVisibility(View.GONE);
        position4.setVisibility(View.GONE);

        adapterContact();
        adapterSport();

    }

    public void adapterContact() {
        spinContacts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String selected = parent.getSelectedItem().toString();
                String selectedByPosition = parent.getItemAtPosition(position).toString();
                String res = "Selected: " + selected + " SelectedByPosition: " + selectedByPosition +
                        " position: " + position;
                Toast.makeText(parent.getContext(), res, Toast.LENGTH_SHORT).show();
                if (selected.equals("Movil")) {

                    tvEmail.setVisibility(View.GONE);
                    etEmail.setVisibility(View.GONE);


                    tvMobile.setVisibility(View.VISIBLE);
                    etMobile.setVisibility(View.VISIBLE);

                } else if (selected.equals("E-mail"))  {

                    tvEmail.setVisibility(View.VISIBLE);
                    etEmail.setVisibility(View.VISIBLE);


                    tvMobile.setVisibility(View.GONE);
                    etMobile.setVisibility(View.GONE);

                } else {
                    tvEmail.setVisibility(View.GONE);
                    etEmail.setVisibility(View.GONE);


                    tvMobile.setVisibility(View.GONE);
                    etMobile.setVisibility(View.GONE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void adapterSport(){
        spinSports.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String selected = parent.getSelectedItem().toString();
                String selectedByPosition = parent.getItemAtPosition(position).toString();
                String res = "Selected: " + selected + " SelectedByPosition: " + selectedByPosition +
                        " position: " + position;
                Toast.makeText(parent.getContext(), res, Toast.LENGTH_SHORT).show();
                if (selected.equals("Fútbol")){
                    choseText.setVisibility(View.VISIBLE);

                    position1.setVisibility(View.VISIBLE);
                    position2.setVisibility(View.VISIBLE);
                    position3.setVisibility(View.VISIBLE);
                    position4.setVisibility(View.VISIBLE);

                    position1.setText("Portero");
                    position2.setText("Defensa");
                    position3.setText("Medio");
                    position4.setText("Delantero");

                } else if (selected.equals("Baloncesto")){

                    choseText.setVisibility(View.VISIBLE);

                    position1.setVisibility(View.VISIBLE);
                    position2.setVisibility(View.VISIBLE);
                    position3.setVisibility(View.VISIBLE);
                    position4.setVisibility(View.VISIBLE);

                    position1.setText("Base");
                    position2.setText("Escolta");
                    position3.setText("Alero");
                    position4.setText("Ala-pivot");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void sendInfo(View v){

        Intent intent = new Intent(this, MainActivity2.class);

        intent.putExtra(NAME, etName.toString());
        intent.putExtra(SURNAME, etSurname.toString());
        intent.putExtra(MOBILE, etMobile.toString());
        intent.putExtra(EMAIL, etEmail.toString());
        intent.putExtra(SPORT, spinSports.getSelectedItem().toString());

        if (position1.isChecked()){
            intent.putExtra(POSITION, position1.toString());
        }
        if (position2.isChecked()){
            intent.putExtra(POSITION, position2.toString());
        }
        if (position3.isChecked()){
            intent.putExtra(POSITION, position3.toString());
        }
        if (position4.isChecked()){
            intent.putExtra(POSITION, position4.toString());
        }
    }
}