// Programa 3 Calidad y pruebas de software
// Proposito de la clase: Leer el input del usuario y leer el archivo corresponidente 
// Einar López Altamirano A01656259
// Fecha de creación: 18/09/2021 
// Última modificación: 19/09/2021

//.b=34
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager { //.m

    ArrayList<String> lines = new ArrayList<String>();

    //.i
    // Lectura del input del usuario, lectura linea por linea del archivo y manejo
    // de exepciones
    // Parámetros: nada
    // Regresa: Arraylist con todas las lineas del archivo
    public ArrayList<String> lineReader() throws Exception { //.m
        //.d=3
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
                lines.add(line); //.m
            }

        } catch (IOException x) {
            System.out.println("El archivo seleccionado no existe, por favor intente con otro"); //.m
            System.exit(0); //.m
        }

        //.d=1
        try {
            if (lines.size() == 0) { //.m
                throw new EOFException();
            }
        } catch (EOFException x) {
            System.out.println("El archivo seleccionado está vacío, por favor intente con otro"); //.m
            System.exit(0); // .m
        }
        //.d=1
        return lines;
    }
}
