import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Interprete de datos de entrada a traves de la linea de comandos para el algoritmo de suma de subconjuntos
 *
 * @author Juan Francisco Casanova Ferrer
 */
class InterpreteComando extends Interprete {

    /**
     * Constructor indicado cuando no se encuentra un archivo de entrada de datos
     */
    InterpreteComando() {
        List<String> datos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Introducir Conjunto A | Elementos del conjunto de entrada (separados por espacios): ");
            datos.add(scanner.nextLine());

            System.out.println("Introducir m | Numero de elementos del subconjunto: ");
            datos.add(scanner.nextLine());

            System.out.println("Introducir c | Suma objetivo: ");
            datos.add(scanner.nextLine());
        } while (asignar(datos));

        scanner.close();
    }
}