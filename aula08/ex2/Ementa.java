package aula08.ex2;

import java.util.ArrayList;
import java.util.List;

public class Ementa {
    private String nome;
    private String local;
    private List<Prato> pratos;

    public Ementa(String nome, String local) {
        this.nome = nome;
        this.local = local;
        this.pratos = new ArrayList<>();
    }

    public void adicionarPrato(Prato prato) {
        this.pratos.add(prato);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ementa: " + nome + ", Local: " + local + "\n");
        for (Prato prato : pratos) {
            sb.append(prato.toString() + "\n");
        }
        return sb.toString();
    }
}
