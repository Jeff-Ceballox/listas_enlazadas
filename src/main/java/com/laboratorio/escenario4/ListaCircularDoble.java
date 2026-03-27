package com.laboratorio.escenario4;

public class ListaCircularDoble<T> {
    private NodoDoble<T> cabeza;

    public ListaCircularDoble() {
        this.cabeza = null;
    }

    // Agregar un jugador al final de la mesa
    public void agregar(T dato) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            // Se apunta a sí mismo en ambas direcciones
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            // El último nodo actual es el anterior a la cabeza
            NodoDoble<T> ultimo = cabeza.getAnterior();

            // Conectamos el último con el nuevo
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);

            // Conectamos el nuevo con la cabeza para cerrar el ciclo
            nuevoNodo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevoNodo);
        }
    }

    // Buscar si un jugador está en la partida
    public boolean buscar(T dato) {
        if (cabeza == null) return false;

        NodoDoble<T> actual = cabeza;
        do {
            if (actual.getDato().equals(dato)) {
                return true;
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);

        return false;
    }

    // Expulsar a un jugador en mitad de la partida
    public void eliminar(T dato) {
        if (cabeza == null) return;

        NodoDoble<T> actual = cabeza;

        do {
            if (actual.getDato().equals(dato)) {
                // Si es el único jugador en la mesa
                if (actual.getSiguiente() == actual) {
                    cabeza = null;
                } else {
                    // Desconectamos el nodo actual enlazando su anterior con su siguiente
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());

                    // Si eliminamos la cabeza, la movemos al siguiente
                    if (actual == cabeza) {
                        cabeza = actual.getSiguiente();
                    }
                }
                return; // Jugador eliminado, salimos
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);
    }

    // Consultar quién jugó antes y quién juega después
    public void consultarVecinos(T dato) {
        if (cabeza == null) return;

        NodoDoble<T> actual = cabeza;
        do {
            if (actual.getDato().equals(dato)) {
                System.out.println("Jugador actual: " + actual.getDato());
                System.out.println("Jugó antes: " + actual.getAnterior().getDato());
                System.out.println("Juega después: " + actual.getSiguiente().getDato());
                return;
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);

        System.out.println("El jugador no está en la partida.");
    }

    // Mostrar el estado actual de la mesa
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La partida no tiene jugadores.");
            return;
        }

        NodoDoble<T> actual = cabeza;
        System.out.print("Sentados en la mesa: ");
        do {
            System.out.print(actual.getDato() + " <-> ");
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        
        System.out.println("(vuelve a " + cabeza.getDato() + ")");
    }
}