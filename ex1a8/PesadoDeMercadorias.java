package ex1a8;

public class PesadoDeMercadorias extends Veiculo{
    private int quadro;
    private int peso;
    private int cargaMax;


    public PesadoDeMercadorias(String matricula, String marca, String modelo, int cv, int quadro, int peso,
            int cargaMax) {
        super(matricula, marca, modelo, cv);
        this.quadro = quadro;
        this.peso = peso;
        this.cargaMax = cargaMax;
    }

    public PesadoDeMercadorias(String matricula, String marca, String modelo, int cv) {
        super(matricula, marca, modelo, cv);
    }
    
    public int getQuadro() {
        return quadro;
    }
    public void setQuadro(int quadro) {
        this.quadro = quadro;
    }
    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public int getCargaMax() {
        return cargaMax;
    }
    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    @Override
    public String toString() {
        return "PesadoDeMercadorias [quadro=" + quadro + ", peso=" + peso + ", cargaMax=" + cargaMax + "]";
    }

}
