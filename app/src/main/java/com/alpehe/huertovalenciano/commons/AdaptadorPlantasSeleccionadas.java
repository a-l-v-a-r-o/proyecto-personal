package com.alpehe.huertovalenciano.commons;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.alpehe.huertovalenciano.R;
import com.alpehe.huertovalenciano.datos.RepositorioPlantasSeleccionadas;
import com.alpehe.huertovalenciano.modelo.PlantaSeleccionada;

public class AdaptadorPlantasSeleccionadas extends
        RecyclerView.Adapter<AdaptadorPlantasSeleccionadas.ViewHolder> {
    protected RepositorioPlantasSeleccionadas plantasS;         // Lista de plantas a mostrar
    protected View.OnClickListener onClickListener;

    public AdaptadorPlantasSeleccionadas(RepositorioPlantasSeleccionadas plantasS) {
        this.plantasS = plantasS;
    }

    //Creamos nuestro ViewHolder, con los tipos de elementos a modificar
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre, fecha1, fecha2;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            fecha1 = itemView.findViewById(R.id.fecha1);
            fecha2 = itemView.findViewById(R.id.fecha2);

        }
        // Personalizamos un ViewHolder a partir de un planta
        public void personaliza(PlantaSeleccionada plantaS) {
            nombre.setText(plantaS.getNombre());
            fecha1.setText("Siembra:");
            fecha2.setText("Cosecha:");
            fecha1.append(plantaS.getFecha_siembra());
            fecha2.append(plantaS.getFecha_trasplante());
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos la vista desde el xml
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.elemento_lista, parent, false);
        v.setOnClickListener(onClickListener);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int posicion) {
        PlantaSeleccionada plantaS = plantasS.elemento(posicion);
        holder.personaliza(plantaS);
    }

    @Override public int getItemCount() {
        return plantasS.tamaño();
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
