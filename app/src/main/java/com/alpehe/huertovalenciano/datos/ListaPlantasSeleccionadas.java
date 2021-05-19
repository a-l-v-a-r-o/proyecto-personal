package com.alpehe.huertovalenciano.datos;

import com.alpehe.huertovalenciano.modelo.Planta;
import com.alpehe.huertovalenciano.modelo.PlantaSeleccionada;

import java.util.ArrayList;
import java.util.List;

public class ListaPlantasSeleccionadas implements RepositorioPlantasSeleccionadas{
    protected List<PlantaSeleccionada> listaPlantasSeleccionadas;
    public ListaPlantasSeleccionadas() {
        listaPlantasSeleccionadas = new ArrayList<>();
    }
    public PlantaSeleccionada elemento(int id) {
        return listaPlantasSeleccionadas.get(id);
    }
    public void añade(PlantaSeleccionada plantaS) {
        listaPlantasSeleccionadas.add(plantaS);
    }
    public int nuevo() {
        PlantaSeleccionada plantaS = new PlantaSeleccionada();
        listaPlantasSeleccionadas.add(plantaS);
        return listaPlantasSeleccionadas.size()-1;
    }
    public void borrar(int id) {
        listaPlantasSeleccionadas.remove(id);
    }
    public int tamaño() {
        return listaPlantasSeleccionadas.size();
    }
    public void actualiza(int id, PlantaSeleccionada plantaS) {
        listaPlantasSeleccionadas.set(id, plantaS);
    }
}
