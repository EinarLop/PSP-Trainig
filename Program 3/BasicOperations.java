// Programa 3 Calidad y pruebas de software
// Proposito de la clase: Preparar los valores necesarios para calcular las operaciones finales 
// Einar López Altamirano A01656259
// Fecha de creación: 18/09/2021 
// Última modificación: 19/09/2021

import java.util.ArrayList;
import java.util.stream.DoubleStream;
import java.lang.NumberFormatException;

public class BasicOperations {
    public ArrayList<String> lines;
    public String xkTemp;
    public double xk;
    public double xs[];
    public double ys[];
    public double xsSquare[];
    public double ysSquare[];
    public double xTimesY[];
    public double basicOperationsResults[];
    public int numberOfPairs;

    BasicOperations(ArrayList<String> lines) {
        this.lines = lines;
        numberOfPairs = lines.size() - 1;
        xkTemp = lines.get(0);
        xs = new double[numberOfPairs];
        ys = new double[numberOfPairs];
        xsSquare = new double[numberOfPairs];
        ysSquare = new double[numberOfPairs];
        xTimesY = new double[numberOfPairs];
        basicOperationsResults = new double[7];

    }

    //.i
    // Separa las x de las y, valida que tengan el formato correcto y maneja las
    // excepciones
    // Parámetros: nada
    // Regresa: nada
    public void filterXsAndYs() {
        lines.remove(0);
        for (int i = 0; i < numberOfPairs; i++) {

            try {
                String[] parts = lines.get(i).split(",");
                parts[0] = parts[0].replaceAll("\\s+", "");
                parts[1] = parts[1].replaceAll("\\s+", "");
                xk = Double.parseDouble(xkTemp);
                xs[i] = Double.parseDouble(parts[0]);
                ys[i] = Double.parseDouble(parts[1]);
                if (xs[i] < 0 || ys[i] < 0 || xk < 0) {
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException x) {
                System.out.println("El archivo seleccionado solo puede contener números, por favor intente con otro ");
                System.exit(0);
            } catch (ArrayIndexOutOfBoundsException y) {
                System.out.println(
                        "El archivo seleccionado no puede contener valores vacíos, por favor intente con otro");
                System.exit(0);

            } catch (IllegalArgumentException z) {
                System.out.println(
                        "El archivo seleccionado no puede contener valores menores a 0, por favor intente con otro");
                System.exit(0);

            }

        }

    }

    //.i
    // Genera dos arreglos con los valores de x al cuadrado y con los de y al
    // cuadrado
    // Parámetros: nada
    // Regresa: nada
    public void squareXandY() {
        for (int i = 0; i < numberOfPairs; i++) {
            xsSquare[i] = xs[i] * xs[i];
            ysSquare[i] = ys[i] * ys[i];
        }
    }

    //.i
    // Genera un arreglo con la multiplicación de cada x y y con los
    // Parámetros: nada
    // Regresa: nada
    public void xsTimesYs() {
        for (int i = 0; i < numberOfPairs; i++) {
            xTimesY[i] = xs[i] * ys[i];
        }
    }

    //.i
    // Control de flujo de la clase y generea la sumatorias de los elementos x, y, x
    // al cuadrado, y al cuadrado y x por y
    // Parámetros: nada
    // Regresa: las sumatorias en un arreglo
    public double[] setupResult() {
        filterXsAndYs();
        squareXandY();
        xsTimesYs();
        basicOperationsResults[0] = numberOfPairs;
        basicOperationsResults[1] = xk;
        basicOperationsResults[2] = DoubleStream.of(xs).sum();
        basicOperationsResults[3] = DoubleStream.of(ys).sum();
        basicOperationsResults[4] = DoubleStream.of(xsSquare).sum();
        basicOperationsResults[5] = DoubleStream.of(ysSquare).sum();
        basicOperationsResults[6] = DoubleStream.of(xTimesY).sum();

        return basicOperationsResults;

    }

}
