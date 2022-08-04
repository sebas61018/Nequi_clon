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
    ArrayList<String> celular , monto, celularD;
    consultar CO;
    Myadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        CO = new consultar(this);
        celular = new ArrayList<>();
        monto = new ArrayList<>();
        celularD = new ArrayList<>();


        recyclerView = findViewById(R.id.recyclerview);
        adapter = new Myadapter(this,celular,monto,celularD);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
        Cursor cursor = CO.getdata();
        if(cursor.getCount() == 0){
            alertToast("No existe");
        }else
        {
            while (cursor.moveToFirst()) {
                celular.add(cursor.getString(0));
                monto.add(cursor.getString(1));
                celularD.add(cursor.getString(2));
            }
        }
    }

    private void alertToast(String msg){
        if(toast != null) toast.cancel();
        toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}