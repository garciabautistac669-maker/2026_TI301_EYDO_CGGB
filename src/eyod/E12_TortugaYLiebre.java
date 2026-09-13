package eyod;

import java.util.Random;

/**
 * Ejercicio 7.28 (opcional) — Simulación: la tortuga y la liebre.
 * Recrea la carrera clásica sobre una pista de 70 posiciones, siguiendo
 * las reglas de movimiento de la figura 7.32.
 */
public class E12_TortugaYLiebre {

    private static final int META = 70;
    private static final Random ALEATORIO = new Random();

    public static void main(String[] args) {
        int posicionTortuga = 1;
        int posicionLiebre = 1;

        System.out.println("PUM !!!!!");
        System.out.println("Y ARRANCAN !!!!!");

        int tic = 0;
        while (posicionTortuga < META && posicionLiebre < META) {
            tic++;
            posicionTortuga = moverTortuga(posicionTortuga);
            posicionLiebre = moverLiebre(posicionLiebre);

            imprimirLinea(posicionTortuga, posicionLiebre);

            if (posicionTortuga >= META && posicionLiebre >= META) {
                System.out.println("Es un empate");
            } else if (posicionTortuga >= META) {
                System.out.println("LA TORTUGA GANA !!! YAY !!!");
            } else if (posicionLiebre >= META) {
                System.out.println("La liebre gana. Que mal.");
            }
        }

        System.out.println("La carrera terminó en el tic tac número " + tic + ".");
    }

    private static int moverTortuga(int posicion) {
        int i = 1 + ALEATORIO.nextInt(10); // entero aleatorio 1 <= i <= 10

        if (i >= 1 && i <= 5) {
            posicion += 3; // paso pesado rápido: 50%
        } else if (i >= 6 && i <= 7) {
            posicion -= 6; // resbalón: 20%
        } else { // 8 <= i <= 10
            posicion += 1; // paso pesado lento: 30%
        }

        return corregirLimiteInferior(posicion);
    }

    private static int moverLiebre(int posicion) {
        int i = 1 + ALEATORIO.nextInt(10); // entero aleatorio 1 <= i <= 10

        if (i >= 1 && i <= 2) {
            // dormir: 20% — ningún movimiento
        } else if (i >= 3 && i <= 4) {
            posicion += 9; // gran salto: 20%
        } else if (i == 5) {
            posicion -= 12; // gran resbalón: 10%
        } else if (i >= 6 && i <= 8) {
            posicion += 1; // pequeño salto: 30%
        } else { // 9 <= i <= 10
            posicion -= 2; // pequeño resbalón: 20%
        }

        return corregirLimiteInferior(posicion);
    }

    /** Si un animal resbala antes de la posición 1, regresa a la posición 1 ("puerta de inicio"). */
    private static int corregirLimiteInferior(int posicion) {
        return Math.max(posicion, 1);
    }

    private static void imprimirLinea(int posicionTortuga, int posicionLiebre) {
        StringBuilder linea = new StringBuilder();
        for (int columna = 1; columna <= META; columna++) {
            boolean tortugaAqui = (columna == posicionTortuga);
            boolean liebreAqui = (columna == posicionLiebre);

            if (tortugaAqui && liebreAqui) {
                linea.append("OUCH!!!");
            } else if (tortugaAqui) {
                linea.append('T');
            } else if (liebreAqui) {
                linea.append('H');
            } else {
                linea.append(' ');
            }
        }
        System.out.println(linea);
    }
}

