package avaliacaoFinal;

public class Place {
    private String nome;
    private int capacidade;

    public Place(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return this.capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
    public String toString() {
        return "Nome: " + nome + ", Capacidade: " + capacidade;
    }
}
