import java.util.ArrayList;


/**
 * Clase que contiene el algoritmo que calcula el resultados del problema de la Practica 1 de Programacion y Estructuras
 * de Datos Avanzadas del curso 2018-2019 por la U.N.E.D.
 *
 * @author Juan Francisco Casanova Ferrer
 */
class Algoritmo {
    private int m;
    private int c;
    private ArrayList<int[]> solucion; // Lista que contiene todos los subconjuntos que forman parte de la solucion.

    /**
     * @param conjuntoA Conjunto inicial de entrada
     * @param m         Tamaño de cada subconjunto
     * @param c         suma objetivo para los subconjuntos
     */
    Algoritmo(ArrayList<Integer> conjuntoA, int m, int c) {
        this.m = m;
        this.c = c;
        solucion = new ArrayList<>();

        // Inicio del calculo.
        subconjuntosSumaDada(conjuntoA, new int[m], 0, 0);
    }

    /**
     * Algoritmo que toma el equema de vuelta atras
     *
     * @param conjunto    Conjunto de entrada
     * @param subconjunto Array donde se guardan los elementos candidatos a formar una solucion
     * @param nivel       Corresponde con el numero de sumandos guardados en el subconjunto candidato a ser solucion
     * @param suma        Almacena la suma de los valores guardados en el subconjunto candidato
     */
    private void subconjuntosSumaDada(ArrayList<Integer> conjunto, int[] subconjunto, int nivel, int suma) {

        // Si no hemos alcanzado el maximo numero de sumandos permitido / Si no hemos llegado al ultimo nivel del arbol
        if (nivel < m) {

            // Mientras el conjunto contenga candidatos
            while (!conjunto.isEmpty()) {

                // Asignamos el primer elemento del conjunto al subconjunto candidato en la posicion del nivel actual
                subconjunto[nivel] = conjunto.get(0);

                // Invocamos de nuevo el algoritmo para el siguiente nivel
                ArrayList<Integer> conjuntoB = new ArrayList<>(conjunto);
                conjuntoB.remove(0);
                subconjuntosSumaDada(conjuntoB, subconjunto, nivel + 1, suma + conjunto.get(0));

                // Eliminamos el primer elemento del conjunto, ya que hemos probado todas las posibles combinacines
                conjunto.remove(0);
            }
        }

        // Si hemos alcanzado el ultimo nivel / Si hemos alcanzado el maximo numero de sumandos
        if (nivel == m) {

            // Si la suma es igual a c
            if (suma == c) {

                // Añadimos el valor del subconjunto a la solucion
                solucion.add(subconjunto.clone());
            }
        }
    }

    ArrayList<int[]> getSolucion() {
        return solucion;
    }

}