package aula01;
import java.io.IOException; /* Importa a classe IOException */
import java.nio.file.Files; /* Importa a classe Files */
import java.nio.file.Path; /* Importa a classe Path */
import java.nio.file.Paths; /* Importa a classe Paths */


public class ReadFileExample { /* Define a classe (deve ser o nome do ficheiro) */

	public static void main(String[] args) { /* Função principal, onde a execução começa*/
		Path fich = Paths.get("POO/src/major.txt"); /* Cria um objeto Path com o caminho do ficheiro */
		try { 										/* Tenta executar o código */
			Files.readAllLines(fich).stream().forEach(System.out::println); /* Lê todas as linhas do ficheiro e imprime-as */
		} catch (IOException e) { 										 /* Se houver um erro */
			System.out.println("Certifique-se que o ficheiro \"POO/src/major.txt\" está na raiz da pasta do projeto"); /* Mostra uma mensagem de erro */
		}
	}
	
}
