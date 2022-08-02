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

import java.io.Serializable;

public class loginUsuario extends AppCompatActivity {

    EditText celularU1,password1;
    Button signin1;
    DBHelper DB;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_usuario);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        celularU1 = findViewById(R.id.celularU1);
        password1 = findViewById(R.id.password1);
        signin1 = findViewById(R.id.signin1);
        DB = new DBHelper(this);

        signin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String celu = celularU1.getText().toString();
                String pass = password1.getText().toString();

                if(TextUtils.isEmpty(celu) || TextUtils.isEmpty(pass))
                    alertToast("Llenar todos los campos");
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(celu,pass);
                    if(checkuserpass == true){
                        alertToast("Bienvenido a Nequi");
                        Intent intent = new Intent(getApplicationContext(),Interfas.class);

                        intent.putExtra("celularU1", celularU1.getText().toString()); //putExtra

                        startActivity(intent);
                        celularU1.setText("");
                        password1.setText("");
                    }else {
                        alertToast("Datos incorrectos");
                    }
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