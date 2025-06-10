package utils;

public class DateYMD extends Date {
    private int day, month, year;

    public DateYMD(int day, int month, int year) {
        set(day, month, year);
    }

    public static boolean validMonth(int month) {
        return month >= 1 && month <= 12;
    }

    public static boolean leapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int monthDays(int month, int year) {
        if (!validMonth(month))
            return -1;
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        if (month == 2)
            return leapYear(year) ? 29 : 28;
        return 31;
    }

    public static boolean valid(int day, int month, int year) {
        return validMonth(month) && day > 0 && day <= monthDays(month, year);
    }

    public void set(int day, int month, int year) {
        if (valid(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Data inválida!");
        }
    }

    @Override
    public int getDay() {
        return day;
    }

    @Override
    public int getMonth() {
        return month;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void increment() {
        if (day < monthDays(month, year)) {
            day++;
        } else {
            day = 1;
            if (month == 12) {
                month = 1;
                year++;
            } else {
                month++;
            }
        }
    }

    @Override
    public void decrement() {
        if (day > 1) {
            day--;
        } else {
            if (month == 1) {
                month = 12;
                year--;
            } else {
                month--;
            }
            day = monthDays(month, year);
        }
    }

    @Override
    public String toString() {
        return year + "-" + (month < 10 ? "0" : "") + month + "-" + (day < 10 ? "0" : "") + day;
    }
}
