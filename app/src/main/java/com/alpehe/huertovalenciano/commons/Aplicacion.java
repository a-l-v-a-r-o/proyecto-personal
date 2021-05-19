package com.alpehe.huertovalenciano.commons;

import android.app.Application;

import com.alpehe.huertovalenciano.datos.ListaPlantas;
import com.alpehe.huertovalenciano.datos.RepositorioPlantas;

public class Aplicacion extends Application {
    public RepositorioPlantas plantas = new ListaPlantas();
    public AdaptadorPlantas adaptador = new AdaptadorPlantas(plantas);

    @Override public void onCreate() {
        super.onCreate();
    }
    public RepositorioPlantas getLugares() {
        return plantas;
    }
}
