import java.util.Scanner;

public class IntOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter value for a: ");
        int a = scanner.nextInt();
        
        System.out.print("Enter value for b: ");
        int b = scanner.nextInt();
        
        System.out.print("Enter value for c: ");
        int c = scanner.nextInt();
        
        int result1 = a + b * c;     // multiplication first, then addition
        int result2 = a * b + c;     // multiplication first, then addition
        int result3 = c + a / b;     // division first, then addition
        int result4 = a % b + c;     // modulus first, then addition
        
        System.out.printf("The results of Int Operations are %d, %d, %d, and %d%n", 
                         result1, result2, result3, result4);
        
        scanner.close();
    }
}
