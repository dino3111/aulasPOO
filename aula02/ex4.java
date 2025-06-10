package aula02;

import java.util.ArrayList;
import java.util.Scanner;

public class ex4 {
    public static void main(String args[]){

    ArrayList<Double> numeros = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Diz um valor para começar a lista: ");
    double primeiro = scanner.nextInt();

    numeros.add(primeiro);

    while(true){

        System.out.print("Diz outro valor para adicionar à lista (para acabar, dá o valor do primeiro número): ");
        double numero = scanner.nextDouble();

        if(numero == primeiro){
            break;
        }

        numeros.add(numero);
    
    }

    scanner.close();

    double max = numeros.get(0);
    double min = numeros.get(0);
    int soma = 0;

    for (double n : numeros){
        if (n > max) max = n;
        if (n < min) min = n;
        soma += n;
    }

    double media = soma / numeros.size();

    System.out.print("Resultados: ");
    System.out.print("\nValor Máximo: " + max);
    System.out.print("\nValor Minimo: " + min);
    System.out.print("\nSoma: " + soma);
    System.out.print("\nMédia: " + media);
    System.out.print("\nNúmeros Totais Lidos: " + numeros.size());

    for (double j : numeros){
        if (j > media){
            System.out.print("\nNúmero acima da média: " + j);
        }
    }
    }
}
