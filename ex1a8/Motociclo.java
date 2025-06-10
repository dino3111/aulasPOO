package ex1a8;

public class Motociclo extends Veiculo{
    
    public Motociclo(String matricula, String marca, String modelo, int cv) {
        super(matricula, marca, modelo, cv);
    }

    public enum tipo{
        DESPORTIVO,
        ESTRADA,
    }

    private tipo tipo;

    

    public tipo getTipo() {
        return tipo;
    }

    public void setTipo(tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Motociclo [tipo=" + tipo + "]";
    }

}
