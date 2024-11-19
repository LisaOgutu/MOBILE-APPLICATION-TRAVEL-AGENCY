package com.example.doramilaje;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class maindb extends SQLiteOpenHelper {
    private static final String DATABASE_NAME ="searchdb";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="searches";
    private static final String KEY_ID= "id";
    private static final String KEY_location= "location";
    private static final String KEY_name= "Hotel_name";
    private static final String  KEY_rating= "Rating";
    private static final String KEY_price= "Price";


    public maindb(@Nullable Context context) {

        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override

    //CREATE TABLE format: ("CREATE TABLE" + TABLE_NAME + "( "+ KEY_ID +"INTEGER PRIMARY KEY AUTOINCREMENT, "
    //        +KEY_fieldname + "datatype," ....);
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE" + TABLE_NAME + "( "+ KEY_ID +"INTEGER PRIMARY KEY AUTOINCREMENT, "
        +KEY_name + "TEXT," + KEY_location + "TEXT," + KEY_rating + "INTEGER," + KEY_price + "INTEGER)");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);

    }
    public void addsearches(String Hotel_name, String location, Integer Rating, Integer Price ){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_name, Hotel_name);
        values.put( KEY_location, location);
        values.put(KEY_rating, Rating);
        values.put(KEY_price, Price);



        db.insert(TABLE_NAME, null, )
    }
}
