/*
* ITESS TICS 2026
* Agosto-Diciembre 2026
* Estructura y Organización de Datos
* Tema 2: Estructuras Lineales
* Docente: Francisco Javier Montesillo Puente
* Descripción: Dado un arreglo y un numero target identificar si existen 
*              dos numeros en el arreglo que sumen el target.
* Programador: CGGB
* Fecha: 02/Octubre/2026 
*/

// Compilación y ejecución
// Pompilar: javac ED1_CollectionTest.java
// Ejecutar: java ED1_CollectionTest

// Package e02_suma2;

// Librerias o paquetes
import java.io.BufferedReader;     // Importa la clase BufferedReader
import java.io.InputStreamReader;  // Importa la clase InputStreamReader
import java.io.IOException;        // Importa la clase IOException
import java.io.InputStreamReader;  // Importa la clase InputStreamReader
import java.util.ArrayList;        // Importa la clase ArrayList
import java.util.List;             // Importa la interfaz List
import java.util.Random;           // Importa la clase Random
import java.util.StringTokenizer;  // Importa la clase StringTokenizer

public class E02_Suma2 {

    // Clase FastReader para lectura eficiente de entrada
    static class FastReader {
        BufferedReader b;
        StringTokenizer s;

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        // Siguiente token como String
        String next() {
            while (s == null || !s.hasMoreTokens()) {
                try {
                    String line = b.readLine();
                    if (line == null) return null;
                    s = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return s.nextToken();
        }

        // Siguiente token como int
        int nextInt() {
            return Integer.parseInt(next());
        }

        // Siguiente token como char
        char nextChar() {
            return next().charAt(0);
        }

        // Siguiente token como long
        long nextLong() {
            return Long.parseLong(next());
        }

        // Siguiente token como double
        double nextDouble() {
            return Double.parseDouble(next());
        }

        // Siguiente línea completa
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
            return str;
        }
    }

    // ---------- Atributos ----------
    Random r = new Random();
    FastReader reader = new FastReader();

    List<Integer> nums = new ArrayList<>();
    int objetivo;

    // ---------- Generación de datos ----------
    private void generarDatos(int n) {
        for (int i = 0; i < n; i++) {
            nums.add(r.nextInt(1_000_000_000));
        }
    }

    private int generarObjetivo() {
        return r.nextInt(1_000_000_000);
    }

    public void leerDatos() {
        int n = 1000;
        nums.clear();
        generarDatos(n);
        objetivo = generarObjetivo();
    }

    public void mostrarDatos() {
        System.out.println("Objetivo: " + objetivo);
        System.out.println("Nums: " + nums.toString());
    }

    // ---------- Soluciones ----------
    public void resuelve() {

    }

    // O(n^2)
    public void resolverFB() {

    }

    // O(n log n + n)
    public void resolverOrden() {

    }

    public static void main(String[] args) {
        E02_Suma2 id = new E02_Suma2();

        id.leerDatos();
        id.resuelve();
        id.mostrarDatos();
    }
}