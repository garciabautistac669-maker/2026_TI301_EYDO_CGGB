/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
*   VERSION DE FUERZA BRUTA (la version optimizada esta en SecuenciaConsecutivaMasLarga.java)
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

public class SecuenciaConsecutivaMasLargaFuerzaBruta {
    FastReader reader = new FastReader();

    private int[] nums;

    public void leerDatos() {
        int n = reader.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = reader.nextInt();
    }

    static class SolucionFuerzaBruta {
        // Fuerza bruta: desde cada elemento se busca linealmente x+1, x+2, ... en el arreglo.
        // O(n^3) en el peor caso
        private boolean contiene(int[] nums, int v) {
            for (int x : nums) if (x == v) return true;
            return false;
        }

        int masLarga(int[] nums) {
            int mejor = 0;
            for (int x : nums) {
                int actual = x, largo = 1;
                while (contiene(nums, actual + 1)) {
                    actual++;
                    largo++;
                }
                mejor = Math.max(mejor, largo);
            }
            return mejor;
        }
    }

    public void resuelve() {
        System.out.println(new SolucionFuerzaBruta().masLarga(nums));
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
        SecuenciaConsecutivaMasLargaFuerzaBruta id = new SecuenciaConsecutivaMasLargaFuerzaBruta();

        id.leerDatos();
        id.resuelve();
    }
}
