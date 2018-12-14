import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Interprete {
    private List<Integer> conjuntoA;
    private int m;
    private int c;

    // Getter A: conjunto de entrada A
    List<Integer> getConjuntoA() {
        return conjuntoA;
    }

    // Getter m: numero de elementos en cada subconjunto
    int getM() {
        return m;
    }

    // Getter c: resultado de la suma de los elementos de cada subconjunto
    int getC() {
        return c;
    }

    boolean asignar(List<String> datos) {

        // El conjunto de entrada contiene solo numeros
        if ("[0-9 ]+$".matches(datos.get(0))) {
            conjuntoA = stringALista(datos.get(0));
        } else {
            System.err.println("El conjunto de entrada solo puede contener numeros enteros separados por espacios");
            return true;
        }

        // m es un entero positivo
        if ("\\d+".matches(datos.get(1))) {
            m = Integer.parseInt(datos.get(1));
        } else {
            System.err.println("Error: La segunda linea del archivo de entrada, correspondiente al parametro m, debe contener solo un entero positivo");
            return true;
        }

        // c es un entero
        if ("-?\\d+".matches(datos.get(2))) {
            c = Integer.parseInt(datos.get(2));
        } else {
            System.err.println("Error: La tercera linea del archivo de entrada, correspondiente al parametro c, debe contener solo un entero");
            return true;
        }

        // No hay numeros repetidos en el conjunto de entrada
        if (numRepetido(conjuntoA)) {
            System.err.println("El conjunto de entrada no puede contener numeros repetidos");
            return true;
        }

        // El numero de elementos de conjunto de entrada es mayor al valor de m
        if (m > conjuntoA.size()) {
            System.err.println("Error: El valor de m no puede ser mayor al numero de elementos en el conjunto de entrada");
            return true;
        }

        return false;
    }

    /**
     * Comprueba si hay algun numero repetido en el conjunto de entrada A
     *
     * @param conjuntoA Conjunto de entrada inicial
     * @return True si hay algun numero repetido
     */
    private boolean numRepetido(List<Integer> conjuntoA) {
        Set<Integer> set = new HashSet<>();
        for (int i : conjuntoA) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    /**
     * Retorna una lista de enteros dado un string que contiene numeros enteros separados por espacios
     *
     * @param string String de entrada
     * @return Lista de enteros
     */
    private List<Integer> stringALista(String string) {
        List<Integer> lista = new ArrayList<>();
        String[] stringsArray = string.split("\\s");
        for (String element : stringsArray) {
            lista.add(Integer.parseInt(element));
        }
        return lista;
    }
}
