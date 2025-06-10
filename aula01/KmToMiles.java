package aula01;
import java.util.Scanner; /* Funciona como um input em python */

public class KmToMiles { /* Define a classe, deve ser o nome do ficheiro*/
	public static void main(String[] args) { /* Função principal, onde a execução começa*/
		double km, miles; /* Declaração de variáveis dadas pelo utilizador, do tipo double(valores decimais)*/
		Scanner sc = new Scanner(System.in); /* Criação de um objeto Scanner para ler input do utilizador */
		System.out.print("Insira distância em km: "); /* Mensagem para o utilizador */
		km = sc.nextDouble(); /* Lê o valor dado pelo utilizador */
		miles = km / 1.609; /* Faz a conversão de km para milhas */
		System.out.println("A distância em milhas é " + miles); /* Mostra o resultado */
		sc.close(); /* Fecha o objeto Scanner */
	}
}
