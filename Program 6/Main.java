// Programa 6 Calidad y pruebas de software
// Proposito del programa: Calcular: coeficiente de correlación y su significancia, parámetros de regresión lineal, predicción mejorada yk e intervalo de predicción al 70%, todos los cálculos en base a un conjunto de pares y a un valor de xk. 
// Einar López Altamirano A01656259
// Fecha de creación: 22/10/2021
// Última modificación: 22/10/2021

import java.util.ArrayList;

public class Main {
    //.i
    // Control de flujo del programa
    // Parámetros: nada
    // Regresa: nada
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<String>();

        FileManager fileManager = new FileManager();
        lines = fileManager.lineReader();

        BasicOperations basicOperations = new BasicOperations(lines);
        double basicOperationsResults[];
        basicOperationsResults = basicOperations.setupResult();

        FinalOperations finalOperations = new FinalOperations(basicOperationsResults);
        double finalOperationsResults[] = finalOperations.setupResults();

        double xs[] = basicOperations.xs;
        double ys[] = basicOperations.ys;
        double xavg = finalOperations.xavrg;

        int numberOfPairs = (int) finalOperationsResults[0];
        double xk = finalOperationsResults[1];
        double r = finalOperationsResults[2];
        double rSquare = finalOperationsResults[3];
        double b0 = finalOperationsResults[4];
        double b1 = finalOperationsResults[5];
        double yk = finalOperationsResults[6];

        CalculateSignificance calculateSignificance = new CalculateSignificance();
        double significance = calculateSignificance.significance(r, rSquare, numberOfPairs);

        CalculateStandardDeviation calculateStandardDeviation = new CalculateStandardDeviation();
        double standardDeviation = calculateStandardDeviation.standardDeviation(numberOfPairs, xs, ys, b0, b1);

        CalculateRange calculateRange = new CalculateRange();
        double[] calculateRangeResults = calculateRange.range(standardDeviation, xk, xs, xavg, yk, numberOfPairs);

        double range = calculateRangeResults[0];
        double LS = calculateRangeResults[1];
        double LI = calculateRangeResults[2];

        Printer printer = new Printer();
        printer.printToConsole(numberOfPairs, xk, r, rSquare, b0, b1, yk, significance, range, LS, LI);
    }
}
