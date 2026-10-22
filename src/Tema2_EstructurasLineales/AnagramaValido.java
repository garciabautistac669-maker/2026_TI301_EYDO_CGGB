package Tema2_EstructurasLineales;

/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
*
*   Problema Valid Anagram (#242)
*   Dadas dos cadenas s y t (una por linea), imprimir true si t es un anagrama de s.
*   Se ignoran espacios y diferencias entre mayusculas/minusculas.
*
*   Entrada: linea s / linea t
*   Salida:  true o false
*
*   Casos de prueba: caso1.txt ... caso4.txt   (salidas esperadas: salida1.txt ...)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AnagramaValido {
    FastReader reader = new FastReader();

    private String s;
    private String t;

    public void leerDatos() {
        s = reader.nextLine();
        t = reader.nextLine();
    }

    static class Solucion {
        // Contador de letras a-z. O(n)
        boolean esAnagrama(String s, String t) {
            int[] cont = new int[26];
            for (char c : s.toLowerCase().toCharArray())
                if (c >= 'a' && c <= 'z') cont[c - 'a']++;
            for (char c : t.toLowerCase().toCharArray())
                if (c >= 'a' && c <= 'z') cont[c - 'a']--;
            for (int v : cont) if (v != 0) return false;
            return true;
        }
    }

    public void resuelve() {
        System.out.println(new Solucion().esAnagrama(s, t));
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
        AnagramaValido id = new AnagramaValido();

        id.leerDatos();
        id.resuelve();
    }
}