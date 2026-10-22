package Tema2_EstructurasLineales;

/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
*
*   Problema Top K Frequent Elements (#347)
*   Dado un arreglo nums y un entero k, imprimir los k elementos mas frecuentes.
*   Orden de salida: mayor frecuencia primero; en empate, el valor menor primero.
*
*   Entrada: n / n enteros / k
*   Salida:  k enteros separados por espacio
*
*   Casos de prueba: caso1.txt ... caso4.txt   (salidas esperadas: salida1.txt ...)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ElementosFrecuentes {
    FastReader reader = new FastReader();

    private int[] nums;
    private int k;

    public void leerDatos() {
        int n = reader.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = reader.nextInt();
        k = reader.nextInt();
    }

    static class Solucion {
        List<Integer> topK(int[] nums, int k) {
            Map<Integer, Integer> frec = new HashMap<>();
            for (int x : nums) frec.merge(x, 1, Integer::sum);
            List<Integer> claves = new ArrayList<>(frec.keySet());
            claves.sort((a, b) -> frec.get(b) != frec.get(a).intValue()
                    ? frec.get(b) - frec.get(a) : Integer.compare(a, b));
            return claves.subList(0, Math.min(k, claves.size()));
        }
    }

    public void resuelve() {
        StringBuilder sb = new StringBuilder();
        for (int x : new Solucion().topK(nums, k)) {
            if (sb.length() > 0) sb.append(' ');
            sb.append(x);
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
        ElementosFrecuentes id = new ElementosFrecuentes();

        id.leerDatos();
        id.resuelve();
    }
}