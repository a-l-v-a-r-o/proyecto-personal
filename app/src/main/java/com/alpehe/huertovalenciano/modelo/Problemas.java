package com.alpehe.huertovalenciano.modelo;

public enum Problemas {

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
    Problemas(String texto) {
        this.texto = texto;
    }
    public String getTexto() { return texto; }

    /*public static String[] getAllTexto() {
        String[] resultado = new String[Problemas.values().length];
        for (Problemas problemas : Problemas.values()) {
            resultado[tipo.ordinal()] = problemas.texto;
        }
        return resultado;
    }*/

}
