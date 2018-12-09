import java.util.ArrayList;

/**
 * Imprime en pantalla
 *
 * @author Juan Francisco Casanova Ferrer
 */
class Impresor {

    Impresor(boolean help, boolean traza, ArrayList<int[]> solucion) {
        if (help) {
            imprimirHelp();
        }
        if (traza) {
            imprimirT();
        }
        if (solucion != null) {
            imprimirSolucion(solucion);
        }
    }

    /**
     * Muestra una ayuda y la sintaxis del comando
     */
    private void imprimirHelp() {
        System.out.println();
        System.out.println("_______________________________________________________________________");
        System.out.println("DESCRIPCION:");
        System.out.println("Dado un conjunto A de n números enteros y dos valores enteros, m y c,");
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
        System.out.println("    - Una línea con los valores del conjunto A, separados por espacios");
        System.out.println("    - Una segunda línea que indica el valor del parámetro m");
        System.out.println("    - Una tercera línea con el valor del parámetro c");
        System.out.println();
        System.out.println("En el caso de que no se encuentre un fichero de entrada o");
        System.out.println("el formato de los datos sea incorrecto, se procederá a");
        System.out.println("usar la entrada por defecto:");
        System.out.println("A = {3, 4, 6, 7}");
        System.out.println("m = 2");
        System.out.println("c = 10");
        System.out.println("___________________________________________________________");
        System.out.println("AUTOR: Juan Francisco Casanova Ferrer");
        System.out.println("Programacion y estructuras de datos avanzadas");
        System.out.println("Practica 1 - 2018/19");
        System.out.println("U.N.E.D.");
        System.out.println();
    }

    /**
     * Traza cada paso de manera que se describa la aplicación del algoritmo utilizado
     */
    private void imprimirT() {
        System.out.println();
        System.out.println("T:");
        System.out.println("tttttttttttttttttttttttt");
        System.out.println();
    }

    /**
     * Imprime en pantalla la solucion del problema
     *
     * @param solucion Array de subconjuntos de enteros por los que se ha dividido el conjunto inicial
     */
    private void imprimirSolucion(ArrayList<int[]> solucion) {
        System.out.println();
        System.out.println("SOLUCION:");
        System.out.println("___________________________________________________________");
        for (int[] conjunto : solucion) {
            for (Integer numero : conjunto) {
                System.out.print(numero + "  ");
            }
            System.out.println();
        }
    }
}
