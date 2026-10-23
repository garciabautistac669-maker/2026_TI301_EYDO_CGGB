/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
*
*   Problema Longest Repeating Character Replacement (#424)
*   Dada una cadena s (letras mayusculas) y un entero k, se puede cambiar cualquier
*   caracter por otro a lo mas k veces. Imprimir la longitud de la subcadena mas larga
*   con una misma letra.
*
*   Entrada: s / k
*   Salida:  un entero
*
*   Casos de prueba: caso1.txt ... caso3.txt   (salidas esperadas: salida1.txt ...)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ReemplazoCaracteresRepetidos {
    FastReader reader = new FastReader();

    private String s;
    private int k;

    public void leerDatos() {
        s = reader.next();
        k = reader.nextInt();
    }

    static class Solucion {
        // Ventana deslizante: valida si (tamano - letra mas frecuente) <= k. O(n)
        int masLarga(String s, int k) {
            int[] cont = new int[26];
            int izq = 0, maxFrec = 0, mejor = 0;
            for (int der = 0; der < s.length(); der++) {
                maxFrec = Math.max(maxFrec, ++cont[s.charAt(der) - 'A']);
                while ((der - izq + 1) - maxFrec > k) {
                    cont[s.charAt(izq) - 'A']--;
                    izq++;
                }
                mejor = Math.max(mejor, der - izq + 1);
            }
            return mejor;
        }
    }

    public void resuelve() {
        System.out.println(new Solucion().masLarga(s, k));
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
        ReemplazoCaracteresRepetidos id = new ReemplazoCaracteresRepetidos();

        id.leerDatos();
        id.resuelve();
    }
}
