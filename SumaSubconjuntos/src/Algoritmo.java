import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase que contiene el algoritmo que calcula el resultados del problema de la Practica 1 de Programacion y Estructuras
 * de InterpreteComando Avanzadas del curso 2018-2019 por la U.N.E.D.
 *
 * @author Juan Francisco Casanova Ferrer
 */
class Algoritmo {
    private int m;
    private int c;
    private List<int[]> solucion; // Lista que contiene todos los subconjuntos que forman parte de la solucion.
    private List<String> traza; // Lista que guarda la traza.

    /**
     * @param conjuntoA Conjunto inicial de entrada
     * @param m         Tamaño de cada subconjunto
     * @param c         Suma objetivo para los subconjuntos
     */
    Algoritmo(List<Integer> conjuntoA, int m, int c) {
        this.m = m;
        this.c = c;
        solucion = new ArrayList<>();
        traza = new ArrayList<>();

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
    private void subconjuntosSumaDada(List<Integer> conjunto, int[] subconjunto, int nivel, int suma) {

        // Si no hemos alcanzado el maximo numero de sumandos permitido / Si no hemos llegado al ultimo nivel del arbol
        if (nivel < m) {

            // Mientras el conjunto contenga candidatos
            while (!conjunto.isEmpty()) {

                // Asignamos el primer elemento del conjunto al subconjunto candidato en la posicion del nivel actual
                subconjunto[nivel] = conjunto.get(0);

                traza.add("");
                traza.add("Sumandos: " + nivel);
                traza.add("Elementos candidatos por comprobar: " + conjunto);
                traza.add("Se anexa " + conjunto.get(0) + " al subconjunto; Subconjunto: " + Arrays.toString(subconjunto));

                // Elminiamos el elemento seleccionado del conjunto para la siguiente iteracion
                List<Integer> conjuntoB = new ArrayList<>(conjunto.subList(1, conjunto.size()));

                // Invocamos de nuevo el algoritmo con las variables apropiadas para el siguiente nivel
                subconjuntosSumaDada(conjuntoB, subconjunto, nivel + 1, suma + conjunto.get(0));

                // Eliminamos el primer elemento del conjunto, ya que hemos probado todas las posibles combinacines
                conjunto = conjunto.subList(1, conjunto.size());

            }
        }

        // Si hemos alcanzado el ultimo nivel / Si hemos alcanzado el maximo numero de sumandos
        // Y si la suma es igual a c
        if (nivel == m) {

            traza.add("");
            traza.add("Sumandos: " + nivel + " -- Numero maximo de sumandos alcanzado!");

            if (suma == c) {

                // Añadimos el valor del subconjunto a la solucion
                solucion.add(subconjunto.clone());

                traza.add("Suma del subconjunto (" + suma + ") = suma objetivo (" + c + ")!");
                traza.add("Se anexa el subconjunto a la solucion!");

            } else {
                traza.add("Suma del subconjunto (" + suma + ") != suma objetivo (" + c + ")!");
                traza.add("Continuamos buscando");
            }
        }
    }

    // Getter solucion: subconjuntos obtenidos por el algoritmo
    List<int[]> getSolucion() {
        return solucion;
    }

    // Getter traza: pasos realizados por el algoritmo
    List<String> getTraza() {
        return traza;
    }
}