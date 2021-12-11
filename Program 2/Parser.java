
// Programa 2 Calidad y pruebas de software
// Proposito de la clase: Categorizar cada elementos (linea) de un ArrayList en item, base, borradas, modificadas y añadidas.  
// Einar López Altamirano A01656259
// Fecha de creación: 10/09/2021 
// Última modificación: 13/09/2021
import java.util.ArrayList;

//.b=23
public class Parser {
    int code;
    int noCode;
    //.d=3

    //.i
    // Registra cantidad de lineas item, base, borradas, modificadas y añadidas
    // Parámetros: lines = ArrayList con las lineas de código
    // Devuelve: parsedValues = Arreglo con valores [0] totales, [1] items, [2] base, [3] borradas, [4] modificadas, [5] añadidas
    public int[] lineParser(ArrayList<String> lines) { //.m
        Boolean multilineComment = false;
        int parsedValues[] = new int[6]; 

        for (int i = 0; i < lines.size(); i++) {
            String currentLine = lines.get(i);
            String tempCurrentLine = currentLine;
            tempCurrentLine = tempCurrentLine.replaceAll("\\s+", "");

            if (tempCurrentLine.contains("//.m") && tempCurrentLine.indexOf("//.m") + 4 == tempCurrentLine.length()) {
                parsedValues[4]++;
                code++;
            }
            else if (tempCurrentLine.contains("//.i")
                    && tempCurrentLine.indexOf("//.i") + 4 == tempCurrentLine.length()) {
                parsedValues[1]++;
            }
            else if (tempCurrentLine.contains("//.b=")) {
                parsedValues[2] = parsedValues[2] + Integer.parseInt(tempCurrentLine.substring(5));
            }
            else if (tempCurrentLine.contains("//.d=")) {
                parsedValues[3] = parsedValues[3] + Integer.parseInt(tempCurrentLine.substring(5));
            } else if (currentLine.contains("//") && tempCurrentLine.indexOf("//") == 0) { //.m
                noCode++; //.m
            } else if (currentLine.contains("/*") && currentLine.contains("*/")) {
                noCode++;
            } else if (currentLine.contains("/*")) {
                noCode++;//.m
                multilineComment = true;
            } else if (currentLine.contains("*/") && multilineComment == true) {
                noCode++;//.m
                multilineComment = false;
            } else if (multilineComment) {
                noCode++;//.m

            } else if (tempCurrentLine.isEmpty()) { //.m
                noCode++; //.m
            } else if (tempCurrentLine.equals("{") || tempCurrentLine.equals("}") || tempCurrentLine.equals("};")) {
                noCode++; //.m
            } else {
                code++;
            }
            //.d=3
            parsedValues[0] = code;
            parsedValues[5] = parsedValues[0] - parsedValues[2] + parsedValues[3];

        }
        code = 0;
        return parsedValues;
    }
}
