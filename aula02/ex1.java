package aula02;

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número: ");

        int segundos = scanner.nextInt();
        int horas = segundos / 3600;
        int minutos = (segundos % 3600) / 60;
        int segundosRestantes = segundos % 60;

        System.out.println(segundos + " São " + horas + " Horas, " + minutos + " Minutos e " + segundosRestantes + " Segundos.");
        scanner.close();
    }
}
