/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
*   VERSION DE FUERZA BRUTA (la version optimizada esta en ContenedorMasAgua.java)
*
*   Problema Container With Most Water (#11)
*   Dado un arreglo de alturas no negativas, imprimir la maxima cantidad de agua que
*   puede almacenar un contenedor formado por dos barras.
*
*   Entrada: n / n alturas
*   Salida:  un entero
*
*   Casos de prueba: caso1.txt ... caso3.txt   (salidas esperadas: salida1.txt ...)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ContenedorMasAguaFuerzaBruta {
    FastReader reader = new FastReader();

    private int[] altura;

    public void leerDatos() {
        int n = reader.nextInt();
        altura = new int[n];
        for (int i = 0; i < n; i++) altura[i] = reader.nextInt();
    }

    static class SolucionFuerzaBruta {
        // Fuerza bruta: se calcula el area de todos los pares de barras. O(n^2)
        long maxAgua(int[] h) {
            long mejor = 0;
            for (int i = 0; i < h.length; i++) {
                for (int j = i + 1; j < h.length; j++) {
                    long area = (long) Math.min(h[i], h[j]) * (j - i);
                    mejor = Math.max(mejor, area);
                }
            }
            return mejor;
        }
    }

    public void resuelve() {
        System.out.println(new SolucionFuerzaBruta().maxAgua(altura));
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
        ContenedorMasAguaFuerzaBruta id = new ContenedorMasAguaFuerzaBruta();

        id.leerDatos();
        id.resuelve();
    }
}
