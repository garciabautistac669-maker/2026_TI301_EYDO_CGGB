package eyod;

import java.util.Random;

/**
 * Ejercicio 7.23 (incisos a, b y c, opcionales) — Paseo del caballo:
 * métodos de fuerza bruta.
 *
 * El inciso d) es una discusión conceptual (se responde en el reporte,
 * no en código): compara la fuerza bruta aleatoria contra la
 * heurística de accesibilidad de E7_PaseoCaballoHeuristico.
 */
public class E8_PaseoCaballoFuerzaBruta {

    private static final int TAM = 8;
    private static final int[] horizontal = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private static final int[] vertical   = { -1, -2, -2, -1, 1, 2, 2, 1 };
    private static final Random ALEATORIO = new Random();

    public static void main(String[] args) {
        // a) Un solo paseo aleatorio, mostrando el tablero final.
        int[][] tableroFinal = new int[TAM][TAM];
        int longitud = intentarPaseoAleatorio(tableroFinal);
        System.out.println("a) Paseo aleatorio único — longitud alcanzada: " + longitud);
        mostrarTablero(tableroFinal);

        // b) 1,000 paseos; tabla de frecuencias por longitud alcanzada.
        System.out.println("\nb) Distribución de longitudes en 1,000 paseos aleatorios:");
        int[] frecuenciaPorLongitud = new int[TAM * TAM + 1];
        int mejorLongitud = 0;
        for (int intento = 0; intento < 1000; intento++) {
            int[][] tableroTemp = new int[TAM][TAM];
            int len = intentarPaseoAleatorio(tableroTemp);
            frecuenciaPorLongitud[len]++;
            mejorLongitud = Math.max(mejorLongitud, len);
        }
        System.out.println("Longitud   Frecuencia");
        for (int len = 1; len <= TAM * TAM; len++) {
            if (frecuenciaPorLongitud[len] > 0) {
                System.out.printf("%6d     %6d%n", len, frecuenciaPorLongitud[len]);
            }
        }
        System.out.println("Mejor resultado de la muestra: " + mejorLongitud + " movimientos.");

        // c) Repetir hasta lograr un paseo completo (con tope de seguridad
        //    para no ejecutar horas en este entorno de pruebas).
        final int TOPE_INTENTOS = 2_000_000;
        System.out.println("\nc) Reintentando hasta lograr un paseo completo "
                + "(tope de seguridad: " + TOPE_INTENTOS + " intentos)...");
        long inicio = System.nanoTime();
        int intentos = 0;
        int[] frecuenciaAcumulada = new int[TAM * TAM + 1];
        int[][] tableroCompleto = null;
        while (intentos < TOPE_INTENTOS) {
            intentos++;
            int[][] tableroTemp = new int[TAM][TAM];
            int len = intentarPaseoAleatorio(tableroTemp);
            frecuenciaAcumulada[len]++;
            if (len == TAM * TAM) {
                tableroCompleto = tableroTemp;
                break;
            }
        }
        long finTiempo = System.nanoTime();
        double segundos = (finTiempo - inicio) / 1_000_000_000.0;

        if (tableroCompleto != null) {
            System.out.println("Paseo completo logrado tras " + intentos + " intentos, en "
                    + String.format("%.3f", segundos) + " s.");
            mostrarTablero(tableroCompleto);
        } else {
            System.out.println("No se logró un paseo completo dentro del tope de "
                    + TOPE_INTENTOS + " intentos (" + String.format("%.3f", segundos)
                    + " s). Esto ilustra por qué la fuerza bruta aleatoria puede "
                    + "requerir un tiempo de ejecución muy alto.");
        }
    }

    /** Ejecuta un paseo aleatorio desde (0,0) y regresa el número de movimientos logrados. */
    private static int intentarPaseoAleatorio(int[][] tablero) {
        int fila = 0;
        int columna = 0;
        int numeroMovimiento = 1;
        tablero[fila][columna] = numeroMovimiento;

        while (numeroMovimiento < TAM * TAM) {
            int[] candidatos = movimientosLegales(fila, columna, tablero);
            if (candidatos.length == 0) {
                break;
            }
            int elegido = candidatos[ALEATORIO.nextInt(candidatos.length)];
            fila += vertical[elegido];
            columna += horizontal[elegido];
            numeroMovimiento++;
            tablero[fila][columna] = numeroMovimiento;
        }
        return numeroMovimiento;
    }

    private static int[] movimientosLegales(int fila, int columna, int[][] tablero) {
        int[] temp = new int[8];
        int total = 0;
        for (int m = 0; m < 8; m++) {
            int nf = fila + vertical[m];
            int nc = columna + horizontal[m];
            if (nf >= 0 && nf < TAM && nc >= 0 && nc < TAM && tablero[nf][nc] == 0) {
                temp[total++] = m;
            }
        }
        int[] resultado = new int[total];
        System.arraycopy(temp, 0, resultado, 0, total);
        return resultado;
    }

    private static void mostrarTablero(int[][] tablero) {
        for (int[] fila : tablero) {
            for (int valor : fila) {
                System.out.printf("%3d", valor);
            }
            System.out.println();
        }
    }
}