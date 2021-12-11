
// Programa 7 Calidad y pruebas de software
// Proposito de la clase: Redondear a 5 decimales n, wk, xk, yk, b0, b1, b2, b3, zk e imprimirlos a consola
// Einar López Altamirano A01656259
// Fecha de creación: 03/10/2021
// Última modificación: 7/11/2021

//.b=26

public class Printer {

    //.i
    // Imprime a consola con el formato correcto
    // Parámetros: n, wk, xk, yk, b0, b1, b2, b3, zk
    // Regresa: nada
    public void printToConsole(int n, double wk, double xk, double yk, double b0, double b1, double b2, double b3, //.m
            double zk) { //.m

        System.out.println("N  = " + n);
        System.out.println("wk = " + roundToFive(wk)); //.m
        System.out.println("xk = " + roundToFive(xk)); //.m
        System.out.println("yk = " + roundToFive(yk)); //.m
        System.out.println("------------"); //.m
        System.out.println("b0 = " + roundToFive(b0)); //.m
        System.out.println("b1 = " + roundToFive(b1)); //.m
        System.out.println("b2 = " + roundToFive(b2)); //.m
        System.out.println("b3 = " + roundToFive(b3)); //.m
        System.out.println("------------");
        System.out.println("zk = " + roundToFive(zk)); //.m

    }

    //.i
    // Redonda a 5 decimales el valor que se pase como parametro
    // Parámetros: value -> Valor a redondear
    // Regresa: El valor redondeado a 5 decimales
    public String roundToFive(double value) {
        if (Math.abs(value) >= 999) {
            return String.format("%.9g", value).replace(",", ".");
        } else if (Math.abs(value) >= 99) {
            return String.format("%.8g", value).replace(",", ".");
        } else if (Math.abs(value) >= 9) {
            return String.format("%.7g", value).replace(",", ".");
        } else if (Math.abs(value) >= 0.9999) {
            return String.format("%.6g", value).replace(",", ".");
        } else if (value == 0.0) {
            return String.format("%.6g", value).replace(",", ".");
        } else if (Math.abs(value) >= 0.09999) {
            return String.format("%.5g", value).replace(",", ".");
        } else if (Math.abs(value) >= 0.009999) {
            return String.format("%.4g", value).replace(",", ".");
        } else {
            return String.format("%.3g", value).replace(",", ".");
        }
    }
    //.d=2
}