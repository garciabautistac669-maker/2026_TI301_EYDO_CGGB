/*
* ITESS TICS 2026
* Agosto-Diciembre 2026
* Estructura y Organización de Datos
* Tema 2: Estructuras Lineal
* Docente: Francisco Javier Montesillo Puente
* Descripción: Pueba de collection usando List, ArrayList, Iteradores y algunos metodos 
* Programador: CGGB
* Fecha: 01/Octubre/2026 
*/

// Compilación y ejecución
// Pompilar: javac ED1_CollectionTest.java
// Ejecutar: java ED1_CollectionTest

// package e01_collectiontest;

// Librerias o paquetes
import java.util.List;       // Importa la interfaz List           
import java.util.ArrayList;  // Importa la clase ArrayList
import java.util.Collection; // Importa la interfaz Collection
import java.util.Iterator;   // Importa la interfaz Iterator

public class E01_CollectionTest { 

    public static void main(String[] args) {

        // Arreglo de colores a agregar a la lista
        String[] colors = {"MAGENTA", "RED", "WHITE", "BLUE", "CYAN"};
        List<String> list = new ArrayList<>();

        // Agrega los colores del arreglo a la lista
        for (String color : colors) {
            list.add(color);
        }

        // Arreglo de colores que se van a eliminar
        String[] removeColors = {"RED", "WHITE", "BLUE"};
        List<String> removeList = new ArrayList<>();

        // Agrega los colores a eliminar a removeList
        for (String color : removeColors) {
            removeList.add(color);
        }

        // Muestra la lista original
        System.out.println("ArrayList: ");
        for (int count = 0; count < list.size(); count++) {
            System.out.printf("%s ", list.get(count));
        }

        // Elimina de 'list' todos los colores que están en 'removeList'
        removeColors(list, removeList);

        // Muestra la lista después de eliminar
        System.out.printf("%n%nArrayList after calling removeColors:%n");
        for (String color : list) {
            System.out.printf("%s ", color);
        }
    } 

    // Método que elimina de collection1 todos los elementos que están en collection2
    private static void removeColors(Collection<String> collection1,
                                     Collection<String> collection2) {

        Iterator<String> iterator = collection1.iterator();

        while (iterator.hasNext()) {
            if (collection2.contains(iterator.next())) {
                iterator.remove(); // elimina el elemento actual de forma segura
            }
        }
    } 

} 