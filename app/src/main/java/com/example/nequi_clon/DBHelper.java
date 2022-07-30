package com.example.nequi_clon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME="login.db";
    public DBHelper(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(celularU TEXT primary key, password TEXT, nameU TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists users");
    }

    public Boolean insertData(String celularU,String password, String nameU){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("celularU",celularU);
        values.put("password",password);
        values.put("nameU",nameU);

        long result = db.insert("users",null,values);
        if(result == -1)return false;
        else
            return true;

    }

    public Boolean checkusername(String celularU){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from users where celularU=?",new String[]{celularU});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }

    public Boolean checkusernamepassword(String celularU,String password){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from users where celularU=? and password=?",new String[]{celularU,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }
}
