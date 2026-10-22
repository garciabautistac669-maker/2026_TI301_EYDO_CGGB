package Tema2_EstructurasLineales;

/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
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

public class AgrupaAnagramas {
    FastReader reader = new FastReader();

    private String[] palabras;

    public void leerDatos() {
        int n = reader.nextInt();
        palabras = new String[n];
        for (int i = 0; i < n; i++) palabras[i] = reader.next();
    }

    static class Solucion {
        // Clave = letras ordenadas de la palabra. O(n * k log k)
        List<List<String>> agrupa(String[] palabras) {
            Map<String, List<String>> mapa = new HashMap<>();
            for (String p : palabras) {
                char[] c = p.toCharArray();
                Arrays.sort(c);
                mapa.computeIfAbsent(new String(c), x -> new ArrayList<>()).add(p);
            }
            List<List<String>> grupos = new ArrayList<>(mapa.values());
            for (List<String> g : grupos) Collections.sort(g);
            grupos.sort((a, b) -> a.get(0).compareTo(b.get(0)));
            return grupos;
        }
    }

    public void resuelve() {
        for (List<String> g : new Solucion().agrupa(palabras))
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
        AgrupaAnagramas id = new AgrupaAnagramas();

        id.leerDatos();
        id.resuelve();
    }
}