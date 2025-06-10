package teste2223poo;

public class CampingSpace {
    private String location;
    private int width;
    private int length;
    private double pricePerDay;
    
    public CampingSpace(String location, int width, int length, double pricePerDay) {
        this.location = location;
        this.width = width;
        this.length = length;
        this.pricePerDay = pricePerDay;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
    

}
