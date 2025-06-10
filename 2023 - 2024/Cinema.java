package avaliacaoFinal;

import java.util.List;
import java.util.Arrays;

public class Cinema extends Event {
    private String realizador;
    private int ano;
    private List<String> atores;

    public Cinema (String nome, String realizador, int ano, String[] atores, int duracao) {
        super(nome, duracao);
        this.realizador = realizador;
        this.ano = ano;
        this.atores = Arrays.asList(atores);
    }

    public String getRealizador() {
        return this.realizador;
    }

    public void setRealizador(String realizador) {
        this.realizador = realizador;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<String> getAtores() {
        return this.atores;
    }

    public void setAtores(List<String> atores) {
        this.atores = atores;
    }

    public String toString() {
        return super.toString() + ", Realizador: " + realizador + ", Ano: " + ano + ", Atores: " + atores;
    }

}
