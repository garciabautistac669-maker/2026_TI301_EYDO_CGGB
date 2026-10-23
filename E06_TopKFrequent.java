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



public class E06_TopKFrequent {
    // FastReader class for efficient input
    // Entrada: n k y luego n enteros
    int n, k;
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
        k = reader.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = reader.nextInt();
    }

    // Ordenar por frecuencia O(n log n)
    int[] porSort() {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.merge(x, 1, Integer::sum);
        List<Map.Entry<Integer, Integer>> lista = new ArrayList<>(freq.entrySet());
        lista.sort((a, b) -> b.getValue() - a.getValue());
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = lista.get(i).getKey();
        return res;
    }

    // Bucket de frecuencias O(n)
    @SuppressWarnings("unchecked")
    int[] porBucket() {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.merge(x, 1, Integer::sum);
        List<Integer>[] bucket = new List[n + 1];
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (bucket[e.getValue()] == null) bucket[e.getValue()] = new ArrayList<>();
            bucket[e.getValue()].add(e.getKey());
        }
        int[] res = new int[k];
        int idx = 0;
        for (int f = n; f > 0 && idx < k; f--) {
            if (bucket[f] == null) continue;
            for (int x : bucket[f]) {
                if (idx == k) break;
                res[idx++] = x;
            }
        }
        return res;
    }

    public void resuelve() {
        int[] res = porBucket(); // o porSort()
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i > 0) sb.append(" ");
            sb.append(res[i]);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        E06_TopKFrequent id  = new E06_TopKFrequent();

        id.leerDatos();
        id.resuelve();
    }   
}
