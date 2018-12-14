import java.io.File;

/**
 * Clase que contiene el metodo Main del programa. Filtra los argumentos introducidos al invocar dicho metodo
 * <p>
 * TODO: Arreglar interpretes, arreglar main, archivo salida, revision y reformateo general
 *
 * @author Juan Francisco Casanova Ferrer
 */
public class suma {

    public static void main(String[] args) {
        // Inicializamos cada uno de los posibles argumentos admitidos
        boolean help = false;
        boolean traza = false;
        String archivoEntrada = null;
        String archivoSalida = null;
        Impresor impresor = new Impresor();

        // Asignamos el valor correspondiente a los argumentos
        for (String argumento : args) {
            if (argumento.equals("-h")) {
                impresor.imprimirHelp();
                System.exit(0);
            } else if (argumento.equals("-t")) {
                traza = true;
            } else if (archivoEntrada != null) {
                archivoSalida = argumento;
                break;
            } else {
                archivoEntrada = argumento;
            }
        }

        // Parseamos los datos del archivo de entrada
        InterpreteComando datos;
        if (archivoEntrada == null) {
            datos = new InterpreteComando();
        } else {
            File f = new File(archivoEntrada);
            if (!f.exists()) {
                datos = new InterpreteComando();
            } else {
                datos = new InterpreteComando(archivoEntrada);
            }
        }

        // Invocamos el algoritmo con los datos obtenidos
        Algoritmo algoritmo = new Algoritmo(datos.getConjuntoA(), datos.getM(), datos.getC());

        // Imprimimos con o sin traza segun se haya especificado
        if (traza) {
            impresor.imprimirTraza(algoritmo.getTraza());
            impresor.imprimirSolucion(algoritmo.getSolucion());
        } else {
            impresor.imprimirSolucion(algoritmo.getSolucion());
        }
    }
}
