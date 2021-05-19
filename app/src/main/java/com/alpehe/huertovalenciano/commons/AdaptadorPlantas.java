package com.alpehe.huertovalenciano.commons;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.alpehe.huertovalenciano.R;
import com.alpehe.huertovalenciano.datos.RepositorioPlantas;
import com.alpehe.huertovalenciano.modelo.Planta;

public class AdaptadorPlantas extends
        RecyclerView.Adapter<AdaptadorPlantas.ViewHolder> {
    protected RepositorioPlantas plantas;         // Lista de plantas a mostrar

    public AdaptadorPlantas(RepositorioPlantas plantas) {
        this.plantas = plantas;
    }

    //Creamos nuestro ViewHolder, con los tipos de elementos a modificar
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre, especie;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            especie = itemView.findViewById(R.id.especie);

        }
        // Personalizamos un ViewHolder a partir de un planta
        public void personaliza(Planta planta) {
            nombre.setText(planta.getNombre());
            especie.setText(planta.getEspecie());

        }
    }

    // Creamos el ViewHolder con la vista de un elemento sin personalizar
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos la vista desde el xml
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.elemento_lista, parent, false);
        return new ViewHolder(v);
    }

    // Usando como base el ViewHolder y lo personalizamos
    @Override
    public void onBindViewHolder(ViewHolder holder, int posicion) {
        Planta planta = plantas.elemento(posicion);
        holder.personaliza(planta);
    }
    // Indicamos el número de elementos de la lista
    @Override public int getItemCount() {
        return 1/*plantas.tamanyo()*/;
    }
}
