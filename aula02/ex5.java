package aula02;

import java.util.Scanner;

public class ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduza uma frase: ");
        String string = scanner.nextLine();

        int count = countDigits(string);
        System.out.println("A frase tem " + count + " dígitos.");

        int espacos = espacos(string);
        System.out.println("A frase tem " + espacos + " espaços.");

        if (minusculas(string)){
            System.out.println("A frase está escrita em minúsculas.");
        } else {
            System.out.println("A frase contem maisculas.");
        }

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

    public static boolean minusculas(String s) {
        return s.equals(s.toLowerCase());
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
