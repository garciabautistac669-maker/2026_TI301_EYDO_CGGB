/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
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

public class TresSumas {
    FastReader reader = new FastReader();

    private int[] nums;

    public void leerDatos() {
        int n = reader.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = reader.nextInt();
    }

    static class Solucion {
        // Ordenar + dos apuntadores, saltando repetidos. O(n^2)
        List<int[]> tripletes(int[] nums) {
            int[] a = nums.clone();
            Arrays.sort(a);
            List<int[]> res = new ArrayList<>();
            for (int i = 0; i < a.length - 2; i++) {
                if (a[i] > 0) break;
                if (i > 0 && a[i] == a[i - 1]) continue;
                int l = i + 1, r = a.length - 1;
                while (l < r) {
                    int suma = a[i] + a[l] + a[r];
                    if (suma == 0) {
                        res.add(new int[]{a[i], a[l], a[r]});
                        l++;
                        r--;
                        while (l < r && a[l] == a[l - 1]) l++;
                        while (l < r && a[r] == a[r + 1]) r--;
                    } else if (suma < 0) l++;
                    else r--;
                }
            }
            return res;
        }
    }

    public void resuelve() {
        List<int[]> res = new Solucion().tripletes(nums);
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
        TresSumas id = new TresSumas();

        id.leerDatos();
        id.resuelve();
    }
}
