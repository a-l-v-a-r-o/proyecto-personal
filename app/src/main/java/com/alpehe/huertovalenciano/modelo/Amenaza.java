package com.alpehe.huertovalenciano.modelo;

public class Amenaza {

    private TipoAmenaza tipoAmenaza;
    private String descripcionAmenaza;

    public Amenaza(){
        tipoAmenaza = TipoAmenaza.OTROS;
        descripcionAmenaza = "";
    }

    public Amenaza(TipoAmenaza tipoAmenaza, String descripcionAmenaza) {
        this.tipoAmenaza = tipoAmenaza;
        this.descripcionAmenaza = descripcionAmenaza;
    }

    @Override
    public String toString() {
        return "Amenaza{" +
                "tipoAmenaza=" + tipoAmenaza +
                ", descripcionAmenaza='" + descripcionAmenaza + '\'' +
                '}';
    }

    public TipoAmenaza getTipoAmenaza() {
        return tipoAmenaza;
    }

    public void setTipoAmenaza(TipoAmenaza tipoAmenaza) {
        this.tipoAmenaza = tipoAmenaza;
    }

    public String getDescripcionAmenaza() {
        return descripcionAmenaza;
    }

    public void setDescripcionAmenaza(String descripcionAmenaza) {
        this.descripcionAmenaza = descripcionAmenaza;
    }
}
