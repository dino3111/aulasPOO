package aula09.ex92;

import java.util.List;
import java.util.Scanner;

public class PlaneTester {
    public static void main(String[] args) {
        PlaneManager manager = new PlaneManager();
        Scanner sc = new Scanner(System.in);
        int opc;

        do {
            System.out.println("\n=== Gerenciamento de Frota ===");
            System.out.println("1. Adicionar avião comercial");
            System.out.println("2. Adicionar avião militar");
            System.out.println("3. Remover avião");
            System.out.println("4. Buscar avião por ID");
            System.out.println("5. Listar todos os aviões");
            System.out.println("6. Listar aviões comerciais");
            System.out.println("7. Listar aviões militares");
            System.out.println("8. Avião mais rápido");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opc = sc.nextInt();
            sc.nextLine();  
            sc.nextLine();  


            switch (opc) {
                case 1 -> {
                    System.out.print("ID: "); String id = sc.nextLine();
                    System.out.print("Fabricante: "); String fab = sc.nextLine();
                    System.out.print("Modelo: "); String mod = sc.nextLine();
                    System.out.print("Ano produção: "); int ano = sc.nextInt();
                    System.out.print("Capacidade passageiros: "); int pax = sc.nextInt();
                    System.out.print("Velocidade máxima (km/h): "); int vel = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Companhia aérea: "); String cia = sc.nextLine();
                    manager.addPlane(new CommercialPlane(id, fab, mod, ano, pax, vel, cia));
                    System.out.println("Aeronave comercial adicionada.");
                }
                case 2 -> {
                    System.out.print("ID: "); String id = sc.nextLine();
                    System.out.print("Fabricante: "); String fab = sc.nextLine();
                    System.out.print("Modelo: "); String mod = sc.nextLine();
                    System.out.print("Ano produção: "); int ano = sc.nextInt();
                    System.out.print("Capacidade passageiros: "); int pax = sc.nextInt();
                    System.out.print("Velocidade máxima (km/h): "); int vel = sc.nextInt();
                    System.out.print("Número de munições: "); int mun = sc.nextInt();
                    sc.nextLine();
                    manager.addPlane(new MilitaryPlane(id, fab, mod, ano, pax, vel, mun));
                    System.out.println("Aeronave militar adicionada.");
                }
                case 3 -> {
                    System.out.print("ID a remover: ");
                    String id = sc.nextLine();
                    if (manager.removePlane(id))
                        System.out.println("Removido com sucesso.");
                    else
                        System.out.println("ID não encontrado.");
                }
                case 4 -> {
                    System.out.print("ID a buscar: ");
                    String id = sc.nextLine();
                    Plane p = manager.searchPlane(id);
                    System.out.println(p != null ? p : "Não existe avião com esse ID.");
                }
                case 5 -> manager.printAllPlanes();
                case 6 -> {
                    List<Plane> comerciais = manager.getCommercialPlanes();
                    if (comerciais.isEmpty()) System.out.println("Nenhum comercial.");
                    else comerciais.forEach(System.out::println);
                }
                case 7 -> {
                    List<Plane> militares = manager.getMilitaryPlanes();
                    if (militares.isEmpty()) System.out.println("Nenhum militar.");
                    else militares.forEach(System.out::println);
                }
                case 8 -> {
                    Plane rapido = manager.getFastestPlane();
                    System.out.println(rapido != null
                        ? "Mais rápido:\n" + rapido
                        : "Frota vazia.");
                }
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opc != 0);

        sc.close();
    }
}

