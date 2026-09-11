package eyod;

import java.util.Scanner;

/**
 * Ejercicio 7.10 - Comisión por ventas.
 * Clasifica el salario semanal de cada vendedor (200 + 9% de sus ventas,
 * truncado a entero) dentro de 9 rangos, utilizando un arreglo de
 * contadores. Se detiene la captura cuando el usuario introduce -1.
 */
public class E3a_ComisionPorVentas {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Arreglo de contadores: un contador por cada uno de los 9 rangos.
        int[] contadores = new int[9];
        String[] etiquetas = {
                "$200-299", "$300-399", "$400-499", "$500-599", "$600-699",
                "$700-799", "$800-899", "$900-999", "$1,000 en adelante"
        };

        System.out.println("Introduzca las ventas semanales de cada vendedor.");
        System.out.println("Ingrese -1 para finalizar la captura.");

        double ventas;
        while (true) {
            System.out.print("Ventas de la semana: $");
            ventas = entrada.nextDouble();
            if (ventas < 0) {
                break;
            }

            int salario = (int) (200 + 0.09 * ventas); // truncado a entero
            int indice = calcularIndiceRango(salario);
            contadores[indice]++;
        }

        System.out.println("\nResumen de vendedores por rango salarial");
        System.out.println("-----------------------------------------");
        for (int i = 0; i < contadores.length; i++) {
            System.out.printf("%-20s %d%n", etiquetas[i], contadores[i]);
        }

        entrada.close();
    }

    /** Traduce un salario a la posición del arreglo de contadores que le corresponde. */
    private static int calcularIndiceRango(int salario) {
        if (salario >= 1000) {
            return 8;
        }
        return (salario - 200) / 100;
    }
}
