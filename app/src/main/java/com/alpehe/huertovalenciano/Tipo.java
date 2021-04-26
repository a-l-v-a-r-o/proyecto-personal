package com.alpehe.huertovalenciano;

public enum Tipo {
    TUBERCULO("Tuberculo");

    String tipo;
    Tipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
