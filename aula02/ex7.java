
package aula02;

import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduza uma frase: ");
        String string = scanner.nextLine();

        String frase = toLowerCase(string);
        System.out.println(frase);

        int espacos = espacos(string);
        System.out.println("A frase tem " + espacos + " espaços.");

        String string2 = normalizarEspacos(string);
        System.out.println(string2);

        if (palindromo(string)){
            System.out.println("A frase é um palíndromo.");
        } else {
            System.out.println("A frase náo é um palíndromo.");
        }
    
    }

    public static int countDigits(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))){
                count++;
            }
        }
        return count;
    }

    public static String minusculas(String s) {
        return (s.toLowerCase(s));
    }

    public static int espacos(String s) {
        int espacos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                espacos++;
            }
        }
        return espacos;
    }

    public static String normalizarEspacos(String s) {
        return s.trim().replaceAll("\\s+", " ");
    }

    public static boolean palindromo(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

}

