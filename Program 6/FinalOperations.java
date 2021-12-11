
// Programa 3 Calidad y pruebas de software
// Proposito de la clase: Obtener los valores r, r2, b0, b1 y yk partir los valores obtenidos en BasicOperations
// Einar López Altamirano A01656259
// Fecha de creación: 18/09/2021 
// Última modificación: 22/10/2021

//.b=49
import java.lang.Math;
//.d=1

public class FinalOperations {

    double basicOperationsResults[];
    public int numberOfPairs;
    public double xk, sumX, sumY, sumXSquare, sumYSquare, sumXTimesY, xavrg, yavrg, xavrgSquare;
    public double b1, b0, r, rSquare, yk;
    double finalOperationsResults[];

    FinalOperations(double[] basicOperationsResults) {
        this.basicOperationsResults = basicOperationsResults;
        numberOfPairs = (int) basicOperationsResults[0];
        xk = basicOperationsResults[1];
        sumX = basicOperationsResults[2];
        sumY = basicOperationsResults[3];
        sumXSquare = basicOperationsResults[4];
        sumYSquare = basicOperationsResults[5];
        sumXTimesY = basicOperationsResults[6];
        xavrg = sumX / numberOfPairs;
        yavrg = sumY / numberOfPairs;
        xavrgSquare = xavrg * xavrg;
        finalOperationsResults = new double[7];
    }

    //.i
    // Calcula los valores b0 y b1
    // Parámetros: nada
    // Regresa: nada
    public void calculateBetas() {
        b1 = (sumXTimesY - (numberOfPairs * xavrg * yavrg)) / (sumXSquare - (numberOfPairs * xavrgSquare));
        b0 = yavrg - b1 * xavrg;
    }

    //.i
    // Calcula los valores r y r cuadrada
    // Parámetros: nada
    // Regresa: nada
    public void calculateRs() {
        double rNumerator;
        double rDenominator;
        rNumerator = numberOfPairs * sumXTimesY - sumX * sumY;
        rDenominator = Math
                .sqrt((numberOfPairs * sumXSquare - sumX * sumX) * (numberOfPairs * sumYSquare - sumY * sumY));
        r = rNumerator / rDenominator;
        rSquare = r * r;
    }

    //.i
    // Control de flujo de la clase y redondo a 5 decimales de los valores finales
    // Parámetros: nada
    // Regresa: arreglo con los resultados de las funciones calculateBetas y
    // calculateRs
    public double[] setupResults() {
        calculateBetas();
        calculateRs();
        yk = b0 + b1 * xk;
        finalOperationsResults[0] = numberOfPairs;
        finalOperationsResults[1] = xk;
        finalOperationsResults[2] = r;
        finalOperationsResults[3] = rSquare;
        finalOperationsResults[4] = b0;
        finalOperationsResults[5] = b1;
        finalOperationsResults[6] = yk;

        //.d=5
        return finalOperationsResults;
    }

}
