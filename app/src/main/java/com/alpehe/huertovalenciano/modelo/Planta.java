package com.alpehe.huertovalenciano.modelo;

public class Planta {

    private String especie;
    private String nombre;
    private TipoVerdura tipoVerudra;
    private NecesidadesHidricas necesidadesHidricas;
    private NecesidadesTermicas necesidadesTermicas;
    private NecesidadesFertilizacion necesidadesFertilizacion;
    private Problemas problemas;
    private Tareas tareas;
    private String notas;

    public Planta(String especie, String nombre, TipoVerdura tipoVerudra, NecesidadesHidricas necesidadesHidricas, NecesidadesTermicas necesidadesTermicas, NecesidadesFertilizacion necesidadesFertilizacion, Problemas problemas, Tareas tareas, String notas) {
        this.especie = especie;
        this.nombre = nombre;
        this.tipoVerudra = tipoVerudra;
        this.necesidadesHidricas = necesidadesHidricas;
        this.necesidadesTermicas = necesidadesTermicas;
        this.necesidadesFertilizacion = necesidadesFertilizacion;
        this.problemas = problemas;
        this.tareas = tareas;
        this.notas = notas;
    }
}
