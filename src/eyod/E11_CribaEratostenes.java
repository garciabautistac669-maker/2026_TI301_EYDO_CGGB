package eyod;

/**
 * Ejercicio 7.27 (opcional) — La Criba de Eratóstenes.
 * Determina e imprime los números primos entre 2 y 999 utilizando un
 * arreglo de 1,000 elementos del tipo primitivo boolean.
 */
public class E11_CribaEratostenes {

    public static void main(String[] args) {
        final int LIMITE = 1000;
        boolean[] esPrimo = new boolean[LIMITE];

        // a) Arreglo booleano con todos los elementos inicializados en true.
        java.util.Arrays.fill(esPrimo, true);
        esPrimo[0] = false; // se ignoran los índices 0 y 1
        esPrimo[1] = false;

        // b) Se marca como false a todo múltiplo de cada índice que aún sea true.
        for (int indice = 2; indice < LIMITE; indice++) {
            if (esPrimo[indice]) {
                for (int multiplo = indice + indice; multiplo < LIMITE; multiplo += indice) {
                    esPrimo[multiplo] = false;
                }
            }
        }

        System.out.println("Números primos entre 2 y 999:");
        int contador = 0;
        for (int i = 2; i < LIMITE; i++) {
            if (esPrimo[i]) {
                System.out.printf("%5d", i);
                contador++;
                if (contador % 10 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println();
        System.out.println("\nTotal de números primos encontrados: " + contador);
    }
}