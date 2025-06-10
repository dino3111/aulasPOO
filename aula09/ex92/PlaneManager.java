package aula09.ex92;

import java.util.ArrayList;
import java.util.List;

public class PlaneManager {
    private List<Plane> frota = new ArrayList<>();

    public void addPlane(Plane p) {
        frota.add(p);
    }

    public boolean removePlane(String id) {
        return frota.removeIf(p -> p.getId().equals(id));
    }

    public Plane searchPlane(String id) {
        for (Plane p : frota) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    public List<Plane> getCommercialPlanes() {
        List<Plane> lista = new ArrayList<>();
        for (Plane p : frota)
            if (p instanceof CommercialPlane) lista.add(p);
        return lista;
    }

    public List<Plane> getMilitaryPlanes() {
        List<Plane> lista = new ArrayList<>();
        for (Plane p : frota)
            if (p instanceof MilitaryPlane) lista.add(p);
        return lista;
    }

    public void printAllPlanes() {
        if (frota.isEmpty()) {
            System.out.println("Frota vazia.");
            return;
        }
        for (Plane p : frota) {
            System.out.printf("[%s] %s\n", p.getPlaneType(), p);
        }
    }

    public Plane getFastestPlane() {
        if (frota.isEmpty()) return null;
        Plane maisRapido = frota.get(0);
        for (Plane p : frota) {
            if (p.getVelocidadeMaxima() > maisRapido.getVelocidadeMaxima()) {
                maisRapido = p;
            }
        }
        return maisRapido;
    }
}

