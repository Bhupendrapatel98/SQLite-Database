package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {

  private static final String dbname = "Mydb"; //database name
  private static final int version = 1;

    public MyHelper(Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Create Table
        String sql = "CREATE TABLE PRODUCTS(id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,DESCRIPTION TEXT,PRICE REAL)";

        //execute query
        db.execSQL(sql);

        //Insert Data
        insertData("Bhupendra","Good Boy",300.50,db);
        insertData("Nageendra","Good Boy",300.50,db);
        insertData("pooja","Good Boy",300.50,db);
        insertData("mintu","Good Boy",300.50,db);
    }

    private void insertData(String name,String description,double price,SQLiteDatabase database){

        ContentValues values = new ContentValues();
        values.put("NAME",name);
        values.put("DESCRIPTION",description);
        values.put("PRICE",price);
        database.insert("PRODUCTS",null,values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
