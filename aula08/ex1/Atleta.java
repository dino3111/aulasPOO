package aula08.ex1;

public class Atleta implements IKmPercorridos {
    private String nome;
    private int quilometrosTreinados = 0;

    public Atleta(String nome) {
        this.nome = nome;
    }

    @Override
    public void trajeto(int quilometros) {
        this.quilometrosTreinados += quilometros;
    }

    @Override
    public int ultimoTrajeto() {
        return quilometrosTreinados;
    }

    @Override
    public int distanciaTotal() {
        return quilometrosTreinados;
    }

    @Override
    public String toString() {
        return "Atleta [nome=" + nome + ", quilometrosTreinados=" + quilometrosTreinados + "]";
    }
}
