package com.example.nequi_clon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Historial extends AppCompatActivity {
    Toast toast;

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
            celarDTXT.add(0,cursor.getString(0));
            montoTXT.add(0,cursor.getString(1));
            usuc.add(0,cursor.getString(2));
        }

    }


    private void alertToast(String msg){
        if(toast != null) toast.cancel();
        toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}