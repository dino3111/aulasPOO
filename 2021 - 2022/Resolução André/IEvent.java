package Exame2122;

import java.time.LocalDate;

public interface IEvent {
    Event addActivity(Activity activity);
    LocalDate getDate();
    double eventPrice();
}
