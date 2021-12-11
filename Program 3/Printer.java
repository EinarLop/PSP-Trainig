// Programa 3 Calidad y pruebas de software
// Proposito de la clase: Imprimir a consola los valores n, xk, r, r2, b0, b1 y yk con el formato correcto  
// Einar López Altamirano A01656259
// Fecha de creación: 18/09/2021 
// Última modificación: 19/09/2021

public class Printer {

    //.i
    // Imprime a consola con el formato correcto
    // Parámetros: finalOperationsResults -> Resultados de las operciones finales
    // Regresa: nada
    public void printToConsole(double finalOperationsResults[]) {

        String r = String.valueOf(finalOperationsResults[2]);
        String r2 = String.valueOf(finalOperationsResults[3]);
        String b0 = String.valueOf(finalOperationsResults[4]);
        String b1 = String.valueOf(finalOperationsResults[5]);
        String yk = String.valueOf(finalOperationsResults[6]);
        int rDotIndex = r.indexOf(".");
        int r2DotIndex = r2.indexOf(".");
        int b0DotIndex = b0.indexOf(".");
        int b1DotIndex = b1.indexOf(".");
        int ykDotIndex = yk.indexOf(".");

        if (r.substring(rDotIndex + 1).length() < 5) {
            r = r + "0";
        }
        if (r2.substring(r2DotIndex + 1).length() < 5) {
            r2 = r2 + "0";
        }
        if (b0.substring(b0DotIndex + 1).length() < 5) {
            b0 = b0 + "0";
        }
        if (b1.substring(b1DotIndex + 1).length() < 5) {
            b1 = b1 + "0";
        }
        if (yk.substring(ykDotIndex + 1).length() < 5) {
            yk = yk + "0";
        }

        System.out.println("N = " + (int) finalOperationsResults[0]);
        System.out.println("xk = " + (int) finalOperationsResults[1]);
        System.out.println("r = " + r);
        System.out.println("r2 = " + r2);
        System.out.println("b0 = " + b0);
        System.out.println("b1 = " + b1);
        System.out.println("yk = " + yk);

    }
}