package aula09.ex92;

public class Plane {
    private String id;
    private String fabricante;
    private String modelo;
    private int anoProducao;
    private int numMaxPassageiros;
    private int velocidadeMaxima;

    public Plane(String id, String fabricante, String modelo, int anoProducao, int numMaxPassageiros, int velocidadeMaxima) {
        this.id = id;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.anoProducao = anoProducao;
        this.numMaxPassageiros = numMaxPassageiros;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    // Getters e setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public int getAnoProducao() { return anoProducao; }
    public void setAnoProducao(int anoProducao) { this.anoProducao = anoProducao; }
    public int getNumMaxPassageiros() { return numMaxPassageiros; }
    public void setNumMaxPassageiros(int numMaxPassageiros) { this.numMaxPassageiros = numMaxPassageiros; }
    public int getVelocidadeMaxima() { return velocidadeMaxima; }
    public void setVelocidadeMaxima(int velocidadeMaxima) { this.velocidadeMaxima = velocidadeMaxima; }

    public String toString() {
        return String.format(
            "ID: %s | Fab: %s | Modelo: %s | Ano: %d | Pax: %d | VelMax: %dkm/h",
            id, fabricante, modelo, anoProducao, numMaxPassageiros, velocidadeMaxima
        );
    }

    public String getPlaneType() {
        return "Genérico";
    }
}

