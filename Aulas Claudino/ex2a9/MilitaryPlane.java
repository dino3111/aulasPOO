package ex2a9;

public class MilitaryPlane extends Plane {

    @Override
    public String toString() {
        return "MilitaryPlane [ammo=" + ammo + ", Tipo: " + getPlaneType() + "]";
    }

    public MilitaryPlane(String id, String fabricante, String modelo, int anoProducao, int maxPassageiros, int maxVel, int ammo) {
        super(id, fabricante, modelo, anoProducao, maxPassageiros, maxVel);
        this.ammo = ammo;
    }

    private int ammo;

    public String getPlaneType() {
        return "Militar";
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }


}
