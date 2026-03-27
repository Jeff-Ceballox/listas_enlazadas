package com.laboratorio.escenario1;

public class NodoCliente {
    String nombre;
    NodoCliente siguiente;

    public NodoCliente(String nombre) {
        this.nombre = nombre;
        this.siguiente = null;
    }
}