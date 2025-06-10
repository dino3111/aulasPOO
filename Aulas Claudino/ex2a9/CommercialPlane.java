package ex2a9;

public class CommercialPlane extends Plane {

    @Override
    public String toString() {
        return "CommercialPlane [tripulantes=" + tripulantes + ", Tipo: " + getPlaneType() + "]";
    }

    private int tripulantes;
    
    public int getTripulantes() {
        return tripulantes;
    }

    public void setTripulantes(int tripulantes) {
        this.tripulantes = tripulantes;
    }

    public CommercialPlane(String id, String fabricante, String modelo, int anoProducao, int maxPassageiros,
            int maxVel, int tripulantes) {
        super(id, fabricante, modelo, anoProducao, maxPassageiros, maxVel);
        this.tripulantes = tripulantes;
    }

    public String getPlaneType() {
        return "Comercial";
    }

}
