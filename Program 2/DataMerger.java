
// Programa 2 Calidad y pruebas de software
// Proposito de la clase: Sumar los valores de las clases con los mismos nombres    
// Einar López Altamirano A01656259
// Fecha de creación: 10/09/2021 
// Última modificación: 13/09/2021

import java.util.ArrayList;

public class DataMerger {
    //.i
    // Algoritmo para juntar las clases con el mismo nombre
    // Parámetros: collectors = arraylist con collectors 
    // Devuelve: collectors = arraylist con collectors fusionados
    public ArrayList<Collector> sameClassMerger(ArrayList<Collector> collectors) {
        for (int i = 0; i < collectors.size(); i++) {
            classIdentifier(collectors.get(i));
            for (int j = 0; j < collectors.size(); j++) {
                if (collectors.get(i).name.equals(collectors.get(j).name)
                        && !collectors.get(i).fileName.equals(collectors.get(j).fileName)) {
                    dataMerger(collectors.get(i), collectors.get(j));
                    collectors.remove(j);
                }
            }
        }
        return collectors;
    }

    //.i
    // Suma de los valores de dos collectors con el mismo nombre
    // Parámetros: collectorOne = primer collector a fusionar, collectorTwo = segundo collector a fusionar
    // Devuelve: nada
    public void dataMerger(Collector collectorOne, Collector collectorTwo) {
        collectorOne.total += collectorTwo.total;
        collectorOne.items += collectorTwo.items;
        collectorOne.base += collectorTwo.base;
        collectorOne.deleted += collectorTwo.deleted;
        collectorOne.modified += collectorTwo.modified;
        collectorOne.added += collectorTwo.added;
    }

    //.i
    // Asigna el tipo de clase a cada collector en base a los valores de sus atributos
    // Parámetros: collector = clase a evaluar
    // Devuelve: nada
    public void classIdentifier(Collector collector) {
        if (collector.base > 0 && (collector.modified > 0 || collector.deleted > 0 || collector.added > 0)) {
            collector.classType = "Base";
        } else if (collector.base == 0 && collector.modified == 0 && collector.deleted == 0 && collector.added > 0) {
            collector.classType = "Nueva";
        } else if (collector.base > 0 && collector.modified == 0 && collector.deleted == 0 && collector.added == 0) {
            collector.classType = "Reusada";
        }
    }

}
