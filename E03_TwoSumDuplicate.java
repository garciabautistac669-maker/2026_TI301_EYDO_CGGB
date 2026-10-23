/*
* ITESS TICS 2026
* Agosto-Diciembre 2026
* Estructura y Organización de Datos
* Tema 2: Estructuras Lineales
* Docente: Francisco Javier Montesillo Puente
* Descripción: Dado un arreglo y un numero target identificar si existen 
*              dos numeros en el arreglo que sumen el target.
* Programador: CGGB
* Fecha: 05/Octubre/2026 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;



public class E03_TwoSumDuplicate {
    // FastReader class for efficient input
    int tipo;        // 1 = Two Sum, 2 = Contains Duplicate
    int n;
    int[] nums;
    int target;
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
        tipo = reader.nextInt();
        n = reader.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = reader.nextInt();
        }
        if (tipo == 1) {
            target = reader.nextInt();
        }
    }

    // ================= TWO SUM =================

    // Fuerza bruta O(n^2)
    int[] twoSumFuerzaBruta() {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    // Ordenar + dos punteros O(n log n) (guarda indices originales)
    int[] twoSumOrdenado() {
        int[][] pares = new int[n][2]; // {valor, indiceOriginal}
        for (int i = 0; i < n; i++) {
            pares[i][0] = nums[i];
            pares[i][1] = i;
        }
        Arrays.sort(pares, (a, b) -> Integer.compare(a[0], b[0]));
        int izq = 0, der = n - 1;
        while (izq < der) {
            int suma = pares[izq][0] + pares[der][0];
            if (suma == target) {
                int a = Math.min(pares[izq][1], pares[der][1]);
                int b = Math.max(pares[izq][1], pares[der][1]);
                return new int[]{a, b};
            } else if (suma < target) {
                izq++;
            } else {
                der--;
            }
        }
        return new int[]{};
    }

    // HashMap (num -> indice) O(n). Complemento = target - num
    int[] twoSumHashMap() {
        Map<Integer, Integer> mapa = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int complemento = target - nums[i];
            if (mapa.containsKey(complemento)) {
                return new int[]{mapa.get(complemento), i};
            }
            mapa.put(nums[i], i);
        }
        return new int[]{};
    }

    // ============= CONTAINS DUPLICATE =============

    // Fuerza bruta O(n^2)
    boolean duplicadoFuerzaBruta() {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    // Ordenar y comparar adyacentes O(n log n)
    boolean duplicadoOrdenado() {
        int[] copia = nums.clone();
        Arrays.sort(copia);
        for (int i = 1; i < n; i++) {
            if (copia[i] == copia[i - 1]) return true;
        }
        return false;
    }

    // HashSet O(n)
    boolean duplicadoHash() {
        Set<Integer> vistos = new HashSet<>();
        for (int num : nums) {
            if (!vistos.add(num)) return true;
        }
        return false;
    }

    public void resuelve() {
        if (tipo == 1) {
            // Para el juez usa solo una (la mas rapida): twoSumHashMap()
            int[] r = twoSumHashMap();
            System.out.println(r[0] + " " + r[1]);
            // Comparacion de los 3 metodos (opcional, borrar en el juez):
            // System.out.println("FB:   " + Arrays.toString(twoSumFuerzaBruta()));
            // System.out.println("Ord:  " + Arrays.toString(twoSumOrdenado()));
            // System.out.println("Hash: " + Arrays.toString(twoSumHashMap()));
        } else {
            System.out.println(duplicadoHash() ? "true" : "false");
            // System.out.println(duplicadoFuerzaBruta());
            // System.out.println(duplicadoOrdenado());
        }
    }

    public static void main(String[] args) {
        E03_TwoSumDuplicate id  = new E03_TwoSumDuplicate();

        id.leerDatos();
        id.resuelve();
    }   
}
