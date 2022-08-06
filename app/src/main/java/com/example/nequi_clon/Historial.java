package com.example.nequi_clon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class Historial extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> celarDTXT, montoTXT , usuc;
    DBHelper DB;
    ListaContactosAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);



        DB = new DBHelper(this);
        celarDTXT = new ArrayList<>();
        montoTXT = new ArrayList<>();
        usuc = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new ListaContactosAdapter(this,celarDTXT,montoTXT,usuc);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dispayData();



    }

    private void dispayData() {

        Cursor cursor = DB.getData();

        while (cursor.moveToNext())
        {
            celarDTXT.add(cursor.getString(0));
            montoTXT.add(cursor.getString(1));
            usuc.add(cursor.getString(2));
        }

    }
}