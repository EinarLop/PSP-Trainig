
// Programa 2 Calidad y pruebas de software
// Proposito de la clase: Representación de una clase    
// Einar López Altamirano A01656259
// Fecha de creación: 10/09/2021 
// Última modificación: 13/09/2021
import java.util.ArrayList;

//.b=5
public class Collector {

    public ArrayList<String> lines = new ArrayList<String>();
    public String fileName;
    public String name;
    public int total, items, base, deleted, modified, added;
    public String classType;

    // .i
    // Añade lineas de código a el Arraylist lines
    // Parámetros: line = linea de código que será agregada a Arraylist
    // Devuelve: nada
    public void lineCollector(String line) {
        lines.add(line);
    }
}
