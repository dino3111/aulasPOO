package Teste2020POO;

public class Autor {
    String nome;
    int anoNascimento;

    public Autor(String nome, int anoNascimento) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public String toString() {
        return getNome() + " (" + getAnoNascimento() + ")";
    }
}
