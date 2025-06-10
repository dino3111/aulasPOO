package aula07;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio7_1 {

    static abstract class Forma {
        protected String cor;

        public Forma(String cor) {
            this.cor = cor;
        }

        public String getCor() {
            return cor;
        }

        public abstract double calcularArea();
        public abstract double calcularPerimetro();

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Forma forma = (Forma) obj;
            return cor.equalsIgnoreCase(forma.cor);
        }

        @Override
        public int hashCode() {
            return cor.toLowerCase().hashCode();
        }
    }

    // Subclasse Circulo
    static class Circulo extends Forma {
        private double raio;

        public Circulo(double raio, String cor) {
            super(cor);
            if (raio <= 0)
                throw new IllegalArgumentException("Erro: O raio deve ser positivo.");
            this.raio = raio;
        }

        @Override
        public double calcularArea() {
            return Math.PI * raio * raio;
        }

        @Override
        public double calcularPerimetro() {
            return 2 * Math.PI * raio;
        }

        @Override
        public String toString() {
            return String.format("Círculo - Raio: %.2f, Cor: %s, Área: %.2f, Perímetro: %.2f",
                    raio, cor, calcularArea(), calcularPerimetro());
        }
    }

    // Subclasse Triangulo
    static class Triangulo extends Forma {
        private double lado1, lado2, lado3;

        public Triangulo(double lado1, double lado2, double lado3, String cor) {
            super(cor);
            if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0 ||
                lado1 + lado2 <= lado3 || lado1 + lado3 <= lado2 || lado2 + lado3 <= lado1)
                throw new IllegalArgumentException("Erro: Lados inválidos para um triângulo.");
            this.lado1 = lado1;
            this.lado2 = lado2;
            this.lado3 = lado3;
        }

        @Override
        public double calcularArea() {
            double s = calcularPerimetro() / 2;
            return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
        }

        @Override
        public double calcularPerimetro() {
            return lado1 + lado2 + lado3;
        }

        @Override
        public String toString() {
            return String.format("Triângulo - Lados: %.2f, %.2f, %.2f, Cor: %s, Área: %.2f, Perímetro: %.2f",
                    lado1, lado2, lado3, cor, calcularArea(), calcularPerimetro());
        }
    }

    // Subclasse Retangulo
    static class Retangulo extends Forma {
        private double comprimento, altura;

        public Retangulo(double comprimento, double altura, String cor) {
            super(cor);
            if (comprimento <= 0 || altura <= 0)
                throw new IllegalArgumentException("Erro: Valores inválidos para o retângulo.");
            this.comprimento = comprimento;
            this.altura = altura;
        }

        @Override
        public double calcularArea() {
            return comprimento * altura;
        }

        @Override
        public double calcularPerimetro() {
            return 2 * (comprimento + altura);
        }

        @Override
        public String toString() {
            return String.format("Retângulo - Comprimento: %.2f, Altura: %.2f, Cor: %s, Área: %.2f, Perímetro: %.2f",
                    comprimento, altura, cor, calcularArea(), calcularPerimetro());
        }
    }

    // Main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Forma> formas = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Criar Círculo");
            System.out.println("2 - Criar Triângulo");
            System.out.println("3 - Criar Retângulo");
            System.out.println("4 - Listar todas as formas");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 5) break;

            try {
                System.out.print("Digite a cor da figura: ");
                String cor = scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o raio: ");
                        double raio = scanner.nextDouble();
                        formas.add(new Circulo(raio, cor));
                        break;
                    case 2:
                        System.out.print("Digite os três lados do triângulo: ");
                        double l1 = scanner.nextDouble();
                        double l2 = scanner.nextDouble();
                        double l3 = scanner.nextDouble();
                        formas.add(new Triangulo(l1, l2, l3, cor));
                        break;
                    case 3:
                        System.out.print("Digite o comprimento e altura: ");
                        double comp = scanner.nextDouble();
                        double alt = scanner.nextDouble();
                        formas.add(new Retangulo(comp, alt, cor));
                        break;
                    case 4:
                        System.out.println("\nFiguras criadas:");
                        for (Forma f : formas) {
                            System.out.println(f);
                        }
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
