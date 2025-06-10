package aula08.ex1;

public class Motociclo extends Viatura {
    private String tipo;

    public Motociclo(String matricula, String marca, String modelo, int potencia, String tipo) {
        super(matricula, marca, modelo, potencia);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + ", tipo=" + tipo + "]";
    }
}
