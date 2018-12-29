import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Clase que contiene el algoritmo que calcula el resultado del problema de la Practica 1 de Programacion y Estructuras
 * de Datos Avanzadas del curso 2018-2019 por la U.N.E.D.
 *
 * @author Juan Francisco Casanova Ferrer
 * teléfono: 625803490
 * email:    juancasanovaferrer@gmail.com
 * Programación y Estructuras de Datos Avanzadas - UNED - Centro Asociado Las Tablas
 */
class Algoritmo {
    private List<Integer> conjunto;
    private int m;
    private int c;
    private int n;
    private boolean posicionC;
    private List<int[]> solucion; // Lista que contiene todos los subconjuntos que forman parte de la solucion.

    /**
     * @param conjunto Conjunto inicial
     * @param m        Tamaño de cada subconjunto
     * @param c        Suma objetivo para los subconjuntos
     */
    Algoritmo(List<Integer> conjunto, int m, int c, boolean traza) {
        this.conjunto = conjunto;
        this.m = m;
        this.c = c;
        n = conjunto.size();
        posicionC = evaluarC();
        solucion = new ArrayList<>();

        // Antes de inicial el calculo, debemos ordenar el conjunto o podría producir resultados con numeros negativos
        Collections.sort(conjunto);

        // Inicio del calculo.
        subconjuntosSumaDada(0, new int[m], 0, 0, n, m, -1, traza);
    }

    /**
     * Algoritmo que toma el equema de vuelta atras
     *
     * @param k     Indice para recorrer el conjunto
     * @param temp  Array donde se guardan los elementos candidatos a formar una solucion
     * @param nivel Corresponde con el numero de sumandos guardados en el subconjunto candidato a ser solucion
     * @param suma  Almacena la suma de los valores guardados en el subconjunto candidato
     * @param p     Numero de hijos de un determinado nodo
     * @param q     Numero de elementos que faltan para alcanzar el maximo numero de sumandos
     */
    private void subconjuntosSumaDada(int k, int[] temp, int nivel, int suma, int p, int q, int r, boolean traza) {

        // Si hemos alcanzado el maximo numero de sumandos
        if (nivel == m) {

            if (traza) {
                System.out.println();
                System.out.println("Sumandos: " + nivel + " -- Numero maximo de sumandos alcanzado!");
            }

            // Y si la suma es igual a c
            if (suma == c) {

                // Añadimos el valor del subconjunto a la solucion
                solucion.add(temp.clone());

                if (traza) {
                    System.out.println("Suma del subconjunto (" + suma + ") = suma objetivo (" + c + ")!");
                    System.out.println("Se anexa el subconjunto: " + Arrays.toString(temp) + " a la solucion!");
                }
            }
        } else {

            // Mientras haya ramas por explorar
            while (k <= r + p - q + 1) {

                // Asignamos el primer elemento del conjunto al subconjunto candidato en la posicion del nivel actual
                temp[nivel] = conjunto.get(k);

                if (traza) {
                    System.out.println();
                    System.out.println("Sumandos: " + nivel);
                    System.out.println("Se anexa " + temp[nivel] + " al subconjunto candidato");
                    System.out.println("Subconjunto: " + Arrays.toString(temp));
                }

                // Caso en el que c es mayor o igual al valor mínimo de A.
                if (posicionC) {

                    // Comprueba si se ha superado la suma objetivo
                    if (suma + conjunto.get(k) <= c) {

                        // Invocamos de nuevo el algoritmo con los parametros actualizados para el siguiente nivel
                        subconjuntosSumaDada(k + 1, temp, nivel + 1, suma + conjunto.get(k), n - k - 1, q - 1, k, traza);
                    }
                }

                // Caso en el que c es menor al elemento minimo de A.
                else {

                    // Comprueba si se ha superado la suma objetivo
                    if (suma + conjunto.get(k) >= c) {

                        // Invocamos de nuevo el algoritmo con los parametros actualizados para el siguiente nivel
                        subconjuntosSumaDada(k + 1, temp, nivel + 1, suma + conjunto.get(k), n - k - 1, q - 1, k, traza);
                    }
                }

                k++;
            }
        }
    }

    // Evalua si c es menor al valor mínimo del conjunto inicial
    private boolean evaluarC() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (conjunto.get(i) < min) {
                min = conjunto.get(i);
            }
        }

        return c >= min;
    }

    // Getter solucion: subconjuntos obtenidos por el algoritmo
    List<int[]> getSolucion() {
        return solucion;
    }
}