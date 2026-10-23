/*
*   Plantilla de configuración ICPC java
*
*   Problema. Dados dos strings s y t, imprimir true si s es subsecuencia de t, false si no.
*   Estrategia: two pointers -> O(n)
*
*   Entrada: línea 1 = s, línea 2 = t
      caso1.txt       caso2.txt
      abc             axc
      abbgdc          abbgdc
Salida:
      true            false
*
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E09_Subsecuencia {
    // FastReader class for efficient input
    String s;
    String t;
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
        s = reader.next();
        t = reader.next();
    }

    public void resuelve() {
        int ps = 0; // puntero en s
        int pb = 0; // puntero en t

        while (ps < s.length() && pb < t.length()) {
            if (s.charAt(ps) == t.charAt(pb)) {
                ps++; // iguales: mover ps y pb
            }
            pb++; // siempre se mueve pb
        }

        System.out.println(ps == s.length());
    }

    public static void main(String[] args) {
        E09_Subsecuencia id = new E09_Subsecuencia();

        id.leerDatos();
        id.resuelve();
    }
}
