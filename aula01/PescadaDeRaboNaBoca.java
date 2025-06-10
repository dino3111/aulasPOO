package aula01;

public class PescadaDeRaboNaBoca { /* Define a classe (deve ser o nome do ficheiro)*/

	public static void main(String[] args) { /* Função principal, onde a execução começa*/
		recursivoSimples(100); /* Chama a função recursiva */
	} /* Fim da função principal */

	public static void recursivoSimples(int x) { /* Função recursiva que recebe um inteiro x */
		System.out.println(x); /* Mostra o valor de x */
		x--; /* Decrementa x */
		if (x>0) 		/* Se x for maior que 0 */
			recursivoSimples(x); /* Chama a função recursiva com o novo valor de x */
	}

}

// Função recursiva que imprime os números de 100 a 1