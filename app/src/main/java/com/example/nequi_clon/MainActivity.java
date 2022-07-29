package com.example.nequi_clon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button iniciosesion , crearusuario;
    Toast toast;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciosesion = findViewById(R.id.id_iniciosesion);
        crearusuario = findViewById(R.id.id_crearcuenta);


        crearusuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, registroUsuarios.class);
                startActivity(i);
            }
        });


    }

    private void alerToast(String msg){
        if(toast != null) toast.cancel();
        toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        toast.show();
    }

    public void inicio(View v){

            iniciosesion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, passwordUsuarios.class);
                    startActivity(i);
                }
            });
    }

}