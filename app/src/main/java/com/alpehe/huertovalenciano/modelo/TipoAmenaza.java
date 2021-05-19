package com.alpehe.huertovalenciano.modelo;

public enum TipoAmenaza {
    OTROS("Otros"),
    HOJA ("Hoja"),
    TALLO ("Tallo"),
    INFLORESCENCIA ("Inflorescencia "),
    FRUTO ("Fruto"),
    BULBO ("Bulbo"),
    SEMILLA ("Semilla "),
    RAIZ("Raíz"),
    TUBERCULO ("Tubérculo"),
    CORNO("Cormo"),
    RIZOMA ("Rizoma");

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
