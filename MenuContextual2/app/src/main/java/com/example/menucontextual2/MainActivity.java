package com.example.menucontextual2;

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
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    protected static final String ITEM_NAME = "com.example.menucontext";

    ListView elementList;

    ArrayList<String> itemlist;

    ArrayAdapter<String> adapter;

    String selectedOption;

    EditText newItem;

    int valueNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializer();
        adapterInit();


    }

    public void initializer() {
       newItem = (EditText) findViewById(R.id.etNameItem);

        Random r = new Random();
         valueNumber = r.nextInt(999)+1;

        elementList = (ListView) findViewById(R.id.lv_elements);

        itemlist = new ArrayList<String>();
        itemlist.add("Water");
        itemlist.add("Fire");

        registerForContextMenu(elementList);


    }

    public void adapterInit(){
        adapter = new ArrayAdapter<String>(this,
                R.layout.list_layout, R.id.tv_listItem, itemlist);
        elementList.setAdapter(adapter);

        elementList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                selectedOption = parent.getItemAtPosition(i).toString();

                nextWindow(selectedOption);

            }
        });
    }

    public void nextWindow(String selectedItem){
        Intent intent = new Intent(this, ItemActivity.class);

        intent.putExtra(MainActivity.ITEM_NAME, selectedItem);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_add, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
       switch (item.getItemId()){
           case R.id.itAdd:
               if (!newItem.toString().isEmpty()){
                   this.itemlist.add(newItem.toString());
                   this.adapter.notifyDataSetChanged();
               } else {
                   this.itemlist.add("20");
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

       getMenuInflater().inflate(R.menu.menu_delete, menu);

       menu.setHeaderTitle("Opciones:");

       menu.add(0,1,0,"Borrar");

    }

    @Override
    public boolean onContextItemSelected( MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case 1:

                this.itemlist.remove(info.position);
                this.adapter.notifyDataSetChanged();

                Toast.makeText(this, "Has borrado el elemento", Toast.LENGTH_SHORT).show();
            default:
                return super.onContextItemSelected(item);
        }


    }
}