package aula02;

import java.util.Scanner;

public class ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduza uma frase: ");
        String frase = scanner.nextLine();

        String acronimo = gerarAcronimo(frase);
        System.out.println("Acrónimo: " + acronimo);
    }

    public static String gerarAcronimo(String frase) {
        String[] palavras = frase.trim().split("\\s+"); 
        StringBuilder acronimo = new StringBuilder();

        for (String palavra : palavras) {
            if (palavra.length() >= 3) {
                acronimo.append(Character.toUpperCase(palavra.charAt(0)));
            }
        }

        return acronimo.toString();
    }
}

