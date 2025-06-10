package ex2a9;

import java.util.*;
import java.util.Scanner;

public class PlaneManager {

    private Map<String, Plane> planes;

    public PlaneManager() {
        planes = new HashMap<>();
    }

    public void addPlane(Plane p) {
        if(!planes.containsKey(p.getId())){
            planes.put(p.getId(), p);
        } else {
            System.out.println("Já existe um avião com o ID: "+ p.getId());
        }
    }

    public void removePlane(String id) {
        if(planes.containsKey(id)){
            planes.remove(id);
            System.out.println("Avião removido.");
        } else {
            System.out.println("Não existe nenhum com o ID: " + id);
        }
    }

    public Plane searchPlane(String id) {
        return planes.get(id);
    }

    public List<Plane> getCommercialPlanes() {
        List<Plane> commercialPlanes = new ArrayList<>();
        for (Plane p : planes.values()) {
            if (p instanceof CommercialPlane) {
                commercialPlanes.add(p);
            }
        }
        return commercialPlanes;
    }

    public List<Plane> getMilitaryPlanes(){
        List<Plane> militaryPlanes = new ArrayList<>();
        for (Plane p : planes.values()) {
            if (p instanceof MilitaryPlane) {
                militaryPlanes.add(p);
            }
        }
        return militaryPlanes;
    }

    public void printAllPlanes(){
        for (Plane p : planes.values()){
            System.out.println("Avião: " + p);
        }
    }

    public Plane getFastestPlane(){
        Plane maisRapido = null;

        for (Plane p : planes.values()) {
            if (maisRapido == null || p.getMaxVel() > maisRapido.getMaxVel()){
                maisRapido = p;
            }
        }

        return maisRapido;
    }

    public static void main(String[] args) {
        PlaneManager manager = new PlaneManager();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Adicionar avião comercial");
            System.out.println("2. Adicionar avião militar");
            System.out.println("3. Remover avião");
            System.out.println("4. Procurar avião por ID");
            System.out.println("5. Imprimir todos os aviões");
            System.out.println("6. Imprimir aviões comerciais");
            System.out.println("7. Imprimir aviões militares");
            System.out.println("8. Mostrar avião mais rápido");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("ID: ");
                    String id1 = sc.nextLine();
                    System.out.print("Fabricante: ");
                    String fab1 = sc.nextLine();
                    System.out.print("Modelo: ");
                    String mod1 = sc.nextLine();
                    System.out.print("Ano de produção: ");
                    int ano1 = sc.nextInt();
                    System.out.print("Capacidade máxima de passageiros: ");
                    int cap1 = sc.nextInt();
                    System.out.print("Velocidade máxima: ");
                    int vel1 = sc.nextInt();
                    System.out.print("Número de tripulantes: ");
                    int trip = sc.nextInt();
                    manager.addPlane(new CommercialPlane(id1, fab1, mod1, ano1, cap1, vel1, trip));
                    break;

                case 2:
                    System.out.print("ID: ");
                    String id2 = sc.nextLine();
                    System.out.print("Fabricante: ");
                    String fab2 = sc.nextLine();
                    System.out.print("Modelo: ");
                    String mod2 = sc.nextLine();
                    System.out.print("Ano de produção: ");
                    int ano2 = sc.nextInt();
                    System.out.print("Capacidade máxima de passageiros: ");
                    int cap2 = sc.nextInt();
                    System.out.print("Velocidade máxima: ");
                    int vel2 = sc.nextInt();
                    System.out.print("Número de munições: ");
                    int muni = sc.nextInt();
                    manager.addPlane(new MilitaryPlane(id2, fab2, mod2, ano2, cap2, vel2, muni));
                    break;

                case 3:
                    System.out.print("ID do avião a remover: ");
                    String idRem = sc.nextLine();
                    manager.removePlane(idRem);
                    break;

                case 4:
                    System.out.print("ID do avião a procurar: ");
                    String idProc = sc.nextLine();
                    Plane p = manager.searchPlane(idProc);
                    if (p != null) {
                        System.out.println(p);
                    } else {
                        System.out.println("Avião não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- Todos os Aviões ---");
                    manager.printAllPlanes();
                    break;

                case 6:
                    System.out.println("\n--- Aviões Comerciais ---");
                    for (Plane pc : manager.getCommercialPlanes()) {
                        System.out.println(pc);
                    }
                    break;

                case 7:
                    System.out.println("\n--- Aviões Militares ---");
                    for (Plane pm : manager.getMilitaryPlanes()) {
                        System.out.println(pm);
                    }
                    break;

                case 8:
                    System.out.println("\n--- Avião mais rápido ---");
                    Plane fastest = manager.getFastestPlane();
                    if (fastest != null) {
                        System.out.println(fastest);
                    } else {
                        System.out.println("Nenhum avião registado.");
                    }
                    break;

                case 0:
                    running = false;
                    System.out.println("Programa terminado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }

}
