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
    private String fecha_siembra_recomendada;
    private String fecha_trasplante;
    private String notas;

    public Planta() {
    }

    public Planta(String especie, String nombre, TipoVerdura tipoVerudra, NecesidadesHidricas necesidadesHidricas, NecesidadesTermicas necesidadesTermicas, NecesidadesFertilizacion necesidadesFertilizacion, Problemas problemas, Tareas tareas, String fecha_siembra_recomendada, String fecha_trasplante, String notas) {
        this.especie = especie;
        this.nombre = nombre;
        this.tipoVerudra = tipoVerudra;
        this.necesidadesHidricas = necesidadesHidricas;
        this.necesidadesTermicas = necesidadesTermicas;
        this.necesidadesFertilizacion = necesidadesFertilizacion;
        this.problemas = problemas;
        this.tareas = tareas;
        this.fecha_siembra_recomendada = fecha_siembra_recomendada;
        this.fecha_trasplante = fecha_trasplante;
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Planta{" +
                "especie='" + especie + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipoVerudra=" + tipoVerudra +
                ", necesidadesHidricas=" + necesidadesHidricas +
                ", necesidadesTermicas=" + necesidadesTermicas +
                ", necesidadesFertilizacion=" + necesidadesFertilizacion +
                ", problemas=" + problemas +
                ", tareas=" + tareas +
                ", fecha_siembra_recomendada='" + fecha_siembra_recomendada + '\'' +
                ", fecha_trasplante='" + fecha_trasplante + '\'' +
                ", notas='" + notas + '\'' +
                '}';
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoVerdura getTipoVerudra() {
        return tipoVerudra;
    }

    public void setTipoVerudra(TipoVerdura tipoVerudra) {
        this.tipoVerudra = tipoVerudra;
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

    public String getFecha_siembra_recomendada() {
        return fecha_siembra_recomendada;
    }

    public void setFecha_siembra_recomendada(String fecha_siembra_recomendada) {
        this.fecha_siembra_recomendada = fecha_siembra_recomendada;
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

    /*String dateStr = "04/05/2010";

    SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
    Date dateObj = curFormater.parse(dateStr);
    SimpleDateFormat postFormater = new SimpleDateFormat("MMMM dd, yyyy");

    String newDateStr = postFormater.format(dateObj);*/

    /*Date c = Calendar.getInstance().getTime();
System.out.println("Current time => " + c);
    SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
    String formattedDate = df.format(c);*/
}
