package com.alpehe.huertovalenciano.modelo;

public enum NecesidadesFertilizacion {

    OTROS("Otros"),

    ;

    private final String texto;
    NecesidadesFertilizacion(String texto) {
        this.texto = texto;
    }
    public String getTexto() { return texto; }

    /*public static String[] getAllTexto() {
        String[] resultado = new String[NecesidadesFertilizacion.values().length];
        for (NecesidadesFertilizacion nf : NecesidadesFertilizacion.values()) {
            resultado[tipo.ordinal()] = nf.texto;
        }
        return resultado;
    }*/

}
