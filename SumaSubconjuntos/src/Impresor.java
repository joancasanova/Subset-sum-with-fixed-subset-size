import java.util.List;

/**
 * Imprime en pantalla
 *
 * @author Juan Francisco Casanova Ferrer
 */
class Impresor {

    /**
     * Muestra una ayuda y la sintaxis del comando
     */
    public void imprimirHelp() {
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
     * Imprime en pantalla la traza
     *
     * @param traza Lista de pasos seguidos por el algoritmo para encontrar las posibles soluciones
     */
    public void imprimirTraza(List<String> traza) {
        System.out.println();
        System.out.println("_______________________________________________________________________");
        System.out.println("INICIO DEL ALGORITMO:");
        for (String string : traza) {
            System.out.println(string);
        }
    }

    /**
     * Imprime en pantalla la solucion del problema
     *
     * @param solucion Array de subconjuntos de enteros por los que se ha dividido el conjunto inicial
     */
    public void imprimirSolucion(List<int[]> solucion) {
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
}
