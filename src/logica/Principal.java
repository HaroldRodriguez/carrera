package logica;

 
import carreras.Equipo;
import carreras.Persona;

/**
 * Clase principal donde se inicializan los hilos y se muestra en pantalla el
 * ganador de la carrera. 
 *
 * @author angyc
 * 
 */


public class Principal {
    
    
   
    Equipo e1 = new Equipo("VER");
    Equipo e2 = new Equipo("LIL");
    Equipo e3 = new Equipo("AZU");
    
    Persona p1 = new Persona("Persona1", 0, 30, e1);
    Persona p2 = new Persona("Persona2", 30, 60, e1);
    Persona p3 = new Persona("Persona3", 60, 100, e1);
    Persona p4 = new Persona("Persona4", 0, 30, e2);
    Persona p5 = new Persona("Persona5", 30, 60, e2);
    Persona p6 = new Persona("Persona6", 60, 100, e2);
    Persona p7 = new Persona("Persona7", 0, 30, e3);
    Persona p8 = new Persona("Persona8", 30, 60, e3);
    Persona p9 = new Persona("Persona9", 60, 100, e3);
    
    /**
     * Metodo que inicializa los hilos de las personas que van a correr
     */
    public void iniciaCarrera(){
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
        p8.start();
        p9.start();
    }
    
    /**
     * Metodo que recibe como parametro equipo, que nos mostrará el ganador
     * @param equipo variable que captura el nombre del equipo ganador
     */
    public void mostrarGanador(String equipo){
        
        System.out.println("EL GANADOR DE LA CARRERA ES EL EQUIPO: "+equipo);
        System.exit(0);
    }
    
}
