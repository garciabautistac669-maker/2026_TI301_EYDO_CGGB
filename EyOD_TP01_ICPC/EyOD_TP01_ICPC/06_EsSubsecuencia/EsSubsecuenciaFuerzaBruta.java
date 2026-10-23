/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
*   VERSION DE FUERZA BRUTA (la version optimizada esta en EsSubsecuencia.java)
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

public class EsSubsecuenciaFuerzaBruta {
    FastReader reader = new FastReader();

    private String s;
    private String t;

    public void leerDatos() {
        s = reader.next();
        t = reader.next();
    }

    static class SolucionFuerzaBruta {
        // Fuerza bruta: backtracking que prueba todas las posiciones posibles de
        // cada caracter de s dentro de t. Exponencial en el peor caso.
        boolean esSubsecuencia(String s, String t) {
            return buscar(s, t, 0, 0);
        }

        private boolean buscar(String s, String t, int i, int desde) {
            if (i == s.length()) return true;
            for (int j = desde; j < t.length(); j++) {
                if (t.charAt(j) == s.charAt(i) && buscar(s, t, i + 1, j + 1)) return true;
            }
            return false;
        }
    }

    public void resuelve() {
        System.out.println(new SolucionFuerzaBruta().esSubsecuencia(s, t));
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
        EsSubsecuenciaFuerzaBruta id = new EsSubsecuenciaFuerzaBruta();

        id.leerDatos();
        id.resuelve();
    }
}
