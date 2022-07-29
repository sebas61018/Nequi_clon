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

public class passwordUsuarios extends AppCompatActivity {

    Toast toast;
    EditText numeroCelular;
    EditText clave;
    AdminSQLiteOpenHelper admin;
    Button entrarVista,id_iniciosesion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_usuarios);
        id_iniciosesion = findViewById(R.id.id_iniciosesion);

        admin = new AdminSQLiteOpenHelper(this,"administracion", null,1);

        numeroCelular = findViewById(R.id.numero_celular_password);
        clave = findViewById(R.id.numero_celular_password);



        id_iniciosesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase bd = admin.getWritableDatabase();
                String num = numeroCelular.getText().toString();
                String clav = clave.getText().toString();

                if (num.isEmpty()){
                    alertToast("Ingrese el numero de Celular");
                    return;
                }else if(clav.isEmpty()){
                    alertToast("Ingrese la clave");
                    return;
                }


                Cursor fila = bd.rawQuery("select celular,contraseña from usuarios where celular="+ num +" and contraseña="+ clav,null);
                if(fila.moveToFirst()){
                    Intent i = new Intent(passwordUsuarios.this, Interfas.class);
                    startActivity(i);

                }else {
                    alertToast("Este numero de celular no esta reguistrado");
                }



            }
        });
    }

    private void alertToast(String msg){


        if(toast != null) toast.cancel();
        toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }


}