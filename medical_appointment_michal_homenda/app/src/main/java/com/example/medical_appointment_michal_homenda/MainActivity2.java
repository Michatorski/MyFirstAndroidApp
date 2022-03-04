package com.example.medical_appointment_michal_homenda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    protected static final String INFO_EXTRA = "example.com.info_extra";

    ArrayAdapter<String> adapter;
    ArrayList<String> elementList;
    String elementSelected;
    EditText speciality;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();

        registerForContextMenu(listView);
    }

    public void init() {
        Intent intent = new Intent(this, MainActivity3.class);

        listView = (ListView) findViewById(R.id.listViewElements);

        elementList = new ArrayList<String>();

        elementList.add("Presencial");
        elementList.add("Telefónica");
        elementList.add("Urgencia");
        elementList.add("Partes de baja/alta");

        speciality = (EditText) findViewById(R.id.etSpeciality);

        adapter = new ArrayAdapter<String>(this, R.layout.list_view, R.id.tvElement, elementList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                elementSelected = adapterView.getItemAtPosition(i).toString();

                intent.putExtra(INFO_EXTRA, elementSelected);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(Menu.NONE, 1, Menu.NONE, "Añadir Elemento");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case 1:
                if (speciality.getText().toString().isEmpty()) {
                    Toast.makeText(this, "No has añadido nada", Toast.LENGTH_SHORT).show();
                } else {
                    this.elementList.add(speciality.getText().toString());
                    this.adapter.notifyDataSetChanged();
                }

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.add_element_menu, menu);

        menu.setHeaderTitle("Opciones:");


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.menuItem_RemoveElement:

                    this.elementList.remove(info.position);
                    this.adapter.notifyDataSetChanged();

            default:
                return super.onContextItemSelected(item);
        }

    }
}