// Programa 6 Calidad y pruebas de software
// Proposito de la clase: Calcular la desviación estandard
// Einar López Altamirano A01656259
// Fecha de creación: 22/10/2021
// Última modificación: 22/10/2021

import java.lang.Math;

public class CalculateStandardDeviation {

    //.i
    // Calcular la desviación estandard
    // Parámetros: numberOfPairs, xs,ys, b0 y b1
    // Regresa: la desviación estandard
    public double standardDeviation(int numberOfPairs, double[] xs, double[] ys, double b0, double b1) {
        double sum = 0;
        for (int i = 0; i < numberOfPairs; i++) {
            sum = sum + Math.pow(ys[i] - b0 - (b1 * xs[i]), 2);
        }
        double sd = Math.sqrt(((double) 1 / (numberOfPairs - 2)) * sum);
        return sd;
    }
}
