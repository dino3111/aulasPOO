package aula07;

import utils.Date;
import utils.DateYMD;

public class Mainex2 {
    public static void main(String[] args) {

        System.out.println("DateYMD:");
        Date d1 = new DateYMD(31, 10, 2006);
        System.out.println("Data: " + d1);
        d1.increment();
        System.out.println("Após +1 dia: " + d1);
        d1.decrement();
        d1.decrement();
        System.out.println("Após -2 dias: " + d1);

        System.out.println("\nDateND:");
        Date d2 = new DateND(2006, 10, 31);
        System.out.println("Data: " + d2);
        d2.increment();
        System.out.println("Após +1 dia: " + d2);
        d2.decrement();
        d2.decrement();
        System.out.println("Após -2 dias: " + d2);
    }
}
