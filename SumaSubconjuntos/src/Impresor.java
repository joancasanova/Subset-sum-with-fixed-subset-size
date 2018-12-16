import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Encargado de imprimir en pantalla o de crear un archivo de impresion
 *
 * @author Juan Francisco Casanova Ferrer
 */
final class Impresor {

    /**
     * Muestra una ayuda y la sintaxis del comando
     */
    static void imprimirHelp() {
        System.out.println();
        System.out.println("_______________________________________________________________________");
        System.out.println("DESCRIPCION:");
        System.out.println("Dado un conjunto A de n numeros enteros y dos valores enteros, m y c,");
        System.out.println("donde m < n. Calcula todos los subconjuntos de A, de m elementos, que");
        System.out.println("la suma de sus valores sea c.");
        System.out.println("_______________________________________________________________________");
        System.out.println("SINTAXIS:");
        System.out.println("java suma [-t] [-h] [fichero_entrada] [fichero_salida]");
        System.out.println("_______________________________________________________________________");
        System.out.println("ARGUMENTOS:");
        System.out.println("-t                          Traza la seleccion de subconjuntos");
        System.out.println("-h                          Muestra esta ayuda");
        System.out.println("fichero_entrada             Nombre del fichero de entrada");
        System.out.println("fichero_salida              Nombre del fichero de salida");
        System.out.println("_______________________________________________________________________");
        System.out.println("FORMATO ENTRADA:");
        System.out.println("El fichero de datos de entrada consta de: ");
        System.out.println("    - Una linea con los valores del conjunto A, separados por espacios");
        System.out.println("    - Una segunda linea que indica el valor del parametro m");
        System.out.println("    - Una tercera linea con el valor del parametro c");
        System.out.println();
        System.out.println("En el caso de que no se encuentre un fichero de entrada o");
        System.out.println("el formato de los datos sea incorrecto, se procedera a");
        System.out.println("usar la entrada por consola.");
        System.out.println("___________________________________________________________");
        System.out.println("AUTOR: Juan Francisco Casanova Ferrer");
        System.out.println("Programacion y estructuras de datos avanzadas");
        System.out.println("Practica 1 - 2018/19");
        System.out.println("U.N.E.D.");
        System.out.println();
    }

    /**
     * Imprime en pantalla la solucion del problema
     *
     * @param solucion Array de subconjuntos de enteros por los que se ha dividido el conjunto inicial
     */
    static void imprimirSolucion(List<int[]> solucion) {
        System.out.println();
        System.out.println("_______________________________________________________________________");
        System.out.println("SOLUCION:");
        for (int[] conjunto : solucion) {
            for (Integer numero : conjunto) {
                System.out.print(numero + "  ");
            }
            System.out.println();
        }
    }

    /**
     * Genera un archivo que contiene los datos de la solucion
     * En el caso de que el archivo ya exista, dara un error
     *
     * @param archivoSalida Archivo donde se almacenara la solucion
     * @param solucion      Array de subconjuntos de enteros por los que se ha dividido el conjunto inicial
     */
    static void archivoSalida(String archivoSalida, List<int[]> solucion) throws IOException {
        ArrayList<String> filas = new ArrayList<>();
        for (int[] conjunto : solucion) {
            String fila = "";
            for (Integer numero : conjunto) {
                fila = fila + numero + "  ";
            }
            filas.add(fila);
        }
        Path file = Paths.get(archivoSalida);
        Files.write(file, filas, Charset.forName("UTF-8"));
    }
}
