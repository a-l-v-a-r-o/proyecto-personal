package com.alpehe.huertovalenciano.modelo;

public class PlantaSeleccionada {

    private String nombre;
    private NecesidadesHidricas necesidadesHidricas;
    private NecesidadesTermicas necesidadesTermicas;
    private NecesidadesFertilizacion necesidadesFertilizacion;
    private Problemas problemas;
    private Tareas tareas;
    private String fecha_siembra;
    private String fecha_trasplante;
    private String notas;

    public PlantaSeleccionada() {
    }

    public PlantaSeleccionada(String nombre, NecesidadesHidricas necesidadesHidricas, NecesidadesTermicas necesidadesTermicas, NecesidadesFertilizacion necesidadesFertilizacion, Problemas problemas, Tareas tareas, String fecha_siembra, String fecha_trasplante, String notas) {
        this.nombre = nombre;
        this.necesidadesHidricas = necesidadesHidricas;
        this.necesidadesTermicas = necesidadesTermicas;
        this.necesidadesFertilizacion = necesidadesFertilizacion;
        this.problemas = problemas;
        this.tareas = tareas;
        this.fecha_siembra = fecha_siembra;
        this.fecha_trasplante = fecha_trasplante;
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "PlantaSeleccionada{" +
                "nombre='" + nombre + '\'' +
                ", necesidadesHidricas=" + necesidadesHidricas +
                ", necesidadesTermicas=" + necesidadesTermicas +
                ", necesidadesFertilizacion=" + necesidadesFertilizacion +
                ", problemas=" + problemas +
                ", tareas=" + tareas +
                ", fecha_siembra='" + fecha_siembra + '\'' +
                ", fecha_trasplante='" + fecha_trasplante + '\'' +
                ", notas='" + notas + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NecesidadesHidricas getNecesidadesHidricas() {
        return necesidadesHidricas;
    }

    public void setNecesidadesHidricas(NecesidadesHidricas necesidadesHidricas) {
        this.necesidadesHidricas = necesidadesHidricas;
    }

    public NecesidadesTermicas getNecesidadesTermicas() {
        return necesidadesTermicas;
    }

    public void setNecesidadesTermicas(NecesidadesTermicas necesidadesTermicas) {
        this.necesidadesTermicas = necesidadesTermicas;
    }

    public NecesidadesFertilizacion getNecesidadesFertilizacion() {
        return necesidadesFertilizacion;
    }

    public void setNecesidadesFertilizacion(NecesidadesFertilizacion necesidadesFertilizacion) {
        this.necesidadesFertilizacion = necesidadesFertilizacion;
    }

    public Problemas getProblemas() {
        return problemas;
    }

    public void setProblemas(Problemas problemas) {
        this.problemas = problemas;
    }

    public Tareas getTareas() {
        return tareas;
    }

    public void setTareas(Tareas tareas) {
        this.tareas = tareas;
    }

    public String getFecha_siembra() {
        return fecha_siembra;
    }

    public void setFecha_siembra(String fecha_siembra) {
        this.fecha_siembra = fecha_siembra;
    }

    public String getFecha_trasplante() {
        return fecha_trasplante;
    }

    public void setFecha_trasplante(String fecha_trasplante) {
        this.fecha_trasplante = fecha_trasplante;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}
