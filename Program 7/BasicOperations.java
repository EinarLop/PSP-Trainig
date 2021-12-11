// Programa 7 Calidad y pruebas de software
// Proposito de la clase: Preparar los valores necesarios para realizar la regresión múltiple
// Einar López Altamirano A01656259
// Fecha de creación: 18/09/2021 
// Última modificación: 7/11/2021

//.b=66
import java.util.ArrayList;
import java.util.stream.DoubleStream;
import java.lang.NumberFormatException;

public class BasicOperations {
    //.d=1
    public ArrayList<String> lines;
    public int numberOfQuadruples; //.m
    public double wk;
    public double xk;
    public double yk;
    public double ws[];
    public double xs[];
    public double ys[];
    public double zs[];
    public double xsSquare[];
    public double ysSquare[];
    public double wsSquare[];
    public double wsTimesXs[];
    public double wsTimesYs[];
    public double wsTimesZs[];
    public double xsTimesYs[]; //.m
    public double xsTimesZs[];
    public double ysTimesZs[]; //.m
    public double basicOperationsResults[];

    BasicOperations(ArrayList<String> lines) {
        this.lines = lines;
        numberOfQuadruples = lines.size() - 1; //.m
        ws = new double[numberOfQuadruples];
        xs = new double[numberOfQuadruples]; //.m
        ys = new double[numberOfQuadruples]; //.m
        zs = new double[numberOfQuadruples];
        wsSquare = new double[numberOfQuadruples];
        xsSquare = new double[numberOfQuadruples]; //.m
        ysSquare = new double[numberOfQuadruples]; //.m
        wsTimesXs = new double[numberOfQuadruples];
        wsTimesYs = new double[numberOfQuadruples];
        wsTimesZs = new double[numberOfQuadruples];
        xsTimesYs = new double[numberOfQuadruples]; //.m
        xsTimesZs = new double[numberOfQuadruples];
        ysTimesZs = new double[numberOfQuadruples];
        basicOperationsResults = new double[17]; //.m
    }

    //.i
    // Separa los cuádruplos valida que tengan el formato correcto y maneja las excepciones
    // Parámetros: nada
    // Regresa: nada
    public void filterQuadruples() { //.m
        try {
            String[] firstLine = lines.get(0).split(",");
            firstLine[0] = firstLine[0].replaceAll("\\s+", "");
            firstLine[1] = firstLine[1].replaceAll("\\s+", "");
            firstLine[2] = firstLine[2].replaceAll("\\s+", "");
            wk = Double.parseDouble(firstLine[0]);
            xk = Double.parseDouble(firstLine[1]);
            yk = Double.parseDouble(firstLine[2]);
            lines.remove(0);

            for (int i = 0; i < numberOfQuadruples; i++) { //.m

                //.d=1
                String[] parts = lines.get(i).split(",");
                parts[0] = parts[0].replaceAll("\\s+", "");
                parts[1] = parts[1].replaceAll("\\s+", "");
                parts[2] = parts[2].replaceAll("\\s+", "");
                parts[3] = parts[3].replaceAll("\\s+", "");
                ws[i] = Double.parseDouble(parts[0]);
                xs[i] = Double.parseDouble(parts[1]);
                ys[i] = Double.parseDouble(parts[2]);
                zs[i] = Double.parseDouble(parts[3]);
                if (ws[i] < 0 || xs[i] < 0 || ys[i] < 0 || zs[i] < 0 || wk < 0 || xk < 0 || yk < 0) { //.m
                    throw new IllegalArgumentException();
                }
            }
        } catch (NumberFormatException x) {
            System.out.println("El archivo seleccionado solo puede contener números, por favor intente con otro ");
            System.exit(0);
        } catch (ArrayIndexOutOfBoundsException y) {
            System.out.println("El archivo seleccionado no puede contener valores vacíos, por favor intente con otro");
            System.exit(0);

        } catch (IllegalArgumentException z) {
            System.out.println(
                    "El archivo seleccionado no puede contener valores menores a 0, por favor intente con otro");
            System.exit(0);

        }
    }

    //.i
    // Genera arreglos con los valores de w,x,y,z al cuadrado
    // Parámetros: nada
    // Regresa: nada
    public void squareQuadruples() { //.m
        for (int i = 0; i < numberOfQuadruples; i++) { //.m
            wsSquare[i] = ws[i] * ws[i];
            xsSquare[i] = xs[i] * xs[i];
            ysSquare[i] = ys[i] * ys[i];
        }
    }

    //.i
    // Genera un arreglo con todas las posibles multiplicaciones de w,x,y,z
    // Parámetros: nada
    // Regresa: nada
    public void multiplyQuadruples() {// .m
        for (int i = 0; i < numberOfQuadruples; i++) { // .m
            wsTimesXs[i] = ws[i] * xs[i];
            wsTimesYs[i] = ws[i] * ys[i];
            wsTimesZs[i] = ws[i] * zs[i];
            xsTimesYs[i] = xs[i] * ys[i];
            xsTimesZs[i] = xs[i] * zs[i];
            ysTimesZs[i] = ys[i] * zs[i];
        }
    }

    //.i
    // Control de flujo de la clase y generea la sumatorias, sumatorias cuadradas y  sumatorias de multiplicaciones de w,x,y,z 
    // Parámetros: nada
    // Regresa: los resultados de las distintas multiplicaciones
    public double[] setupResult() {
        filterQuadruples();
        squareQuadruples();
        multiplyQuadruples();

        basicOperationsResults[0] = numberOfQuadruples; //.m
        basicOperationsResults[1] = wk;
        basicOperationsResults[2] = xk; //.m
        basicOperationsResults[3] = yk;
        basicOperationsResults[4] = DoubleStream.of(ws).sum();
        basicOperationsResults[5] = DoubleStream.of(xs).sum(); //.m
        basicOperationsResults[6] = DoubleStream.of(ys).sum(); //.m
        basicOperationsResults[7] = DoubleStream.of(zs).sum();
        basicOperationsResults[8] = DoubleStream.of(wsSquare).sum();
        basicOperationsResults[9] = DoubleStream.of(xsSquare).sum(); //.m
        basicOperationsResults[10] = DoubleStream.of(ysSquare).sum(); //.m
        basicOperationsResults[11] = DoubleStream.of(wsTimesXs).sum();
        basicOperationsResults[12] = DoubleStream.of(wsTimesYs).sum();
        basicOperationsResults[13] = DoubleStream.of(wsTimesZs).sum();
        basicOperationsResults[14] = DoubleStream.of(xsTimesYs).sum(); //.m
        basicOperationsResults[15] = DoubleStream.of(xsTimesZs).sum();
        basicOperationsResults[16] = DoubleStream.of(ysTimesZs).sum();
        return basicOperationsResults;

    }

}
