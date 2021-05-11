package com.alpehe.huertovalenciano.controlador;

import android.app.Activity;
import android.content.Intent;

import com.alpehe.huertovalenciano.modelo.PlantaSeleccionada;
import com.alpehe.huertovalenciano.vista.BotonesActivity;
import com.alpehe.huertovalenciano.vista.RiegoActivity;

public class ControladorPrincipal {

    private Activity actividad;

    public ControladorPrincipal(Activity actividad){
        this.actividad = actividad;
    }

    /*public Intent lanzarPlantas(){
        Intent plantas = new Intent(actividad, PlantasActivity.class);
        actividad.startActivity(plantas);
        return plantas;
    }*/

    public Intent lanzarPlantaSeleccionada(){
        Intent pSeleccionada = new Intent(actividad, PlantaSeleccionada.class);
        actividad.startActivity(pSeleccionada);

        return pSeleccionada;
    }

    public Intent lanzarRiego(){
            Intent riego = new Intent(actividad, RiegoActivity.class);
            actividad.startActivity(riego);
            return  riego;
    }

    public Intent lanzarBotones(){
        Intent botones = new Intent(actividad, BotonesActivity.class);
        actividad.startActivity(botones);

        return botones;
    }
    /*public Intent lanzarAjustes(){
        Intent pref = new Intent(actividad, AjustesActivity.class);
        actividad.startActivity(pref);
        return pref;
    }*/

    public void lanzarAcercaDe(){
        /*Intent acercaDe = new Intent(actividad, AcercaDeActivity.class);
        actividad.startActivity(acercaDe);*/
    }
}
