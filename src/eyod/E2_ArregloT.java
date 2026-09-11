package eyod;

import java.util.Scanner;

/**
 * Ejercicio 7.9 - Operaciones sobre un arreglo bidimensional entero t (2 x 3).
 * Cada inciso del enunciado se resuelve en un método independiente para
 * mantener trazabilidad con la numeración original (a-n).
 */
public class E2_ArregloT {

    public static void main(String[] args) {

        // a) Declaración y creación de t
        int[][] t = new int[2][3];

        System.out.println("b) Filas: " + t.length);
        System.out.println("c) Columnas: " + t[0].length);

        int totalElementos = 0;
        for (int fila = 0; fila < t.length; fila++) {
            totalElementos += t[fila].length;
        }
        System.out.println("d) Elementos totales: " + totalElementos);

        // e) Acceso a todos los elementos de la fila 1
        System.out.println("e) Elementos de la fila 1: "
                + t[1][0] + ", " + t[1][1] + ", " + t[1][2]);

        // f) Acceso a todos los elementos de la columna 2
        System.out.println("f) Elementos de la columna 2: "
                + t[0][2] + ", " + t[1][2]);

        // g) Asignar cero a t[0][1]
        t[0][1] = 0;

        // h) Inicializar cada elemento de t con cero, de forma individual
        t[0][0] = 0;
        t[0][1] = 0;
        t[0][2] = 0;
        t[1][0] = 0;
        t[1][1] = 0;
        t[1][2] = 0;

        // i) Inicializar cada elemento de t con cero usando for anidado
        for (int fila = 0; fila < t.length; fila++) {
            for (int col = 0; col < t[fila].length; col++) {
                t[fila][col] = 0;
            }
        }

        // j) For anidado que reciba del usuario los valores de t
        Scanner entrada = new Scanner(System.in);
        for (int fila = 0; fila < t.length; fila++) {
            for (int col = 0; col < t[fila].length; col++) {
                System.out.printf("t[%d][%d] = ", fila, col);
                t[fila][col] = entrada.nextInt();
            }
        }

        // k) Determinar e imprimir el valor más pequeño de t
        int menor = t[0][0];
        for (int fila = 0; fila < t.length; fila++) {
            for (int col = 0; col < t[fila].length; col++) {
                if (t[fila][col] < menor) {
                    menor = t[fila][col];
                }
            }
        }
        System.out.println("k) Valor más pequeño de t: " + menor);

        // l) printf que muestre los elementos de la primera fila
        System.out.printf("l) Primera fila: %d %d %d%n", t[0][0], t[0][1], t[0][2]);

        // m) Totalizar los elementos de la tercera columna sin repetición (for anidado)
        int totalColumna3 = 0;
        for (int fila = 0; fila < t.length; fila++) {
            totalColumna3 += t[fila][2];
        }
        System.out.println("m) Total de la columna 3: " + totalColumna3);

        // n) Imprimir t en formato tabular con encabezados de columna e índices de fila
        System.out.println("n) Contenido de t en formato tabular:");
        System.out.print("      ");
        for (int col = 0; col < t[0].length; col++) {
            System.out.printf("%4d", col);
        }
        System.out.println();
        for (int fila = 0; fila < t.length; fila++) {
            System.out.printf("%4d  ", fila);
            for (int col = 0; col < t[fila].length; col++) {
                System.out.printf("%4d", t[fila][col]);
            }
            System.out.println();
        }

        entrada.close();
    }
}
