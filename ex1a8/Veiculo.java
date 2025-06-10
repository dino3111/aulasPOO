package ex1a8;

public class Veiculo implements IKmPercorridos{
    private String matricula;
    private String marca;
    private String modelo;
    private int cv;
    private int kms;
    private static int contakms;
    
    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    public Veiculo(String matricula, String marca, String modelo, int cv) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
        this.kms += contakms;
    }
    
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getCv() {
        return cv;
    }
    public void setCv(int cv) {
        this.cv = cv;
    }

    @Override
    public String toString() {
        return "Veiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", cv=" + cv + "]";
    }

    @Override
    public void trajeto(int quilometros) {
    }

    @Override
    public int ultimoTrajeto() {
    }

    @Override
    public int distanciaTotal() {
        return kms;
    }

    public void addKms(int contakms){
        kms += contakms;
    }

}
