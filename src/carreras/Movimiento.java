package carreras;

/**
 * Clase genera un numero aleatorio entre 1 y 3
 *
 * @author Camila Urueña
 * @author Harold Gomez
 */
public class Movimiento {
    /**
     * Metodo que genera el numero aleatorio para que "la persona" se mueva.
     * @return int retorna el numero obtenido
     */
    public static int random(){
        int numero = (int) (Math.random() * 3) + 1;
        return numero;
    }
}
