package eyod;

import java.util.Random;

/**
 * Ejercicio 7.25 (incisos a y b, opcionales) — Ocho reinas: métodos de
 * fuerza bruta.
 *
 * Los incisos c) y d) son discusión conceptual (se responden en el
 * reporte): por qué la fuerza bruta exhaustiva es apropiada aquí pero
 * no en el Paseo del caballo, y la comparación entre fuerza bruta
 * aleatoria y exhaustiva.
 */
public class E10_OchoReinasFuerzaBruta {

    private static final int TAM = 8;
    private static final Random ALEATORIO = new Random();

    public static void main(String[] args) {
        // a) Fuerza bruta ALEATORIA: coloca reinas al azar en casillas no
        // atacadas; si se atasca, reinicia desde cero, hasta lograr las 8.
        int[] columnasAleatorio = new int[TAM];
        long intentosAleatorio = resolverAleatorio(columnasAleatorio);
        System.out.println("a) Fuerza bruta aleatoria — solución encontrada tras "
                + intentosAleatorio + " reinicios:");
        mostrarSolucion(columnasAleatorio);

        // b) Fuerza bruta EXHAUSTIVA (backtracking): cuenta TODAS las
        // soluciones posibles del tablero de 8 reinas.
        int[] columnasBacktracking = new int[TAM];
        java.util.List<int[]> soluciones = new java.util.ArrayList<>();
        long inicio = System.nanoTime();
        backtracking(0, columnasBacktracking, soluciones);
        long fin = System.nanoTime();

        System.out.println("\nb) Fuerza bruta exhaustiva (backtracking):");
        System.out.println("Total de soluciones encontradas: " + soluciones.size()
                + " (valor conocido para el tablero de 8 reinas: 92)");
        System.out.printf("Tiempo de cómputo: %.4f s%n", (fin - inicio) / 1_000_000_000.0);
        System.out.println("Primera solución encontrada:");
        mostrarSolucion(soluciones.get(0));
    }

    // ---------------------------------------------------------------
    // a) Fuerza bruta aleatoria
    // ---------------------------------------------------------------

    /** Intenta colocar 8 reinas (una por fila) en columnas aleatorias no atacadas; reinicia si se atasca. */
    private static long resolverAleatorio(int[] columnas) {
        long intentos = 0;
        while (true) {
            intentos++;
            if (intentarColocacionAleatoria(columnas)) {
                return intentos;
            }
        }
    }

    private static boolean intentarColocacionAleatoria(int[] columnas) {
        java.util.Arrays.fill(columnas, -1);
        for (int fila = 0; fila < TAM; fila++) {
            java.util.List<Integer> candidatas = new java.util.ArrayList<>();
            for (int col = 0; col < TAM; col++) {
                if (esSegura(columnas, fila, col)) {
                    candidatas.add(col);
                }
            }
            if (candidatas.isEmpty()) {
                return false; // esta colocación aleatoria se atascó: reiniciar
            }
            columnas[fila] = candidatas.get(ALEATORIO.nextInt(candidatas.size()));
        }
        return true;
    }

    // ---------------------------------------------------------------
    // b) Fuerza bruta exhaustiva (backtracking)
    // ---------------------------------------------------------------

    private static void backtracking(int fila, int[] columnas, java.util.List<int[]> soluciones) {
        if (fila == TAM) {
            soluciones.add(columnas.clone());
            return;
        }
        for (int col = 0; col < TAM; col++) {
            if (esSegura(columnas, fila, col)) {
                columnas[fila] = col;
                backtracking(fila + 1, columnas, soluciones);
            }
        }
    }

    // ---------------------------------------------------------------
    // Utilidades comunes
    // ---------------------------------------------------------------

    /** Verifica que colocar una reina en (fila,col) no ataque a ninguna reina ya colocada en filas previas. */
    private static boolean esSegura(int[] columnas, int fila, int col) {
        for (int f = 0; f < fila; f++) {
            int c = columnas[f];
            if (c == col || Math.abs(c - col) == Math.abs(f - fila)) {
                return false;
            }
        }
        return true;
    }

    private static void mostrarSolucion(int[] columnas) {
        for (int fila = 0; fila < TAM; fila++) {
            for (int col = 0; col < TAM; col++) {
                System.out.print(columnas[fila] == col ? "R " : ". ");
            }
            System.out.println();
        }
    }
}