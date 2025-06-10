public class StandardConcertProfitCalculator implements IConcertProfitCalculator{

    @Override
    public double calculateConcertProfit(Concert c) {
        double hours = c.getDuracao() / 60.0;
        double profit = hours * 1500;

        String local = c.getLocal();
        String[] parts = local.split(",");
        String country = parts[parts.length - 1].trim();

        if (country == "Portugal") {
            profit *= 2;
        }

        if (country != "Portugal" || country != "Espanha") {
            profit -= 800;
        }

        return profit;
    }
}
