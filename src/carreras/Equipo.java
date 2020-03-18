package carreras;

import java.util.Date;

/**
 * Clase que establece las variables para Equipo y la posición de los corredores
 * @author Camila Urueña
 * @author Harold Gomez
 */
public class Equipo {
    private String nombre;
    private Date termina;
    private int posicion;
    private int posicionActualP1;
    private int posicionActualP2;
    private int posicionActualP3;
    
    /**
     * Constructor de la clase Equipo
     * @param nombre variable que establece el nombre del equipo
     */
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.posicionActualP1=0;
        this.posicionActualP2=30;
        this.posicionActualP3=60;
        termina = null;
    }
    /**
     * Esta clase se encarga de pintar en pantalla como va cada equipo con su 
     * respectiva posicion.
     * @return void
     */
    public synchronized String mostrarPosicion(){
        String posicion="";
        posicion = "EQUIPO "+nombre+" ";
        for (int i = 0; i <= 100; i++) {
            if (i == posicionActualP1) {
                posicion += "x";
            } else if (i == posicionActualP2) {
                posicion += "o";
            } else if (i == posicionActualP3) {
                posicion += "n";
            } else {
                posicion += "_";
            }
        } 
        return posicion;
    }

  /**
     * Metodos
     * get y set 
     */   
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosicionActualP1() {
        return posicionActualP1;
    }

    public void setPosicionActualP1(int posicionActualP1) {
        this.posicionActualP1 = posicionActualP1;
    }

    public int getPosicionActualP2() {
        return posicionActualP2;
    }

    public void setPosicionActualP2(int posicionActualP2) {
        this.posicionActualP2 = posicionActualP2;
    }

    public int getPosicionActualP3() {
        return posicionActualP3;
    }

    public void setPosicionActualP3(int posicionActualP3) {
        this.posicionActualP3 = posicionActualP3;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Date getTermino() {
        return termina;
    }

    public void setTermino(Date termino) {
        this.termina = termino;
    }
    
}
