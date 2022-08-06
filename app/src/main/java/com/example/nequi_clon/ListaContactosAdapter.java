package com.example.nequi_clon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaContactosAdapter extends RecyclerView.Adapter<ListaContactosAdapter.ContactoViewHolder> {

    //contructor
    ArrayList<HistorialContactos>listContactos;
    public ListaContactosAdapter(ArrayList<HistorialContactos>listContactos){
        this.listContactos = listContactos;
    }

    @NonNull
    @Override

    //identifica cual sera el diseño de cada elemento
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_historial,null,false);
       return new ContactoViewHolder(view);
    }


    //asignar los elementos que corresponde para cada opcion
    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        holder.viewCelularP.setText(listContactos.get(position).getCelularP());
        holder.viewDinero.setText(listContactos.get(position).getDinero());
        holder.viewCelularE.setText(listContactos.get(position).getCelular());

    }


    // tamaño que tenemos de nuestra lista
    @Override
    public int getItemCount() {
        return listContactos.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {

        TextView viewCelularP,viewDinero,viewCelularE;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            viewCelularP = itemView.findViewById(R.id.viewCelularP);
            viewDinero = itemView.findViewById(R.id.viewDinero);
            viewCelularE = itemView.findViewById(R.id.viewCelularE);

        }
    }
}
