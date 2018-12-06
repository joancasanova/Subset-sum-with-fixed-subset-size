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
     *  Muestra una ayuda y la sintaxis del comando
     */
    private void imprimirHelp(){
        System.out.println();
        System.out.println("SINTAXIS: suma [-t] [-h] [fichero_entrada] [fichero_salida]");
        System.out.println("___________________________________________________________");
        System.out.println("ARGUMENTOS:");
        System.out.println("-t                   Traza la seleccion de subconjuntos");
        System.out.println("-h                   Muestra esta ayuda");
        System.out.println("fichero_entrada      Nombre del fichero de entrada");
        System.out.println("fichero_salida       Nombre del fichero de salida");
        System.out.println();
    }

    /**
     * Traza cada paso de manera que se describa la aplicación del algoritmo utilizado
     */
    private void imprimirT(){
        System.out.println();
        System.out.println("T:");
        System.out.println("tttttttttttttttttttttttt");
        System.out.println();
    }

    /**
     * Imprime en pantalla la solucion del problema
     *
     * @param solucion  Array de subconjuntos de enteros por los que se ha dividido el conjunto inicial
     */
    private void imprimirSolucion(ArrayList<int[]> solucion){
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
