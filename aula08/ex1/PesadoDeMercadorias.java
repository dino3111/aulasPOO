package aula08.ex1;

public class PesadoDeMercadorias extends Viatura {
    private int peso;
    private int cargaMaxima;

    public PesadoDeMercadorias(String matricula, String marca, String modelo, int potencia, String numeroQuadro, int peso, int cargaMaxima) {
        super(matricula, marca, modelo, potencia);
        this.peso = peso;
        this.cargaMaxima = cargaMaxima;
    }

    @Override
    public String toString() {
        return super.toString() + ", peso=" + peso + ", cargaMaxima=" + cargaMaxima + "]";
    }
}
