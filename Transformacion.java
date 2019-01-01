/**
 * Clase que representa una transformación hecha por el algoritmo
 *
 * @author Juan Francisco Casanova Ferrer
 * teléfono: 625803490
 * email:    juancasanovaferrer@gmail.com
 * Programación y Estructuras de Datos Avanzadas - UNED - Centro Asociado Las Tablas
 */
public class Transformacion {
    private String operacion;
    private int posicion;
    private char caracter;
    private String x;

    Transformacion(String operacion, int posicion, String x) {
        this.operacion = operacion;
        this.posicion = posicion;
        this.x = x;
    }

    public String getOperacion() {
        return operacion;
    }

    public int getPosicion() {
        return posicion;
    }

    public char getCaracter() {
        return caracter;
    }

    public String getX() {
        return x;
    }
}
