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
    EditText celularH,saldoH, celulardestinoH;
    Toast toast;
    Button enviarDinero, volver;
    DBHelper DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_transaccion);
        DB = new DBHelper(this);

        int saldo = Integer.parseInt(getIntent().getExtras().getString("saldo"));// putExtra de interfacas a transaccion del saldo

        celularH = findViewById(R.id.celularPropietario);
        saldoH = findViewById(R.id.dinerotransaccion);
        celulardestinoH = findViewById(R.id.celularDestino);






        enviarDinero = findViewById(R.id.enviarDinero);
        enviarDinero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String celular = celularH.getText().toString();
                String monto = saldoH.getText().toString();
                String celularD= celulardestinoH.getText().toString();

                if(TextUtils.isEmpty(celular) || TextUtils.isEmpty(monto) ||  TextUtils.isEmpty(celularD))
                alertToast("Llenar todos los campos");

                else if(Integer.parseInt(monto) <= saldo){ //convertir Strind monto de a entero

                    int num1=Integer.parseInt(monto);
                    int resta = saldo - num1 ;
                    String resu = String.valueOf(resta);

                    Boolean isUpdate = DB.updatesaldo(celularH.getText().toString(),resu);

                    if(isUpdate == true){
                        alertToast("Envio exitoso");


                    }else
                        alertToast("Fallo en el envio");



                    celularH.setText("");
                    saldoH.setText("");
                    celulardestinoH.setText("");
                }else
                    alertToast("El monto supera su saldo");
                }

        });

        volver = findViewById(R.id.volver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Interfas.class);
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