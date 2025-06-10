package aula08.ex1;

public class AutomovelLigeiroEletrico extends AutomovelLigeiro implements IGestaoBateria {
    private double cargaMaxima;
    private double cargaAtual;

    public AutomovelLigeiroEletrico(String matricula, String marca, String modelo, int potencia, String numeroQuadro, int capacidadeBagageira, double cargaMaxima) {
        super(matricula, marca, modelo, potencia, numeroQuadro, capacidadeBagageira);
        this.cargaMaxima = cargaMaxima;
        this.cargaAtual = cargaMaxima;
    }

    @Override
    public double cargaDisponivel() {
        return (cargaAtual / cargaMaxima) * 100;
    }

    @Override
    public void carregar(double percentagem) {
        cargaAtual = Math.min(cargaMaxima, cargaAtual + (cargaMaxima * percentagem / 100));
    }

    @Override
    public void limitarCargaMaxima(double percentagem) {
        cargaMaxima = (cargaMaxima * percentagem) / 100;
        if (cargaAtual > cargaMaxima) {
            cargaAtual = cargaMaxima;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", cargaAtual=" + cargaDisponivel() + "%]";
    }
}
