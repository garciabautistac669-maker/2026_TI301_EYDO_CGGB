package eyod;

/**
 * Ejercicios 7.22 (incisos b, c y d) y 7.26 (opcionales) — Paseo del
 * caballo mediante la "heurística de accesibilidad".
 *
 * El inciso 7.22 a) es un ejercicio manual en papel (dibujar un
 * tablero e intentar el paseo a mano); se documenta la reflexión sobre
 * ese inciso en el reporte y no se resuelve aquí con código.
 *
 * Movimientos en L definidos exactamente como en el enunciado
 * (horizontal[] y vertical[]).
 */
public class E7_PaseoCaballoHeuristico {

    private static final int TAM = 8;

    private static final int[] horizontal = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private static final int[] vertical   = { -1, -2, -2, -1, 1, 2, 2, 1 };

    public static void main(String[] args) {
        // 7.22 b) el caballo inicia en (0,0); puede parametrizarse.
        int[][] tablero = new int[TAM][TAM];
        int[][] accesibilidad = calcularAccesibilidadInicial();

        int filaActual = 0;
        int columnaActual = 0;
        int numeroMovimiento = 1;
        tablero[filaActual][columnaActual] = numeroMovimiento;
        actualizarAccesibilidad(accesibilidad, tablero, filaActual, columnaActual);

        while (numeroMovimiento < TAM * TAM) {
            int mejorMovimiento = -1;
            int mejorAccesibilidad = Integer.MAX_VALUE;

            for (int m = 0; m < 8; m++) {
                int nf = filaActual + vertical[m];
                int nc = columnaActual + horizontal[m];
                if (!esValido(nf, nc, tablero)) {
                    continue;
                }
                if (accesibilidad[nf][nc] < mejorAccesibilidad) {
                    mejorAccesibilidad = accesibilidad[nf][nc];
                    mejorMovimiento = m;
                } else if (accesibilidad[nf][nc] == mejorAccesibilidad && mejorMovimiento != -1) {
                    // 7.22 d) Desempate: entre candidatos con la misma
                    // accesibilidad, se elige aquel cuyo destino tenga a su
                    // vez el vecino más restringido (se "mira" un movimiento
                    // más adelante), en lugar de tomar el primero encontrado.
                    int nfActual = filaActual + vertical[mejorMovimiento];
                    int ncActual = columnaActual + horizontal[mejorMovimiento];
                    if (menorAccesibilidadDeVecinos(accesibilidad, tablero, nf, nc)
                            < menorAccesibilidadDeVecinos(accesibilidad, tablero, nfActual, ncActual)) {
                        mejorMovimiento = m;
                    }
                }
            }

            if (mejorMovimiento == -1) {
                break; // el caballo se quedó sin movimientos legales
            }

            filaActual += vertical[mejorMovimiento];
            columnaActual += horizontal[mejorMovimiento];
            numeroMovimiento++;
            tablero[filaActual][columnaActual] = numeroMovimiento;
            actualizarAccesibilidad(accesibilidad, tablero, filaActual, columnaActual);
        }

        System.out.println("Movimientos completados: " + numeroMovimiento
                + " de " + (TAM * TAM));
        mostrarTablero(tablero);

        if (numeroMovimiento == TAM * TAM) {
            System.out.println("¡Paseo completo!");
            // 7.26 — Prueba del paseo cerrado
            boolean cerrado = esPaseoCerrado(filaActual, columnaActual);
            System.out.println(cerrado
                    ? "El paseo es CERRADO: existe un movimiento en L desde la "
                      + "posición 64 de regreso a la posición inicial (0,0)."
                    : "El paseo es ABIERTO: no existe un movimiento en L desde "
                      + "la posición 64 de regreso a la posición inicial (0,0).");
        } else {
            System.out.println("El caballo quedó atascado tras " + numeroMovimiento
                    + " movimientos (la heurística no garantiza el éxito).");
        }
    }

    private static boolean esValido(int f, int c, int[][] tablero) {
        return f >= 0 && f < TAM && c >= 0 && c < TAM && tablero[f][c] == 0;
    }

    /** Accesibilidad inicial = cantidad de movimientos en L que caen dentro del tablero. */
    private static int[][] calcularAccesibilidadInicial() {
        int[][] acc = new int[TAM][TAM];
        for (int f = 0; f < TAM; f++) {
            for (int c = 0; c < TAM; c++) {
                int cuenta = 0;
                for (int m = 0; m < 8; m++) {
                    int nf = f + vertical[m];
                    int nc = c + horizontal[m];
                    if (nf >= 0 && nf < TAM && nc >= 0 && nc < TAM) {
                        cuenta++;
                    }
                }
                acc[f][c] = cuenta;
            }
        }
        return acc;
    }

    /** Al ocupar (f,c), cada vecino disponible pierde una forma de ser alcanzado. */
    private static void actualizarAccesibilidad(int[][] acc, int[][] tablero, int f, int c) {
        for (int m = 0; m < 8; m++) {
            int nf = f + vertical[m];
            int nc = c + horizontal[m];
            if (nf >= 0 && nf < TAM && nc >= 0 && nc < TAM && tablero[nf][nc] == 0) {
                acc[nf][nc]--;
            }
        }
    }

    private static int menorAccesibilidadDeVecinos(int[][] acc, int[][] tablero, int f, int c) {
        int menor = Integer.MAX_VALUE;
        for (int m = 0; m < 8; m++) {
            int nf = f + vertical[m];
            int nc = c + horizontal[m];
            if (esValido(nf, nc, tablero)) {
                menor = Math.min(menor, acc[nf][nc]);
            }
        }
        return menor;
    }

    /** 7.26 — el paseo es cerrado si desde la posición final existe un
     *  movimiento en L legítimo de regreso a la posición inicial. */
    private static boolean esPaseoCerrado(int filaFinal, int columnaFinal) {
        for (int m = 0; m < 8; m++) {
            if (filaFinal + vertical[m] == 0 && columnaFinal + horizontal[m] == 0) {
                return true;
            }
        }
        return false;
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