package avaliacaoFinal;

public class Event {
    private String nome;
    private int duracao;

    public Event(String nome, int duracao) {
        this.nome = nome;
        this.duracao = duracao;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return this.duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String toString() {
        return "Nome: " + nome + ", Duração: " + duracao;
    }
}
