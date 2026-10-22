package Tema2_EstructurasLineales;

/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
*
*   Problema Contains Duplicate (#217)
*   Dado un arreglo de enteros nums, imprimir true si algun valor aparece al menos
*   dos veces, y false si todos los elementos son distintos.
*
*   Entrada: n / n enteros
*   Salida:  true o false
*
*   Casos de prueba: caso1.txt ... caso4.txt   (salidas esperadas: salida1.txt ...)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ContieneDuplicados {
    FastReader reader = new FastReader();

    private int[] nums;

    public void leerDatos() {
        int n = reader.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = reader.nextInt();
    }

    static class Solucion {
        // HashSet: add devuelve false si el valor ya estaba. O(n)
        boolean hayDuplicado(int[] nums) {
            Set<Integer> vistos = new HashSet<>();
            for (int x : nums) {
                if (!vistos.add(x)) return true;
            }
            return false;
        }
    }

    public void resuelve() {
        System.out.println(new Solucion().hayDuplicado(nums));
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
        ContieneDuplicados id = new ContieneDuplicados();

        id.leerDatos();
        id.resuelve();
    }
}