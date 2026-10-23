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



public class E04_ContainsDuplicate {
    // FastReader class for efficient input
    // Entrada: n y luego n enteros
    int n;
    int[] nums;
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
        nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = reader.nextInt();
    }

    // Fuerza bruta O(n^2)
    boolean bruteForce() {
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (nums[i] == nums[j]) return true;
        return false;
    }

    // Sort O(n log n)
    boolean porSort() {
        int[] c = nums.clone();
        Arrays.sort(c);
        for (int i = 1; i < n; i++)
            if (c[i] == c[i - 1]) return true;
        return false;
    }

    // HashSet O(n)
    boolean porHash() {
        Set<Integer> vistos = new HashSet<>();
        for (int x : nums)
            if (!vistos.add(x)) return true;
        return false;
    }

    public void resuelve() {
        System.out.println(porHash()); // cambia por bruteForce() o porSort()
    }

    public static void main(String[] args) {
        E04_ContainsDuplicate id  = new E04_ContainsDuplicate();

        id.leerDatos();
        id.resuelve();
    }   
}
