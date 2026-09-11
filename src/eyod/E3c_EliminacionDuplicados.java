package eyod;

import java.util.Scanner;

/**
 * Ejercicio 7.12 - Eliminación de duplicados.
 * Lee cinco números enteros en el rango [10, 100]. Antes de almacenar
 * cada número verifica, mediante búsqueda lineal, si ya fue leído; en
 * ese caso lo descarta. Se utiliza el arreglo más pequeño posible
 * (tamaño 5, el "peor caso" en el que los cinco valores son distintos).
 * Tras cada lectura se muestra el conjunto de valores únicos acumulados.
 */

public class E3c_EliminacionDuplicados {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        final int CANTIDAD_LECTURAS = 5;
        int[] unicos = new int[CANTIDAD_LECTURAS]; // peor caso: 5 valores distintos
        int totalUnicos = 0;

        for (int i = 0; i < CANTIDAD_LECTURAS; i++) {
            int numero;
            do {
                System.out.print("Introduzca un número entre 10 y 100: ");
                numero = entrada.nextInt();
            } while (numero < 10 || numero > 100);

            if (!yaExiste(unicos, totalUnicos, numero)) {
                unicos[totalUnicos] = numero;
                totalUnicos++;
            } else {
                System.out.println("Valor duplicado, se descarta: " + numero);
            }

            mostrarConjunto(unicos, totalUnicos);
        }
    }

    /** Búsqueda lineal para detectar si el valor ya fue registrado. */
    private static boolean yaExiste(int[] unicos, int totalUnicos, int valor) {
        for (int i = 0; i < totalUnicos; i++) {
            if (unicos[i] == valor) {
                return true;
            }
        }
        return false;
    }

    private static void mostrarConjunto(int[] unicos, int totalUnicos) {
        System.out.print("Conjunto actual de valores únicos: {");
        for (int i = 0; i < totalUnicos; i++) {
            System.out.print(unicos[i]);
            if (i < totalUnicos - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}

