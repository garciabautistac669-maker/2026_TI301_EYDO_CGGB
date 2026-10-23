/*
*   Plantilla de configuración ICPC java
*
*   Problema. Dado un arreglo no ordenado de enteros, encontrar la longitud
*   de la secuencia consecutiva más larga.
*   Sol. 1: ordenar + recorrer -> O(n log n)
*
*   Entrada: línea 1 = n, línea 2 = los n números
      caso1.txt
      6
      100 4 200 1 3 2
Salida:
      4
*
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E08_SecuenciaConsecutiva {
    // FastReader class for efficient input
    int n;
    int[] nums;
    FastReader reader = new FastReader();

    static class FastReader {
        // BufferedReader to read input
        BufferedReader b;
        // StringTokenizer to tokenize input
        StringTokenizer s;

        // Constructor to initialize BufferedReader
        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        // Method to read the next token as a string
        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return s.nextToken();
        }

        // Method to read the next token as an integer
        int nextInt() {
            return Integer.parseInt(next());
        }

        // Method to read Char
        char nextChar() {
            return next().charAt(0);
        }

        // Method to read the next token as a long
        long nextLong() {
            return Long.parseLong(next());
        }

        // Method to read the next token as a double
        double nextDouble() {
            return Double.parseDouble(next());
        }

        // Method to read the next line as a string
        String nextLine() {
            String str = "";
            try {
                if (s.hasMoreTokens()) {
                    str = s.nextToken("\n");
                } else {
                    str = b.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public void leerDatos() {
        n = reader.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = reader.nextInt();
        }
    }

    public void resuelve() {
        if (n == 0) {
            System.out.println(0);
            return;
        }

        Arrays.sort(nums); // 100 4 200 1 3 2 -> 1 2 3 4 100 200

        int mejor = 1;
        int actual = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                continue; // repetido: no cuenta
            }
            if (nums[i] == nums[i - 1] + 1) {
                actual++; // continúa la racha
            } else {
                actual = 1; // se rompe la racha
            }
            mejor = Math.max(mejor, actual);
        }

        System.out.println(mejor);
    }

    public static void main(String[] args) {
        E08_SecuenciaConsecutiva id = new E08_SecuenciaConsecutiva();

        id.leerDatos();
        id.resuelve();
    }
}
