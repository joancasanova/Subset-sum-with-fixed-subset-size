import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class SumaConjuntos {


    public static void main (String[] args) throws IOException {


        for (String argument : args) {

            if ("-.*".matches(argument)){
                switch (argument) {
                    case "-h": imprimirHelp(); break;
                    case "-t": System.out.print("-t"); break;
                }
                continue;
            }

            new InputOutput(argument, argument);
        }

    }
}
