package Exame2122;

import java.util.Objects;

public class Sport extends Activity {
    private Modality modalidade;
    private final double preco = 20;

    public enum Modality {
        KAYAK, HIKING,
    }

    public Sport(Modality modalidade, int numParticipantes) {
        super(numParticipantes);
        this.modalidade = modalidade;
    }

    public Modality getModalidade() {
        return this.modalidade;
    }

    public void setModalidade(Modality modalidade) {
        this.modalidade = modalidade;
    }

    public double getPrice() {
        return preco;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Sport)) {
            return false;
        }
        Sport sport = (Sport) o;
        return Objects.equals(modalidade, sport.modalidade) && preco == sport.preco;
    }

    @Override
    public int hashCode() {
        return Objects.hash(modalidade, preco);
    }

    @Override
    public String toString() {
        return getModalidade() + " for " + getNumParticipantes() + " participantes";
    }
}
