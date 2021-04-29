package com.alpehe.huertovalenciano.controlador;

import android.app.Activity;
import android.content.Intent;

import com.alpehe.huertovalenciano.vista.RiegoActivity;

public class ControladorPrincipal {

    private Activity actividad;

    public ControladorPrincipal(Activity actividad){
        this.actividad = actividad;
    }

    public void lanzarPlantas(){
        /*Intent plantas = new Intent(actividad, PlantasActivity.class);
        actividad.startActivity(plantas);*/
    }

    public void lanzarRiego(){
            Intent riego = new Intent(actividad, RiegoActivity.class);
            actividad.startActivity(riego);
    }
    public void lanzarAjustes(){
        /*Intent pref = new Intent(actividad, AjustesActivity.class);
        actividad.startActivity(pref);*/
    }

    public void lanzarAcercaDe(){
        /*Intent acercaDe = new Intent(actividad, AcercaDeActivity.class);
        actividad.startActivity(acercaDe);*/
    }
}
