package eyod;

import eyod.ScoreBoardApp.FastReader;

/**
 * Ejercicio 7.21 (opcional) — Gráficos de tortuga.
 * Simula el concepto de gráficos de tortuga del lenguaje Logo sobre un
 * "piso" de 20 por 20 (arreglo bidimensional inicializado en cero),
 * leyendo los comandos de la figura 7.29 con la plantilla FastReader
 * hasta encontrar el centinela 9.
 *
 * Supuesto de diseño: el enunciado no especifica la dirección inicial
 * de desplazamiento (solo indica que el bolígrafo inicia arriba); se
 * asume que la tortuga inicia mirando hacia la derecha, en la posición
 * (0,0) del piso.
 */
public class E6_GraficosTortuga {

    private static final int TAM = 20;

    // Direcciones en sentido horario: 0=arriba, 1=derecha, 2=abajo, 3=izquierda
    private static final int[] dFila = {-1, 0, 1, 0};
    private static final int[] dCol  = {0, 1, 0, -1};

    public static void main(String[] args) {
        int[][] piso = new int[TAM][TAM];

        int filaActual = 0;
        int columnaActual = 0;
        boolean boligrafoAbajo = false; // el bolígrafo inicia arriba
        int direccion = 1;              // inicia mirando a la derecha

        FastReader lector = new FastReader();
        boolean fin = false;

        while (!fin) {
            int comando = lector.nextInt();
            switch (comando) {
                case 1: // bolígrafo arriba
                    boligrafoAbajo = false;
                    break;
                case 2: // bolígrafo abajo
                    boligrafoAbajo = true;
                    break;
                case 3: // voltear a la derecha
                    direccion = (direccion + 1) % 4;
                    break;
                case 4: // voltear a la izquierda
                    direccion = (direccion + 3) % 4;
                    break;
                case 5: // avanzar N espacios; N viene en el siguiente token
                    int espacios = lector.nextInt();
                    for (int paso = 0; paso < espacios; paso++) {
                        int nuevaFila = filaActual + dFila[direccion];
                        int nuevaCol = columnaActual + dCol[direccion];
                        if (nuevaFila < 0 || nuevaFila >= TAM || nuevaCol < 0 || nuevaCol >= TAM) {
                            break; // no se permite salir del piso
                        }
                        filaActual = nuevaFila;
                        columnaActual = nuevaCol;
                        if (boligrafoAbajo) {
                            piso[filaActual][columnaActual] = 1;
                        }
                    }
                    break;
                case 6: // mostrar el arreglo de 20 por 20
                    mostrarPiso(piso);
                    break;
                case 9: // fin de los datos (centinela)
                    fin = true;
                    break;
                default:
                    System.out.println("Comando desconocido: " + comando);
            }
        }
    }

    private static void mostrarPiso(int[][] piso) {
        for (int[] fila : piso) {
            for (int celda : fila) {
                System.out.print(celda == 1 ? "*" : " ");
            }
            System.out.println();
        }
    }
}