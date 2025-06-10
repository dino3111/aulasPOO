package aula03;

import java.util.Scanner;

public class ex1 {

    // Função para verificar se é número primo
    public static boolean ehPrimo(int num) { 
        if (num < 2) 
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Função para calcular a soma dos números primos até um determinado valor
    public static int somaPrimos(int limite) {
        int soma = 0;
        for (int i = 2; i <= limite; i++) {
            if (ehPrimo(i)) {
                soma += i;
            }
        }
        return soma;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        // Leitura e validação do número
        do {
            System.out.print("Introduza um número inteiro positivo: ");
            while (!scanner.hasNextInt()) { // Garante que o usuário digite um número inteiro
                System.out.println("Entrada inválida! Digite um número inteiro positivo.");
                scanner.next(); // Descarta entrada inválida
            }
            numero = scanner.nextInt();
        } while (numero <= 0); // Repete enquanto o número não for positivo

        // Calcula e exibe a soma dos números primos até o número informado
        int soma = somaPrimos(numero);
        System.out.println("A soma dos números primos até " + numero + " é: " + soma);

        scanner.close();
    }
}
