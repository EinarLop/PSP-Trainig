import java.util.ArrayList;

class Main {
    //.i
    //Control de flujo del programa
    //Parámetros: nada
    //Devuelve: nada
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<String>();
        FileManager fileManager = new FileManager();
        lines = fileManager.lineReader();
        BasicOperations basicOperations = new BasicOperations(lines);
        double basicOperationsResults[];
        basicOperationsResults = basicOperations.setupResult();
        MultipleRegression multipleRegression = new MultipleRegression(basicOperationsResults);
        double[] multipleRegressionResults = multipleRegression.setupResults();
        int n = (int) multipleRegressionResults[0];
        double wk = multipleRegressionResults[1];
        double xk = multipleRegressionResults[2];
        double yk = multipleRegressionResults[3];
        double b0 = multipleRegressionResults[4];
        double b1 = multipleRegressionResults[5];
        double b2 = multipleRegressionResults[6];
        double b3 = multipleRegressionResults[7];
        double zk = multipleRegressionResults[8];
        Printer printer = new Printer();
        printer.printToConsole(n, wk, xk, yk, b0, b1, b2, b3, zk);
    }
}
