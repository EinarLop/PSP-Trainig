// Programa 6 Calidad y pruebas de software
// Proposito de la clase: Calcular el intervalo de predicción al 70% 
// Einar López Altamirano A01656259
// Fecha de creación: 22/10/2021
// Última modificación: 22/10/2021

public class CalculateRange {

    //.i
    // Calcular el intervalo de predicción al 70%
    // Parámetros: standardDeviation, xk, xs, xavg, yk, numberOfPairs
    // Regresa: un arreglo con los valores del rango, limite superior y limite
    // inferior
    public double[] range(double standardDeviation, double xk, double[] xs, double xavg, double yk, int numberOfPairs) {
        CalculateX calculateX = new CalculateX(numberOfPairs - 2);
        double t = calculateX.x(0.35);
        double sum = 0;

        for (int i = 0; i < numberOfPairs; i++) {
            sum = sum + Math.pow((xs[i] - xavg), 2);
        }

        double range = t * standardDeviation * Math.sqrt(1 + ((double) 1 / numberOfPairs) + (Math.pow((xk - xavg), 2) / sum));

        double[] results = new double[3];
        results[0] = range;
        results[1] = yk + range;
        if (yk - range >= 0) {
            results[2] = yk - range;
        } else {
            results[2] = 0;
        }
        return results;
    }
}
