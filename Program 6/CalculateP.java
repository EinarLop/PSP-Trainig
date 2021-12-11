// Programa 4 Calidad y pruebas de software
// Proposito de la clase: Calcular el valor p acorde al error aceptable
// Einar López Altamirano A01656259
// Fecha de creación: 03/10/2021
// Última modificación: 04/10/2021

//.b=39
public class CalculateP {

    public double evenSum;
    public double oddSum;
    public int segments = 1000;
    public double error = 0.00001;
    public double w;
    public int dof;
    double currentP;
    double futureP;
    DistributionT distributionT;

    CalculateP(int dof) {
        this.dof = dof;
        distributionT = new DistributionT(dof);
    }

    //.i
    // Calcula las dos sumatorias de la formula de p
    // Parámetros: segments -> Número de segmentos
    // Regresa: nada
    public void calculateSumP(int segments, double x) {
        w = (double) x / segments;
        evenSum = 0;
        oddSum = 0;

        for (int i = 1; i <= segments - 2; i++) {
            if (i % 2 == 0) {
                evenSum = evenSum + (2 * distributionT.t((double) i * w));
            }
        }
        for (int i = 1; i <= segments - 1; i++) {
            if (!(i % 2 == 0)) {
                oddSum = oddSum + (4 * distributionT.t((double) i * w));
            }
        }
    }

    //.i
    // Calcula el valor de p
    // Parámetros: segments -> Número de segmentos
    // Regresa: el valor de p
    public double calculateP(int segments, double x) {
        w = (double) x / segments;
        double p;
        calculateSumP(segments, x);
        p = (w / 3) * (distributionT.t(0) + oddSum + evenSum + distributionT.t(x));

        return p;
    }

    //.i
    // Realiza la comparación entre Pn y Pn+1 cuando la diferencia es menor al error
    // devuelve Pn+1
    // Parámetros: nada
    // Regresa: el valor final de P
    public double comparePs(double x) {
        currentP = calculateP(segments, x);
        segments = segments * 2;
        futureP = calculateP(segments, x);

        while (Math.abs(currentP - futureP) >= error) {
            currentP = futureP;
            segments = segments * 2;
            futureP = calculateP(segments, x);
        }
        return futureP;
    }

}
