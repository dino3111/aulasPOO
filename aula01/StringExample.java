package aula01;

public class StringExample { /* Define a classe (deve ser o nome do ficheiro)*/
	public static void main(String[] args) { /* Função principal, onde a execução começa*/
		String s1 = "programar em Java"; /* Declaração de uma variável do tipo String */
		System.out.println(s1.split(" ")[0] + " é engraçado!! :)"); /* Divide a string em palavras e imprime a primeira */
		System.out.println("É giro " + s1); /* Concatenação de strings */
		for (int i=0; i<14; i++) /* Ciclo for de 0 a 13 */
			System.out.println("vamos " + s1 + " na aula " + i); /* Concatenação de strings */
	}
}