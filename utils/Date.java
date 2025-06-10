package utils;

/**
 * Classe abstrata para representar datas de forma genérica.
 */
public abstract class Date {

    public abstract int getYear();
    public abstract int getMonth();
    public abstract int getDay();
    public abstract String toString();

    public abstract void increment();
    public abstract void decrement();

    public boolean isEqual(Date other) {
        return getYear() == other.getYear() &&
               getMonth() == other.getMonth() &&
               getDay() == other.getDay();
    }

    public boolean isBefore(Date other) {
        if (getYear() != other.getYear())
            return getYear() < other.getYear();
        if (getMonth() != other.getMonth())
            return getMonth() < other.getMonth();
        return getDay() < other.getDay();
    }

    public boolean isAfter(Date other) {
        return !isBefore(other) && !isEqual(other);
    }

    public static boolean isLeapYear(int year) {
        return java.time.Year.isLeap(year);
    }

    public static boolean validDate(int year, int month, int day) {
        try {
            java.time.LocalDate.of(year, month, day);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
