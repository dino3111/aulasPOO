package aula08.ex2;

import java.util.HashSet;
import java.util.Set;

public class Prato implements Comparable<Prato> {
    private String nome;
    private Set<Alimento> alimentos;

    public Prato(String nome) {
        this.nome = nome;
        this.alimentos = new HashSet<>();
    }

    public void adicionarIngrediente(Alimento alimento) {
        this.alimentos.add(alimento);
    }

    public double calcularCalorias() {
        double totalCalorias = 0;
        for (Alimento alimento : alimentos) {
            totalCalorias += alimento.getCalorias();
        }
        return totalCalorias;
    }

    public double calcularProteinas() {
        double totalProteinas = 0;
        for (Alimento alimento : alimentos) {
            totalProteinas += alimento.getProteinas();
        }
        return totalProteinas;
    }

    public double calcularPeso() {
        double totalPeso = 0;
        for (Alimento alimento : alimentos) {
            totalPeso += alimento.getPeso();
        }
        return totalPeso;
    }

    @Override
    public int compareTo(Prato outroPrato) {
        return Double.compare(this.calcularCalorias(), outroPrato.calcularCalorias());
    }

    @Override
    public String toString() {
        return "Prato: " + nome + ", Calorias: " + calcularCalorias() + ", Proteínas: " + calcularProteinas() + ", Peso: " + calcularPeso();
    }
}
