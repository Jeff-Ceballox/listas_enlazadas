package com.laboratorio.escenario2;

public class NodoPagina {
    String url;
    NodoPagina anterior;
    NodoPagina siguiente;

    public NodoPagina(String url) {
        this.url = url;
        this.anterior = null;
        this.siguiente = null;
    }
}