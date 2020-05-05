package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //access MyHelper class
        MyHelper myHelper = new MyHelper(this);
        SQLiteDatabase database = myHelper.getReadableDatabase(); //here is two methods getReadableDatabase() and WriteableDatabase

        //cursor object for get data
        Cursor cursor = database.rawQuery("SELECT NAME,PRICE FROM PRODUCTS", new String[]{});

        if (cursor != null) {
            cursor.moveToFirst();
        }
        StringBuilder builder = new StringBuilder(); // store all data(optional)
        do {

            String name = cursor.getString(0);
            double price = cursor.getDouble(1);

            builder.append("name" + name + "price" + price);

            Log.i("msjdhsjk", "onCreate1: " + name);
            Log.i("msjdhsjk", "onCreate2: " + price);
            Log.i("msjdhsjk", "onCreate3: " + builder.toString());

        } while (cursor.moveToNext());

    }
}
