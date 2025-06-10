package teste2223poo;

public class TentSpace extends CampingSpace{

    public TentSpace(String location, int width, int length, double pricePerDay) {
        super(location, width, length, pricePerDay);
    }

    @Override
    public int getMaxRentalDays() {
        return 10; 
    }

}
