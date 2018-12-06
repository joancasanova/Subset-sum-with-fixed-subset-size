import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Datos de entrada para el algoritmo de Suma de Subconjuntos
 *
 * @author Juan Francisco Casanova Ferrer
 */
class Datos {
    private ArrayList<Integer> conjuntoA;
    private int m;
    private int c;

    /**
     * Constructor indicado cuando no se encuentra un archivo de entrada de datos
     */
    Datos() {
        System.out.println("No hemos encontrado un archivo de entrada, utilizaremos la entrada datos por defecto.");
        datosPorDefecto();
    }

    /**
     * Constructor indicado para analizar y asignar los datos del problema a cada variable correspondiente
     *
     * @param archivoEntrada  Archivo en el que se encuentran los datos
     * @throws IOException    En el caso de que no se encuentre el archivo
     */
    Datos(String archivoEntrada) throws IOException {
        setDatos(archivoEntrada);
    }

    // Getter A: conjunto de entrada A
    ArrayList<Integer> getConjuntoA() {
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

    /**
     * Lee el archivo de entrada y guarda los datos en las correspondientes variables
     *
     * @param archivoEntrada  Archivo de entrada de datos
     * @throws IOException    Si no se encuentra el archivo o está vacío
     */
    private void setDatos(String archivoEntrada) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
        ArrayList<ArrayList<Integer>> datos = new ArrayList<>();
        String linea;
        int i = 0;
        while ((linea = br.readLine()) != null && i < 3) {
            String[] stringsArray = linea.split("\\s");
            ArrayList<Integer> stringsList = new ArrayList<>();
            for (String string : stringsArray) {
                try{
                    stringsList.add(Integer.parseInt(string));
                }
                catch (NumberFormatException e) {
                    System.err.println("El archivo de datos contiene elementos que no son numeros enteros. " + e);
                }
            }
            datos.add(stringsList);
            i++;
        }

        if (verificarDatos(datos)) {
            conjuntoA = datos.get(0);
            m = datos.get(1).get(0);
            c = datos.get(2).get(0);
        }
    }

    /**
     * Comprueba que los datos se ajustan al formato correcto
     *
     * @param datos  datos a comprobar
     * @return       True si los datos son conrrectos, False si son incorrectos
     */
    private boolean verificarDatos(ArrayList<ArrayList<Integer>> datos) {
        if (datos.size() < 3 || datos.get(0).size() == 0 || datos.get(1).size() != 1|| datos.get(2).size() != 1
                || datos.get(1).get(0) > datos.get(0).size()) {
            System.err.println("El formato de los datos del archivo de entrada es incorrecto");
            return false;
        }
        return true;
    }

    /**
     * Asigna a los datos unos valores por defecto
     */
    private void datosPorDefecto(){
        conjuntoA = new ArrayList<>(Arrays.asList(3, 4, 6, 7));
        m = 2;
        c = 10;
    }
}