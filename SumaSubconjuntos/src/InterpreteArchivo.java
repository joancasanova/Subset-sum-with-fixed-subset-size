import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Interprete de datos de entrada a traves de un archivo de texto para el algoritmo de suma de subconjuntos
 *
 * @author Juan Francisco Casanova Ferrer
 */
class InterpreteArchivo extends Interprete {

    /**
     * Constructor indicado para analizar y asignar los datos del problema a cada variable correspondiente
     *
     * @param archivoEntrada Archivo en el que se encuentran los datos
     * @throws IOException En el caso de que no se encuentre el archivo
     */
    InterpreteArchivo(String archivoEntrada) throws IOException {
        List<String> datos = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
        int i = 0;
        String line;
        while ((line = br.readLine()) != null && i < 3) {
            datos.add(line);
            i++;
        }

        if (asignar(datos)) {
            throw new IllegalArgumentException("Error: El formato del archivo de datos de entrada no es compatible");
        }
    }
}