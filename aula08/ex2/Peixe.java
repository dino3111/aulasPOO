package aula08.ex2;

public class Peixe extends Alimento {
    private String tipo;

    public Peixe(String nome, double proteinas, double calorias, double peso, String tipo) {
        super(nome, proteinas, calorias, peso);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + tipo;
    }
}
