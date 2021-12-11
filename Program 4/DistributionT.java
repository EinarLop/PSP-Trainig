// Programa 4 Calidad y pruebas de software
// Proposito de la clase: Calcular el valor de la función t
// Einar López Altamirano A01656259
// Fecha de creación: 03/10/2021
// Última modificación: 04/10/2021

import java.lang.Math;

public class DistributionT {
    CalculateGamma calculateGamma = new CalculateGamma();
    public int dof;

    DistributionT(int dof) {
        this.dof = dof;
    }

    // .i
    // Calcula el valor de la función t aplicada a un valor x
    // Parámetros: x -> Valor a evaluar en la función t
    // Regresa: El valor de la aplicación de la función t a x
    public double t(double x) {
        // System.out.println("LAAAAAST TEST:" + calculateGamma.gamma((double) dof /
        // 2));
        double tNumerator = (calculateGamma.gamma((double) (dof + 1) / 2));
        // System.out.println("GammaTest" + calculateGamma.gamma((double) (dof + 1) /
        // 2));
        double tDenominator = (Math.pow(dof * Math.PI, 0.5) * calculateGamma.gamma((double) dof / 2));
        // // System.out.println("TNumerator: " + tNumerator);
        // // System.out.println("TDenominator: " + tDenominator);
        // System.out.println("Multiplier: " + Math.pow((1 + ((x * x) / dof)), (-1 *
        // (dof + 1)) / 2));
        // System.out.println("X: " + x);
        // System.out.println("First term: " + (1 + ((double) (x * x) / dof)));
        // System.out.println("With no double " + (1 + ((x * x) / dof)));
        // System.out.println("Second term " + (-1 * (double) (dof + 1)) / 2);
        // System.out.println("No double " + (-1 * (dof + 1)) / 2);
        // System.out.println("Whole multi with double" + Math.pow((1 + ((x * x) /
        // dof)), (-1 * (double) (dof + 1)) / 2));
        System.out.println(
                "pop" + ((tNumerator / tDenominator) * Math.pow((1 + ((x * x) / dof)), (-1 * (double) (dof + 1)) / 2)));
        return ((tNumerator / tDenominator) * Math.pow((1 + ((x * x) / dof)), (-1 * (double) (dof + 1)) / 2));

    }

}
