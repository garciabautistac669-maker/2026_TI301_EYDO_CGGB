/*
* ITESS TICS 2026
* Agosto-Diciembre 2026
* Estructura y Organización de Datos
* Tema 2: Estructuras Lineales
* Docente: Francisco Javier Montesillo Puente
* Descripción: Dado un arreglo y un numero target identificar si existen 
*              dos numeros en el arreglo que sumen el target.
* Programador: CGGB
* Fecha: 08/Octubre/2026 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class E05_GroupAnagrams {
    // FastReader class for efficient input
    // Entrada: n y luego n palabras (minusculas)
    int n;
    String[] palabras;
    FastReader reader = new FastReader();

    static class FastReader {
        // BufferedReader to read input
        BufferedReader b;
        // StringTokenizer to tokenize input
        StringTokenizer s; 

        // Constructor to initialize BufferedReader
        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        // Method to read the next token as a string
        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace(); 
                }
            }
            return s.nextToken();
        }

        // Method to read the next token as an integer
        int nextInt() { 
                return Integer.parseInt(next()); 
        }

        // Method to read Char
        char nextChar() {
            return next().charAt(0);
        }

        // Method to read the next token as a long
        long nextLong() { 
            return Long.parseLong(next()); 
        }

        // Method to read the next token as a double
        double nextDouble() { 
            return Double.parseDouble(next()); 
        }

        // Method to read the next line as a string
        String nextLine() {
            String str = "";
            try {
                if (s.hasMoreTokens()) {
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

    public void leerDatos() {
        n = reader.nextInt();
        palabras = new String[n];
        for (int i = 0; i < n; i++) palabras[i] = reader.next();
    }

    // SORT + HASH: clave = palabra ordenada (aet -> eat, tea, ate)
    Map<String, List<String>> porSort() {
        Map<String, List<String>> mapa = new TreeMap<>();
        for (String w : palabras) {
            char[] c = w.toCharArray();
            Arrays.sort(c);
            mapa.computeIfAbsent(new String(c), k -> new ArrayList<>()).add(w);
        }
        return mapa;
    }

    // Frecuencias: clave = a1e1t1
    Map<String, List<String>> porFrecuencia() {
        Map<String, List<String>> mapa = new TreeMap<>();
        for (String w : palabras) {
            int[] conteo = new int[26];
            for (char ch : w.toCharArray()) conteo[ch - 'a']++;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++)
                if (conteo[i] > 0) sb.append((char) ('a' + i)).append(conteo[i]);
            mapa.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(w);
        }
        return mapa;
    }

    public void resuelve() {
        Map<String, List<String>> mapa = porSort(); // o porFrecuencia()
        for (List<String> grupo : mapa.values()) {
            Collections.sort(grupo);
            System.out.println(String.join(" ", grupo));
        }
    }

    public static void main(String[] args) {
        E05_GroupAnagrams id  = new E05_GroupAnagrams();

        id.leerDatos();
        id.resuelve();
    }   
}
