/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
*   VERSION DE FUERZA BRUTA (la version optimizada esta en PalindromoValido.java)
*
*   Problema Valid Palindrome (#125)
*   Dada una cadena s (una linea), imprimir true si es palindromo considerando solo
*   letras y digitos, sin distinguir mayusculas de minusculas.
*
*   Entrada: una linea
*   Salida:  true o false
*
*   Casos de prueba: caso1.txt ... caso4.txt   (salidas esperadas: salida1.txt ...)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PalindromoValidoFuerzaBruta {
    FastReader reader = new FastReader();

    private String s;

    public void leerDatos() {
        s = reader.nextLine();
    }

    static class SolucionFuerzaBruta {
        // Fuerza bruta: se construye la cadena limpia, su reverso y se comparan. O(n) con memoria extra
        boolean esPalindromo(String s) {
            StringBuilder limpia = new StringBuilder();
            for (char c : s.toCharArray())
                if (Character.isLetterOrDigit(c)) limpia.append(Character.toLowerCase(c));
            String reverso = new StringBuilder(limpia).reverse().toString();
            return limpia.toString().equals(reverso);
        }
    }

    public void resuelve() {
        System.out.println(new SolucionFuerzaBruta().esPalindromo(s));
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
        PalindromoValidoFuerzaBruta id = new PalindromoValidoFuerzaBruta();

        id.leerDatos();
        id.resuelve();
    }
}
