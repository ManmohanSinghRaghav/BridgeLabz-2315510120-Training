import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OTPGenerator {

    public static int generateOTP() {
        return 100000 + (int)(Math.random() * 900000);
    }

    public static boolean areOTPsUnique(int[] otps) {
        Set<Integer> uniqueOtps = new HashSet<>();
        for (int otp : otps) {
            uniqueOtps.add(otp);
        }
        return uniqueOtps.size() == otps.length;
    }

    public static void main(String[] args) {
        int[] generatedOtps = new int[10];
        for (int i = 0; i < 10; i++) {
            generatedOtps[i] = generateOTP();
        }
        System.out.println("Generated OTPs: " + Arrays.toString(generatedOtps));
        System.out.println("Are all generated OTPs unique? " + areOTPsUnique(generatedOtps));
    }
}
