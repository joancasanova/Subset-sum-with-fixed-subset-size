import java.io.File;
import java.io.IOException;

/**
 * Clase que contiene el metodo Main del programa. Filtra los argumentos introducidos al invocar dicho metodo
 *
 * TODO: Entrada por consola, imprimir traza, archivo salida, intentar mejorar algoritmo
 * @author Juan Francisco Casanova Ferrer
 */
public class suma {

    public static void main(String[] args) throws IOException {

        // Inicializamos cada uno de los posibles argumentos admitidos
        boolean help = false;
        boolean traza = false;
        String archivoEntrada = null;
        String archivoSalida = null;

        // Asignamos el valor correspondiente a los argumentos
        for (String argumento : args) {
            if (argumento.equals("-h")) {
                help = true;
            } else if (argumento.equals("-t")) {
                traza = true;
            } else if (archivoEntrada != null) {
                archivoSalida = argumento;
                break;
            } else {
                archivoEntrada = argumento;
            }
        }

        // Parseamos los datos del archivo de entrada, invocamos al algoritmo para obtener la solucion e imprimimos
        Datos datos;
        if (archivoEntrada == null) {
            datos = new Datos();
        } else {
            File f = new File(archivoEntrada);
            if (!f.exists()) {
                datos = new Datos();
            } else {
                datos = new Datos(archivoEntrada);
            }
        }
        new Impresor(help, traza, new Algoritmo(datos.getConjuntoA(), datos.getM(), datos.getC()).getSolucion());
    }
}
