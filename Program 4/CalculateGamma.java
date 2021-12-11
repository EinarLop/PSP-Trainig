// Programa 4 Calidad y pruebas de software
// Proposito de la clase: Calcular el valor de gamma
// Einar López Altamirano A01656259
// Fecha de creación: 03/10/2021
// Última modificación: 04/10/2021

import java.lang.Math;

public class CalculateGamma {
    //.i
    // Calcula el valor de gamma de forma recursiva
    // Parámetros: x -> Valor a evaluar en la función gamma
    // Regresa: El valor de la aplicación de la función gamma a x
    public double gamma(double x) {

        if (x == 1) {
            return 1;
        } else if (x == 0.5) {
            return Math.sqrt(Math.PI);
        } else {
            return (x - 1) * gamma(x - 1);
        }
    }
}
