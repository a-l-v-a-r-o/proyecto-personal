package com.alpehe.huertovalenciano.datos;

import com.alpehe.huertovalenciano.modelo.Planta;

public interface RepositorioPlantas {
        Planta elemento(int id); //Devuelve el elemento dado su id
        void añade(Planta lugar); //Añade el elemento indicado
        int nuevo(); //Añade un elemento en blanco y devuelve su id
        void borrar(int id); //Elimina el elemento con el id indicado
        int tamaño(); //Devuelve el número de elementos
        void actualiza(int id, Planta lugar); //Reemplaza un elemento

}
