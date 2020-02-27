package com.tonikamitv.loginregister;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Map;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "squattools.db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users(ID INTEGER PRIMARY KEY, id INT, username TEXT, name TEXT, age TEXT)");
        db.execSQL("CREATE TABLE groups(ID INTEGER PRIMARY KEY, name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
    }

    public boolean Insert(String table, Map values){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        /*contentValues.put("id", id);
        contentValues.put("name", name);
        contentValues.put("username", username);
        contentValues.put("age", age);
        */
        long result = sqLiteDatabase.insert(table, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean CheckValue(String value){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE username=?", new String[]{value});
        if(cursor.getCount() > 0){
            return false;
        }else{
            return true;
        }
    }

    public Boolean CheckLogin(String username, String password){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE username=? AND password=?", new String[]{username, password});
        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }
}
