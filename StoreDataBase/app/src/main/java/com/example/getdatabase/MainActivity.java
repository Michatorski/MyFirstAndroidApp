package com.example.getdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    protected static final String ITEM_NAME = "com.example.menucontext";

    ListView elementList;

    ArrayList<String> itemlist;

    ArrayAdapter<String> adapter;

    EditText newItem;

    int valueNumber;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializer();
        adapterInit();
    }


    public void initializer() {
        newItem = (EditText) findViewById(R.id.etNameItem);
        elementList = (ListView) findViewById(R.id.lv_elements);

        itemlist = new ArrayList<String>();
        itemlist.add("Water");
        itemlist.add("Fire");

        registerForContextMenu(elementList);

        intent = new Intent(this, MainActivity2.class);
    }

    public void adapterInit() {

        adapter = new ArrayAdapter<String>(this,
                R.layout.list_layout, R.id.tv_listItem, itemlist);
        elementList.setAdapter(adapter);

        elementList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
               String  selectedOption = parent.getItemAtPosition(i).toString();

                sharedPreference(selectedOption);

                startActivity(intent);
            }
        });
    }

    public void sharedPreference(String optionItem){
        SharedPreferences prefItem = getSharedPreferences(getString(R.string.configItem), Context.MODE_PRIVATE);
        SharedPreferences.Editor editorItem = prefItem.edit();

        editorItem.putString(getString(R.string.itemName), optionItem);
        editorItem.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_add, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itAdd:
                if (!newItem.getText().toString().isEmpty()) {
                    this.itemlist.add(newItem.getText().toString());
                    this.adapter.notifyDataSetChanged();
                } else {
                    Random r = new Random();
                    valueNumber = r.nextInt(999) + 1;
                    this.itemlist.add(String.valueOf(valueNumber));
                    this.adapter.notifyDataSetChanged();
                }

                Toast.makeText(this, "Has añadido el elemento", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Opciones:");

        menu.add(0, 1, 0, "Borrar");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case 1:
                this.itemlist.remove(info.position);
                this.adapter.notifyDataSetChanged();

                Toast.makeText(this, "Has borrado el elemento", Toast.LENGTH_SHORT).show();
            default:
                return super.onContextItemSelected(item);
        }
    }
}