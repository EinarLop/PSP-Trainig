
// Programa 2 Calidad y pruebas de software
// Analizar uno o múltiples clases y determinar la cantidad de lineas totales, base, añadidad, modificadas y borradas  
// Einar López Altamirano A01656259
// Fecha de creación: 10/09/2021 
// Última modificación: 13/09/2021

import java.util.ArrayList;

public class Main {

    public static ArrayList<Collector> collectors = new ArrayList<Collector>();
    public static ArrayList<Collector> mergedCollectors = new ArrayList<Collector>();

    //.i
    // Control de flujo del programa
    public static void main(String[] args) {

        FileManager filemanager = new FileManager();
        Parser parser = new Parser();
        collectors = filemanager.filesManagement();

        DataMerger dataMerger = new DataMerger();
        Printer printer = new Printer();

        for (int i = 0; i < collectors.size(); i++) {
            int parsedValues[] = new int[6];
            Collector currentCollector = collectors.get(i);
            parsedValues = parser.lineParser(currentCollector.lines);
            currentCollector.total = parsedValues[0];
            currentCollector.items = parsedValues[1];
            currentCollector.base = parsedValues[2];
            currentCollector.deleted = parsedValues[3];
            currentCollector.modified = parsedValues[4];
            currentCollector.added = parsedValues[5];

        }
        mergedCollectors = dataMerger.sameClassMerger(collectors);
        printer.printToConsole(mergedCollectors);
        printer.printToFile(mergedCollectors);
    }
}