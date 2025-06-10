import java.time.DayOfWeek;

public class StandardTransactionCostCalculator implements ITransactionCostCalculator {
    @Override
    public double calculateTransactionCost(Transaction t) {
        double cost = t.getHoursWorked() * 50.0;
        DayOfWeek day = t.getServiceDateTime().getDayOfWeek();

        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
            cost *= 2;
        }

        if (day == DayOfWeek.WEDNESDAY) {
            cost *= 0.9;
        }

        return cost;
    }
}