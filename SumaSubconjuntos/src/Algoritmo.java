import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase que contiene el algoritmo que calcula el resultado del problema de la Practica 1 de Programacion y Estructuras
 * de Datos Avanzadas del curso 2018-2019 por la U.N.E.D.
 *
 * @author Juan Francisco Casanova Ferrer
 */
class Algoritmo {
    private List<Integer> conjuntoA;
    private int m;
    private int c;
    private int i;
    private List<int[]> solucion; // Lista que contiene todos los subconjuntos que forman parte de la solucion.

    /**
     * @param conjuntoA Conjunto inicial de entrada
     * @param m         Tamaño de cada subconjunto
     * @param c         Suma objetivo para los subconjuntos
     */
    Algoritmo(List<Integer> conjuntoA, int m, int c, boolean traza) {
        this.conjuntoA = conjuntoA;
        this.m = m;
        this.c = c;
        solucion = new ArrayList<>();
        i = 0;

        // Antes de inicial el calculo, debemos ordenar el conjunto inicial o podría producir resultados erroneos al
        // introducir numeros negativos
        Collections.sort(conjuntoA);

        // Inicio del calculo.
        subconjuntosSumaDada(0, new int[m], 0, 0, traza);

        System.out.println(i);
    }

    /**
     * Algoritmo que toma el equema de vuelta atras
     *
     * @param k           Indice para explorar el conjunto inicial A
     * @param subconjunto Array donde se guardan los elementos candidatos a formar una solucion
     * @param nivel       Corresponde con el numero de sumandos guardados en el subconjunto candidato a ser solucion
     * @param suma        Almacena la suma de los valores guardados en el subconjunto candidato
     */
    private void subconjuntosSumaDada(int k, int[] subconjunto, int nivel, int suma, boolean traza) {


        // Si hemos alcanzado el ultimo nivel / Si hemos alcanzado el maximo numero de sumandos
        if (nivel == m) {
            i++;

            if (traza) {
                System.out.println();
                System.out.println("Sumandos: " + nivel + " -- Numero maximo de sumandos alcanzado!");
            }

            // Y si la suma es igual a c
            if (suma == c) {

                // Añadimos el valor del subconjunto a la solucion
                solucion.add(subconjunto.clone());

                if (traza) {
                    System.out.println("Suma del subconjunto (" + suma + ") = suma objetivo (" + c + ")!");
                    System.out.println("Se anexa el subconjunto a la solucion!");
                }
            }
        }
        else {

            // Mientras haya opciones por explorar
            while (k < conjuntoA.size()) {
                i++;
                if (traza) {
                    System.out.println();
                    System.out.println("Valor k: " + k);
                    System.out.println("Sumandos: " + nivel);
                    System.out.println("Se anexa " + conjuntoA.get(k) + " al subconjunto candidato");
                }

                // Asignamos el primer elemento k conjunto al subconjunto candidato en la posicion del nivel actual
                subconjunto[nivel] = conjuntoA.get(k);

                // Comprueba si se ha superado la suma objetivo
                if (suma + conjuntoA.get(k) <= c) {

                    // Invocamos de nuevo el algoritmo con las variables actualizadas para el siguiente nivel
                    subconjuntosSumaDada(k + 1, subconjunto, nivel + 1, suma + conjuntoA.get(k), traza);
                }

                k++;
            }
        }
    }

    // Getter solucion: subconjuntos obtenidos por el algoritmo
    List<int[]> getSolucion() {
        return solucion;
    }
}