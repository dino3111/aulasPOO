package aula05;

import java.util.Scanner;

class DateYMD {
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

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

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

    public String toString() {
        return year + "-" + (month < 10 ? "0" : "") + month + "-" + (day < 10 ? "0" : "") + day;
    }
}

public class ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateYMD date = null;
        int option;

        do {
            System.out.println("\nDate operations:");
            System.out.println("1 - Create new date");
            System.out.println("2 - Show current date");
            System.out.println("3 - Increment date");
            System.out.println("4 - Decrement date");
            System.out.println("0 - Exit");
            System.out.print("Choose an option: ");
            option = sc.nextInt();

            if (option == 1) {
                System.out.print("Enter day: ");
                int day = sc.nextInt();
                System.out.print("Enter month: ");
                int month = sc.nextInt();
                System.out.print("Enter year: ");
                int year = sc.nextInt();
            
                if (DateYMD.valid(day, month, year)) {
                    date = new DateYMD(day, month, year);
                    System.out.println("Date created successfully: " + date);
                } else {
                    System.out.println("Invalid date! Try again.");
                }
                            
            } else if (option == 2) {
                if (date == null) {
                    System.out.println("No date set.");
                } else {
                    System.out.println("Current date: " + date);
                }
            } else if (option == 3) {
                if (date == null) {
                    System.out.println("No date set.");
                } else {
                    date.increment();
                    System.out.println("Date incremented: " + date);
                }
            } else if (option == 4) {
                if (date == null) {
                    System.out.println("No date set.");
                } else {
                    date.decrement();
                    System.out.println("Date decremented: " + date);
                }
            } else if (option == 0) {
                System.out.println("Exiting...");
            } else {
                System.out.println("Invalid option! Try again.");
            }
        } while (option != 0);

        sc.close();
    }
}
