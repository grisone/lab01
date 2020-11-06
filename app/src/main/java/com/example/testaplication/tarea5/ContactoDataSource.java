package com.example.testaplication.tarea5;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ContactoDataSource {

    private static final String TAG = "ContactoDataSource";
    private SQLiteOpenHelper dbHelper;
    private SQLiteDatabase database;

    public ContactoDataSource(Context context) {
        dbHelper = new ContactoDbOpenHelper(context);
    }

    public void openDb() {
        database = dbHelper.getWritableDatabase();
        Log.i(TAG, "Abriendo base de datos");
    }

    public void closeDb() {
        dbHelper.close();
        Log.i(TAG, "base de datos Cerrada");
    }


    public List<Contacto> getListaContactos() {
        List<Contacto> lista = new ArrayList<Contacto>();
        String query = "SELECT * FROM contacto";

        Cursor cursor = database.rawQuery(query, null);
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                Contacto per = new Contacto();
                per.setId(cursor.getInt(cursor.getColumnIndex("id")));
                per.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
                per.setPaterno(cursor.getString(cursor.getColumnIndex("paterno")));
                per.setMaterno(cursor.getString(cursor.getColumnIndex("materno")));
                per.setTelefono(cursor.getString(cursor.getColumnIndex("telefono")));
                per.setSexo(cursor.getString(cursor.getColumnIndex("sexo")));

                lista.add(per);
            }
        }

        return lista;
    }
}
