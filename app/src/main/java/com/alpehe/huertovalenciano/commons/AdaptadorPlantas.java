package com.alpehe.huertovalenciano.commons;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.alpehe.huertovalenciano.R;
import com.alpehe.huertovalenciano.datos.RepositorioPlantas;
import com.alpehe.huertovalenciano.modelo.Planta;

public class AdaptadorPlantas extends
        RecyclerView.Adapter<AdaptadorPlantas.ViewHolder> {
    protected RepositorioPlantas plantas;
    protected View.OnClickListener onClickListener;

    public AdaptadorPlantas(RepositorioPlantas plantas) {
        this.plantas = plantas;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre, especie;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.fSiembra);
            especie = itemView.findViewById(R.id.especie);

        }

        public void personaliza(Planta planta) {
            nombre.setText(planta.getNombre());
            especie.setText(planta.getEspecie());

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.elemento_lista, parent, false);
        v.setOnClickListener(onClickListener);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int posicion) {
        Planta planta = plantas.elemento(posicion);
        holder.personaliza(planta);
    }

    @Override public int getItemCount() {
        return plantas.tamaño();
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
