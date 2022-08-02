package com.example.nequi_clon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Interfas extends AppCompatActivity {
    TextView usuNobre ,saldoUsuario ;
    DBHelper DB;
    Bundle bundle;
    String celularU1;
    Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfas);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        DB = new DBHelper(this);


        bundle = getIntent().getExtras();
        celularU1 = bundle.getString("celularU1");

        usuNobre = findViewById(R.id.nombreDeusuario);
        usuNobre.setText(DB.consultar(celularU1));

        saldoUsuario = findViewById(R.id.saldoUsuario);

        String saldo = DB.consultarsaldo(celularU1);
        
        saldoUsuario.setText(DB.consultarsaldo(celularU1));


        enviar = findViewById(R.id.enviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),transaccion.class);
                intent.putExtra("saldo",saldo);
                startActivity(intent);
            }
        });

    }



    @Override
    public void onBackPressed(){
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("Estas seguro que quieres salir de Nequi??")
                    .setMessage("cierra tu sesion cuando no estes usando Nequi")
                    .setPositiveButton("Si",null)
                    .setNegativeButton("Cancelar",null)
                    .show();

            Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(),loginUsuario.class);
                    startActivity(intent);
                    finish();
                }
            });
        }

    }
