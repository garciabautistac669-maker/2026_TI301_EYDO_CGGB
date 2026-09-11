package eyod;

import java.util.Random;

/**
 * Ejercicio 7.18 - Juego de Craps.
 * Ejecuta 1,000,000 partidas de Craps y utiliza dos arreglos
 * unidimensionales (juegosGanados y juegosPerdidos, indexados por el
 * número de tiro en el que terminó la partida) para responder:
 *   a) juegos ganados por tiro (1º, 2º, ..., 20º y después)
 *   b) juegos perdidos por tiro (idem)
 *   c) probabilidad de ganar
 *   d) duración promedio de una partida
 *   e) si la probabilidad de ganar mejora con la duración del juego
 */

public class E5_JuegoCraps {

    private static final int NUM_JUEGOS = 1_000_000;
    private static final int TOPE_TIRO = 20; // 1..19 individuales, 20 = "20 y después"

    public static void main(String[] args) {
        Random aleatorio = new Random();

        long[] juegosGanados = new long[TOPE_TIRO + 1];
        long[] juegosPerdidos = new long[TOPE_TIRO + 1];
        long totalTiros = 0;
        long totalGanados = 0;

        for (int partida = 0; partida < NUM_JUEGOS; partida++) {
            int numTiro = 1;
            int suma = tirarDados(aleatorio);
            int punto;

            boolean partidaTerminada = false;
            boolean gano = false;

            if (suma == 7 || suma == 11) {
                gano = true;
                partidaTerminada = true;
            } else if (suma == 2 || suma == 3 || suma == 12) {
                gano = false;
                partidaTerminada = true;
            } else {
                punto = suma;
                while (!partidaTerminada) {
                    numTiro++;
                    suma = tirarDados(aleatorio);
                    if (suma == punto) {
                        gano = true;
                        partidaTerminada = true;
                    } else if (suma == 7) {
                        gano = false;
                        partidaTerminada = true;
                    }
                }
            }

            int indice = Math.min(numTiro, TOPE_TIRO);
            if (gano) {
                juegosGanados[indice]++;
                totalGanados++;
            } else {
                juegosPerdidos[indice]++;
            }
            totalTiros += numTiro;
        }

        System.out.println("a) y b) Juegos ganados / perdidos por número de tiro");
        System.out.println("Tiro   Ganados     Perdidos    Prob. de ganar en ese tiro");
        System.out.println("--------------------------------------------------------");
        for (int tiro = 1; tiro <= TOPE_TIRO; tiro++) {
            String etiqueta = (tiro == TOPE_TIRO) ? "20+" : String.valueOf(tiro);
            long ganadosTiro = juegosGanados[tiro];
            long perdidosTiro = juegosPerdidos[tiro];
            long totalTiroN = ganadosTiro + perdidosTiro;
            double probTiro = (totalTiroN == 0) ? 0.0 : (100.0 * ganadosTiro / totalTiroN);
            System.out.printf("%-5s  %-10d  %-10d  %6.2f%%%n",
                    etiqueta, ganadosTiro, perdidosTiro, probTiro);
        }

        double probabilidadGanar = 100.0 * totalGanados / NUM_JUEGOS;
        double duracionPromedio = (double) totalTiros / NUM_JUEGOS;

        System.out.printf("%nc) Probabilidad global de ganar: %.3f%%%n", probabilidadGanar);
        System.out.printf("d) Duración promedio de una partida: %.3f tiros%n", duracionPromedio);
        System.out.println("e) Ver análisis de la columna 'Prob. de ganar en ese tiro':");
        System.out.println("   la probabilidad condicional de ganar NO aumenta con la duración;");
        System.out.println("   se estabiliza porque, a partir del segundo tiro, el evento");
        System.out.println("   decisivo en cada tiro adicional es siempre 'suma == 7' (pierde)");
        System.out.println("   frente a 'suma == punto' (gana), con probabilidades fijas.");
    }

    private static int tirarDados(Random aleatorio) {
        int dado1 = 1 + aleatorio.nextInt(6);
        int dado2 = 1 + aleatorio.nextInt(6);
        return dado1 + dado2;
    }
}
