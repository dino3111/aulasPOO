package ex1a8;

public class AutomovelLigeiro extends Veiculo{

    private int quadro;
    private int capacidadeBag;

    public AutomovelLigeiro(String matricula, String marca, String modelo, int cv, int quadro, int capacidadeBag) {
        super(matricula, marca, modelo, cv);
        this.quadro = quadro;
        this.capacidadeBag = capacidadeBag;
    }


    public AutomovelLigeiro(String matricula, String marca, String modelo, int cv) {
        super(matricula, marca, modelo, cv);
    }
    
    
    public int getQuadro() {
        return quadro;
    }
    public void setQuadro(int quadro) {
        this.quadro = quadro;
    }
    public int getCapacidadeBag() {
        return capacidadeBag;
    }
    public void setCapacidadeBag(int capacidadeBag) {
        this.capacidadeBag = capacidadeBag;
    }

    @Override
    public String toString() {
        return "AutomovelLigeiro [quadro=" + quadro + ", capacidadeBag=" + capacidadeBag + "]";
    }

}
