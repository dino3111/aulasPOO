package ex1a8;

public class PesadoDePassageiros {
    private int quadro;
    private int peso;
    private int numMaxPas;
    
    public PesadoDePassageiros(int quadro, int peso, int numMaxPas) {
        this.quadro = quadro;
        this.peso = peso;
        this.numMaxPas = numMaxPas;
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
    public int getNumMaxPas() {
        return numMaxPas;
    }
    public void setNumMaxPas(int numMaxPas) {
        this.numMaxPas = numMaxPas;
    }

    @Override
    public String toString() {
        return "PesadoDePassageiros [quadro=" + quadro + ", peso=" + peso + ", numMaxPas=" + numMaxPas + "]";
    }
}
