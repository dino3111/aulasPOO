package aula08.ex1;

public class AutomovelLigeiro extends Viatura {
    private String numeroQuadro;
    private int capacidadeBagageira;

    public AutomovelLigeiro(String matricula, String marca, String modelo, int potencia, String numeroQuadro, int capacidadeBagageira) {
        super(matricula, marca, modelo, potencia);
        this.numeroQuadro = numeroQuadro;
        this.capacidadeBagageira = capacidadeBagageira;
    }

    @Override
    public String toString() {
        return super.toString() + ", numeroQuadro=" + numeroQuadro + ", capacidadeBagageira=" + capacidadeBagageira + "]";
    }
}
