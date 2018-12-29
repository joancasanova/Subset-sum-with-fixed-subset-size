import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Interprete de los datos albergados en el fichero de entrada
 *
 * @author Juan Francisco Casanova Ferrer
 * teléfono: 625803490
 * email:    juancasanovaferrer@gmail.com
 * Programación y Estructuras de Datos Avanzadas - UNED - Centro Asociado Las Tablas
 */
class Interprete {
    private List<Integer> conjuntoA;
    private int m;
    private int c;

    /**
     * Constructor indicado cuando no se encuentra un archivo de entrada de datos
     */
    Interprete() {

        System.out.println();
        System.out.println("Procedemos a la entrada de datos por consola");

        String[] datos = new String[3];
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Introducir Conjunto A | Elementos del conjunto de entrada (separados por espacios): ");
            datos[0] = scanner.nextLine();

            System.out.println("Introducir m | Numero de elementos del subconjunto: ");
            datos[1] = scanner.nextLine();

            System.out.println("Introducir c | Suma objetivo: ");
            datos[2] = scanner.nextLine();
        } while (encontrarError(datos));

        scanner.close();
    }

    /**
     * Constructor indicado cuando se cuenta con un archivo de entrada
     *
     * @param archivoEntrada Archivo en el que se encuentran los datos
     * @throws IOException En el caso de que no se encuentre el archivo
     */
    Interprete(String archivoEntrada) throws IOException {
        String[] datos = new String[3];
        BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
        int i = 0;
        String line;
        while ((line = br.readLine()) != null && i < 3) {
            datos[i] = line;
            i++;
        }

        if (encontrarError(datos)) {
            System.err.println("Error: El formato del archivo de datos de entrada no es compatible");
            System.err.println("Atencion: Corrija los errores del archivo de entrada e invoque de nuevo el programa");
            System.exit(0);
        }
    }

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

    /**
     * Verifica que los datos de entrada sean correctos
     *
     * @param datos Datos de entrada a comprobar
     * @return True si se encuentra un error en los datos
     */
    private boolean encontrarError(String[] datos) {

        // Los datos no existen
        if (datos[0] == null || datos[1] == null || datos[2] == null) {
            System.err.println("Error: Deben existir todos los datos de entrada");
            return true;
        }

        // El conjunto de entrada contiene solo numeros
        if (!datos[0].matches("(-?\\d+ *)+")) {
            System.err.println("Error: El conjunto de entrada solo puede contener numeros enteros separados por espacios");
            return true;
        }

        // m es un entero positivo
        if (!datos[1].trim().matches("\\d+")) {
            System.err.println("Error: La segunda linea del archivo de entrada, correspondiente al parametro m, debe contener solo un entero positivo");
            return true;
        }

        // c es un entero
        if (!datos[2].trim().matches("-?\\d+")) {
            System.err.println("Error: La tercera linea del archivo de entrada, correspondiente al parametro c, debe contener solo un entero");
            return true;
        }

        // Asignamos los datos a las variables correspondientes
        asignar(datos);

        // No hay numeros repetidos en el conjunto de entrada
        if (numRepetido(conjuntoA)) {
            System.err.println("Error: El conjunto de entrada no puede contener numeros repetidos");
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
     * Asigna los datos correspondientes a las variables de instancia
     *
     * @param datos Datos de entrada
     */
    private void asignar(String[] datos) {
        conjuntoA = stringALista(datos[0]);
        m = Integer.parseInt(datos[1].trim());
        c = Integer.parseInt(datos[2].trim());
    }

    /**
     * Comprueba si hay algun numero repetido en el conjunto de entrada
     *
     * @param conjunto Conjunto de entrada inicial
     * @return True si hay algun numero repetido
     */
    private boolean numRepetido(List<Integer> conjunto) {
        Set<Integer> set = new HashSet<>();
        for (int i : conjunto) {
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
