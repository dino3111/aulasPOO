package aula08.ex1;

public class PesadoDePassageiros extends Viatura {
    private int peso;
    private int numeroMaximoPassageiros;

    public PesadoDePassageiros(String matricula, String marca, String modelo, int potencia, String numeroQuadro, int peso, int numeroMaximoPassageiros) {
        super(matricula, marca, modelo, potencia);
        this.peso = peso;
        this.numeroMaximoPassageiros = numeroMaximoPassageiros;
    }

    @Override
    public String toString() {
        return super.toString() + ", peso=" + peso + ", numeroMaximoPassageiros=" + numeroMaximoPassageiros + "]";
    }
}
