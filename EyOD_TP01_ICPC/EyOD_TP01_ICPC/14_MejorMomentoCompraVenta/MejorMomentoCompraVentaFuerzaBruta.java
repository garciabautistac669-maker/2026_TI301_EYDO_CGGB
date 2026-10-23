/*
*   EyOD - Estructuras lineales 2.1 Listas / arreglos
*   Programacion tipo ICPC (basado en PlantillaICPC)
*   VERSION DE FUERZA BRUTA (la version optimizada esta en MejorMomentoCompraVenta.java)
*
*   Problema Best Time to Buy and Sell Stock (#121)
*   Dado un arreglo prices (precio de la accion cada dia), imprimir la ganancia maxima
*   comprando un dia y vendiendo en un dia posterior. Si no hay ganancia, imprimir 0.
*
*   Entrada: n / n precios
*   Salida:  un entero
*
*   Casos de prueba: caso1.txt ... caso3.txt   (salidas esperadas: salida1.txt ...)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MejorMomentoCompraVentaFuerzaBruta {
    FastReader reader = new FastReader();

    private int[] precios;

    public void leerDatos() {
        int n = reader.nextInt();
        precios = new int[n];
        for (int i = 0; i < n; i++) precios[i] = reader.nextInt();
    }

    static class SolucionFuerzaBruta {
        // Fuerza bruta: se prueba cada dia de compra contra cada dia de venta posterior. O(n^2)
        int gananciaMaxima(int[] p) {
            int ganancia = 0;
            for (int i = 0; i < p.length; i++) {
                for (int j = i + 1; j < p.length; j++) {
                    ganancia = Math.max(ganancia, p[j] - p[i]);
                }
            }
            return ganancia;
        }
    }

    public void resuelve() {
        System.out.println(new SolucionFuerzaBruta().gananciaMaxima(precios));
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
        MejorMomentoCompraVentaFuerzaBruta id = new MejorMomentoCompraVentaFuerzaBruta();

        id.leerDatos();
        id.resuelve();
    }
}
