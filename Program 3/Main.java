
// Programa 3 Calidad y pruebas de software
// Proposito del programa: Obtener los valores r, r2, b0, b1 y yk a partir de un set de puntos y de xk 
// Einar López Altamirano A01656259
// Fecha de creación: 18/09/2021 
// Última modificación: 19/09/2021
import java.util.ArrayList;

public class Main {

    //.i
    // Control de flujo del programa
    // Parámetros: nada
    // Regresa: nada
    public static void main(String[] args) throws Exception {
        ArrayList<String> lines = new ArrayList<String>();
        FileManager fileManager = new FileManager();
        lines = fileManager.lineReader();
        BasicOperations basicOperations = new BasicOperations(lines);
        double basicOperationsResults[];
        basicOperationsResults = basicOperations.setupResult();
        FinalOperations finalOperations = new FinalOperations(basicOperationsResults);
        double finalOperationsResults[] = finalOperations.setupResults();
        Printer printer = new Printer();
        printer.printToConsole(finalOperationsResults);
    }
}
