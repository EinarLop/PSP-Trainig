
// Programa 4 Calidad y pruebas de software
// Proposito de la clase: Calcular el valor p acorde al error aceptable
// Einar López Altamirano A01656259
// Fecha de creación: 03/10/2021
// Última modificación: 04/10/2021

public class CalculateP {

    public double evenSum;
    public double oddSum;
    public int segments = 10;
    public double error = 0.0000001;
    public double x;
    public double w;
    public int dof;
    double currentP;
    double futureP;
    DistributionT distributionT;

    CalculateP(int dof, double x) {
        this.dof = dof;
        this.x = x;
        distributionT = new DistributionT(dof);
    }

    // .i
    // Calcula las dos sumatorias de la formula de p
    // Parámetros: segments -> Número de segmentos
    // Regresa: nada
    public void calculateSumP(int segments) {
        w = (double) x / segments;
        evenSum = 0;
        oddSum = 0;

        for (int i = 1; i <= segments - 2; i++) {
            // evenSum = 0;
            if (i % 2 == 0) {
                evenSum = evenSum + (((double) w / 3) * 2 * distributionT.t((double) i * w));
                // System.out.println(evenSum + "at " + i * w);
            }
        }
        for (int i = 1; i <= segments - 1; i++) {
            // oddSum = 0;
            if (!(i % 2 == 0)) {

                oddSum = oddSum + (((double) w / 3) * 4 * distributionT.t((double) i * w));
                // System.out.println(oddSum + "at " + i * w);
            }

        }
        // System.out.println((w / 3) * distributionT.t(0) + "zero");
        // System.out.println((w / 3) * distributionT.t(x) + "->" + x);
        // System.out.println((w / 3) * distributionT.t(0) + evenSum + oddSum + (w / 3)
        // * distributionT.t(x));
    }

    // .i
    // Calcula el valor de p
    // Parámetros: segments -> Número de segmentos
    // Regresa: el valor de p
    public double calculateP(int segments) {
        w = (double) x / segments;
        double p;
        calculateSumP(segments);
        p = (distributionT.t(0) + oddSum + evenSum + distributionT.t(x));
        System.out.println("p" + p);
        return p;
    }

    // .i
    // Realiza la comparación entre Pn y Pn+1 cuando la diferencia es menor al error
    // devuelve Pn+1
    // Parámetros: nada
    // Regresa: el valor final de P
    public double comparePs() {
        currentP = calculateP(segments);
        segments = segments * 2;
        futureP = calculateP(segments);

        while (Math.abs(currentP - futureP) > error) {
            currentP = futureP;
            segments = segments * 2;
            futureP = calculateP(segments);
        }

        return futureP;
    }

}
