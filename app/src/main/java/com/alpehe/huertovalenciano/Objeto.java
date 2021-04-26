package com.alpehe.huertovalenciano;

public class Objeto {

    String nombre;
    Tipo tipo;
    String variedad;
    String descripcion;

    public Objeto(String nombre, Tipo tipo, String variedad, String descripcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.variedad = variedad;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
