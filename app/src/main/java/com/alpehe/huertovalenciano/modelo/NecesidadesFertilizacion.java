package com.alpehe.huertovalenciano.modelo;

public enum NecesidadesFertilizacion {

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
