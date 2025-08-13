import java.util.Scanner;

class HeightConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your height in centimeters: ");
        double heightCm = input.nextDouble();
        
        double cmPerInch = 2.54;
        double inchesPerFoot = 12.0;
        double totalInches = heightCm / cmPerInch;
        int feet = (int) (totalInches / inchesPerFoot);
        double remainingInches = totalInches % inchesPerFoot;
        
        System.out.println("Your Height in cm is " + heightCm + " while in feet is " + feet + " and inches is " + remainingInches);
        
        input.close();
    }
}
        
        // Calculate feet and remaining inches
        int feet = (int) (totalInches / inchesPerFoot);
        double remainingInches = totalInches % inchesPerFoot;
        
        // Display the result
        System.out.println("Your Height in cm is " + heightCm + " while in feet is " + feet + " and inches is " + remainingInches);
        
        // Close scanner
        input.close();
    }
}
