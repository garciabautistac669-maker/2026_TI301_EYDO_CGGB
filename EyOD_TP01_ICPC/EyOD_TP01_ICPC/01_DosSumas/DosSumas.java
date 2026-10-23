/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
*
*   Problema Two Sum (#1)
*   Dado un arreglo de enteros nums y un entero objetivo, imprimir los indices (base 0)
*   de los dos numeros que suman objetivo. Siempre existe exactamente una solucion.
*
*   Entrada: n / n enteros / objetivo
*   Salida:  dos indices i j (i < j)
*
*   Casos de prueba: caso1.txt ... caso4.txt   (salidas esperadas: salida1.txt ...)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DosSumas {
    FastReader reader = new FastReader();

    private int[] nums;
    private int objetivo;

    public void leerDatos() {
        int n = reader.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = reader.nextInt();
        objetivo = reader.nextInt();
    }

    // Logica del problema encapsulada. HashMap valor -> indice, O(n)
    static class Solucion {
        int[] indices(int[] nums, int objetivo) {
            Map<Integer, Integer> vistos = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer j = vistos.get(objetivo - nums[i]);
                if (j != null) return new int[]{j, i};
                vistos.put(nums[i], i);
            }
            return new int[]{-1, -1};
        }
    }

    public void resuelve() {
        int[] r = new Solucion().indices(nums, objetivo);
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
        DosSumas id = new DosSumas();

        id.leerDatos();
        id.resuelve();
    }
}
