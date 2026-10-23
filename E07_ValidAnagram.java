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



public class E07_ValidAnagram {
    // FastReader class for efficient input
    // Entrada: dos palabras s y t (minusculas)
    String s, t;
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
        s = reader.next();
        t = reader.next();
    }

    // Fuerza bruta O(n^2): tachar letras
    boolean bruteForce() {
        if (s.length() != t.length()) return false;
        char[] tc = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            boolean ok = false;
            for (int j = 0; j < tc.length; j++) {
                if (tc[j] == s.charAt(i)) { tc[j] = '*'; ok = true; break; }
            }
            if (!ok) return false;
        }
        return true;
    }

    // Sort O(n log n)
    boolean porSort() {
        if (s.length() != t.length()) return false;
        char[] a = s.toCharArray(), b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    // Arreglo de frecuencias a..z (+1 con s, -1 con t) O(n)
    boolean porFrecuencia() {
        if (s.length() != t.length()) return false;
        int[] conteo = new int[26];
        for (int i = 0; i < s.length(); i++) {
            conteo[s.charAt(i) - 'a']++;
            conteo[t.charAt(i) - 'a']--;
        }
        for (int c : conteo) if (c != 0) return false;
        return true;
    }

    public void resuelve() {
        System.out.println(porFrecuencia()); // cambia por bruteForce() o porSort()
    }

    public static void main(String[] args) {
        E07_ValidAnagram id  = new E07_ValidAnagram();

        id.leerDatos();
        id.resuelve();
    }   
}
