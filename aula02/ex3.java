package aula02;

import java.util.Scanner;

public class ex3 {
    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Valor do primeiro cateto: ");
        int cat1 = scanner.nextInt();

        System.out.print("Valor do segundo cateto: ");
        int cat2 = scanner.nextInt();

        if(cat1 <= 0 || cat2 <= 0) {
            System.out.print("Os valores dos catetos devem ser positivos.");
            scanner.close();
            return;
        }

        double hypo = Math.sqrt(cat1*cat1 + cat2*cat2);
        System.out.print("O valor da hipotenusa é igual a " + hypo);

        double anguloRad = Math.acos(cat1 / hypo);
        double anguloGraus = Math.toDegrees(anguloRad);

        System.out.print("\nO valor do ângulo entre o cateto A e a hipotenusa é de " + anguloGraus + " Graus.");

        scanner.close();
    }
}
