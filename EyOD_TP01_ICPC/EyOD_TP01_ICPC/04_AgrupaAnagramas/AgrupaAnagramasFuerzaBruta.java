/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
*   VERSION DE FUERZA BRUTA (la version optimizada esta en AgrupaAnagramas.java)
*
*   Problema Group Anagrams (#49)
*   Dado un arreglo de cadenas, agrupar los anagramas. Se imprime un grupo por linea,
*   con las palabras ordenadas alfabeticamente y los grupos ordenados por su primera palabra.
*
*   Entrada: n / n palabras
*   Salida:  un grupo por linea
*
*   Casos de prueba: caso1.txt ... caso3.txt   (salidas esperadas: salida1.txt ...)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AgrupaAnagramasFuerzaBruta {
    FastReader reader = new FastReader();

    private String[] palabras;

    public void leerDatos() {
        int n = reader.nextInt();
        palabras = new String[n];
        for (int i = 0; i < n; i++) palabras[i] = reader.next();
    }

    static class SolucionFuerzaBruta {
        // Fuerza bruta: cada palabra se compara contra todas las demas (par por par). O(n^2 * k^2)
        private boolean sonAnagramas(String a, String b) {
            if (a.length() != b.length()) return false;
            List<Character> restantes = new ArrayList<>();
            for (char c : b.toCharArray()) restantes.add(c);
            for (char c : a.toCharArray()) {
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
            return true;
        }

        List<List<String>> agrupa(String[] palabras) {
            boolean[] usada = new boolean[palabras.length];
            List<List<String>> grupos = new ArrayList<>();
            for (int i = 0; i < palabras.length; i++) {
                if (usada[i]) continue;
                List<String> grupo = new ArrayList<>();
                grupo.add(palabras[i]);
                usada[i] = true;
                for (int j = i + 1; j < palabras.length; j++) {
                    if (!usada[j] && sonAnagramas(palabras[i], palabras[j])) {
                        grupo.add(palabras[j]);
                        usada[j] = true;
                    }
                }
                Collections.sort(grupo);
                grupos.add(grupo);
            }
            grupos.sort((a, b) -> a.get(0).compareTo(b.get(0)));
            return grupos;
        }
    }

    public void resuelve() {
        for (List<String> g : new SolucionFuerzaBruta().agrupa(palabras))
            System.out.println(String.join(" ", g));
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
        AgrupaAnagramasFuerzaBruta id = new AgrupaAnagramasFuerzaBruta();

        id.leerDatos();
        id.resuelve();
    }
}
