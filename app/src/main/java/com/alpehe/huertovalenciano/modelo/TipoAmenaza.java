package com.alpehe.huertovalenciano.modelo;

public enum TipoAmenaza {
    OTROS("Otros"),
    ;

    private final String texto;
    TipoAmenaza(String texto) {
        this.texto = texto;
    }
    public String getTexto() { return texto; }

    /*public static String[] getAllTexto() {
        String[] resultado = new String[TipoVerdura.values().length];
        for (TipoVerdura tipo : TipoVerdura.values()) {
            resultado[tipo.ordinal()] = tipo.texto;
        }
        return resultado;
    }*/
}
