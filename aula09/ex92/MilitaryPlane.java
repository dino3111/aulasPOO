package aula09.ex92;

public class MilitaryPlane extends Plane {
    private int numMunicoes;

    public MilitaryPlane(String id, String fabricante, String modelo,
        int anoProducao, int numMaxPassageiros, int velocidadeMaxima,
        int numMunicoes) {
        super(id, fabricante, modelo, anoProducao, numMaxPassageiros, velocidadeMaxima);
        this.numMunicoes = numMunicoes;
    }

    public int getNumMunicoes() { return numMunicoes; }
    public void setNumMunicoes(int numMunicoes) { this.numMunicoes = numMunicoes; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Munições: %d", numMunicoes);
    }

    @Override
    public String getPlaneType() {
        return "Militar";
    }
}
