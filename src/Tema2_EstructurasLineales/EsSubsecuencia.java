package Tema2_EstructurasLineales;

/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
*
*   Problema Is Subsequence (#392)
*   Dadas dos cadenas s y t, imprimir true si s es subsecuencia de t (se obtiene
*   borrando algunos caracteres de t sin cambiar el orden), false en caso contrario.
*
*   Entrada: s / t (sin espacios)
*   Salida:  true o false
*
*   Casos de prueba: caso1.txt ... caso4.txt   (salidas esperadas: salida1.txt ...)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EsSubsecuencia {
    FastReader reader = new FastReader();

    private String s;
    private String t;

    public void leerDatos() {
        s = reader.next();
        t = reader.next();
    }

    static class Solucion {
        // Dos apuntadores. O(|t|)
        boolean esSubsecuencia(String s, String t) {
            int i = 0;
            for (int j = 0; j < t.length() && i < s.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) i++;
            }
            return i == s.length();
        }
    }

    public void resuelve() {
        System.out.println(new Solucion().esSubsecuencia(s, t));
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
        EsSubsecuencia id = new EsSubsecuencia();

        id.leerDatos();
        id.resuelve();
    }
}