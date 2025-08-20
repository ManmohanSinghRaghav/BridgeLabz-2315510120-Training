import java.util.Scanner;

public class CountdownFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter countdown value: ");
        int startValue = scanner.nextInt();
        
        for (int counter = startValue; counter >= 1; counter--) {
            System.out.println(counter);
        }
        
        scanner.close();
    }
}