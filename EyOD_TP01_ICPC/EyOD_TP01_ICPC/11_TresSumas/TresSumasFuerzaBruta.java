/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
*   VERSION DE FUERZA BRUTA (la version optimizada esta en TresSumas.java)
*
*   Problema 3Sum (#15)
*   Dado un arreglo nums, imprimir todos los tripletes unicos cuya suma sea 0 (uno por
*   linea, ordenados). Si no hay ninguno se imprime [].
*
*   Entrada: n / n enteros
*   Salida:  un triplete por linea, o []
*
*   Casos de prueba: caso1.txt ... caso4.txt   (salidas esperadas: salida1.txt ...)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TresSumasFuerzaBruta {
    FastReader reader = new FastReader();

    private int[] nums;

    public void leerDatos() {
        int n = reader.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = reader.nextInt();
    }

    static class SolucionFuerzaBruta {
        // Fuerza bruta: tres ciclos anidados sobre el arreglo ordenado; los tripletes
        // repetidos se descartan comparandolos con los ya encontrados. O(n^3)
        List<int[]> tripletes(int[] nums) {
            int[] a = nums.clone();
            Arrays.sort(a);
            List<int[]> res = new ArrayList<>();
            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    for (int k = j + 1; k < a.length; k++) {
                        if (a[i] + a[j] + a[k] != 0) continue;
                        int[] t = {a[i], a[j], a[k]};
                        boolean repetido = false;
                        for (int[] otro : res) if (Arrays.equals(otro, t)) repetido = true;
                        if (!repetido) res.add(t);
                    }
                }
            }
            return res;
        }
    }

    public void resuelve() {
        List<int[]> res = new SolucionFuerzaBruta().tripletes(nums);
        if (res.isEmpty()) {
            System.out.println("[]");
            return;
        }
        for (int[] t : res) System.out.println(t[0] + " " + t[1] + " " + t[2]);
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
        TresSumasFuerzaBruta id = new TresSumasFuerzaBruta();

        id.leerDatos();
        id.resuelve();
    }
}
