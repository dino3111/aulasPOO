package Exame2122;

public abstract class Activity {
    private int numParticipantes;
    
    public Activity(int numParticipantes) {
        this.numParticipantes = numParticipantes;
    }

    public int getNumParticipantes() {
        return this.numParticipantes;
    }

    public void setNumParticipantes(int numParticipantes) {
        this.numParticipantes = numParticipantes;
    }

    public abstract double getPrice();
}
