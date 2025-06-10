package aula05;

import java.time.LocalDate; 
// Olá professor, usei esta biblioteca do java para importar a classe LocalDate,
// que é uma classe que representa uma data (ano, mês e dia) sem horário.
import java.util.Scanner;

class CalendarYMD {
    private int year, firstWeekday;
    private int[][] events;

    public CalendarYMD(int year) {
        this.year = year;
        this.firstWeekday = calculateFirstWeekday(year); 
        events = new int[12][];

        for (int i = 0; i < 12; i++) {
            events[i] = new int[DateYMD.monthDays(i + 1, year)];
        }
    }

    private int calculateFirstWeekday(int year) {
        int dayOfWeek = LocalDate.of(year, 1, 1).getDayOfWeek().getValue();
        return (dayOfWeek % 7) + 1; 
    }

    public int year() {
        return year;
    }

    public int firstWeekdayOfYear() {
        return firstWeekday;
    }

    public int firstWeekdayOfMonth(int month) {
        int totalDays = 0;
        for (int i = 1; i < month; i++) {
            totalDays += DateYMD.monthDays(i, year);
        }
        return (firstWeekday + totalDays - 1) % 7 + 1;
    }

    public void printMonth(int month) {
        System.out.printf("\n%10s %d\n", getMonthName(month), year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        int firstDay = firstWeekdayOfMonth(month);
        int days = DateYMD.monthDays(month, year);

        for (int i = 1; i < firstDay; i++) {
            System.out.print("   ");
        }

        for (int day = 1; day <= days; day++) {
            System.out.printf("%2d ", day);
            if ((firstDay + day - 1) % 7 == 0)
                System.out.println();
        }
        System.out.println();
    }

    public void printCalendar() {
        for (int i = 1; i <= 12; i++) {
            printMonth(i);
        }
    }

    private String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July",
                           "August", "September", "October", "November", "December"};
        return months[month - 1];
    }
}

public class DesafioAula { // Alteração do nome da classe principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalendarYMD calendar = null;
        int option;

        do {
            System.out.println("\nCalendar operations:");
            System.out.println("1 - Create new calendar");
            System.out.println("2 - Print calendar month");
            System.out.println("3 - Print full calendar");
            System.out.println("0 - Exit");
            System.out.print("Choose an option: ");
            option = sc.nextInt();

            if (option == 1) {
                System.out.print("Enter year: ");
                int year = sc.nextInt();
                calendar = new CalendarYMD(year);
                System.out.println("Calendar created successfully.");
            } else if (option == 2) {
                if (calendar == null) {
                    System.out.println("No calendar set.");
                } else {
                    System.out.print("Enter month (1-12): ");
                    int month = sc.nextInt();
                    calendar.printMonth(month);
                }
            } else if (option == 3) {
                if (calendar == null) {
                    System.out.println("No calendar set.");
                } else {
                    calendar.printCalendar();
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
