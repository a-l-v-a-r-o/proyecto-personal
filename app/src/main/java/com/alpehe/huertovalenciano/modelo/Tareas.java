package com.alpehe.huertovalenciano.modelo;

public enum Tareas {
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
    Tareas(String texto) {
        this.texto = texto;
    }
    public String getTexto() { return texto; }

    /*public static String[] getAllTexto() {
        String[] resultado = new String[Tareas.values().length];
        for (Tareas tareas : Tareas.values()) {
            resultado[tipo.ordinal()] = tareas.texto;
        }
        return resultado;
    }*/
}
