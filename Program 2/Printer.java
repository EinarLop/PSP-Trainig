
// Programa 2 Calidad y pruebas de software
// Proposito de la clase: Imprimir con formato correcto a consola y a archivo de texto
// Einar López Altamirano A01656259
// Fecha de creación: 10/09/2021 
// Última modificación: 13/09/2021

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Printer {
    int totalLinesOfCode = 0;

    //.i
    // Imprime a consola con formato correspondiente
    // Parámetros: collector = objeto que almacena toda la infromación de una clase
    // Devuelve: nada
    public void printToConsole(ArrayList<Collector> collectors) {
        System.out.println("CLASES BASE");

        for (int i = 0; i < collectors.size(); i++) {

            if (collectors.get(i).classType == "Base") {
                System.out.println("  " + collectors.get(i).name + ": " + " T=" + collectors.get(i).total + ", I="
                        + collectors.get(i).items + ", B=" + collectors.get(i).base + ", D=" + collectors.get(i).deleted
                        + ", M=" + collectors.get(i).modified + ", A=" + collectors.get(i).added);
            }
        }
        System.out.println("--------------------------------------------");
        System.out.println("CLASES NUEVAS");
        for (int i = 0; i < collectors.size(); i++) {

            if (collectors.get(i).classType == "Nueva") {
                System.out.println("  " + collectors.get(i).name + ": " + " T=" + collectors.get(i).total + ", I="
                        + collectors.get(i).items);
            }
        }
        System.out.println("--------------------------------------------");
        System.out.println("CLASES REUSADAS");
        for (int i = 0; i < collectors.size(); i++) {

            if (collectors.get(i).classType == "Reusada") {
                System.out.println("  " + collectors.get(i).name + ": " + " T=" + collectors.get(i).total + ", I="
                        + collectors.get(i).items + ", B=" + collectors.get(i).base);
            }
        }

        System.out.println("--------------------------------------------");
        for (int i = 0; i < collectors.size(); i++) {
            totalLinesOfCode += collectors.get(i).total;
        }
        System.out.println("Total de LDC=" + totalLinesOfCode);
    }

    //.i
    // Imprime a archivo con formato correspondiente
    // Parámetros: collector = objeto que almacena toda la infromación de una clase
    // Devuelve: nada
    public void printToFile(ArrayList<Collector> collectors) {
        totalLinesOfCode = 0;
        try (PrintWriter printWriter = new PrintWriter("ConteoLDC.txt")) {
            printWriter.println("CLASES BASE");

            for (int i = 0; i < collectors.size(); i++) {

                if (collectors.get(i).classType == "Base") {
                    printWriter.println("  " + collectors.get(i).name + ": " + " T=" + collectors.get(i).total + ", I="
                            + collectors.get(i).items + ", B=" + collectors.get(i).base + ", D="
                            + collectors.get(i).deleted + ", M=" + collectors.get(i).modified + ", A="
                            + collectors.get(i).added);
                }
            }
            printWriter.println("--------------------------------------------");
            printWriter.println("CLASES NUEVAS");
            for (int i = 0; i < collectors.size(); i++) {

                if (collectors.get(i).classType == "Nueva") {
                    printWriter.println("  " + collectors.get(i).name + ": " + " T=" + collectors.get(i).total + ", I="
                            + collectors.get(i).items);
                }
            }
            printWriter.println("--------------------------------------------");
            printWriter.println("CLASES REUSADAS");
            for (int i = 0; i < collectors.size(); i++) {

                if (collectors.get(i).classType == "Reusada") {
                    printWriter.println("  " + collectors.get(i).name + ": " + " T=" + collectors.get(i).total + ", I="
                            + collectors.get(i).items + ", B=" + collectors.get(i).base);
                }
            }

            printWriter.println("--------------------------------------------");
            for (int i = 0; i < collectors.size(); i++) {
                totalLinesOfCode += collectors.get(i).total;
            }
            printWriter.println("Total de LDC=" + totalLinesOfCode);
            printWriter.close();
        } catch (FileNotFoundException x) {
            System.out.println(x);
        }

    }
}
