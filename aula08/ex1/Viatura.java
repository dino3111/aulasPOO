package aula08.ex1;

public abstract class Viatura implements IKmPercorridos {
    protected String matricula;
    protected String marca;
    protected String modelo;
    protected int potencia;
    protected int quilometrosPercorridos = 0;

    public Viatura(String matricula, String marca, String modelo, int potencia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    @Override
    public void trajeto(int quilometros) {
        this.quilometrosPercorridos += quilometros;
    }

    @Override
    public int ultimoTrajeto() {
        return quilometrosPercorridos;
    }

    @Override
    public int distanciaTotal() {
        return quilometrosPercorridos;
    }

    @Override
    public String toString() {
        return "Viatura [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", potencia=" + potencia + "]";
    }
}
