import java.util.ArrayList;

public class Algoritmo {
    private int m;
    private int c;
    private int n;
    private int[] subconjunto;
    private int sumaSubconjunto;
    private ArrayList<Integer> pendientes;
    private ArrayList<Integer> provisional;
    private ArrayList<int[]> solucion;

    public ArrayList<int[]> getSolucion() {
        return solucion;
    }

    public Algoritmo(ArrayList<Integer> listaInicial, int m, int c) {
        this.m = m;
        this.c = c;
        subconjunto = new int[m];
        solucion = new ArrayList<>();
        pendientes = listaInicial;

        while(!pendientes.isEmpty()) {
            sumaSubconjunto = 0;
            n = pendientes.size() - 1;
            int contadorM = 2;
            int indexElegido = 0;
            ArrayList<Integer> indexElegidos = new ArrayList<>();

            while (n >= 0) {
                if (pendientes.get(n) < c - m + 1) {
                    subconjunto[0] = pendientes.get(n);
                    sumaSubconjunto = pendientes.get(n);
                    pendientes.remove(n);
                    n--;
                    break;
                }
                pendientes.remove(n);
                n--;
            }
            if (n == -1) {
                break; // Fin del programa, no hay ningun valor con el que se pueda formar un subconjunto que cumpla las condiciones
            }

            provisional = pendientes;

            while (contadorM < m && provisional.size() > 1) { // Desde la segunda posicion del subconjunto a la penultima

                if (sumaSubconjunto + provisional.get(0) < c - m + contadorM) { // Si la suma de los valores elegidos es viable
                    subconjunto[contadorM-1] = provisional.get(0); // Asignamos a la posicion emesima el valor correspondiente
                    sumaSubconjunto = sumaSubconjunto + provisional.get(0); // Actualizamos sumaSubconjuntos
                    indexElegidos.add(indexElegido);
                    provisional.remove(0);
                    indexElegido++;
                    contadorM++;
                }
                else {
                    provisional.remove(0);
                    indexElegido++;
                }
            }

            if (contadorM < m) {
                continue;
            }

            if (contadorM == m) {
                while (!provisional.isEmpty()) {
                    if (sumaSubconjunto + provisional.get(0) == c) {
                        subconjunto[m-1] = provisional.get(0);
                        indexElegidos.add(indexElegido);
                        for (int a : indexElegidos) {
                            pendientes.remove(a);
                        }
                        int k = 0;
                        int[] subSolucion = new int[m];
                        for (Integer numeroSolucion : subconjunto) {
                            subSolucion[k] = numeroSolucion;
                            k++;
                        }
                        solucion.add(subSolucion);
                        break;
                    }
                    provisional.remove(0);
                    indexElegido++;
                }
            }
        }
    }
}
