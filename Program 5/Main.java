// Programa 4 Calidad y pruebas de software
// Proposito del programa: Calcular el valor de p = t (x, dof). Con la integral de la distribución t, con el límite 0 – x y con dof grados de libertad.  
// Einar López Altamirano A01656259
// Fecha de creación: 03/10/2021
// Última modificación: 04/10/2021

//.b=35
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
//.d=3

class Main {

    //.i
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double x;
        int dof = 0;
        double p = 0;

        System.out.println("Ingresar valor de p"); //.m
        try {
            p = scanner.nextDouble(); //.m
            if (!(p >= 0.0 && p <= 0.5)) { //.m
                System.out.println(
                        "El valor de p no puede estar fuera del rango 0 – 0.5, por favor intente de nuevo con un valor de p que cumpla con el formato correcto"); //.m
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println(
                    "El valor de p no cumple con el formato indicado, por favor intente de nuevo con un valor de p que cumpla con el formato correcto"); //.m
            System.exit(0);
        }
        System.out.println("Ingresar valor de dof");
        try {
            dof = scanner.nextInt();
            if (dof < 0) {
                System.out.println(
                        "El valor de dof no puede ser negativo, por favor intente de nuevo con un valor de dof que cumpla con el formato correcto"); //.m
                System.exit(0);
            }
        } catch (InputMismatchException e) { //.m
            System.out.println(
                    "El valor de dof no cumple con el formato indicado, por favor intente de nuevo con un valor de dof que cumpla con el formato correcto");
            System.exit(0);
        }

        //.d=5
        scanner.close();
        CalculateX calculateX = new CalculateX(dof);
        x = calculateX.x(p);
        Printer printer = new Printer();
        printer.printToConsole(x, dof, p);

    }
    //.d=9
}
