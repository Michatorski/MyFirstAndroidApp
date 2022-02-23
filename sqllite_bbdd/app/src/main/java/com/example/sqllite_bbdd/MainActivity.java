package com.example.sqllite_bbdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.ContentInfo;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqllite_bbdd.tables.Comments;

import java.net.CookieHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Permite envio de datos personalizados
        //DbHelper dbHelper = new DbHelper(this, "test.db", null, 2);
        //creo la base de datos
        DbHelper dbHelperLawyer = new DbHelper(this);
        Toast.makeText(this, "Creando la base de datos lawyers.sqlite", Toast.LENGTH_SHORT).show();
        SQLiteDatabase database = dbHelperLawyer.getWritableDatabase();

        //Creando tabla
        Toast.makeText(this, "Creando la tabla alumnos...", Toast.LENGTH_SHORT).show();
        String create_alumnos = "CREATE TABLE IF NOT EXISTS alumnos(code INTEGER" +
                " PRIMARY KEY AUTOINCREMENT, nombre VARCHAR(50))";
        database.execSQL(create_alumnos);
        Toast.makeText(this, "Tabla de alumnos creada.", Toast.LENGTH_SHORT).show();

        String create_comments = "CREATE TABLE IF NOT EXISTS " +
                "comments(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "user VARCHAR(50), comment VARCHAR(100))";
        database.execSQL(create_comments);
        Toast.makeText(this, "Tabla de comentarios creada.", Toast.LENGTH_SHORT).show();

        // Opcion 1: Insert mediante execSQL
        String insertComments = "INSERT INTO comments (user, comment) " +
                "VALUES ('admin', 'Adminisitrador del sistema')";

        database.execSQL(insertComments);

        // Opcion 2: Insert medianteValues

        ContentValues insertCommentsV2 = new ContentValues();
        String userVar = "user";

        Comments comments = new Comments();
        insertCommentsV2.put(userVar, "usuario");
        insertCommentsV2.put("comment", "Usuario normal del sistema");
        database.insert("comments", null, insertCommentsV2);
        //database.close();
    }

    public void crearBD(View view){
        EditText et_databaseName = (EditText) findViewById(R.id.et_databaseName);

        if (!et_databaseName.getText().toString().equals("")){
            String bd = et_databaseName.getText().toString();
            DbHelper sbHelperCustom = new DbHelper(this, bd + ".sqlite", null, 1);

            SQLiteDatabase database = sbHelperCustom.getWritableDatabase();
            Toast.makeText(this, "Dase de datos creada", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Introduce un nombre " +
                    "para la base de datos", Toast.LENGTH_SHORT).show();
        }
    }
    
    public void crearQuery(View view){
        EditText et_queryName = (EditText) findViewById(R.id.et_queryName);
        
        DbHelper sbHelperCustom = new DbHelper(this,  "lawyers.sqlite", null, 1);
        
        SQLiteDatabase getDataBase = sbHelperCustom.getWritableDatabase();
        
        String newQuery = et_queryName.getText().toString();
        
        if (!et_queryName.getText().toString().isEmpty()){
            getDataBase.execSQL(newQuery);

            Toast.makeText(this, "Query creada", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Introduce la query", Toast.LENGTH_SHORT).show();
        }
    }
}