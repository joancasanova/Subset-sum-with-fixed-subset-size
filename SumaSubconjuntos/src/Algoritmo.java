import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase que contiene el algoritmo que calcula el resultado del problema de la Practica 1 de Programacion y Estructuras
 * de Datos Avanzadas del curso 2018-2019 por la U.N.E.D.
 *
 * @author Juan Francisco Casanova Ferrer
 */
class Algoritmo {
    private int m;
    private int c;
    private List<int[]> solucion; // Lista que contiene todos los subconjuntos que forman parte de la solucion.

    /**
     * @param conjuntoA Conjunto inicial de entrada
     * @param m         Tamaño de cada subconjunto
     * @param c         Suma objetivo para los subconjuntos
     */
    Algoritmo(List<Integer> conjuntoA, int m, int c, boolean traza) {
        this.m = m;
        this.c = c;
        solucion = new ArrayList<>();

        // Inicio del calculo.
        subconjuntosSumaDada(conjuntoA, new int[m], 0, 0, traza);
    }

    /**
     * Algoritmo que toma el equema de vuelta atras
     *
     * @param conjunto    Conjunto de entrada
     * @param subconjunto Array donde se guardan los elementos candidatos a formar una solucion
     * @param nivel       Corresponde con el numero de sumandos guardados en el subconjunto candidato a ser solucion
     * @param suma        Almacena la suma de los valores guardados en el subconjunto candidato
     */
    private void subconjuntosSumaDada(List<Integer> conjunto, int[] subconjunto, int nivel, int suma, boolean traza) {

        // Si no hemos alcanzado el maximo numero de sumandos permitido / Si no hemos llegado al ultimo nivel del arbol
        if (nivel < m) {

            // Mientras el conjunto contenga candidatos
            while (!conjunto.isEmpty()) {

                // Asignamos el primer elemento del conjunto al subconjunto candidato en la posicion del nivel actual
                subconjunto[nivel] = conjunto.get(0);

                if (traza) {
                    System.out.println();
                    System.out.println("Sumandos: " + nivel);
                    System.out.println("Elementos candidatos por comprobar: " + conjunto);
                    System.out.println("Se anexa " + conjunto.get(0) + " al subconjunto; Subconjunto: " + Arrays.toString(subconjunto));
                }

                // Eliminiamos el elemento seleccionado del conjunto para la siguiente iteracion
                List<Integer> conjuntoB = new ArrayList<>(conjunto.subList(1, conjunto.size()));

                // Invocamos de nuevo el algoritmo con las variables actualizadas para el siguiente nivel
                subconjuntosSumaDada(conjuntoB, subconjunto, nivel + 1, suma + conjunto.get(0), traza);

                // Eliminamos el primer elemento del conjunto, ya que hemos probado todas las posibles combinacines
                conjunto = conjunto.subList(1, conjunto.size());
            }
        }

        // Si hemos alcanzado el ultimo nivel / Si hemos alcanzado el maximo numero de sumandos
        // Y si la suma es igual a c
        if (nivel == m) {

            if (traza) {
                System.out.println();
                System.out.println("Sumandos: " + nivel + " -- Numero maximo de sumandos alcanzado!");
            }

            if (suma == c) {

                // Añadimos el valor del subconjunto a la solucion
                solucion.add(subconjunto.clone());

                if (traza) {
                    System.out.println("Suma del subconjunto (" + suma + ") = suma objetivo (" + c + ")!");
                    System.out.println("Se anexa el subconjunto a la solucion!");
                }

            } else if (traza) {
                System.out.println("Suma del subconjunto (" + suma + ") != suma objetivo (" + c + ")!");
                System.out.println("Continuamos buscando");
            }
        }
    }

    // Getter solucion: subconjuntos obtenidos por el algoritmo
    List<int[]> getSolucion() {
        return solucion;
    }
}