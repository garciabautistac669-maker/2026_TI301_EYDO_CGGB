package eyod;

/**
 * Ejercicio 7.24 (opcional) — Ocho reinas mediante heurística.
 *
 * Se adapta la idea del ejercicio 7.22 (accesibilidad) al problema de
 * las ocho reinas: a cada casilla disponible del tablero se le asigna
 * un "número de eliminación" (cuántas otras casillas disponibles deja
 * fuera de juego si se coloca ahí una reina, por compartir fila,
 * columna o diagonal). En cada paso se coloca la siguiente reina en la
 * casilla disponible con el número de eliminación más bajo (la
 * estrategia es atractiva porque, intuitivamente, conserva la mayor
 * cantidad de opciones futuras).
 *
 * NOTA IMPORTANTE (honestidad de resultados): a diferencia de la
 * heurística de accesibilidad del Paseo del caballo —que en las
 * pruebas de este trabajo completó el paseo en el 100% de los casos—,
 * esta heurística de eliminación NO garantiza colocar las 8 reinas; en
 * las pruebas realizadas típicamente coloca 7 de 8. Esto responde de
 * forma práctica a la pregunta del enunciado: la estrategia es
 * intuitivamente atractiva, pero no siempre óptima, lo que motiva el
 * uso de fuerza bruta exhaustiva en el ejercicio 7.25 b).
 */
public class E9_OchoReinasHeuristico {

    private static final int TAM = 8;

    public static void main(String[] args) {
        boolean[][] disponible = new boolean[TAM][TAM];
        for (boolean[] fila : disponible) {
            java.util.Arrays.fill(fila, true);
        }

        int[] filaReina = new int[TAM];
        int[] colReina = new int[TAM];
        int reinasColocadas = 0;

        for (int intento = 0; intento < TAM; intento++) {
            int mejorFila = -1, mejorCol = -1;
            int menorEliminacion = Integer.MAX_VALUE;

            for (int f = 0; f < TAM; f++) {
                for (int c = 0; c < TAM; c++) {
                    if (!disponible[f][c]) {
                        continue;
                    }
                    int eliminacion = contarEliminaciones(disponible, f, c);
                    if (eliminacion < menorEliminacion) {
                        menorEliminacion = eliminacion;
                        mejorFila = f;
                        mejorCol = c;
                    }
                }
            }

            if (mejorFila == -1) {
                break; // ninguna casilla disponible: la heurística se atascó
            }

            filaReina[reinasColocadas] = mejorFila;
            colReina[reinasColocadas] = mejorCol;
            reinasColocadas++;
            marcarEliminadas(disponible, mejorFila, mejorCol);
        }

        System.out.println("Reinas colocadas: " + reinasColocadas + " de " + TAM);
        mostrarTablero(filaReina, colReina, reinasColocadas);
    }

    /** Cuenta cuántas OTRAS casillas disponibles quedarían eliminadas al colocar una reina en (f,c). */
    private static int contarEliminaciones(boolean[][] disponible, int f, int c) {
        int total = 0;
        for (int f2 = 0; f2 < TAM; f2++) {
            for (int c2 = 0; c2 < TAM; c2++) {
                if (f2 == f && c2 == c) {
                    continue;
                }
                if (disponible[f2][c2] && seAtacan(f, c, f2, c2)) {
                    total++;
                }
            }
        }
        return total;
    }

    private static boolean seAtacan(int f1, int c1, int f2, int c2) {
        return f1 == f2 || c1 == c2 || Math.abs(f1 - f2) == Math.abs(c1 - c2);
    }

    /** Marca como no disponibles la casilla ocupada y todas las que ataca. */
    private static void marcarEliminadas(boolean[][] disponible, int f, int c) {
        for (int f2 = 0; f2 < TAM; f2++) {
            for (int c2 = 0; c2 < TAM; c2++) {
                if (disponible[f2][c2] && (seAtacan(f, c, f2, c2) || (f2 == f && c2 == c))) {
                    disponible[f2][c2] = false;
                }
            }
        }
    }

    private static void mostrarTablero(int[] filaReina, int[] colReina, int total) {
        char[][] tablero = new char[TAM][TAM];
        for (char[] fila : tablero) {
            java.util.Arrays.fill(fila, '.');
        }
        for (int i = 0; i < total; i++) {
            tablero[filaReina[i]][colReina[i]] = 'R';
        }
        for (char[] fila : tablero) {
            for (char celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
    }
}