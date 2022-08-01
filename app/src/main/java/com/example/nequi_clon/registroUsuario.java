package com.example.nequi_clon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registroUsuario extends AppCompatActivity {

    EditText celularU,password,respassword,nameU;
    Button signup,atras;
    DBHelper DB;
    Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        celularU = findViewById(R.id.celularU);
        password = findViewById(R.id.password);
        respassword = findViewById(R.id.respassword);
        nameU = findViewById(R.id.nameU);
        signup = findViewById(R.id.signup);
        atras = findViewById(R.id.atras);

        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String celu = celularU.getText().toString();
                String pass = password.getText().toString();
                String respass = respassword.getText().toString();
                String nam = nameU.getText().toString();

                if(TextUtils.isEmpty(celu) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(respass) || TextUtils.isEmpty(nam) )
                    alertToast("Llenar todos los campos");
                else {
                    if(pass.equals(respass)){
                        Boolean checkuser = DB.checkusername(celu);
                        if(checkuser == false){
                            Boolean insert = DB.insertData(celu,pass,nam);
                            if(insert == true){
                                alertToast("Registro exitoso");

                                celularU.setText("");
                                password.setText("");
                                respassword.setText("");
                                nameU.setText("");
                            }else {
                                alertToast("Registro Fallido");
                            }
                        }else {
                            alertToast("Este usuario ya existe");
                        }
                    }else {
                        alertToast("La contraseña no coinciden");
                    }
                }
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void alertToast(String msg){
        if(toast != null) toast.cancel();
        toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}