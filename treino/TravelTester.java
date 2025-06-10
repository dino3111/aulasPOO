package treino;

public class TravelTester {
    public static void main(String[] args) {
        TravelManager tm = new TravelManager();

        // ----------------------------------------------------------
        Travel t1 = new Travel(5, "Madrid, Spain", "Aveiro, Portugal");
        Travel t2 = new Travel(15, "Cork, Ireland", "Dublin, Ireland");
        tm.addTravel(t1);
        tm.addTravel(t2);
        // ----------------------------------------------------------

        tm.printAllTravels();

        // ----------------------------------------------------------
        System.out.println(tm.getTravel(1));
        System.out.println(tm.calculateTravelCost(1));
        System.out.println(tm.getTravel(2));
        System.out.println(tm.calculateTravelCost(2));
        System.out.println(tm.getTravel(30));              // não existe!
        System.out.println(tm.calculateTravelCost(30));    // não existe!
        // ----------------------------------------------------------

        System.out.println("---------------");
        System.out.println("> NATIONAL");
        System.out.println("---------------");
        tm.sortTravelsByCost(true);
        System.out.println();

        System.out.println("------------------");
        System.out.println("> INTERNATIONAL");
        System.out.println("------------------");
        tm.sortTravelsByCost(false);
        System.out.println();

        // ----------------------------------------------------------
        tm.readFile("C:\\Users\\inesg\\OneDrive\\Desktop\\POO\\src\\treino\\viagens.txt");
        tm.printAllTravels();

        // ----------------------------------------------------------
        System.out.println(tm.getTravel(1));
        System.out.println(tm.calculateTravelCost(1));
        System.out.println(tm.getTravel(2));
        System.out.println(tm.calculateTravelCost(2));
        System.out.println(tm.getTravel(30));
        System.out.println(tm.calculateTravelCost(30));
        // ----------------------------------------------------------

        tm.writeFile("C:\\Users\\inesg\\OneDrive\\Desktop\\POO\\src\\treino\\output.txt");

        // ----------------------------------------------------------

        System.out.println("---------------");
        System.out.println("> NATIONAL");
        System.out.println("---------------");
        tm.sortTravelsByCost(true);
        System.out.println();

        System.out.println("------------------");
        System.out.println("> INTERNATIONAL");
        System.out.println("------------------");
        tm.sortTravelsByCost(false);

        // ----------------------------------------------------------

    }
}
