
// Programa 6 Calidad y pruebas de software
// Proposito de la clase: Redondear a 5 o a 10 decimales n,xk,r,r2,b0,b1,yk,sig,ran,LS y LI e imprimirlos a consola
// Einar López Altamirano A01656259
// Fecha de creación: 03/10/2021
// Última modificación: 10/10/2021

//.b=10

public class Printer {

    //.i
    // Imprime a consola con el formato correcto
    // Parámetros: x, dof y p
    // Regresa: nada
    public void printToConsole(int n, double xk, double r, double r2, double b0, double b1, double yk, double sig, double ran, double LS, double LI) { //.m
        System.out.println("N  = " + n); //.m
        System.out.println("xk = " + roundToFive(xk)); //.m
        System.out.println("r  = " + roundToFive(r)); //.m
        System.out.println("r2 = " + roundToFive(r2));
        System.out.println("b0 = " + roundToFive(b0));
        System.out.println("b1 = " + roundToFive(b1));
        System.out.println("yk = " + roundToFive(yk));
        System.out.println("sig= " + roundToTen(sig));
        System.out.println("ran= " + roundToFive(ran));
        System.out.println("LS = " + roundToFive(LS));
        System.out.println("LI = " + roundToFive(LI));

    }

    //.i
    // Redonda a 5 decimales el valor que se pase como parametro
    // Parámetros: value -> Valor a redondear
    // Regresa: El valor redondeado a 5 decimales
    public String roundToFive(double value) {
        if (Math.abs(value) >= 99) {
            return String.format("%.8g", value).replace(",", ".");
        } else if (Math.abs(value) >= 9) {
            return String.format("%.7g", value).replace(",", ".");
        } else if (Math.abs(value) >= 0.9999) {
            return String.format("%.6g", value).replace(",", ".");
        } else if (value == 0.0) {
            return String.format("%.6g", value).replace(",", ".");
        } else {
            return String.format("%.5g", value).replace(",", ".");
        }
    }

    //.i
    // Redonda a 10 decimales el valor que se pase como parametro
    // Parámetros: value -> Valor a redondear
    // Regresa: El valor redondeado a 10 decimales
    public String roundToTen(double value) {
        return String.format("%.10f", value).replace(",", ".");
    }
}