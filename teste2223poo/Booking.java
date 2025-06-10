package teste2223poo;

import java.time.LocalDate;

public class Booking {

    @Override
    public String toString() {
        return "Booking [client=" + client + ", starDate=" + starDate + ", durationDays=" + durationDays
                + ", spaceType=" + spaceType + ", minWidth=" + minWidth + ", minLength=" + minLength + "]";
    }
    
    public Booking(Client client, LocalDate starDate, int durationDays, String spaceType, int minWidth, int minLength) {
        this.client = client;
        this.starDate = starDate;
        this.durationDays = durationDays;
        this.spaceType = spaceType;
        this.minWidth = minWidth;
        this.minLength = minLength;
    }
    
    private Client client;
    private LocalDate starDate;
    private int durationDays;
    private String spaceType;
    private int minWidth;
    private int minLength;
    
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public LocalDate getStarDate() {
        return starDate;
    }
    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
    }
    public int getDurationDays() {
        return durationDays;
    }
    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }
    public String getSpaceType() {
        return spaceType;
    }
    public void setSpaceType(String spaceType) {
        this.spaceType = spaceType;
    }
    public int getMinWidth() {
        return minWidth;
    }
    public void setMinWidth(int minWidth) {
        this.minWidth = minWidth;
    }
    public int getMinLength() {
        return minLength;
    }
    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

}
