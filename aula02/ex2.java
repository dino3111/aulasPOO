package aula02;

import java.util.Scanner;

public class ex2 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digita o x1 do primeiro ponto: ");
        int x1 = scanner.nextInt();

        System.out.print("Digita o y do primeiro ponto: ");
        int y1 = scanner.nextInt();

        System.out.print("Digita o y do primeiro ponto: ");
        int x2 = scanner.nextInt();

        System.out.print("Digita o y do primeiro ponto: ");
        int y2 = scanner.nextInt();

        double distancia = Math.sqrt((x2-x1)*2 + (y2-y1)*2);
        System.out.print("A distância entre o ponto 1 e 2 é "+ distancia);

        scanner.close();
        
    }
}
