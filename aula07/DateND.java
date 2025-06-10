package aula07;

import utils.Date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class DateND extends Date {

    private long daysSinceBase;
    private static final LocalDate BASE = LocalDate.of(2000, 1, 1);

    public DateND(int year, int month, int day) {
        if (!Date.validDate(year, month, day))
            throw new IllegalArgumentException("Data inválida");
        LocalDate input = LocalDate.of(year, month, day);
        this.daysSinceBase = ChronoUnit.DAYS.between(BASE, input);
    }

    private LocalDate currentDate() {
        return BASE.plusDays(daysSinceBase);
    }

    @Override
    public int getYear() {
        return currentDate().getYear();
    }

    @Override
    public int getMonth() {
        return currentDate().getMonthValue();
    }

    @Override
    public int getDay() {
        return currentDate().getDayOfMonth();
    }

    @Override
    public void increment() {
        daysSinceBase++;
    }

    @Override
    public void decrement() {
        daysSinceBase--;
    }

    @Override
    public String toString() {
        return currentDate().toString(); // yyyy-MM-dd
    }
}
