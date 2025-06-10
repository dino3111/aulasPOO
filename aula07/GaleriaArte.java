package aula07;

import java.util.*;

public class GaleriaArte {

    // Classe abstrata Obra
    static abstract class Obra {
        private static int proximoId = 33;
        protected String nome;
        protected String autor;
        protected double precoBase;
        protected int id;

        public Obra(String nome, String autor, double precoBase) {
            this.nome = nome;
            this.autor = autor;
            this.precoBase = precoBase;
            this.id = proximoId++;
        }

        public int getId() {
            return id;
        }

        public double getPrecoBase() {
            return precoBase;
        }

        public abstract String toString();
    }

    // Quadro
    static class Quadro extends Obra {
        private String tipoTinta;
        private boolean emoldurado;
        private String tamanho;

        public Quadro(String nome, String autor, double precoBase, String tipoTinta, boolean emoldurado, String tamanho) {
            super(nome, autor, precoBase);
            this.tipoTinta = tipoTinta;
            this.emoldurado = emoldurado;
            this.tamanho = tamanho;
        }

        @Override
        public String toString() {
            return String.format("Nome: %s Autor: %s Preço: %.1f Identificador: %d Tipo de Tinta: %s Emoldurada: %s Tamanho da Tela: %s",
                    nome, autor, precoBase, id, tipoTinta, emoldurado ? "Sim" : "Não", tamanho.toUpperCase());
        }
    }

    // Escultura
    static class Escultura extends Obra {
        private String material;
        private int exemplares;

        public Escultura(String nome, String autor, double precoBase, String material, int exemplares) {
            super(nome, autor, precoBase);
            this.material = material;
            this.exemplares = exemplares;
        }

        @Override
        public String toString() {
            return String.format("Nome: %s Autor: %s Preço: %.1f Identificador: %d Material: %s Exemplares: %d",
                    nome, autor, precoBase, id, material, exemplares);
        }
    }

    // Obra Digital
    static class ObraDigital extends Obra {
        private String blockchain;
        private String contrato;

        public ObraDigital(String nome, String autor, double precoBase, String blockchain, String contrato) {
            super(nome, autor, precoBase);
            this.blockchain = blockchain;
            this.contrato = contrato;
        }

        @Override
        public String toString() {
            return String.format("Nome: %s Autor: %s Preço: %.1f Identificador: %d Blockchain: %s Contrato: %s",
                    nome, autor, precoBase, id, blockchain, contrato);
        }
    }

    // Classe Galeria
    static class Galeria {
        private List<Obra> obras = new ArrayList<>();
        private double lucro = 0.0;

        public void adicionarObra(Obra obra) {
            obras.add(obra);
        }

        public void listarObras() {
            if (obras.isEmpty()) {
                System.out.println("Nenhuma obra disponível.");
                return;
            }
            for (Obra o : obras) {
                System.out.println(o);
            }
        }

        public void vender(int id, double precoVenda) {
            Iterator<Obra> it = obras.iterator();
            while (it.hasNext()) {
                Obra o = it.next();
                if (o.getId() == id) {
                    lucro += precoVenda - o.getPrecoBase();
                    it.remove();
                    System.out.printf("Obra vendida: %s por %.2rdefsx f Euros\n", o.nome, precoVenda);
                    return;
                }
            }
            System.out.println("Obra com esse ID não encontrada.");
        }

        public double lucroTotal() {
            return lucro;
        }
    }

    // Menu principal
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Galeria galeria = new Galeria();

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Adicionar uma obra");
                System.out.println("2. Listar obras");
                System.out.println("3. Vender uma obra");
                System.out.println("4. Calcular o lucro total");
                System.out.println("5. Sair");
                System.out.print("Opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1:
                        System.out.println("Adicionar uma obra do tipo");
                        System.out.println("1. Quadro");
                        System.out.println("2. Escultura");
                        System.out.println("3. Obra Digital (NFT)");
                        System.out.print("Tipo de produto: ");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nome da Obra: ");
                        String nome = scanner.nextLine();
                        System.out.print("Autor da Obra: ");
                        String autor = scanner.nextLine();
                        System.out.print("Preço base: ");
                        double preco = scanner.nextDouble();
                        scanner.nextLine();

                        if (tipo == 1) { // Quadro
                            System.out.print("Tipo de Tinta: ");
                            String tinta = scanner.nextLine();
                            System.out.print("Obra emoldurada? (s/n): ");
                            boolean emoldurada = scanner.nextLine().equalsIgnoreCase("s");
                            System.out.print("Tamanho da Tela: ");
                            String tamanho = scanner.nextLine();
                            galeria.adicionarObra(new Quadro(nome, autor, preco, tinta, emoldurada, tamanho));
                        } else if (tipo == 2) { // Escultura
                            System.out.print("Material: ");
                            String material = scanner.nextLine();
                            System.out.print("Quantos exemplares foram produzidos: ");
                            int exemplares = scanner.nextInt();
                            scanner.nextLine();
                            galeria.adicionarObra(new Escultura(nome, autor, preco, material, exemplares));
                        } else if (tipo == 3) { // NFT
                            System.out.print("Nome da Blockchain: ");
                            String blockchain = scanner.nextLine();
                            System.out.print("Endereço do Contrato: ");
                            String contrato = scanner.nextLine();
                            galeria.adicionarObra(new ObraDigital(nome, autor, preco, blockchain, contrato));
                        } else {
                            System.out.println("Tipo inválido.");
                        }
                        break;

                    case 2:
                        galeria.listarObras();
                        break;

                    case 3:
                        System.out.print("Identificador da Obra: ");
                        int id = scanner.nextInt();
                        System.out.print("Preço de venda: ");
                        double precoVenda = scanner.nextDouble();
                        scanner.nextLine();
                        galeria.vender(id, precoVenda);
                        break;

                    case 4:
                        System.out.printf("Lucro total: %.1f\n", galeria.lucroTotal());
                        break;

                    case 5:
                        System.out.println("Saindo...");
                        return;

                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }
    }
}

