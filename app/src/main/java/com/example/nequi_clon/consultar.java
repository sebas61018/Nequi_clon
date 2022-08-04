package com.example.nequi_clon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class consultar extends SQLiteOpenHelper {

    private static final String DBNAME = "Cosulta.db";

    public consultar(Context context) {

        super(context, "Consulta.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table histo(celularR TEXT primary key, saldoE TEXT, celularE TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists histo");


    }


    public Boolean insertDataH(String celularR, String saldoE, String celularE) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("celularR", celularR);
        values.put("saldoE", saldoE);
        values.put("celularE", celularE);


        long result = db.insert("histo", null, values);
        if(result == 0){
            return false;
        }else
            return true;

    }

    public Cursor getdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from histo",null);
        return cursor;
    }
}
