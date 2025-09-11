

class PalindromeChecker {
    // Attribute
    String text;
    
    // Constructor
    public PalindromeChecker(String text) {
        this.text = text;
    }
    
    // Method to check if text is palindrome
    public boolean isPalindrome() {
        // Remove spaces and convert to lowercase for accurate checking
        String cleanText = text.replaceAll("\\s+", "").toLowerCase();
        int length = cleanText.length();
        
        for (int i = 0; i < length / 2; i++) {
            if (cleanText.charAt(i) != cleanText.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    
    // Method to display the result
    public void displayResult() {
        System.out.println("Text: \"" + text + "\"");
        if (isPalindrome()) {
            System.out.println("Result: The text is a palindrome.");
        } else {
            System.out.println("Result: The text is not a palindrome.");
        }
    }
    
    public static void main(String[] args) {
        PalindromeChecker checker1 = new PalindromeChecker("madam");
        checker1.displayResult();
        
        System.out.println("\n--- Another Text ---");
        PalindromeChecker checker2 = new PalindromeChecker("hello");
        checker2.displayResult();
        
        System.out.println("\n--- Another Text ---");
        PalindromeChecker checker3 = new PalindromeChecker("A man a plan a canal Panama");
        checker3.displayResult();
        
        System.out.println("\n--- Another Text ---");
        PalindromeChecker checker4 = new PalindromeChecker("racecar");
        checker4.displayResult();
    }
}