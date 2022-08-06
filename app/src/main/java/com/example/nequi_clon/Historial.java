package com.example.nequi_clon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Historial extends AppCompatActivity {

    RecyclerView listaContactos;
    ArrayList<HistorialContactos>listaArrayContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        listaContactos = findViewById(R.id.listaHistorial);
        listaContactos.setLayoutManager(new LinearLayoutManager(this));

        DBHelper dbHelper = new DBHelper(Historial.this);

        listaArrayContactos = new ArrayList<>();

        ListaContactosAdapter adapter = new ListaContactosAdapter(dbHelper.mostrarContactos());
        listaContactos.setAdapter(adapter);

    }
}