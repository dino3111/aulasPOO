package teste2223poo;

public class CaravanSpace extends CampingSpace {
    public CaravanSpace(String location, int width, int length, double pricePerDay) {
        super(location, width, length, pricePerDay);
    }

    @Override
    public int getMaxRentalDays() {
        return 3 * 365; // 3 anos
    }
}

