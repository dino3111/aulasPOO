import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private static int idCounter = 1;
    private int id;
    private double hoursWorked;
    private String description;
    private LocalDateTime serviceDateTime;

    public Transaction(String description, String serviceDateTime, double hoursWorked) {
        this.id = idCounter++;
        this.description = description;
        this.hoursWorked = hoursWorked;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.serviceDateTime = LocalDateTime.parse(serviceDateTime, formatter);
    }

    public Transaction(int id, double hoursWorked, String description, String serviceDateTime) {
        this.id = id;
        this.description = description;
        this.hoursWorked = hoursWorked;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.serviceDateTime = LocalDateTime.parse(serviceDateTime, formatter);
        if (id >= idCounter) {
            idCounter = id + 1;
        }
    }

    public int getId() { return id; }
    public double getHoursWorked() { return hoursWorked; }
    public String getDescription() { return description; }
    public LocalDateTime getServiceDateTime() { return serviceDateTime; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Transaction [id=" + id + ", hoursWorked=" + hoursWorked + ", description=" + description + ", serviceDateTime=" + serviceDateTime.format(formatter) + "]";
    }
}