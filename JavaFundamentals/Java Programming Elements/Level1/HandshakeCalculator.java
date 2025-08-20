import java.util.Scanner;

class HandshakeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numberOfStudents = input.nextInt();
        
        int maxHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
        
        System.out.println("Maximum number of handshakes among " + numberOfStudents + " students is " + maxHandshakes);
        
        input.close();
    }
}