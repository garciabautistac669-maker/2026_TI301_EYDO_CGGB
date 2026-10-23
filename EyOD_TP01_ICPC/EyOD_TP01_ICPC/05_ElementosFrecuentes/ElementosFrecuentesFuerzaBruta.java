/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
*   VERSION DE FUERZA BRUTA (la version optimizada esta en ElementosFrecuentes.java)
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

public class ElementosFrecuentesFuerzaBruta {
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
        // Fuerza bruta: se cuenta cada valor recorriendo todo el arreglo y luego
        // se elige k veces el mejor por seleccion. O(n^2 + n*k)
        List<Integer> topK(int[] nums, int k) {
            List<Integer> distintos = new ArrayList<>();
            for (int x : nums) if (!distintos.contains(x)) distintos.add(x);
            int[] frec = new int[distintos.size()];
            for (int i = 0; i < distintos.size(); i++)
                for (int x : nums) if (x == distintos.get(i)) frec[i]++;
            boolean[] elegido = new boolean[distintos.size()];
            List<Integer> res = new ArrayList<>();
            for (int ronda = 0; ronda < k && ronda < distintos.size(); ronda++) {
                int mejor = -1;
                for (int i = 0; i < distintos.size(); i++) {
                    if (elegido[i]) continue;
                    if (mejor == -1 || frec[i] > frec[mejor]
                            || (frec[i] == frec[mejor] && distintos.get(i) < distintos.get(mejor)))
                        mejor = i;
                }
                elegido[mejor] = true;
                res.add(distintos.get(mejor));
            }
            return res;
        }
    }

    public void resuelve() {
        StringBuilder sb = new StringBuilder();
        for (int x : new SolucionFuerzaBruta().topK(nums, k)) {
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
        ElementosFrecuentesFuerzaBruta id = new ElementosFrecuentesFuerzaBruta();

        id.leerDatos();
        id.resuelve();
    }
}
