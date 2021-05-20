package com.alpehe.huertovalenciano.modelo;

public enum NecesidadesHidricas {

    OTROS("Otros"),
    ;

    private final String texto;
    NecesidadesHidricas(String texto) {
        this.texto = texto;
    }
    public String getTexto() { return texto; }

    /*public static String[] getAllTexto() {
        String[] resultado = new String[NecesidadesHidricas.values().length];
        for (NecesidadesHidricas nh : NecesidadesHidricas.values()) {
            resultado[tipo.ordinal()] = nh.texto;
        }
        return resultado;
    }*/
}
