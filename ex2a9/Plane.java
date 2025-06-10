package ex2a9;

public class Plane {
    private String id;
    private String fabricante;
    private String modelo;
    private int anoProducao;
    private int maxPassageiros;
    private int maxVel;

    public Plane(String id, String fabricante, String modelo, int anoProducao, int maxPassageiros, int maxVel) {
        this.id = id;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.anoProducao = anoProducao;
        this.maxPassageiros = maxPassageiros;
        this.maxVel = maxVel;
    }

    @Override
    public String toString() {
        return "Plane [id=" + id + ", fabricante=" + fabricante + ", modelo=" + modelo + ", anoProducao=" + anoProducao
                + ", maxPassageiros=" + maxPassageiros + ", maxVel=" + maxVel + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoProducao() {
        return anoProducao;
    }

    public void setAnoProducao(int anoProducao) {
        this.anoProducao = anoProducao;
    }

    public int getMaxPassageiros() {
        return maxPassageiros;
    }

    public void setMaxPassageiros(int maxPassageiros) {
        this.maxPassageiros = maxPassageiros;
    }

    public int getMaxVel() {
        return maxVel;
    }

    public void setMaxVel(int maxVel) {
        this.maxVel = maxVel;
    }

}
