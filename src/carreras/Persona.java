package carreras;

import logica.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que establece las variables de las personas que compiten
 *
 * @author Camila Urueña
 * @author Harold Gomez
 */
public class Persona extends Thread{
    Equipo equipo;
    private String nombre;
    private int posisionInicial;
    private int posicionFinal;
    private String equipo1;
    private String equipo2;
    private String equipo3;
    String morado="\033[35m"; 
    String azul="\033[36m"; 
    String verde="\033[32m";
    /**
     * Constructor de la clase que establece los siguientes parametros:
     * @param nombre variable de tipo String que captura el nombre del competidor
     * @param posisionInicial variable de tipo entero que captura la posicion inicial del competidor
     * @param posicionFinal variable de tipo entero que captura la posicion final del competidor
     * @param equipo objeto de la clase Equipo que captura a que equipo pertenece cada competidor
     */
    public Persona(String nombre, int posisionInicial, int posicionFinal, Equipo equipo) {
        this.nombre = nombre;
        this.posisionInicial = posisionInicial;
        this.posicionFinal = posicionFinal;
        this.equipo = equipo;
    }

    Persona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void run(){
        if (posisionInicial == 0) {
            cicloPersonaUno();
        } else {
            Espera();
        }
        if (posisionInicial == 30) {
            cicloPersonaDos();
        } else {
            Espera();
        }
        if (posisionInicial == 60) {
            cicloPersonaTres();
        } else {
            Espera();
        }
    }
    
    /**
     * Metodo que realiza el ciclo del competidor 1 de cada equipo
     */
    public void cicloPersonaUno(){
        while (true) {
            int pasoActual = avanzar(1);
            if (pasoActual >= 30) {
                equipo.setPosicionActualP1(30);
                synchronized (equipo) {
                    equipo.notifyAll();
                    posisionInicial = 30;
                }
                break;
            }
        }
    }
    
    /**
     * Metodo que realiza el ciclo del competidor 2 de cada equipo
     */
    public void cicloPersonaDos(){
        while (true) {
            int pasoActual = avanzar(2);
            if (pasoActual >= 60) {
                equipo.setPosicionActualP2(60);
                synchronized (equipo) {
                    equipo.notify();
                }
                break;
            }
        }
    }
    
    /**
     * Metodo que realiza el ciclo del competidor 3 de cada equipo y da por finalizada la carrera
     */
    public  void cicloPersonaTres(){
        while (true) {
            int pasoActual = avanzar(3);
            if (pasoActual >= 100) {
                equipo.setPosicionActualP3(100);
                if(equipo.getNombre().equals("VER")){
                    equipo.setNombre("AZUL");
                }else if(equipo.getNombre().equals("LIL")){
                    equipo.setNombre("LILA");
                }else if(equipo.getNombre().equals("AZU")){
                    equipo.setNombre("VERDE");
                }
                System.out.println(equipo.getNombre()+" Llegó a la meta primero");
                Principal p = new Principal();
                p.mostrarGanador(equipo.getNombre());
                break;
            }
        }
    }
    
    /**
     * Metodo que se encarg de hacer esperar los hilos
     */
    public void Espera(){
        synchronized (equipo) {
            try {
                equipo.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Metodo que sirve para hacer que cada competidor avance y recibe como parametro el numero del atleta
     * @param numCorredor variable de tipo entero que establece el numero del competidor
     * @return int
     */
    public int avanzar(int numCorredor) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        int avance = Movimiento.random();
        if (numCorredor == 1) {
            equipo.setPosicionActualP1(equipo.getPosicionActualP1()+ avance);
            equipoPerteneciente();
            return equipo.getPosicionActualP1();
        }
        if (numCorredor == 2) {
            equipo.setPosicionActualP2(equipo.getPosicionActualP2() + avance);
            equipoPerteneciente();
            return equipo.getPosicionActualP2();
        }
        if (numCorredor == 3) {
            equipo.setPosicionActualP3(equipo.getPosicionActualP3()+ avance);
            equipoPerteneciente();
            return equipo.getPosicionActualP3();
        }
        return 0;
    }
    
    /**
     * Metodo que no recibe ningún parametro y se encarga de validar a que
     * equipo pertenece el jugador
     */
    public void equipoPerteneciente(){
        if(equipo.mostrarPosicion().contains("VER")){
            equipo1=equipo.mostrarPosicion();
            if(equipo1!=null){
                System.out.println(verde+equipo1);
            }
        }else if(equipo.mostrarPosicion().contains("LIL")){
            equipo2=equipo.mostrarPosicion();
            if(equipo2!=null){
                System.out.println(morado+equipo2);
            }
        }else if(equipo.mostrarPosicion().contains("AZU")){
            equipo3=equipo.mostrarPosicion();
            if(equipo3!=null){
                System.out.println(azul+equipo3);
            }
        }
    }
}
