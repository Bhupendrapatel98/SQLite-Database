package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //access MyHelper class
        MyHelper myHelper = new MyHelper(this);
        SQLiteDatabase database = myHelper.getReadableDatabase(); //here is two methods getReadableDatabase() and WriteableDatabase

    }
}
