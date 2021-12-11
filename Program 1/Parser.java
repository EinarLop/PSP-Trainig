
// Programa 1 Calidad y pruebas de software
// Proposito de la clase: Registrar la cantidad de lineas de código, lineas en blanco y lineas de comentario de cada uno de los elementos de un ArrayList  
// Einar López Altamirano A01656259
// Fecha de creación: 28/08/2021 
// Última modificación: 29/08/2021

import java.util.ArrayList;

public class Parser {

    public int comments;
    public int code;
    public int whiteLines;

    //.i
    // Registra cantidad de lineas de comentarios,vacias y de código
    // Parámetros: lines = ArrayList con todas las lineas de código
    // Devuelve: nada
    public void lineParser(ArrayList<String> lines) {
        Boolean multilineComment = false;

        for (int i = 0; i < lines.size(); i++) {
            String currentLine = lines.get(i);
            String tempCurrentLine = currentLine;
            if (currentLine.contains("//")) {
                comments++;
            } else if (currentLine.contains("/*")) {
                comments++;
                multilineComment = true;
            } else if (currentLine.contains("*/") && multilineComment == true) {
                comments++;
                multilineComment = false;
            } else if (multilineComment) {
                comments++;

            } else if (tempCurrentLine.replaceAll("\\s+", "").isEmpty()) {
                whiteLines++;
            } else {
                code++;
            }
        }
    }
}
