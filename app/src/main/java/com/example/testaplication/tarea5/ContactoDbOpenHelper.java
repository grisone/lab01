package com.example.testaplication.tarea5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class ContactoDbOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contactos.db";
    private static final int VERSION = 1;
    private static final String TAG = "ContactoDbOpenHelper";

    private static final String CREATE_TABLE = "CREATE TABLE contacto(" +
            "id INTEGER PRIMARY KEY autoincrement," +
            "nombre TEXT," +
            "paterno TEXT," +
            "materno TEXT," +
            "telefono TEXT," +
            "sexo TEXT" +
            ")";

    private static final String USUARIO = "INSERT OR REPLACE INTO contacto (id, nombre, paterno, materno, telefono, sexo) VALUES ";


    public ContactoDbOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.i(TAG, "Base de datos creada");
        db.execSQL(USUARIO + "(1, 'Pedro', 'Perez', 'Pereira','+56 9 9999 99999', 'M');");
        db.execSQL(USUARIO + "(2, 'Armando', 'Casas', 'Bellas','+56 9 9999 99999', 'M');");
        db.execSQL(USUARIO + "(3, 'Zoila', 'Cerda', 'Del Campo','+56 9 9999 99999', 'M');");
        db.execSQL(USUARIO + "(4, 'Felipe', 'Pinto', 'Sanchez','+56 9 9999 99999', 'F');");
        db.execSQL(USUARIO + "(5, 'Jaimini', 'Santini', 'Chorizo','+56 9 9999 99999', 'F');");
        db.execSQL(USUARIO + "(6, 'Elsa', 'Pito', 'Rosales','+56 9 9999 99999', 'F');");
        db.execSQL(USUARIO + "(7, 'Ana', 'Lisa', 'Melano','+56 9 9999 99999', 'F');");
        db.execSQL(USUARIO + "(8, 'Elsa', 'Pito', 'Rosales','+56 9 9999 99999', 'F');");
        db.execSQL(USUARIO + "(9, 'Jorge', 'Nitales', 'Hermosilla','+56 9 9999 99999', 'M');");
        Log.i(TAG, "Base de datos actualizada");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "Base de datos actualizada desde la version [" + oldVersion +" hacia [" + newVersion + "]");
    }
}
