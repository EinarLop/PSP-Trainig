
// Programa 1 Calidad y pruebas de software
// Proposito de la clase: Imprimir a consola con formato correcto cantidad de lineas de comentarios,vacias y de código
// Einar López Altamirano A01656259
// Fecha de creación: 28/08/2021 
// Última modificación: 29/08/2021

public class Printer {
    //.i
    // Imprimir a consola con formato correcto cantidad de lineas de
    // comentarios,vacias y de código
    // Parámetros:
    // filename = nombre del archivo,
    // code = número de lineas de código
    // whiteLines = número de lineas en blanco
    // Devuelve: nada
    public void printFormatt(String filename, int code, int comments, int whiteLines) {
        System.out.println("Nombre del archivo: " + filename);
        System.out.println("--------------------------------------------");
        System.out.println("Cantidad de líneas en blanco: " + whiteLines);
        System.out.println("Cantidad de líneas con comentarios: " + comments);
        System.out.println("Cantidad de líneas con código:" + code);
        System.out.println("--------------------------------------------");
        System.out.println("Cantidad total de líneas: " + (code + comments + whiteLines));

    }

}
