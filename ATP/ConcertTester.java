import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConcertTester {
    public static void main(String[] args) {
        ConcertManager cm = new ConcertManager();

        // ----------------------------------------------------------
        Concert c1 = new Concert("Madrid, Espanha", "2025-05-27 11:00", 25.0);
        Concert c2 = new Concert("Oslo, Suecia", "2025-05-28 05:00", 35.0);
        cm.addConcert(c1);
        cm.addConcert(c2);
        // ----------------------------------------------------------

        cm.printAllConcerts();

        // ----------------------------------------------------------
        System.out.println(cm.getConcert(1));
        System.out.println(cm.calculateConcertProfit(1));
        System.out.println(cm.getConcert(2));
        System.out.println(cm.calculateConcertProfit(2));
        System.out.println(cm.getConcert(30));              // não existe!
        System.out.println(cm.calculateConcertProfit(30));    // não existe!
        // ----------------------------------------------------------

        System.out.println("---------------");
        cm.sortConcertsByProfit();
        System.out.println("---------------");

        // ----------------------------------------------------------
        cm.readFile("C:\\Users\\claud\\Desktop\\127368\\src\\classicpimba.txt");
        cm.printAllConcerts();

        // ----------------------------------------------------------
        System.out.println(cm.getConcert(1));
        System.out.println(cm.calculateConcertProfit(1));
        System.out.println(cm.getConcert(2));
        System.out.println(cm.calculateConcertProfit(2));
        System.out.println(cm.getConcert(30));
        System.out.println(cm.calculateConcertProfit(30));
        // ----------------------------------------------------------

        cm.writeFile("C:\\Users\\claud\\Desktop\\127368\\src\\result.txt");

        // ----------------------------------------------------------

        System.out.println("---------------");
        cm.sortConcertsByProfit();
        System.out.println("---------------");

        // ----------------------------------------------------------

    }
}
