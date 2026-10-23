/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
*   VERSION DE FUERZA BRUTA (la version optimizada esta en AnagramaValido.java)
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

public class AnagramaValidoFuerzaBruta {
    FastReader reader = new FastReader();

    private String s;
    private String t;

    public void leerDatos() {
        s = reader.nextLine();
        t = reader.nextLine();
    }

    static class SolucionFuerzaBruta {
        // Fuerza bruta: cada letra de s se busca en t y se elimina la primera coincidencia. O(n^2)
        boolean esAnagrama(String s, String t) {
            List<Character> restantes = new ArrayList<>();
            for (char c : t.toLowerCase().toCharArray())
                if (c >= 'a' && c <= 'z') restantes.add(c);
            for (char c : s.toLowerCase().toCharArray()) {
                if (c < 'a' || c > 'z') continue;
                boolean encontrada = false;
                for (int i = 0; i < restantes.size(); i++) {
                    if (restantes.get(i) == c) {
                        restantes.remove(i);
                        encontrada = true;
                        break;
                    }
                }
                if (!encontrada) return false;
            }
            return restantes.isEmpty();
        }
    }

    public void resuelve() {
        System.out.println(new SolucionFuerzaBruta().esAnagrama(s, t));
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
        AnagramaValidoFuerzaBruta id = new AnagramaValidoFuerzaBruta();

        id.leerDatos();
        id.resuelve();
    }
}
