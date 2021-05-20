package com.alpehe.huertovalenciano.modelo;

public class Planta {

    private String especie;
    private String nombre;
    private TipoVerdura tipoVerudra;
    private NecesidadesHidricas necesidadesHidricas;
    private NecesidadesTermicas necesidadesTermicas;
    private NecesidadesFertilizacion necesidadesFertilizacion;
    private Amenaza amenaza;
    private Tareas tareas;
    private String fecha_siembra_recomendada;
    private String fecha_cosecha;
    private String notas;

    public Planta() {
    }

    public Planta(String especie, String nombre, TipoVerdura tipoVerudra, NecesidadesHidricas necesidadesHidricas, NecesidadesTermicas necesidadesTermicas, NecesidadesFertilizacion necesidadesFertilizacion, Amenaza amenaza, Tareas tareas, String fecha_siembra_recomendada, String fecha_trasplante, String notas) {
        this.especie = especie;
        this.nombre = nombre;
        this.tipoVerudra = tipoVerudra;
        this.necesidadesHidricas = necesidadesHidricas;
        this.necesidadesTermicas = necesidadesTermicas;
        this.necesidadesFertilizacion = necesidadesFertilizacion;
        this.amenaza = amenaza;
        this.tareas = tareas;
        this.fecha_siembra_recomendada = fecha_siembra_recomendada;
        this.fecha_cosecha = fecha_trasplante;
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
                ", amenaza=" + amenaza +
                ", tareas=" + tareas +
                ", fecha_siembra_recomendada='" + fecha_siembra_recomendada + '\'' +
                ", fecha_trasplante='" + fecha_cosecha + '\'' +
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

    public Amenaza getAmenaza() {
        return amenaza;
    }

    public void setAmenaza(Amenaza amenaza) {
        this.amenaza = amenaza;
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

    public String getFecha_cosecha() {
        return fecha_cosecha;
    }

    public void setFecha_cosecha(String fecha_cosecha) {
        this.fecha_cosecha = fecha_cosecha;
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
