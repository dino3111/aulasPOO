package aula03;

import java.util.Scanner;

public class AltoBaixo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        boolean continuar = true;
        while (continuar) {
            // Primeira fase - Jogador tenta adivinhar
            int numeroAleatorio = (int) (Math.random() * 100) + 1;
            int tentativaJogador;
            int tentativasJogador = 0;
            
            System.out.println("Bem-vindo ao jogo AltoBaixo!");
            System.out.println("Tente adivinhar o número entre 1 e 100 que o computador escolheu.");
            
            do {
                System.out.print("Digite sua tentativa: ");
                tentativaJogador = sc.nextInt();
                tentativasJogador++;
                
                if (tentativaJogador < numeroAleatorio) {
                    System.out.println("Muito baixo! Tente novamente.");
                } else if (tentativaJogador > numeroAleatorio) {
                    System.out.println("Muito alto! Tente novamente.");
                } else {
                    System.out.println("Parabéns! Você acertou em " + tentativasJogador + " tentativas.");
                }
                
            } while (tentativaJogador != numeroAleatorio);
            
            // Segunda fase - Computador tenta adivinhar
            System.out.println("\nAgora é a vez do computador tentar adivinhar seu número!");
            System.out.println("Pense em um número entre 1 e 100 e NÃO o diga!");

            int tentativasComputador = 0;
            boolean acertou = false;
            int min = 1;
            int max = 100;
            int palpiteComputador;

            while (!acertou) {
                if (min > max) { 
                    System.out.println("Erro: Os valores de min e max ficaram inválidos! Reiniciando...");
                    break; 
                }

                // O computador faz um palpite usando busca binária
                palpiteComputador = (min + max) / 2;
                tentativasComputador++;
                
                System.out.println("\nO computador acha que o número é: " + palpiteComputador);
                System.out.print("Responda (M)aior, (m)enor ou (C)orreto: ");
                String resposta = sc.next().trim().toLowerCase(); 

                if (resposta.equals("m")) {  
                    max = palpiteComputador - 1;  
                    System.out.println("Você disse que o número é Menor.");
                } else if (resposta.equals("m")) { 
                    min = palpiteComputador + 1;  
                    System.out.println("Você disse que o número é Maior.");
                } else if (resposta.equals("c")) {
                    System.out.println("O computador acertou em " + tentativasComputador + " tentativas!");
                    acertou = true;
                } else {
                    System.out.println("Resposta inválida! Use apenas (M)aior, (m)enor ou (C)orreto.");
                    continue; 
                }
            }

            // Comparação entre tentativas do Jogador e do Computador
            System.out.println("\nResultado Final:");
            System.out.println("Computador: " + tentativasComputador + " tentativas.");
            System.out.println("Jogador: " + tentativasJogador + " tentativas.");
            
            if (tentativasComputador < tentativasJogador) {
                System.out.println("O computador ganhou!");
            } else if (tentativasComputador > tentativasJogador) {
                System.out.println("Parabéns, você ganhou!");
            } else {
                System.out.println("Empate!");
            }
            
            System.out.print("\nPretende continuar? Digite (S)im para jogar novamente: ");
            String resposta = sc.next();
            continuar = resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("Sim");
        }
        
        System.out.println("\nObrigado por jogar! Até a próxima.");
        sc.close();
    }
}
