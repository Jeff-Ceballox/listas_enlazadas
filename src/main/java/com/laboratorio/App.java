package com.laboratorio;

import com.laboratorio.escenario1.ListaTurnosPanaderia;
import com.laboratorio.escenario2.HistorialNavegacion;
import com.laboratorio.escenario3.ListaCircularSimple;
import com.laboratorio.escenario4.ListaCircularDoble;

public class App {
    public static void main(String[] args) {
        System.out.println("LABORATORIO: LISTAS ENLAZADAS \n");

        /* ---------------------------------------------------------
         * ESCENARIO 1: Sistema de turnos en panadería
         * Usa: ListaTurnosPanaderia (Lista simplemente enlazada)
         * --------------------------------------------------------- */
        System.out.println("--- ESCENARIO 1: Panadería ---");
        ListaTurnosPanaderia filaPanaderia = new ListaTurnosPanaderia();
        
        filaPanaderia.agregar("Ana");
        filaPanaderia.agregar("Carlos");
        filaPanaderia.agregar("Beatriz");
        
        filaPanaderia.mostrar(); // Turnos actuales: Ana -> Carlos -> Beatriz
        
        System.out.println("Siguiente en la fila: " + filaPanaderia.siguienteCliente());
        System.out.println("Atendiendo a: " + filaPanaderia.eliminar()); // Elimina a Ana
        
        filaPanaderia.mostrar(); // Turnos actuales: Carlos -> Beatriz
        System.out.println();


        /* ---------------------------------------------------------
         * ESCENARIO 2: Historial del navegador
         * Usa: HistorialNavegacion (Lista doblemente enlazada)
         * --------------------------------------------------------- */
        System.out.println("ESCENARIO 2: Historial del Navegador");
        HistorialNavegacion historial = new HistorialNavegacion();
        
        historial.agregar("www.google.com");
        historial.agregar("www.github.com/Jeff-Ceballox");
        historial.agregar("www.stackoverflow.com");
        
        System.out.println("Navegación inicial:");
        historial.mostrar(); // Muestra el historial con corchetes en la página actual
        
        System.out.println("\nSimulando botón 'Atrás' (retroceder):");
        historial.eliminar(); // Tu método eliminar() actúa como retroceder
        historial.mostrar(); 
        System.out.println("Página actual: " + historial.paginaActual());

        System.out.println("\nVisitando una nueva página (borra el futuro):");
        historial.agregar("www.youtube.com");
        historial.mostrar();
        System.out.println();


        /* ---------------------------------------------------------
         * ESCENARIO 3: Lista de reproducción continua
         * Usa: ListaCircularSimple<T>
         * --------------------------------------------------------- */
        System.out.println("ESCENARIO 3: Reproductor de Música");
        ListaCircularSimple<String> playlist = new ListaCircularSimple<>();
        
        playlist.agregar("Canción 1: Bohemian Rhapsody");
        playlist.agregar("Canción 2: Hotel California");
        playlist.agregar("Canción 3: Stairway to Heaven");
        
        playlist.mostrar();
        
        System.out.println("Eliminando 'Canción 2'...");
        playlist.eliminar("Canción 2: Hotel California");
        playlist.mostrar(); 
        System.out.println();


        /* ---------------------------------------------------------
         * ESCENARIO 4: Juego por turnos
         * Usa: ListaCircularDoble<T>
         * --------------------------------------------------------- */
        System.out.println("ESCENARIO 4: Mesa de Juego Virtual ");
        ListaCircularDoble<String> partida = new ListaCircularDoble<>();
        
        partida.agregar("Jugador 1: Jeff");
        partida.agregar("Jugador 2: Mario");
        partida.agregar("Jugador 3: Luigi");
        partida.agregar("Jugador 4: Bowser");
        
        partida.mostrar();
        
        System.out.println("\nConsultando vecinos de Mario:");
        partida.consultarVecinos("Jugador 2: Mario");
        
        System.out.println("\nExpulsando a Luigi por desconexión...");
        partida.eliminar("Jugador 3: Luigi");
        partida.mostrar();
        
        System.out.println("\nConsultando vecinos de Bowser (ciclo cerrado):");
        partida.consultarVecinos("Jugador 4: Bowser"); 
        
    }
}