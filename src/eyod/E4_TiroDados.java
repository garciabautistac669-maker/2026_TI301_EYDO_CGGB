package eyod;

import java.util.Random;

/**
 * Ejercicio 7.17 - Tiro de dados.
 * Simula 36,000,000 lanzamientos de dos dados y registra, mediante un
 * arreglo unidimensional (frecuencias[2..12]), el número de veces que
 * ocurre cada suma posible. Los resultados se muestran en formato
 * tabular con la frecuencia relativa de cada suma.
 */

public class E4_TiroDados {

    public static void main(String[] args) {
        Random aleatorio = new Random();
        final long NUM_TIROS = 36_000_000L;

        // Índices 0 y 1 no se usan; las sumas posibles van de 2 a 12.
        long[] frecuencias = new long[13];

        for (long tiro = 0; tiro < NUM_TIROS; tiro++) {
            int dado1 = 1 + aleatorio.nextInt(6);
            int dado2 = 1 + aleatorio.nextInt(6);
            int suma = dado1 + dado2;
            frecuencias[suma]++;
        }

        System.out.println("Suma   Frecuencia   Porcentaje");
        System.out.println("-----------------------------------");
        for (int suma = 2; suma <= 12; suma++) {
            double porcentaje = 100.0 * frecuencias[suma] / NUM_TIROS;
            System.out.printf("%3d    %10d   %6.3f%%%n", suma, frecuencias[suma], porcentaje);
        }
    }
}

