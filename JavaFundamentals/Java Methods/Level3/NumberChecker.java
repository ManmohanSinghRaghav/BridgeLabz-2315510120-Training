import java.util.Arrays;

public class NumberChecker {

    // --- Helper Methods ---
    public static int countDigits(int number) {
        if (number == 0) return 1;
        return (int) Math.floor(Math.log10(Math.abs(number))) + 1;
    }

    public static int[] getDigitsArray(int number) {
        number = Math.abs(number);
        int count = countDigits(number);
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    // --- Part 1 ---
    public static boolean isDuckNumber(int number) {
        String s = String.valueOf(number);
        return s.indexOf('0') != -1 && s.charAt(0) != '0';
    }

    public static boolean isArmstrongNumber(int number) {
        if (number < 0) return false;
        int[] digits = getDigitsArray(number);
        int n = digits.length;
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, n);
        }
        return sum == number;
    }

    public static int[] findLargestAndSecondLargest(int number) {
        int[] digits = getDigitsArray(number);
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }
        return new int[]{largest, secondLargest};
    }

    public static int[] findSmallestAndSecondSmallest(int number) {
        int[] digits = getDigitsArray(number);
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    // --- Part 2 ---
    public static int sumOfDigits(int number) {
        int[] digits = getDigitsArray(number);
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquaresOfDigits(int number) {
        int[] digits = getDigitsArray(number);
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number) {
        if (number <= 0) return false;
        return number % sumOfDigits(number) == 0;
    }
    
    public static int[][] findDigitFrequency(int number) {
        int[] digits = getDigitsArray(number);
        int[] freq = new int[10];
        for (int digit : digits) {
            freq[digit]++;
        }
        
        int count = 0;
        for(int f : freq) {
            if (f > 0) count++;
        }

        int[][] result = new int[count][2];
        int index = 0;
        for(int i=0; i<10; i++) {
            if(freq[i] > 0) {
                result[index][0] = i;
                result[index][1] = freq[i];
                index++;
            }
        }
        return result;
    }

    // --- Part 3 ---
    public static int[] reverseDigitsArray(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    public static boolean compareArrays(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static boolean isPalindrome(int number) {
        int[] digits = getDigitsArray(number);
        int[] reversedDigits = reverseDigitsArray(digits);
        return compareArrays(digits, reversedDigits);
    }

    // --- Part 4 ---
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static boolean isNeonNumber(int number) {
        if (number < 0) return false;
        int square = number * number;
        return sumOfDigits(square) == number;
    }

    public static boolean isSpyNumber(int number) {
        if (number < 0) return false;
        int[] digits = getDigitsArray(number);
        int sum = 0;
        int product = 1;
        for (int digit : digits) {
            sum += digit;
            product *= digit;
        }
        return sum == product;
    }

    public static boolean isAutomorphicNumber(int number) {
        if (number < 0) return false;
        long square = (long) number * number;
        return String.valueOf(square).endsWith(String.valueOf(number));
    }

    public static boolean isBuzzNumber(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    // --- Part 5 ---
    private static int sumOfProperDivisors(int number) {
        if (number <= 1) return 0;
        int sum = 1;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                sum += i;
                if (i * i != number) {
                    sum += number / i;
                }
            }
        }
        return sum;
    }

    public static boolean isPerfectNumber(int number) {
        return number > 1 && sumOfProperDivisors(number) == number;
    }

    public static boolean isAbundantNumber(int number) {
        return number > 1 && sumOfProperDivisors(number) > number;
    }

    public static boolean isDeficientNumber(int number) {
        return number > 1 && sumOfProperDivisors(number) < number;
    }
    
    private static int factorial(int n) {
        if (n == 0) return 1;
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static boolean isStrongNumber(int number) {
        if (number < 0) return false;
        int[] digits = getDigitsArray(number);
        int sum = 0;
        for (int digit : digits) {
            sum += factorial(digit);
        }
        return sum == number;
    }
}
