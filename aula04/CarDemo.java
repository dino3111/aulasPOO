package aula04;
import java.util.Scanner;

class Carro {
    private String marca, modelo;
    private int ano, quilometragem;

    public Carro(String marca, String modelo, int ano, int quilometragem) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.quilometragem = quilometragem;
    }

    public void dirigir(int distancia) {
        if (distancia > 0) {
            quilometragem += distancia;
        }
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAno() { return ano; }
    public int getQuilometragem() { return quilometragem; }
}

public class CarDemo {
    private static final Scanner scanner = new Scanner(System.in);

    private static int registrarCarros(Carro[] carros) {
        int contador = 0;
        while (contador < carros.length) {
            System.out.print("Insira os detalhes do carro (marca modelo ano km): ");
            String entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) break;
            
            String[] dados = entrada.split(" ");
            if (dados.length < 4) {
                System.out.println("Erro: Formato inválido. Tente novamente.");
                continue;
            }
            
            try {
                String marca = dados[0];
                String modelo = String.join(" ", java.util.Arrays.copyOfRange(dados, 1, dados.length - 2));
                int ano = Integer.parseInt(dados[dados.length - 2]);
                int quilometragem = Integer.parseInt(dados[dados.length - 1]);
                carros[contador++] = new Carro(marca, modelo, ano, quilometragem);
            } catch (NumberFormatException e) {
                System.out.println("Erro: O ano e os km devem ser números.");
            }
        }
        return contador;
    }

    private static void registrarViagens(Carro[] carros, int numCarros) {
        while (true) {
            System.out.print("Registe uma viagem no formato (número:distância): ");
            String entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) break;
            String[] dados = entrada.split(":");
            if (dados.length == 2) {
                try {
                    int indice = Integer.parseInt(dados[0]);
                    int distancia = Integer.parseInt(dados[1]);
                    if (indice >= 0 && indice < numCarros && distancia > 0) {
                        carros[indice].dirigir(distancia);
                    } else {
                        System.out.println("Erro: Índice inválido ou distância negativa.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Entrada inválida, tente novamente.");
                }
            } else {
                System.out.println("Formato incorreto, use número:distância.");
            }
        }
    }

    private static void listarCarros(Carro[] carros, int numCarros) {
        System.out.println("\nLista de carros registados:");
        for (int i = 0; i < numCarros; i++) {
            System.out.printf("%d - %s %s, %d, km: %d%n", i, carros[i].getMarca(), carros[i].getModelo(), carros[i].getAno(), carros[i].getQuilometragem());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Carro[] carros = new Carro[10];
        int numCarros = registrarCarros(carros);
        if (numCarros > 0) {
            listarCarros(carros, numCarros);
            registrarViagens(carros, numCarros);
            listarCarros(carros, numCarros);
        }
        scanner.close();
    }
}
