/*
* ITESS TICS 2026
* Agosto-Diciembre 2026
* Estructura y Organización de Datos
* Tema 2: Estructuras Lineal
* Docente: Francisco Javier Montesillo Puente
* Descripción: Pueba de collection usando List, ArrayList, Iteradores y algunos metodos 
* Programador: CGGB
* Fecha: 01/Octubre/2026 
*/

// Compilación y ejecución
// Pompilar: javac ED1_CollectionTest.java
// Ejecutar: java ED1_CollectionTest

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;



public class PlantillaICPC {
    // FastReader class for efficient input
    int nums[];
    Random r = new Random();

    List<integer> nums = new ArrayList<>(); 

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
    
    private void generarDatos(int n){
        nums = new int[n];

        for (i = 0; i < n; i++);
        nums.add(r.nextInt(1_000_000_000));
    }

    public void leerDatos() {
        int n = 1000;
        nums.clear();
        generarDatos(n);
        objetivo = generarObjetivo();
    }

    public int generarTourget(){
        return r.nextInt(1_000_000_000);
    }

    public void mostrarDatos(){
        System.out.println("Objetivo: " + objetivo);
        System.out.println("Nums: " + nums.toString);
    }

    public void resuelve() {
        
    }
    // n2
    public void resolverFB(){

    }
    // n long + n
    public void resolverOrden();

    public static void main(String[] args) {
        E02_Suma2 id  = new E02_Suma2();

        id.leerDatos();
        id.resuelve();
    }   
}