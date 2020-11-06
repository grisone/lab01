package com.example.testaplication.tarea5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DistroDBOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "baseDeDatos.db";
    private static final int VERSION = 1;
    private static final String TAG = "DistroDBOpenHelper";

    private static final String CREATE_TABLE = "CREATE TABLE distro(" +
            "id INTEGER PRIMARY KEY autoincrement," +
            "NOMBRE TEXT," +
            "DESCRIPCION TEXT," +
            "PAQUETE TEXT," +
            "LANZAMIENTO TEXT" +
            ")";

    public DistroDBOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.i(TAG, "Base de datos creada");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "Base de datos actualizada desde la version [" + oldVersion +" hacia [" + newVersion + "]");
    }
}