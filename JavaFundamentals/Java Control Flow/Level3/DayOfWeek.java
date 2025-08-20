public class DayOfWeek {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java DayOfWeek <month> <day> <year>");
            return;
        }
        
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        
        // Adjust month and year for the formula
        if (m < 3) {
            m += 12;
            y--;
        }
        
        // Zeller's congruence formula
        int k = y % 100;
        int j = y / 100;
        
        int h = (d + ((13 * (m + 1)) / 5) + k + (k / 4) + (j / 4) - 2 * j) % 7;
        
        // Convert to standard format (0=Sunday, 1=Monday, etc.)
        int dayOfWeek = (h + 5) % 7;
        
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        
        System.out.println("Day of week: " + dayOfWeek + " (" + days[dayOfWeek] + ")");
    }
}
