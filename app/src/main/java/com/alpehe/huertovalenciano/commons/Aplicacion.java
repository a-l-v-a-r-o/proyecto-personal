package com.alpehe.huertovalenciano.commons;

import android.app.Application;

import com.alpehe.huertovalenciano.datos.ListaPlantas;
import com.alpehe.huertovalenciano.datos.ListaPlantasSeleccionadas;
import com.alpehe.huertovalenciano.datos.RepositorioPlantas;
import com.alpehe.huertovalenciano.datos.RepositorioPlantasSeleccionadas;

public class Aplicacion extends Application {
    public RepositorioPlantas plantas = new ListaPlantas();
    public AdaptadorPlantas adaptador = new AdaptadorPlantas(plantas);

    public RepositorioPlantasSeleccionadas plantasS = new ListaPlantasSeleccionadas();
    public AdaptadorPlantasSeleccionadas adaptadorS = new AdaptadorPlantasSeleccionadas(plantasS);

    @Override public void onCreate() {
        super.onCreate();
    }
    public RepositorioPlantas getPlantas() {
        return plantas;
    }
    public RepositorioPlantasSeleccionadas getPlantasSeleccionadas() {
        return plantasS;
    }
}
