import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        double first = scanner.nextDouble();
        System.out.print("Enter operator (+, -, *, /): ");
        String op = scanner.next();
        System.out.print("Enter second number: ");
        double second = scanner.nextDouble();
        
        double result = 0;
        boolean validOperation = true;
        
        switch (op) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                if (second != 0) {
                    result = first / second;
                } else {
                    System.out.println("Error: Division by zero");
                    validOperation = false;
                }
                break;
            default:
                System.out.println("Invalid Operator");
                validOperation = false;
        }
        
        if (validOperation) {
            System.out.println("Result: " + first + " " + op + " " + second + " = " + result);
        }
        
        scanner.close();
    }
}
