package com.example.nequi_clon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class transaccion extends AppCompatActivity {
    EditText saldoH, celulardestinoH;
    Toast toast;
    Button enviarDinero, volver;
    DBHelper DB;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        setContentView(R.layout.activity_transaccion);
        DB = new DBHelper(this);


        int saldo = Integer.parseInt(getIntent().getExtras().getString("saldo"));
        String usuc = getIntent().getExtras().getString("usuc");
        // putExtra de interfacas a transaccion del saldo , celular usuario

        saldoH = findViewById(R.id.dinerotransaccion);
        celulardestinoH = findViewById(R.id.celularDestino);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        enviarDinero = findViewById(R.id.enviarDinero);
        enviarDinero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String montoTXT = saldoH.getText().toString();
                String celularDTXT= celulardestinoH.getText().toString();

                DB.insertarContacto(celularDTXT,montoTXT,usuc);// celular destino , monto , celular dueño


                if( TextUtils.isEmpty(montoTXT) ||  TextUtils.isEmpty(celularDTXT))
                alertToast("Llenar todos los campos");

                else if(Integer.parseInt(montoTXT) <= saldo){ //convertir Strind monto de a entero
                    int num1=Integer.parseInt(montoTXT);
                    int resta = saldo - num1 ;
                    String resu = String.valueOf(resta);

                    Boolean isUpdate = DB.updatesaldo(usuc,resu);


                    if(isUpdate == true){
                        alertToast("envio Exitoso");
                        saldoH.setText("");
                        celulardestinoH.setText("");
                        Intent intent = new Intent(transaccion.this,Interfas.class);
                        intent.putExtra("celularU1",usuc);
                        startActivity(intent);
                        finish();
                    }else
                        alertToast("fallas en el envio");
                }else
                    alertToast("El monto supera su saldo");
                }

        });
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        volver = findViewById(R.id.volver);
        volver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                transaccion.super.onBackPressed();
                    finish();
                

            }
        });

    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onBackPressed(){

    }

    private void alertToast(String msg){
        if(toast != null) toast.cancel();
        toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}