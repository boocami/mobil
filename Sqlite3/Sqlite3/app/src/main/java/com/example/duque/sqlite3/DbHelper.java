package com.example.duque.sqlite3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    // creamos las tablas en comando sql.
    String query1 = "CREATE TABLE tblpersona (rut TEXT PRIMARY KEY, nombre TEXT, apellido TEXT)";

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);//this, bdgym, null,1
    }

    //ejecuta consultas sql, preferencia  create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query1);
    }

    // para hacer actualizaciones a la base de datos.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // if exists table drop nombreTable.
    }
}
