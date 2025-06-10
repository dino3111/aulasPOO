package aula04;

import java.util.Scanner;

public class ex1 {
    static class Circulo {
        private double raio;

        public Circulo(double raio) {
            if (raio <= 0) {
                System.out.println("Erro: O raio deve ser positivo.");
                return;
            }
            this.raio = raio;
        }

        public double calcularArea() {
            return 3.14 * raio * raio;
        }

        public double calcularPerimetro() {
            return 2 * 3.14 * raio;
        }

        public String toString() {
            return "Círculo - Raio: " + raio + ", Área: " + calcularArea() + ", Perímetro: " + calcularPerimetro();
        }
    }

    static class Triangulo {
        private double lado1, lado2, lado3;

        public Triangulo(double lado1, double lado2, double lado3) {
            if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0 || lado1 + lado2 <= lado3 || lado1 + lado3 <= lado2 || lado2 + lado3 <= lado1) {
                System.out.println("Erro: Lados inválidos para um triângulo.");
                return;
            }
            this.lado1 = lado1;
            this.lado2 = lado2;
            this.lado3 = lado3;
        }

        public double calcularArea() {
            double s = (lado1 + lado2 + lado3) / 2;
            return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
        }

        public double calcularPerimetro() {
            return lado1 + lado2 + lado3;
        }

        public String toString() {
            return "Triângulo - Lados: " + lado1 + ", " + lado2 + ", " + lado3 + ", Área: " + calcularArea() + ", Perímetro: " + calcularPerimetro();
        }
    }

    static class Retangulo {
        private double comprimento, altura;

        public Retangulo(double comprimento, double altura) {
            if (comprimento <= 0 || altura <= 0) {
                System.out.println("Erro: Valores inválidos.");
                return;
            }
            this.comprimento = comprimento;
            this.altura = altura;
        }

        public double calcularArea() {
            return comprimento * altura;
        }

        public double calcularPerimetro() {
            return 2 * (comprimento + altura);
        }

        public String toString() {
            return "Retângulo - Comprimento: " + comprimento + ", Altura: " + altura + ", Área: " + calcularArea() + ", Perímetro: " + calcularPerimetro();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Criar Círculo");
            System.out.println("2 - Criar Triângulo");
            System.out.println("3 - Criar Retângulo");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            if (opcao == 4) break;

            if (opcao == 1) {
                System.out.print("Digite o raio: ");
                double raio = scanner.nextDouble();
                Circulo c = new Circulo(raio);
                System.out.println(c);
            } 
            else if (opcao == 2) {
                System.out.print("Digite os três lados do triângulo: ");
                double l1 = scanner.nextDouble(), l2 = scanner.nextDouble(), l3 = scanner.nextDouble();
                Triangulo t = new Triangulo(l1, l2, l3);
                System.out.println(t);
            } 
            else if (opcao == 3) {
                System.out.print("Digite o comprimento e altura: ");
                double comp = scanner.nextDouble(), alt = scanner.nextDouble();
                Retangulo r = new Retangulo(comp, alt);
                System.out.println(r);
            } 
            else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}

