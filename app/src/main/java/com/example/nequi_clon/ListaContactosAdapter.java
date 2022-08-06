package com.example.nequi_clon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaContactosAdapter extends RecyclerView.Adapter<ListaContactosAdapter.ContactoViewHolder> {

    private Context context;
    private ArrayList celularE_id , dinero_id , celularP_id;

    public ListaContactosAdapter(Context context, ArrayList celularE_id, ArrayList dinero_id, ArrayList celularP_id) {
        this.context = context;
        this.celularE_id = celularE_id;
        this.dinero_id = dinero_id;
        this.celularP_id = celularP_id;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);

        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {

            holder.celularE_id.setText(String.valueOf(celularE_id.get(position)));
            holder.dinero_id.setText(String.valueOf(dinero_id.get(position)));
            holder.celularP_id.setText(String.valueOf(celularP_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return celularE_id.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {
        TextView celularE_id , dinero_id , celularP_id;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            celularE_id = itemView.findViewById(R.id.textCelularDTXT);
            dinero_id = itemView.findViewById(R.id.textMontoTXT);
            celularP_id = itemView.findViewById(R.id.textUsucTXT);

        }
    }
    //contructor
    //identifica cual sera el diseño de cada elemento
    //asignar los elementos que corresponde para cada opcion
    // tamaño que tenemos de nuestra lista
}
