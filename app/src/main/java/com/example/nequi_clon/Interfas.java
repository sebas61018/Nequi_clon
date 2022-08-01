package com.example.nequi_clon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Interfas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfas);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
