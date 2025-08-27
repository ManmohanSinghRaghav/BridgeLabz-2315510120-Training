import java.util.Scanner;

public class CalendarDisplay {

    public static String getMonthName(int month) {
        String[] months = {"", "January", "February", "March", "April", "May", "June",
                           "July", "August", "September", "October", "November", "December"};
        return months[month];
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getNumberOfDays(int month, int year) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month];
    }

    public static int getFirstDayOfMonth(int month, int year) {
        // Gregorian calendar algorithm
        int y = year - (14 - month) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        return (1 + x + (31 * m) / 12) % 7;
    }

    public static void displayCalendar(int month, int year) {
        int startDay = getFirstDayOfMonth(month, year);
        int numDays = getNumberOfDays(month, year);

        System.out.println("   " + getMonthName(month) + " " + year);
        System.out.println("Su  Mo  Tu  We  Th  Fr  Sa");

        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        for (int i = 1; i <= numDays; i++) {
            System.out.printf("%3d ", i);
            if ((i + startDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        displayCalendar(month, year);
        scanner.close();
    }
}
