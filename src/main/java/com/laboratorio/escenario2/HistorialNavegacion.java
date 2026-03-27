package com.laboratorio.escenario2;

public class HistorialNavegacion {
    private NodoPagina cabeza;
    private NodoPagina actual;

    public HistorialNavegacion() {
        cabeza = null;
        actual = null;
    }

    // visitar nueva página
    public void agregar(String url) {
        NodoPagina nueva = new NodoPagina(url);

        if (cabeza == null) {
            cabeza = nueva;
            actual = nueva;
            return;
        }

        // eliminar páginas futuras si existen
        if (actual.siguiente != null) {
            NodoPagina temp = actual.siguiente;
            while (temp != null) {
                NodoPagina siguiente = temp.siguiente;
                temp.anterior = null;
                temp.siguiente = null;
                temp = siguiente;
            }
            actual.siguiente = null;
        }

        actual.siguiente = nueva;
        nueva.anterior = actual;
        actual = nueva;
    }

    // retroceder
    public boolean eliminar() {
        if (actual != null && actual.anterior != null) {
            actual = actual.anterior;
            return true;
        }
        return false;
    }

    // avanzar
    public boolean avanzar() {
        if (actual != null && actual.siguiente != null) {
            actual = actual.siguiente;
            return true;
        }
        return false;
    }

    // buscar página en el historial
    public boolean buscar(String url) {
        NodoPagina temp = cabeza;

        while (temp != null) {
            if (temp.url.equalsIgnoreCase(url)) {
                return true;
            }
            temp = temp.siguiente;
        }

        return false;
    }

    // mostrar historial completo
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("Historial vacío.");
            return;
        }

        NodoPagina temp = cabeza;
        System.out.print("Historial: ");

        while (temp != null) {
            if (temp == actual) {
                System.out.print("[" + temp.url + "]");
            } else {
                System.out.print(temp.url);
            }

            if (temp.siguiente != null) {
                System.out.print(" <-> ");
            }

            temp = temp.siguiente;
        }
        System.out.println();
    }

    // mostrar página actual
    public String paginaActual() {
        return (actual != null) ? actual.url : null;
    }
}