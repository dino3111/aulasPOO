package Exame2122;

import java.util.Objects;

public class Catering extends Activity {
    private Option opcao;
    private final double preco = 30;

    public enum Option {
        FULL_MENU, DRINKS_AND_SNACKS,
    }

    public Catering(Option opcao, int numParticipantes) {
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
        return preco;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Catering)) {
            return false;
        }
        Catering catering = (Catering) o;
        return Objects.equals(opcao, catering.opcao) && preco == catering.preco;
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
