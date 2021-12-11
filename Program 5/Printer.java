// Programa 5 Calidad y pruebas de software
// Proposito de la clase: Redondear a 5 decimales x y p e imprimirlos a consola junto con el dof
// Einar López Altamirano A01656259
// Fecha de creación: 03/10/2021
// Última modificación: 10/10/2021

//.b=10

public class Printer {

    //.i
    // Imprime a consola con el formato correcto
    // Parámetros: x, dof y p
    // Regresa: nada
    public void printToConsole(double x, int dof, double p) {
        System.out.println("  p = " + roundToFive(p)); //.m
        System.out.println("dof = " + dof);
        System.out.println("  x = " + roundToFive(x)); //.m

    }

    //.i
    // Redonda a 5 decimales el valor que se pase como parametro
    // Parámetros: value -> Valor a redondear
    // Regresa: El valor redondeado a 5 decimales
    public String roundToFive(double value) {
        if (value >= 1) {
            return String.format("%.6g", value).replace(",", ".");
        } else {
            return String.format("%.5g", value).replace(",", ".");
        }
    }
}