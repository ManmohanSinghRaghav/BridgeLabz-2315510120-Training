

class BankAccount {
    // Attributes
    String accountHolder;
    String accountNumber;
    double balance;
    
    // Constructor
    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    // Method for depositing money
    public void depositMoney(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    
    // Method for withdrawing money
    public void withdrawMoney(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            System.out.println("Remaining Balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Current balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }
    
    // Method to display current balance
    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
    }
    
    public static void main(String[] args) {
        BankAccount account = new BankAccount("John Doe", "ACC123456", 1000.0);
        
        System.out.println("=== ATM Simulation ===");
        account.displayBalance();
        
        System.out.println("\n--- Deposit Transaction ---");
        account.depositMoney(500.0);
        
        System.out.println("\n--- Withdrawal Transaction ---");
        account.withdrawMoney(200.0);
        
        System.out.println("\n--- Insufficient Funds Test ---");
        account.withdrawMoney(2000.0);
        
        System.out.println("\n--- Final Balance ---");
        account.displayBalance();
    }
}