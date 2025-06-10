package aula12b;

public class Peixe extends Animal{
    private String corEscama;

    @Override
    public void locomover() {
        System.out.println("Nadar");
    }

    @Override
    public void alimentar() {
        System.out.println("Comer");
    }

    @Override
    public void emitirSom() {
        System.out.println("Peixe nao faz barulho");
    }
    
    public void fazerBolha(){
        System.out.println("O peixe saltou uma bolha.");
    }

    public String getCorEscama() {
        return corEscama;
    }

    public void setCorEscama(String corEscama) {
        this.corEscama = corEscama;
    }

}
