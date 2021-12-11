// Programa 5 Calidad y pruebas de software
// Proposito de la clase: Calcular el valor de x en base a un p y un dof
// Einar López Altamirano A01656259
// Fecha de creación: 10/10/2021
// Última modificación: 11/10/2021

//.b=40
import java.lang.Math;

public class CalculateX {
    double x = 1;
    int dof;
    double d = (double) x / 2;
    double error = 0.0000000001;
    double currentP = 2.0;
    double futureP = 1.0;
    String direction;
    CalculateP calculateP;

    CalculateX(int dof) {
        this.dof = dof;
    }

    //.i
    // Calcula el valor de x en base a un p esperado
    // Parámetros: p -> Valor dado por el usuario y usado para determinar el x
    // Regresa: x -> el valor de con el que se obtiene el valor de p correspondiente
    public double x(double p) {
        calculateP = new CalculateP(dof);
        currentP = calculateP.comparePs(x);
        if (currentP < p) {
            x = x + d;
            direction = "left";
        } else {
            x = x - d;
            direction = "right";
        }
        while (Math.abs(futureP - currentP) >= error) {
            calculateP = new CalculateP(dof);
            currentP = calculateP.comparePs(x);
            if (currentP < p && direction == "right") {
                d = (double) d / 2;
                x = x + d;
                direction = "left";
            } else if (currentP > p && direction == "right") {
                x = (double) x - d;
                direction = "right";
            } else if (currentP < p && direction == "left") {
                x = x + d;
                direction = "left";
            } else {
                d = (double) d / 2;
                x = x - d;
                direction = "right";
            }
            futureP = calculateP.comparePs(x);
        }
        return x;
    }

}
