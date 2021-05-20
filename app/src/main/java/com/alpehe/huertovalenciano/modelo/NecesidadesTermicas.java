package com.alpehe.huertovalenciano.modelo;

public enum NecesidadesTermicas {

    OTROS("Otros"),
    ;

    private final String texto;
    NecesidadesTermicas(String texto) {
        this.texto = texto;
    }
    public String getTexto() { return texto; }

    /*public static String[] getAllTexto() {
        String[] resultado = new String[NecesidadesTermicas.values().length];
        for (NecesidadesTermicas nt : NecesidadesTermicas.values()) {
            resultado[tipo.ordinal()] = nt.texto;
        }
        return resultado;
    }*/

}
