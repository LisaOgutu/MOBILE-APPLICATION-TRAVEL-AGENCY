package com.example.doramilaje;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME ="searchdb";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="searches";
    private static final String COLUMN_ID= "id";
    private static final String COLUMN_LOCATION = "location";
    private static final String COLUMN_NAME = "Hotel_name";
    private static final String  COLUMN_RATING = "Rating";
    private static final String COLUMN_PRICE = "Price";

    public  DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override

    //CREATE TABLE format: ("CREATE TABLE" + TABLE_NAME + "( "+ KEY_ID +"INTEGER PRIMARY KEY AUTOINCREMENT, "
    //        +KEY_fieldname + "datatype," ....);
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "( "+ COLUMN_ID +"INTEGER PRIMARY KEY AUTOINCREMENT, "
        +COLUMN_LOCATION + "TEXT," + COLUMN_NAME + "TEXT," + COLUMN_RATING + "STRING," + COLUMN_PRICE + "INTEGER)";

        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public void addData(String Hotel_name, String location, String Rating, String Price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,Hotel_name );
        values.put(COLUMN_LOCATION, location);
        values.put(COLUMN_RATING,Rating );
        values.put(COLUMN_PRICE,Price );

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

}
