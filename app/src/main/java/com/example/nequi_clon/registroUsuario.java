package com.example.nequi_clon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registroUsuario extends AppCompatActivity {

    EditText celularU,password,respassword,nameU;
    Button signup;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        celularU = findViewById(R.id.celularU);
        password = findViewById(R.id.password);
        respassword = findViewById(R.id.respassword);
        nameU = findViewById(R.id.nameU);
        signup = findViewById(R.id.signup);

        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String celu = celularU.getText().toString();
                String pass = password.getText().toString();
                String respass = respassword.getText().toString();
                String nam = nameU.getText().toString();

                if(TextUtils.isEmpty(celu) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(respass) || TextUtils.isEmpty(nam) )
                    Toast.makeText(registroUsuario.this, "Llenar todos los campos", Toast.LENGTH_SHORT).show();
                else {
                    if(pass.equals(respass)){
                        Boolean checkuser = DB.checkusername(celu);
                        if(checkuser == false){
                            Boolean insert = DB.insertData(celu,pass,nam);
                            if(insert == true){
                                Toast.makeText(registroUsuario.this, "Registro exitoso", Toast.LENGTH_SHORT).show();

                                celularU.setText("");
                                password.setText("");
                                respassword.setText("");
                                nameU.setText("");
                            }else {
                                Toast.makeText(registroUsuario.this, "Registro Fallido", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(registroUsuario.this, "Este usuario ya existe", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(registroUsuario.this, "La contraseña no coinciden", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}