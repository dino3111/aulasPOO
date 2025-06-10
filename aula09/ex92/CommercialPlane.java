package aula09.ex92;

public class CommercialPlane extends Plane {
    private String ciaAerea;  

    public CommercialPlane(String id, String fabricante, String modelo,
        int anoProducao, int numMaxPassageiros, int velocidadeMaxima,
        String ciaAerea) {
        super(id, fabricante, modelo, anoProducao, numMaxPassageiros, velocidadeMaxima);
        this.ciaAerea = ciaAerea;
    }

    public String getCiaAerea() { return ciaAerea; }
    public void setCiaAerea(String ciaAerea) { this.ciaAerea = ciaAerea; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Cia: %s", ciaAerea);
    }

    @Override
    public String getPlaneType() {
        return "Comercial";
    }
}

