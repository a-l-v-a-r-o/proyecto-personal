package com.alpehe.huertovalenciano.datos;

import com.alpehe.huertovalenciano.modelo.Planta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

        //Para utilizar año actual
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String anyo = formatter.format(date);

        añade(new Planta("null","Zanahoria",
                null, null,null,null,null,null,
                "null"+"/"+anyo,"null",
                "null"));
        añade(new Planta("null","Fresa",
                null, null,null,null,null,null,
                "Noviembre-Enero","null",
                "null"));
        añade(new Planta("null","null",
                null, null,null,null,null,null,
                "null"+"/"+anyo,"null",
                "null"));
        añade(new Planta("null","null",
                null, null,null,null,null,null,
                "null"+"/"+anyo,"null",
                "null"));
        añade(new Planta("null","null",
                null, null,null,null,null,null,
                "null"+"/"+anyo,"null",
                "null"));
        añade(new Planta("null","null",
                null, null,null,null,null,null,
                "null"+"/"+anyo,"null",
                "null"));
        añade(new Planta("null","null",
                null, null,null,null,null,null,
                "null"+"/"+anyo,"null",
                "null"));

    }
}
