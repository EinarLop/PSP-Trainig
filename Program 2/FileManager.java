
// Programa 2 Calidad y pruebas de software
// Proposito de la clase: Representación de una clase    
// Einar López Altamirano A01656259
// Fecha de creación: 10/09/2021 
// Última modificación: 13/09/2021

//.b=40
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
//.d=1

public class FileManager {

    public int numberOfFiles;
    public String fileNames[];
    public ArrayList<Collector> collectors = new ArrayList<Collector>();

    // .d=3
    // .i
    // Maneja las entradas escritas por el usuario
    // Parámetros: nada
    // Devuelve: nada
    public void handleUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar la cantidad de archivos");// .m
        numberOfFiles = scanner.nextInt();
        fileNames = new String[numberOfFiles];
        scanner.nextLine();
        System.out.println("Ingresar los nombres de los archivos");// .m
        for (int i = 0; i < numberOfFiles; i++) {
            fileNames[i] = scanner.nextLine();
        }
        scanner.close();
    }

    // .d=1
    // .i
    // Lee cada linea de ArrayList lines de objeto collector
    // Parámetros: index del arreglo filenames
    // Devuelve: nada
    public void fileReader(int index) {
        Collector collector = new Collector();
        Path path = FileSystems.getDefault().getPath(fileNames[index]); // .m
        Charset charset = Charset.forName("UTF-8");
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                collector.lineCollector(line);
            }

        } catch (IOException x) {
            System.out.println("Uno o múltiples de los archivos no existen, por favor intente de nuevo"); // .m
            System.exit(1); // .m
        }

        collector.fileName = fileNames[index];
        int dotIndex = fileNames[index].indexOf(".");
        collector.name = fileNames[index].substring(0, dotIndex);
        collectors.add(collector);
    }

    // .i
    // Control de flujo, llama a fileReader por cada archivo escrito
    // Parámetros: nada
    // Devuelve: Lista de collectors
    public ArrayList<Collector> filesManagement() {
        handleUserInput();
        for (int i = 0; i < fileNames.length; i++) {
            fileReader(i);
        }
        return collectors;
    }

    // .d=9

}