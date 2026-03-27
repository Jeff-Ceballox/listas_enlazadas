package com.laboratorio.escenario3;

public class ListaCircularSimple<T> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;

    public ListaCircularSimple() {
        this.cabeza = null;
        this.cola = null;
    }

    // Agregar un elemento al final de la lista
    public void agregar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            cola.setSiguiente(cabeza); // Se cierra el ciclo
        } else {
            cola.setSiguiente(nuevoNodo);
            cola = nuevoNodo;
            cola.setSiguiente(cabeza); // El nuevo último apunta al primero
        }
    }

    // Buscar si un elemento existe en la lista
    public boolean buscar(T dato) {
        if (cabeza == null) return false;
        
        Nodo<T> actual = cabeza;
        do {
            if (actual.getDato().equals(dato)) {
                return true;
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza); // Recorremos hasta dar la vuelta completa
        
        return false;
    }

    // Eliminar la primera ocurrencia de un elemento
    public void eliminar(T dato) {
        if (cabeza == null) return;

        Nodo<T> actual = cabeza;
        Nodo<T> anterior = cola; // Iniciamos 'anterior' en la cola por si eliminamos la cabeza

        do {
            if (actual.getDato().equals(dato)) {
                // Caso 1: Hay un solo elemento en la lista
                if (cabeza == cola) {
                    cabeza = null;
                    cola = null;
                } 
                // Caso 2: El elemento a eliminar es la cabeza
                else if (actual == cabeza) {
                    cabeza = cabeza.getSiguiente();
                    cola.setSiguiente(cabeza);
                } 
                // Caso 3: El elemento a eliminar es la cola
                else if (actual == cola) {
                    anterior.setSiguiente(cabeza);
                    cola = anterior;
                } 
                // Caso 4: El elemento está en el medio
                else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
                return; // Elemento eliminado, salimos del método
            }
            anterior = actual;
            actual = actual.getSiguiente();
        } while (actual != cabeza);
    }

    // Mostrar todos los elementos de la lista
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista de reproducción está vacía.");
            return;
        }

        Nodo<T> actual = cabeza;
        System.out.print("Lista actual: ");
        do {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        
        System.out.println("(vuelve a " + cabeza.getDato() + ")");
    }
}