package teste2223poo;

public class CarSpace extends CampingSpace{

    public CarSpace(String location, int width, int length, double pricePerDay) {
        super(location, width, length, pricePerDay);
    }}

    @Override
    public int getMaxRentalDays() {
        return 3 * 30; 
    }


}
