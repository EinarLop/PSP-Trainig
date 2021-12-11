// Programa 4 Calidad y pruebas de software
// Proposito del programa: Calcular el valor de p = t (x, dof). Con la integral de la distribución t, con el límite 0 – x y con dof grados de libertad.  
// Einar López Altamirano A01656259
// Fecha de creación: 03/10/2021
// Última modificación: 04/10/2021

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.lang.RuntimeException;

class Main {

    // .i
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double x;
        int dof;
        double p;

        try {
            System.out.println("Ingresar valor de x");
            x = scanner.nextDouble();
            if (x < 0) {
                throw new IllegalArgumentException();
            }
            System.out.println("Ingresar valor de dof");
            dof = scanner.nextInt();
            if (dof <= 0) {
                throw new RuntimeException();
            }

            CalculateP calculateP = new CalculateP(dof, x);
            p = calculateP.comparePs();
            Printer printer = new Printer();
            printer.printToConsole(x, dof, p);
        } catch (InputMismatchException e) {
            System.out
                    .println("El dato ingresado no coincide con el tipo de dato requerido, por favor intente de nuevo");
            System.exit(0);
        } catch (IllegalArgumentException e) {
            System.out.println(
                    "El valor de x tiene que ser un número real mayor o igual a cero, por favor intente de nuevo");
            System.exit(0);
        } catch (RuntimeException e) {
            System.out
                    .println("El valor de dof tiene que ser un número entero mayor a cero, por favor intente de nuevo");
            System.exit(0);
        }

    }
}
