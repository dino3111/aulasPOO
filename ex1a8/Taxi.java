package ex1a8;

public class Taxi extends AutomovelLigeiro{

    public Taxi(String matricula, String marca, String modelo, int cv, int quadro, int capacidadeBag, int numLicensa) {
        super(matricula, marca, modelo, cv, quadro, capacidadeBag);
        this.numLicensa = numLicensa;
    }

    private int numLicensa;

    public int getNumLicensa() {
        return numLicensa;
    }

    public void setNumLicensa(int numLicensa) {
        this.numLicensa = numLicensa;
    }

    @Override
    public String toString() {
        return "Taxi [numLicensa=" + numLicensa + "]";
    }
}

