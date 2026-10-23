/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
*   VERSION DE FUERZA BRUTA (la version optimizada esta en PromedioMaximoSubarreglo.java)
*
*   Problema Maximum Average Subarray I (#643)
*   Dado un arreglo nums y un entero k, hallar el subarreglo contiguo de longitud k con
*   mayor promedio e imprimir ese promedio con 5 decimales.
*
*   Entrada: n / n enteros / k
*   Salida:  promedio con 5 decimales
*
*   Casos de prueba: caso1.txt ... caso3.txt   (salidas esperadas: salida1.txt ...)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PromedioMaximoSubarregloFuerzaBruta {
    FastReader reader = new FastReader();

    private int[] nums;
    private int k;

    public void leerDatos() {
        int n = reader.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = reader.nextInt();
        k = reader.nextInt();
    }

    static class SolucionFuerzaBruta {
        // Fuerza bruta: para cada inicio se vuelve a sumar los k elementos. O(n*k)
        double promedioMaximo(int[] nums, int k) {
            long mejor = Long.MIN_VALUE;
            for (int i = 0; i + k <= nums.length; i++) {
                long suma = 0;
                for (int j = i; j < i + k; j++) suma += nums[j];
                mejor = Math.max(mejor, suma);
            }
            return (double) mejor / k;
        }
    }

    public void resuelve() {
        System.out.println(String.format(Locale.US, "%.5f", new SolucionFuerzaBruta().promedioMaximo(nums, k)));
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
        PromedioMaximoSubarregloFuerzaBruta id = new PromedioMaximoSubarregloFuerzaBruta();

        id.leerDatos();
        id.resuelve();
    }
}
