package aula06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Pessoa {
    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome;
    }
}

class Aluno extends Pessoa {
    public Aluno(String nome) {
        super(nome);
    }
}

class Professor extends Pessoa {
    public Professor(String nome) {
        super(nome);
    }
}

class Contato {
    private static int contador = 1;
    private int id;
    private Pessoa pessoa;
    private String telefone;
    private String email;

    public Contato(Pessoa pessoa, String telefone, String email) {
        if (telefone == null && email == null) {
            throw new IllegalArgumentException("Pelo menos um meio de contato deve ser fornecido.");
        }
        if (telefone != null && !validarTelefone(telefone)) {
            throw new IllegalArgumentException("Número de telemóvel inválido! Deve ter 9 dígitos e começar com '9'.");
        }
        if (email != null && !validarEmail(email)) {
            throw new IllegalArgumentException("Endereço de email inválido!");
        }

        this.id = contador++;
        this.pessoa = pessoa;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (!validarTelefone(telefone)) {
            throw new IllegalArgumentException("Número de telemóvel inválido!");
        }
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!validarEmail(email)) {
            throw new IllegalArgumentException("Endereço de email inválido!");
        }
        this.email = email;
    }

    private boolean validarTelefone(String telefone) {
        return telefone.matches("^9\\d{8}$");
    }

    private boolean validarEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.(pt|com|net|org)$");
    }

    @Override
    public String toString() {
        return "ID: " + id + ", " + pessoa + ", Telefone: " + (telefone != null ? telefone : "N/A") +
                ", Email: " + (email != null ? email : "N/A");
    }
}

// Classe que gerencia a lista de contatos
class GestorDeContactos {
    private List<Contato> contatos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void inserirContato() {
        System.out.print("Nome da pessoa: ");
        String nome = scanner.nextLine();

        Pessoa pessoa;
        System.out.print("É um Aluno (A) ou Professor (P)? ");
        String tipo = scanner.next().trim().toUpperCase();
        scanner.nextLine(); 


        if (tipo.equals("A")) {
            pessoa = new Aluno(nome);
        } else if (tipo.equals("P")) {
            pessoa = new Professor(nome);
        } else {
            System.out.println("Opção inválida!");
            return;
        }

        System.out.print("Número de telemóvel (ou Enter para ignorar): ");
        String telefone = scanner.nextLine().trim();
        telefone = telefone.isEmpty() ? null : telefone;

        System.out.print("Email (ou Enter para ignorar): ");
        String email = scanner.nextLine().trim();
        email = email.isEmpty() ? null : email;

        for (Contato c : contatos) {
            if (c.getPessoa().getNome().equalsIgnoreCase(nome)) {
                System.out.print("Esta pessoa já tem um contato. Deseja adicionar outro? (S/N): ");
                if (!scanner.nextLine().trim().equalsIgnoreCase("S")) {
                    return;
                }
                break;
            }
        }

        try {
            contatos.add(new Contato(pessoa, telefone, email));
            System.out.println("Contato adicionado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void alterarContato() {
        Contato contato = buscarContato();
        if (contato == null) return;

        System.out.print("Novo telefone (ou Enter para manter): ");
        String novoTelefone = scanner.nextLine().trim();
        if (!novoTelefone.isEmpty()) {
            try {
                contato.setTelefone(novoTelefone);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
                return;
            }
        }

        System.out.print("Novo email (ou Enter para manter): ");
        String novoEmail = scanner.nextLine().trim();
        if (!novoEmail.isEmpty()) {
            try {
                contato.setEmail(novoEmail);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        System.out.println("Contato atualizado!");
    }

    public void apagarContato() {
        Contato contato = buscarContato();
        if (contato != null) {
            contatos.remove(contato);
            System.out.println("Contato removido!");
        }
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato registrado.");
        } else {
            contatos.forEach(System.out::println);
        }
    }

    public Contato buscarContato() {
        System.out.print("Pesquisar por Nome ou Número: ");
        String termo = scanner.nextLine().trim();

        List<Contato> encontrados = new ArrayList<>();
        for (Contato c : contatos) {
            if (c.getPessoa().getNome().equalsIgnoreCase(termo) || (c.getTelefone() != null && c.getTelefone().equals(termo))) {
                encontrados.add(c);
            }
        }

        if (encontrados.isEmpty()) {
            System.out.println("Contato não encontrado!");
            return null;
        }

        if (encontrados.size() == 1) {
            return encontrados.get(0);
        }

        System.out.println("Vários contatos encontrados:");
        encontrados.forEach(System.out::println);
        System.out.print("Digite o ID desejado: ");
        int id = Integer.parseInt(scanner.nextLine());
        return encontrados.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }
}

// Classe principal com o menu
public class GestorContactos {
    public static void main(String[] args) {
        GestorDeContactos gestor = new GestorDeContactos();
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;

            do {
                System.out.println("\n1. Inserir contacto\n2. Alterar contacto\n3. Apagar contacto\n4. Procurar contacto\n5. Listar contactos\n0. Sair");
                System.out.print("Escolha: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> gestor.inserirContato();
                    case 2 -> gestor.alterarContato();
                    case 3 -> gestor.apagarContato();
                    case 4 -> gestor.buscarContato();
                    case 5 -> gestor.listarContatos();
                }
            } while (opcao != 0);
        }
    }
}
