package aula08.ex2;

public abstract class Alimento {
    protected String nome;
    protected double proteinas;
    protected double calorias;
    protected double peso;

    public Alimento(String nome, double proteinas, double calorias, double peso) {
        this.nome = nome;
        this.proteinas = proteinas;
        this.calorias = calorias;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public double getProteinas() {
        return proteinas;
    }

    public double getCalorias() {
        return calorias;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Proteínas: " + proteinas + ", Calorias: " + calorias + ", Peso: " + peso;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alimento alimento = (Alimento) obj;
        return nome.equals(alimento.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }
}
