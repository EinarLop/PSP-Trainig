
// Programa 1 Calidad y pruebas de software
// Proposito de la clase: Agregar lineas de código a ArrayList  
// Einar López Altamirano A01656259
// Fecha de creación: 28/08/2021 
// Última modificación: 29/08/2021
import java.util.ArrayList;

public class Collector {
    //.i
    ArrayList<String> lines = new ArrayList<String>();

    // Añade lineas de código a el Arraylist lines
    // Parámetros: line = linea de código que será agregada a Arraylist
    // Devuelve: nada
    public void lineCollector(String line) {
        lines.add(line);
    }
}
