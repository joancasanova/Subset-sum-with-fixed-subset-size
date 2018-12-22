import java.util.ArrayList;
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
        subconjuntosSumaDada(conjuntoA, 0, new int[m], 0, 0, traza);
    }

    /**
     * Algoritmo que toma el equema de vuelta atras
     *
     * @param conjunto    Conjunto de entrada
     * @param subconjunto Array donde se guardan los elementos candidatos a formar una solucion
     * @param nivel       Corresponde con el numero de sumandos guardados en el subconjunto candidato a ser solucion
     * @param suma        Almacena la suma de los valores guardados en el subconjunto candidato
     */
    private void subconjuntosSumaDada(List<Integer> conjunto, int k, int[] subconjunto, int nivel, int suma, boolean traza) {


        // Si hemos alcanzado el ultimo nivel / Si hemos alcanzado el maximo numero de sumandos
        if (nivel == m) {

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
            while (k < conjunto.size()) {

                if (traza) {
                    System.out.println();
                    System.out.println("Valor k: " + k);
                    System.out.println("Sumandos: " + nivel);
                    System.out.println("Se anexa " + conjunto.get(k) + " al subconjunto candidato");
                }

                // Asignamos el primer elemento del conjunto al subconjunto candidato en la posicion del nivel actual
                subconjunto[nivel] = conjunto.get(k);

                // Invocamos de nuevo el algoritmo con las variables actualizadas para el siguiente nivel
                subconjuntosSumaDada(conjunto, k + 1, subconjunto, nivel + 1, suma + conjunto.get(k), traza);

                k++;
            }
        }
    }

    // Getter solucion: subconjuntos obtenidos por el algoritmo
    List<int[]> getSolucion() {
        return solucion;
    }
}