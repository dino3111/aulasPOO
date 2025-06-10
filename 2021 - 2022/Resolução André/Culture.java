package Exame2122;

import java.util.Objects;

public class Culture extends Activity {
    private Option opcao;
    private final double preco = 25;

    public enum Option {
        ARCHITECTURAL_TOUR, ART_MUSEUM, RIVER_TOUR, WINE_TASTING
    }

    public Culture(Option opcao, int numParticipantes) {
        super(numParticipantes);
        this.opcao = opcao;
    }

    public Option getOpcao() {
        return this.opcao;
    }

    public void setOpcao(Option opcao) {
        this.opcao = opcao;
    }

    public double getPrice() {
        return this.preco;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Culture)) {
            return false;
        }
        Culture culture = (Culture) o;
        return Objects.equals(opcao, culture.opcao) && preco == culture.preco;
    }

    @Override
    public int hashCode() {
        return Objects.hash(opcao, preco);
    }

    @Override
    public String toString() {
        return getOpcao() + " for " + getNumParticipantes() + " participantes";
    }
}
