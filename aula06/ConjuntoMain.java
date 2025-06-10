package aula06;

import java.util.HashSet;
import java.util.Set;

class Conjunto {
    private Set<Integer> elementos;

    public Conjunto() {
        elementos = new HashSet<>();
    }

    public void insert(int n) {
        elementos.add(n);
    }

    public boolean contains(int n) {
        return elementos.contains(n);
    }

    public void remove(int n) {
        elementos.remove(n);
    }

    public void empty() {
        elementos.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int el : elementos) {
            sb.append(el).append(" ");
        }
        return sb.toString().trim();
    }

    public int size() {
        return elementos.size();
    }

    public Conjunto unir(Conjunto add) {
        Conjunto resultado = new Conjunto();
        resultado.elementos.addAll(this.elementos);
        resultado.elementos.addAll(add.elementos);
        return resultado;
    }

    public Conjunto subtrair(Conjunto dif) {
        Conjunto resultado = new Conjunto();
        for (int el : this.elementos) {
            if (!dif.elementos.contains(el)) {
                resultado.insert(el);
            }
        }
        return resultado;
    }

    public Conjunto interset(Conjunto inter) {
        Conjunto resultado = new Conjunto();
        for (int el : this.elementos) {
            if (inter.elementos.contains(el)) {
                resultado.insert(el);
            }
        }
        return resultado;
    }
}

public class ConjuntoMain {
    public static void main(String[] args) {
        Conjunto c1 = new Conjunto();
        c1.insert(4); c1.insert(7); c1.insert(6); c1.insert(5);

        Conjunto c2 = new Conjunto();
        int[] test = { 7, 3, 2, 5, 4, 6, 7 };
        for (int el : test) c2.insert(el);

        c2.remove(3); c2.remove(5); c2.remove(6);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println("Número de elementos em c1: " + c1.size());
        System.out.println("Número de elementos em c2: " + c2.size());
        System.out.println("c1 contém 6?: " + (c1.contains(6) ? "sim" : "não"));
        System.out.println("c2 contém 6?: " + (c2.contains(6) ? "sim" : "não"));
        System.out.println("União:" + c1.unir(c2));
        System.out.println("Interseção:" + c1.interset(c2));
        System.out.println("Diferença:" + c1.subtrair(c2));
        c1.empty();
        System.out.println("c1:" + c1);
    }
}
