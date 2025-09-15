class BankAccount {
    // Static variables shared across all accounts
    private static String bankName = "Global Bank";
    private static int totalAccounts = 0;
    
    // Instance variables
    private String accountHolderName;
    private final String accountNumber; // Final - cannot be changed once assigned
    private double balance;
    
    // Constructor using 'this' to resolve ambiguity
    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName; // 'this' resolves ambiguity
        this.accountNumber = accountNumber; // Final variable initialization
        this.balance = balance;
        totalAccounts++; // Increment total accounts
    }
    
    // Static method to get total accounts
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    
    // Static method to get/set bank name
    public static String getBankName() {
        return bankName;
    }
    
    public static void setBankName(String bankName) {
        BankAccount.bankName = bankName;
    }
    
    // Method for depositing money
    public void depositMoney(double amount) {
        if (amount > 0) {
            this.balance += amount; // Using 'this' for clarity
            System.out.println("Deposited: $" + amount);
            System.out.println("New Balance: $" + this.balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    
    // Method for withdrawing money
    public void withdrawMoney(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            System.out.println("Remaining Balance: $" + this.balance);
        } else if (amount > this.balance) {
            System.out.println("Insufficient balance! Current balance: $" + this.balance);
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }
    
    // Method to display account details with instanceof check
    public static void displayAccountDetails(Object obj) {
        if (obj instanceof BankAccount) { // Type checking with instanceof
            BankAccount account = (BankAccount) obj; // Safe casting
            System.out.println("=== Account Details ===");
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + account.accountHolderName);
            System.out.println("Account Number: " + account.accountNumber);
            System.out.println("Current Balance: $" + account.balance);
        } else {
            System.out.println("Error: Object is not a BankAccount instance!");
        }
    }
    
    // Getters
    public String getAccountHolderName() {
        return this.accountHolderName;
    }
    
    public String getAccountNumber() {
        return this.accountNumber; // Final variable can be read
    }
    
    public double getBalance() {
        return this.balance;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Bank Account Management System ===");
        System.out.println("Bank: " + BankAccount.getBankName());
        System.out.println("Initial Total Accounts: " + BankAccount.getTotalAccounts());
        
        // Creating accounts
        BankAccount account1 = new BankAccount("John Doe", "ACC123456", 1000.0);
        BankAccount account2 = new BankAccount("Alice Smith", "ACC789012", 1500.0);
        
        System.out.println("\nTotal Accounts after creation: " + BankAccount.getTotalAccounts());
        
        // Using instanceof to safely display account details
        BankAccount.displayAccountDetails(account1);
        
        System.out.println("\n--- Banking Operations ---");
        account1.depositMoney(500.0);
        account1.withdrawMoney(200.0);
        
        // Testing instanceof with non-BankAccount object
        String notAnAccount = "This is not a bank account";
        System.out.println("\n--- Testing instanceof with invalid object ---");
        BankAccount.displayAccountDetails(notAnAccount);
        
        // Final variable demonstration
        System.out.println("\n--- Final Variable Demonstration ---");
        System.out.println("Account Number (final): " + account1.getAccountNumber());
        // account1.accountNumber = "NEW123"; // This would cause compilation error
    }
}