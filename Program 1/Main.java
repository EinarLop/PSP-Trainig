
// Programa 1 Calidad y pruebas de software
// Indetificar la cantidad de lineas de código, lineas en blanco y lineas de comentario en un archivo de código  
// Einar López Altamirano A01656259
// Fecha de creación: 28/08/2021 
// Última modificación: 29/08/2021
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;

public class Main {


    //.i
    public static void main(String[] args) throws Exception {

        // Inicialización de objetos
        Collector collector = new Collector();
        Parser parser = new Parser();
        Printer printer = new Printer();
        // Lógica para leer input de usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingrese el nombre del archivo a analizar");
        String nameOfFile = scanner.nextLine();
        scanner.close();
        // Apertura y lectura de archivo
        Path path = FileSystems.getDefault().getPath(nameOfFile);
        Charset charset = Charset.forName("UTF-8");
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                collector.lineCollector(line);
            }

        } catch (IOException x) {
            System.out.println("El archivo no existe, por favor intente con otro archivo");
            return;
        }
        // Análisis de archivo
        parser.lineParser(collector.lines);

        try {
            if ((parser.code + parser.comments + parser.whiteLines) == 0) {
                throw new EOFException();
            }
        } catch (EOFException x) {
            System.out.println("El archivo esta vacío, por favor intente de nuevo con otro archivo");
            return;
        }
        // Impresión de datos
        printer.printFormatt(nameOfFile, parser.code, parser.comments, parser.whiteLines);

    }
}
