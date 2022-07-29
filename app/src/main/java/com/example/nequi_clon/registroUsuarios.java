package com.example.nequi_clon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registroUsuarios extends AppCompatActivity {

    EditText nombre;
    EditText celular;
    EditText clave;
    EditText cedula;
    AdminSQLiteOpenHelper admin;
    private Button id;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        nombre = findViewById(R.id.nombreusuario);
        cedula = findViewById(R.id.cedulausuario);
        celular = findViewById(R.id.celularusuario);
        clave= findViewById(R.id.claveusuario);
        admin = new AdminSQLiteOpenHelper(this,"administracion", null,1);


    }

    public void register(View view) {

        SQLiteDatabase db = admin.getWritableDatabase();

        String nom = nombre.getText().toString();
        String ced = cedula.getText().toString();
        String cel = celular.getText().toString();
        String cla = clave.getText().toString();

       if(nom.length() == 0){
           alerToast("Ingrese su nombre");
           return;
       }else if(ced.length() == 0){
           alerToast("Ingrese su cedula");
           return;
       }else if(cel.length() == 0){
           alerToast("Ingrese su celular");
           return;
       }else if (cla.length() == 0){
           alerToast("Ingrese su clave");
           return;
       }


       ContentValues registro = new ContentValues();
       registro.put("celular",cel);
       registro.put("nombre",nom);
       registro.put("cedula",ced);
       registro.put("contraseña",cla);

       db.insert("usuarios",null,registro);
       db.close();

       nombre.setText("");
       cedula.setText("");
       celular.setText("");
       clave.setText("");

       alerToast("Registro exitoso");
    }

    private void alerToast(String msg){
        if(toast != null) toast.cancel();
        toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        toast.show();
    }


}