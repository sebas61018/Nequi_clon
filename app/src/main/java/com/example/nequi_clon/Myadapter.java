package com.example.nequi_clon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {

    private Context context;
    private ArrayList celular_id, monto_id,celularD_id;

    public Myadapter(Context context, ArrayList celular_id, ArrayList monto_id, ArrayList celularD) {
        this.context = context;
        this.celular_id = celular_id;
        this.monto_id = monto_id;
        this.celularD_id = celularD;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.celular_id.setText(String.valueOf(celular_id.get(position)));
        holder.monto_id.setText(String.valueOf(monto_id.get(position)));
        holder.celularD_id.setText(String.valueOf(celularD_id.get(position)));
            
    }

    @Override
    public int getItemCount() {
        return celular_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView celular_id, monto_id, celularD_id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            celular_id = itemView.findViewById(R.id.textCelularP);
            monto_id = itemView.findViewById(R.id.textSaldoE);
            celularD_id = itemView.findViewById(R.id.textCelularE);
        }
    }
}