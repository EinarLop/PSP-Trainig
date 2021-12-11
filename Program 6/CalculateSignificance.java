// Programa 6 Calidad y pruebas de software
// Proposito de la clase: Calcular el area de las colas una distribución t / significancia de correlación
// Einar López Altamirano A01656259
// Fecha de creación: 22/10/2021
// Última modificación: 22/10/2021

import java.lang.Math;

public class CalculateSignificance {

    //.i
    // Calcular el area de las colas de una grafica
    // Parámetros: r, rSquare, numberOfPairs
    // Regresa: el area de las colas de una distribución t / significancia de
    // correlación
    public double significance(double r, double rSquare, int numberOfPairs) {
        double x = (double) (Math.abs(r) * Math.sqrt(numberOfPairs - 2)) / Math.sqrt(1 - rSquare);
        CalculateP calculateP = new CalculateP((numberOfPairs - 2));
        double p = calculateP.comparePs(x);
        return 1 - (2 * p);
    }
}
