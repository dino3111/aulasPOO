package aula08.ex1;

public class Telemovel {
    private String numero;
    private String operadora;

    public Telemovel(String numero, String operadora) {
        this.numero = numero;
        this.operadora = operadora;
    }

    @Override
    public String toString() {
        return "Telemóvel [numero=" + numero + ", operadora=" + operadora + "]";
    }
}
