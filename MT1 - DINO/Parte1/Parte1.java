package Parte1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.nio.file.Files;
import java.nio.file.Paths; 
public class Parte1 {
    // -----------------------------------------------------
    //          !!! Não alterar este código !!!
    // -----------------------------------------------------
    private static int v1;
    private static List<Integer> v2 = new ArrayList<>();
    private static String v3;
    private static List<String> v4 = new ArrayList<>();
    // -----------------------------------------------------

    // -----------------------------------------------------------
    // >> Pode acrescentar novos métodos aqui (não é obrigatório)
    // -----------------------------------------------------------

    // pex., public static void ler(SOURCE) {}

    // -----------------------------------------------------------

    public static void lerTeclado() {
        Scanner scanner = new Scanner(System.in);
    
        v1 = Integer.parseInt(scanner.nextLine());
    
        String[] numeros = scanner.nextLine().split(" ");
        v2.clear();

        for (String num : numeros) {
            v2.add(Integer.parseInt(num));
        }
    
        v3 = scanner.nextLine();
    
        String[] palavras = scanner.nextLine().split(" ");
        v4.clear();

        for (String palavra : palavras) {
            v4.add(palavra);
        }
    }
    

    public static void lerFicheiro() {
        try {
            List<String> linhas = Files.readAllLines(Paths.get("src/Parte1/inputs.txt"));
    
            v1 = Integer.parseInt(linhas.get(0));
    
            for (String num : linhas.get(1).split(" "))
                v2.add(Integer.parseInt(num));
    
            v3 = linhas.get(2);
     
            for (String num : linhas.get(3).split(" "))
                v4.add(num);

        } catch (Exception e) {
            System.out.println("Erro ao ler o ficheiro: " + e.getMessage());
        }
    }
    

    
    public static void imprimir() {
        System.out.println(v1);

        for (int i = 0; i < v2.size(); i++) {
            System.out.print(v2.get(i));
            if (i < v2.size() - 1) System.out.print(" ");
        }
        System.out.println();

        System.out.println(v3);

        for (int i = 0; i < v4.size(); i++) {
            System.out.print(v4.get(i));
            if (i < v4.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // -----------------------------------------------------------------
        // !!! Não imprimir texto a pedir determinado input, ler direto !!!
        // -----------------------------------------------------------------

        lerFicheiro();
        imprimir();

    }
}
