package Tema2_EstructurasLineales;

/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
*
*   Problema Longest Consecutive Sequence (#128)
*   Dado un arreglo sin ordenar, imprimir la longitud de la secuencia de numeros
*   consecutivos mas larga. Algoritmo O(n).
*
*   Entrada: n / n enteros
*   Salida:  un entero
*
*   Casos de prueba: caso1.txt ... caso4.txt   (salidas esperadas: salida1.txt ...)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SecuenciaConsecutivaMasLarga {
    FastReader reader = new FastReader();

    private int[] nums;

    public void leerDatos() {
        int n = reader.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = reader.nextInt();
    }

    static class Solucion {
        // Solo se cuenta desde el inicio de cada secuencia (x-1 no existe). O(n)
        int masLarga(int[] nums) {
            Set<Integer> conjunto = new HashSet<>();
            for (int x : nums) conjunto.add(x);
            int mejor = 0;
            for (int x : conjunto) {
                if (!conjunto.contains(x - 1)) {
                    int actual = x, largo = 1;
                    while (conjunto.contains(actual + 1)) {
                        actual++;
                        largo++;
                    }
                    mejor = Math.max(mejor, largo);
                }
            }
            return mejor;
        }
    }

    public void resuelve() {
        System.out.println(new Solucion().masLarga(nums));
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
        SecuenciaConsecutivaMasLarga id = new SecuenciaConsecutivaMasLarga();

        id.leerDatos();
        id.resuelve();
    }
}