import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class InputOutput {

    private String archivoEntrada;
    private String  archivoSalida;
    private ArrayList<Integer>[] datos = new ArrayList[3];

    public InputOutput(String argumentos, String archivoEntrada, String archivoSalida) throws IOException {
        this.archivoEntrada = archivoEntrada;
        this.archivoSalida = archivoSalida;


        Si hay argumentos,
                hacer un switch



        setDatos(archivoEntrada);
    }

    /**
     * Lee el archivo de entrada y guarda los datos
     *
     * @param archivoEntrada  Archivo de entrada de datos
     * @throws IOException    Si no se encuentra el archivo o está vacío
     */
    private void setDatos(String archivoEntrada) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
        String linea;
        int i = 0;
        while ((linea = br.readLine()) != null && i < 3) {
            String[] stringsArray = linea.split("\\s");
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (String string : stringsArray) {
                arrayList.add(Integer.parseInt(string));
            }
            datos[i] = arrayList;
            i++;
        }
    }

    /**
     * Comprueba que los datos son correctos
     *
     * @param datos  datos a comprobar
     * @return       True si los datos son conrrectos, False si son incorrectos
     */
    public boolean verificarDatos(ArrayList<ArrayList<Integer>> datos) {
        if (datos.isEmpty() || datos.get(1).size() != 1 || datos.get(2).size() != 1) {
            System.err.println("El formato de los datos del archivo de entrada es incorrecto");
            return false;
        }
        if (datos.get(1).get(0) < datos.get(0).size()) {
            System.err.println("No puede haber mas subconjuntos que numeros en el conjunto principal");
            return false;
        }
        return true;
    }

    public static void imprimirHelp(){
        System.out.println("SINTAXIS: suma [-t] [-h] [fichero_entrada] [fichero_salida]");
        System.out.println("___________________________________________________________");
        System.out.println("ARGUMENTOS:");
        System.out.println("-t                   Traza la seleccion de subconjuntos");
        System.out.println("-h                   Muestra esta ayuda");
        System.out.println("fichero_entrada      Nombre del fichero de entrada");
        System.out.println("fichero_salida       Nombre del fichero de salida");
    }

    private void imprimirSolucion(){
        for (int[] conjunto : solucion) {
            System.out.println();
            System.out.println("Subconjunto: ");
            for (Integer numero : conjunto) {
                System.out.print(numero + "  ");
            }
        }
    }
}
