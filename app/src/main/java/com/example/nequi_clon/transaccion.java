package com.example.nequi_clon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class transaccion extends AppCompatActivity {
    EditText celularH,saldoH;
    Toast toast;
    Button enviarDinero;
    TextView text;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaccion);
        DB = new DBHelper(this);

        int saldo = Integer.parseInt(getIntent().getExtras().getString("saldo"));

        celularH = findViewById(R.id.celulartransaccion);
        saldoH = findViewById(R.id.dinerotransaccion);
        text = findViewById(R.id.textra);



        enviarDinero = findViewById(R.id.enviarDinero);
        enviarDinero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String celular = celularH.getText().toString();
                String monto = saldoH.getText().toString();

                if(TextUtils.isEmpty(celular) || TextUtils.isEmpty(monto))
                alertToast("Llenar todos los campos");

                else if(Integer.parseInt(monto) <= saldo){

                    int valorE = Integer.parseInt(monto);
                    int valorR = saldo;
                    int result =  valorR - valorE ;

                    Boolean updatedata;


                    alertToast("Envio exitoso");
                    celularH.setText("");
                    saldoH.setText("");
                }else
                    alertToast("El monto supera su saldo");

                }

        });
    }


    private void alertToast(String msg){
        if(toast != null) toast.cancel();
        toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}