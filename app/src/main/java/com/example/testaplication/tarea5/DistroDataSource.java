package com.example.testaplication.tarea5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DistroDataSource {

    private static final String TAG = "DistroDataSource";
    private SQLiteOpenHelper dbHelper;
    private SQLiteDatabase database;

    public DistroDataSource(Context context) {
        dbHelper = new DistroDBOpenHelper(context);
    }

    public void openDb() {
        database = dbHelper.getWritableDatabase();
        Log.i(TAG, "Abriendo base de datos");
    }

    public void closeDb() {
        dbHelper.close();
        Log.i(TAG, "base de datos Cerrada");
    }
}