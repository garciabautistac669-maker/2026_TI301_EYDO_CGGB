package eyod;

/**
 * Ejercicio 7.11 - Instrucciones sobre arreglos unidimensionales.
 * a) Asigna cero a los 10 elementos del arreglo cuentas.
 * b) Suma uno a cada uno de los 15 elementos del arreglo bono.
 * c) Imprime los cinco valores de mejoresPuntuaciones en formato de columnas.
 */

public class E3b_OperacionesArreglos {

    public static void main(String[] args) {

        // a) Arreglo cuentas de tipo entero, inicializado en cero
        int[] cuentas = new int[10];
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = 0;
        }

        // b) Arreglo bono de tipo entero; se incrementa cada elemento en uno
        int[] bono = new int[15];
        for (int i = 0; i < bono.length; i++) {
            bono[i] = bono[i] + 1;
        }

        // c) Arreglo mejoresPuntuaciones de tipo entero, impreso en formato de columnas
        int[] mejoresPuntuaciones = {98, 95, 91, 89, 87};
        System.out.println("mejoresPuntuaciones");
        for (int i = 0; i < mejoresPuntuaciones.length; i++) {
            System.out.println(mejoresPuntuaciones[i]);
        }

        // Verificación de los incisos a) y b)
        System.out.println("\ncuentas -> todos en cero:");
        for (int valor : cuentas) {
            System.out.print(valor + " ");
        }
        System.out.println("\nbono -> todos en uno:");
        for (int valor : bono) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }
}

