// Programa 7 Calidad y pruebas de software
// Proposito de la clase: Obtener los resultados de b0,b1,b2,b3 mediante eliminación gaussiana y sustitución hacia arriba
// Einar López Altamirano A01656259
// Fecha de creación: 7/10/2021
// Última modificación: 7/11/2021

public class MultipleRegression {

    public int numberOfQuadruples;
    public double wk;
    public double xk;
    public double yk;
    public double wSum;
    public double xSum;
    public double ySum;
    public double zSum;
    public double xsSquareSum;
    public double ysSquareSum;
    public double wsSquareSum;
    public double wsTimesXsSum;
    public double wsTimesYsSum;
    public double wsTimesZsSum;
    public double xsTimesYsSum;
    public double xsTimesZsSum;
    public double ysTimesZsSum;
    public double matrix[][];
    public double finalResults[];

    MultipleRegression(double[] basicOperationsResults) {

        numberOfQuadruples = (int) basicOperationsResults[0];
        wk = basicOperationsResults[1];
        xk = basicOperationsResults[2];
        yk = basicOperationsResults[3];
        wSum = basicOperationsResults[4];
        xSum = basicOperationsResults[5];
        ySum = basicOperationsResults[6];
        zSum = basicOperationsResults[7];
        wsSquareSum = basicOperationsResults[8];
        xsSquareSum = basicOperationsResults[9];
        ysSquareSum = basicOperationsResults[10];
        wsTimesXsSum = basicOperationsResults[11];
        wsTimesYsSum = basicOperationsResults[12];
        wsTimesZsSum = basicOperationsResults[13];
        xsTimesYsSum = basicOperationsResults[14];
        xsTimesZsSum = basicOperationsResults[15];
        ysTimesZsSum = basicOperationsResults[16];
        matrix = new double[4][5];
        finalResults = new double[9];
    }

    //.i
    //Crea la matriz basado en el documento de especificaciones y utilizando los resultados de las operaciones básicas
    //Parámtros: nada
    //Devuelve: nada
    public void setupMatrix() {
        matrix[0][0] = numberOfQuadruples;
        matrix[0][1] = wSum;
        matrix[0][2] = xSum;
        matrix[0][3] = ySum;
        matrix[0][4] = zSum;
        matrix[1][0] = wSum;
        matrix[1][1] = wsSquareSum;
        matrix[1][2] = wsTimesXsSum;
        matrix[1][3] = wsTimesYsSum;
        matrix[1][4] = wsTimesZsSum;
        matrix[2][0] = xSum;
        matrix[2][1] = wsTimesXsSum;
        matrix[2][2] = xsSquareSum;
        matrix[2][3] = xsTimesYsSum;
        matrix[2][4] = xsTimesZsSum;
        matrix[3][0] = ySum;
        matrix[3][1] = wsTimesYsSum;
        matrix[3][2] = xsTimesYsSum;
        matrix[3][3] = ysSquareSum;
        matrix[3][4] = ysTimesZsSum;
    }

    //.i
    //Resolver un sistema de ecuaciones utilizando el método de eliminación gaussiana
    //Parámtros: nada
    //Devuelve: nada
    public void gaussianElimination() {
        //Encontrar pivote
        for (int i = 0; i <= matrix.length - 2; i++) {
            int pivotMax = i;
            for (int j = i; j <= matrix.length - 1; j++) {
                if (matrix[pivotMax][i] < matrix[j][i]) {
                    pivotMax = j;
                }
            }
        //Posicionar pivote en primera fila 
            double temp[] = matrix[i];
            matrix[i] = matrix[pivotMax];
            matrix[pivotMax] = temp;
            double reciprocal = matrix[i][i];
        //Dividir primera fila por recíproco
            for (int k = 0; k <= matrix[i].length - 1; k++) {
                matrix[i][k] = matrix[i][k] * (1 / reciprocal);
            }
        //Restar fila con el coefficiente negado
            for (int l = i + 1; l <= matrix.length - 1; l++) {
                double rowTemp[] = new double[5];
                double negatedCoefficent = -1 * (double) matrix[l][i];
                for (int m = i; m <= matrix[i].length - 1; m++) {
                    rowTemp[m] = matrix[i][m] * negatedCoefficent;
                }
                for (int n = i; n <= matrix[l].length - 1; n++) {
                    matrix[l][n] = rowTemp[n] + matrix[l][n];
                }
            }
        }
    }

    //.i
    //Realizar la substitución hacia arriba y crear el arreglo de resultados finales
    //Parámtros: nada
    //Devuelve: arreglo de resultados finales
    public double[] setupResults() {
        setupMatrix();
        gaussianElimination();

        //Substitución hacia arriba
        double b3 = (double) matrix[3][4] / matrix[3][3];
        for (int i = 0; i <= matrix.length - 2; i++) {
            matrix[i][3] = matrix[i][3] * b3;
            matrix[i][4] = matrix[i][4] + ((-1) * matrix[i][3]);
        }
        double b2 = matrix[2][4] / matrix[2][2];
        for (int i = 0; i <= matrix.length - 3; i++) {
            matrix[i][2] = matrix[i][2] * b2;
            matrix[i][4] = matrix[i][4] + ((-1) * matrix[i][2]);
        }
        double b1 = matrix[1][4] / matrix[1][1];
        matrix[0][1] = matrix[0][1] * b1;
        matrix[0][4] = matrix[0][4] + ((-1) * matrix[0][1]);
        double b0 = matrix[0][4] / matrix[0][0];

        //Obtener zk
        double zk = b0 + wk * b1 + xk * b2 + yk * b3;

        //Generar arreglo de resultados finales
        finalResults[0] = numberOfQuadruples;
        finalResults[1] = wk;
        finalResults[2] = xk;
        finalResults[3] = yk;
        finalResults[4] = b0;
        finalResults[5] = b1;
        finalResults[6] = b2;
        finalResults[7] = b3;
        finalResults[8] = zk;
        return finalResults;
    }
}