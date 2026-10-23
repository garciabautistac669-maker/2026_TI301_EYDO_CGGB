/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
*
*   Problema Two Sum II - Input Array Is Sorted (#167)
*   Dado un arreglo ordenado de forma no decreciente (indexado desde 1), imprimir los
*   indices (base 1) de los dos numeros que suman objetivo. Espacio extra O(1).
*
*   Entrada: n / n enteros ordenados / objetivo
*   Salida:  dos indices i j (base 1)
*
*   Casos de prueba: caso1.txt ... caso3.txt   (salidas esperadas: salida1.txt ...)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DosSumasOrdenado {
    FastReader reader = new FastReader();

    private int[] numeros;
    private int objetivo;

    public void leerDatos() {
        int n = reader.nextInt();
        numeros = new int[n];
        for (int i = 0; i < n; i++) numeros[i] = reader.nextInt();
        objetivo = reader.nextInt();
    }

    static class Solucion {
        // Dos apuntadores desde los extremos. O(n)
        int[] indices(int[] a, int objetivo) {
            int i = 0, j = a.length - 1;
            while (i < j) {
                int suma = a[i] + a[j];
                if (suma == objetivo) return new int[]{i + 1, j + 1};
                if (suma < objetivo) i++;
                else j--;
            }
            return new int[]{-1, -1};
        }
    }

    public void resuelve() {
        int[] r = new Solucion().indices(numeros, objetivo);
        System.out.println(r[0] + " " + r[1]);
    }

    // Lector rapido de entrada (version robusta de la plantilla ICPC)
    static class FastReader {
        BufferedReader b;
        StringTokenizer s;

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (s == null || !s.hasMoreTokens()) {
                try {
                    String linea = b.readLine();
                    if (linea == null) return null;
                    s = new StringTokenizer(linea);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return s.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        char nextChar() { return next().charAt(0); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble() { return Double.parseDouble(next()); }

        String nextLine() {
            String str = "";
            try {
                if (s != null && s.hasMoreTokens()) {
                    str = s.nextToken("\n");
                } else {
                    str = b.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            s = null;
            return str == null ? "" : str;
        }
    }

    public static void main(String[] args) {
        DosSumasOrdenado id = new DosSumasOrdenado();

        id.leerDatos();
        id.resuelve();
    }
}
