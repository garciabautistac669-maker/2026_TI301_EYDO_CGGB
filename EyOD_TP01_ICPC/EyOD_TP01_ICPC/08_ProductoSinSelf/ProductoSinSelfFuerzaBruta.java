/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
*   VERSION DE FUERZA BRUTA (la version optimizada esta en ProductoSinSelf.java)
*
*   Problema Product of Array Except Self (#238)
*   Dado un arreglo nums, imprimir answer donde answer[i] es el producto de todos los
*   elementos excepto nums[i]. O(n) y sin usar division.
*
*   Entrada: n / n enteros
*   Salida:  n enteros separados por espacio
*
*   Casos de prueba: caso1.txt ... caso3.txt   (salidas esperadas: salida1.txt ...)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ProductoSinSelfFuerzaBruta {
    FastReader reader = new FastReader();

    private int[] nums;

    public void leerDatos() {
        int n = reader.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = reader.nextInt();
    }

    static class SolucionFuerzaBruta {
        // Fuerza bruta: para cada i se multiplican todos los demas elementos. O(n^2)
        long[] productos(int[] nums) {
            int n = nums.length;
            long[] resp = new long[n];
            for (int i = 0; i < n; i++) {
                long prod = 1;
                for (int j = 0; j < n; j++) {
                    if (j != i) prod *= nums[j];
                }
                resp[i] = prod;
            }
            return resp;
        }
    }

    public void resuelve() {
        long[] r = new SolucionFuerzaBruta().productos(nums);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r.length; i++) {
            if (i > 0) sb.append(' ');
            sb.append(r[i]);
        }
        System.out.println(sb);
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
        ProductoSinSelfFuerzaBruta id = new ProductoSinSelfFuerzaBruta();

        id.leerDatos();
        id.resuelve();
    }
}
