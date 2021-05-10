package com.alpehe.huertovalenciano.datos;

import com.alpehe.huertovalenciano.modelo.Planta;

import java.util.ArrayList;
import java.util.List;

public class ListaPlantas implements RepositorioPlantas {
    protected List<Planta> listaPlantas;
    public ListaPlantas() {
        listaPlantas = new ArrayList<>();
        añadeEjemplos();
    }
    public Planta elemento(int id) {
        return listaPlantas.get(id);
    }
    public void añade(Planta planta) {
        listaPlantas.add(planta);
    }
    public int nuevo() {
        Planta planta = new Planta();
        listaPlantas.add(planta);
        return listaPlantas.size()-1;
    }
    public void borrar(int id) {
        listaPlantas.remove(id);
    }
    public int tamaño() {
        return listaPlantas.size();
    }
    public void actualiza(int id, Planta planta) {
        listaPlantas.set(id, planta);
    }
    public void añadeEjemplos() {

        añade(new Planta(null,null,
                null, null,null,null,null,null,
                null,null,
                null));
        añade(new Planta(null,null,
                null, null,null,null,null,null,
                null,null,
                null));
        añade(new Planta(null,null,
                null, null,null,null,null,null,
                null,null,
                null));
        añade(new Planta(null,null,
                null, null,null,null,null,null,
                null,null,
                null));
        añade(new Planta(null,null,
                null, null,null,null,null,null,
                null,null,
                null));
        añade(new Planta(null,null,
                null, null,null,null,null,null,
                null,null,
                null));
        añade(new Planta(null,null,
                null, null,null,null,null,null,
                null,null,
                null));

    }
}
