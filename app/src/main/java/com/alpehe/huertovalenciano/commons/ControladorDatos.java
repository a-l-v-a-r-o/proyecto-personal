package com.alpehe.huertovalenciano.commons;

import android.app.Activity;
import android.content.Intent;

import com.alpehe.huertovalenciano.datos.RepositorioPlantas;
import com.alpehe.huertovalenciano.datos.RepositorioPlantasSeleccionadas;
import com.alpehe.huertovalenciano.modelo.Planta;
import com.alpehe.huertovalenciano.modelo.PlantaSeleccionada;
import com.alpehe.huertovalenciano.vista.VistaPlantaActivity;

public class ControladorDatos {
        private Activity vActividad;
        private RepositorioPlantas plantas;
    private RepositorioPlantasSeleccionadas plantasS;
        public ControladorDatos(Activity pActividad, RepositorioPlantas plantas) {
            this.vActividad = pActividad;
            this.plantas = plantas;
        }
    public ControladorDatos(Activity pActividad, RepositorioPlantasSeleccionadas plantasS) {
        this.vActividad = pActividad;
        this.plantasS = plantasS;
    }
        // OPERACIONES BÁSICAS
        public void mostrar(int pos,int num_iniciar) {
            Intent i = new Intent(vActividad, VistaPlantaActivity.class);
            i.putExtra("pos", pos);
            i.putExtra("num_iniciar", num_iniciar);
            vActividad.startActivity(i);
        }
        public void borrar(int id) {
            plantas.borrar(id);
            vActividad.finish();
        }

        public void guardar(int id, Planta nuevaPlanta) {
            plantas.actualiza(id, nuevaPlanta);
        }

    public void borrarS(int id) {
        plantasS.borrar(id);
        vActividad.finish();
    }

    public void guardar(int id, PlantaSeleccionada nuevaPlantaS) {
        plantasS.actualiza(id, nuevaPlantaS);
    }

    public void añadirS(PlantaSeleccionada plantaS){
            plantasS.añade(plantaS);
    }
}
