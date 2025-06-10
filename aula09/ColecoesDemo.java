package aula09;

import java.util.*;

import utils.DateYMD;
import aula06.PessoaApp.Pessoa;

public class ColecoesDemo {

    public static void main(String[] args) {
        // (a) ArrayList<Integer>
        List<Integer> c1 = new ArrayList<>();
        for (int i = 10; i <= 100; i += 10) {
            c1.add(i);
        }
        System.out.println("c1 = " + c1);
        System.out.println("contains(30)? " + c1.contains(30));
        System.out.println("indexOf(30) = " + c1.indexOf(30));
        System.out.println("lastIndexOf(50) = " + c1.lastIndexOf(50));
        c1.set(3, 999);
        System.out.println("após set(3,999): " + c1);
        List<Integer> sub = c1.subList(2, 5);
        System.out.println("subList(2,5) = " + sub);
        System.out.println();

        // (b) HashSet<Pessoa>
        Set<Pessoa> c3 = new HashSet<>();
        c3.add(new Pessoa("Ana", 20, null));
        c3.add(new Pessoa("Bruno", 25,null));
        c3.add(new Pessoa("Carla", 22,null));
        c3.add(new Pessoa("Daniel", 28,null));
        c3.add(new Pessoa("Eduarda", 24,null));

        System.out.println("HashSet<Pessoa> c3 (iteração sem ordem de inserção):");
        for (Pessoa p : c3) {
            System.out.println("  " + p);
        }
        System.out.println("inserindo duplicado Ana,20: " + c3.add(new Pessoa("Ana", 20, null)));
        System.out.println("tamanho após duplicado: " + c3.size());
        System.out.println();

        // (c) TreeSet<DateYMD>
        TreeSet<DateYMD> c4 = new TreeSet<>();
        c4.add(new DateYMD(2021, 3, 15));
        c4.add(new DateYMD(2020, 1, 1));
        c4.add(new DateYMD(2022, 12, 30));
        c4.add(new DateYMD(2019, 7, 5));
        c4.add(new DateYMD(2021, 8, 20));

        System.out.println("TreeSet<DateYMD> c4 (ordenado cronologicamente):");
        for (DateYMD d : c4) {
            System.out.println("  " + d);
        }
        System.out.println("inserindo duplicado 2020-01-01: " + c4.add(new DateYMD(2020, 1, 1)));
        System.out.println("tamanho após duplicado: " + c4.size());
    }
}
