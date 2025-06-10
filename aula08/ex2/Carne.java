package aula08.ex2;

public class Carne extends Alimento {
    private String variedade;

    public Carne(String nome, double proteinas, double calorias, double peso, String variedade) {
        super(nome, proteinas, calorias, peso);
        this.variedade = variedade;
    }

    @Override
    public String toString() {
        return super.toString() + ", Variedade: " + variedade;
    }
}
