package com.alpehe.huertovalenciano.datos;

import com.alpehe.huertovalenciano.modelo.Planta;
import com.alpehe.huertovalenciano.modelo.PlantaSeleccionada;

public interface RepositorioPlantasSeleccionadas {

    PlantaSeleccionada elemento(int id); //Devuelve el elemento dado su id
    void añade(PlantaSeleccionada plantaS); //Añade el elemento indicado
    int nuevo(); //Añade un elemento en blanco y devuelve su id
    void borrar(int id); //Elimina el elemento con el id indicado
    int tamaño(); //Devuelve el número de elementos
    void actualiza(int id, PlantaSeleccionada plantaS); //Reemplaza un elemento
}
