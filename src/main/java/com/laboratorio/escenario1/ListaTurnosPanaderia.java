package com.laboratorio.escenario1;

public class ListaTurnosPanaderia {
    private NodoCliente cabeza;
    private NodoCliente cola;

    public ListaTurnosPanaderia() {
        cabeza = null;
        cola = null;
    }

    // agregar cliente al final
    public void agregar(String nombre) {
        NodoCliente nuevo = new NodoCliente(nombre);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
        }
    }

    // eliminar (atender) al primer cliente
    public String eliminar() {
        if (cabeza == null) {
            return null;
        }

        String atendido = cabeza.nombre;
        cabeza = cabeza.siguiente;

        if (cabeza == null) {
            cola = null;
        }

        return atendido;
    }

    // buscar cliente por nombre
    public boolean buscar(String nombre) {
        NodoCliente actual = cabeza;

        while (actual != null) {
            if (actual.nombre.equalsIgnoreCase(nombre)) {
                return true;
            }
            actual = actual.siguiente;
        }

        return false;
    }

    // mostrar turnos
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("No hay clientes en espera.");
            return;
        }

        NodoCliente actual = cabeza;
        System.out.print("Turnos actuales: ");

        while (actual != null) {
            System.out.print(actual.nombre);
            if (actual.siguiente != null) {
                System.out.print(" -> ");
            }
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // consultar siguiente cliente
    public String siguienteCliente() {
        if (cabeza == null) {
            return null;
        }
        return cabeza.nombre;
    }
}