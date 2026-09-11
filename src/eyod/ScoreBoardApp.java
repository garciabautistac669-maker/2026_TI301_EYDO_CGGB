package eyod;

/*
*   FJMP-EDU @ 2026
*   Plantilla de configuración ICPC java
*   frajavimopu@gmail.com
*    
*   Ejemplo Problema. Dado un número entero N multiplicarlo por 2 y sumar 1. 
      caso1.txt       caso2.txt           caso3.txt
      1               2                   -3
Salida:
      3               5                   -5
*/

// ITESS TICS 2026
// Periodo Agosto-Diciembre
// Estructura y Organización de datos
// Tema1 Fundamentos de Estructura de Datos
// 1.3 Estructura nineal y no lineal 
// 1.4 estructura estatica y 
// compilar javac

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer; 


class GameEntry{
    private String name;
    private int score;

    public GameEntry(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return this.score;
    }

    public String toString(){
        return "(GameEntry: " + name +", " + score + ")";
    }
}

class ScoreBoard{
    private int maxSize;
    private GameEntry score[];
    private int numEntries = 0;

    public ScoreBoard(int maxSize){
        this.maxSize = maxSize;
        score = new GameEntry[maxSize];
    }

    public void addScoreEntry(GameEntry e){
        // Si hay espacio se inserta directo; si no hay espacio,
        // solo se inserta si el nuevo score es mayor que el último
        // (el más bajo), y ese último elemento se elimina (se descarta).
        if (numEntries < maxSize || e.getScore() > score[numEntries - 1].getScore()){
            if (numEntries < maxSize){
                numEntries++;
            }
            int j = numEntries - 1;
            while (j > 0 && score[j - 1].getScore() < e.getScore()){
                score[j] = score[j - 1];
                j--;
            }
            score[j] = e;
        }
    }

    public String getTopPlayerScore(){
        return score[0].getName();
    }
}


public class ScoreBoardApp { 
    // FastReader class for efficient input
    int numero;
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

    public static void main(String[] args) {
        FastReader reader = new FastReader();

        // Primera línea: N (tamaño maximo del tablero) y M (cantidad de entradas a leer)
        int n = reader.nextInt();
        int m = reader.nextInt();

        ScoreBoard board = new ScoreBoard(n);

        // M líneas siguientes con nombre y score
        for (int i = 0; i < m; i++) {
            String name = reader.next();
            int score = reader.nextInt();
            board.addScoreEntry(new GameEntry(name, score));
        }

        System.out.println(board.getTopPlayerScore());
    }
}