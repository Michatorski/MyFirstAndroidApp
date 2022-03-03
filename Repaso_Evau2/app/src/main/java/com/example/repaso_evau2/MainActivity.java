package com.example.repaso_evau2;

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

public class MainActivity extends AppCompatActivity {


    EditText name, surname, age, newExtraItem;
    ArrayList<String> extraItems;
    String selectedItem;
    ArrayAdapter<String> adapter;
    ListView listExtraInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        listViewInitializer();

        registerForContextMenu(listExtraInfo);
    }

    public void initialize(){
        name = (EditText) findViewById(R.id.etName);
        surname = (EditText) findViewById(R.id.etSurname);
        age = (EditText) findViewById(R.id.etAge);
        newExtraItem = (EditText) findViewById(R.id.etNewExtraItem);
    }

    public void listViewInitializer(){

         listExtraInfo = (ListView) findViewById(R.id.lvExtra);

        extraItems = new ArrayList<String>();
        extraItems.add("telefono");
        extraItems.add("email");
        extraItems.add("nif");

         adapter = new ArrayAdapter(this, R.layout.list_view, R.id.tvListViewText, extraItems);

        listExtraInfo.setAdapter(adapter);

        listExtraInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 selectedItem = extraItems.get(i);

//                SharedPreferences sharedPref = getSharedPreferences("sharedFile", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPref.edit();
//
//                editor.putString("extra", selectedItem);
//
//                editor.commit();

                Toast.makeText(MainActivity.this, "Objeto seleccionado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void sendInfo(View view){
        Intent intent = new Intent(this, MainActivity2.class);

        SharedPreferences sharedPref = getSharedPreferences("sharedFile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("name", name.getText().toString());
        editor.putString("surname", surname.getText().toString());
        editor.putString("age", age.getText().toString());
        editor.putString("extra", selectedItem);

        editor.commit();

        startActivity(intent);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Opciones:");

        menu.add(0, 1, 0,"borrar");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
         AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

         switch (item.getItemId()){
             case 1:
                 this.extraItems.remove(info.position);
                 this.adapter.notifyDataSetChanged();

                 Toast.makeText(this, "Se ha eleminado", Toast.LENGTH_SHORT).show();
             default:
                 return super.onContextItemSelected(item);
         }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);

         menu.add(Menu.NONE, 1,Menu.NONE, "Añadir");

         return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()){
            case 1:
                if(!newExtraItem.getText().toString().isEmpty()){
                    this.extraItems.add(newExtraItem.getText().toString());
                    this.adapter.notifyDataSetChanged();

                    Toast.makeText(this, "Nuevo item añadido", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Debes introducir algo", Toast.LENGTH_SHORT).show();
                }
                
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}