package com.example.nequi_clon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="login.db";
    private static final String TABLA_NAME1 ="users";
    private static final String TABLA_NAME2 ="histo";




    public DBHelper(Context context) {super(context, "login.db", null, 1);}


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLA_NAME1+"(celularU TEXT primary key, password TEXT, nameU TEXT,saldo TEXT)");
        db.execSQL("create table "+TABLA_NAME2+"(celularE TEXT, dinero TEXT ,celularP TEXT)");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int ii) {
        db.execSQL("drop table if exists users");
        db.execSQL("drop table if exists histo");


    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////// historial


    public void insertarContacto(String celularE, String dinero,String celularP){
        SQLiteDatabase db = this.getWritableDatabase();



        ContentValues values = new ContentValues();
        values.put("celularE",celularE);
        values.put("dinero",dinero);
        values.put("celularP",celularP);

        db.insert("histo" ,null,values);


    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from histo",null);
        return cursor;
    }


    public Boolean consultaHistorial(String celularP){
        SQLiteDatabase db = this.getWritableDatabase();

        db.rawQuery("select * from histo where celularP='"+celularP+"'",null);

        return true;

    }







    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  registro de usuario
    public Boolean insertData(String celularU,String password, String nameU){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("celularU",celularU);
        values.put("password",password);
        values.put("nameU",nameU);
        values.put("saldo",1000000);

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

    /////////////////////////////////////////////////////////////////////////////////////////

    public String consultar(String celularU){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from users where celularU='"+celularU+"'",null);
        cursor.moveToFirst();
        return cursor.getString(2);
    }

    public String consultarsaldo(String celularU){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from users where celularU='"+celularU+"'",null);
        cursor.moveToFirst();
        return cursor.getString(3);
    }

    public Boolean updatesaldo(String celularU, String saldo){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("celularU",celularU);
        values.put("saldo",saldo);


        db.update("users",values,"celularU='"+celularU+"'",null);
        return true;


    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean VeryUser(String celularU){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from users where celularU='"+celularU+"'",null);

        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public String consultarEnvio(String celularU){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from users where celularU='"+celularU+"'",null);
        cursor.moveToFirst();
        return cursor.getString(3);
    }

    public void updatesaldoEnvio(String celularU, String saldo){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("celularU",celularU);
        values.put("saldo",saldo);


        db.update("users",values,"celularU='"+celularU+"'",null);
    }

}
