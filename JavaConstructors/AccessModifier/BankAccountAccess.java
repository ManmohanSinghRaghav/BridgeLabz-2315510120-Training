class BankAccountAccess {
    public String accountNumber;      // Public access
    protected String accountHolder;   // Protected access
    private double balance;           // Private access
    
    // Constructor
    public BankAccountAccess(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        setBalance(balance); // Use setter for validation
    }
    
    // Public methods to access and modify private balance
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative");
            this.balance = 0.0;
        }
    }
    
    // Public methods for banking operations
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive");
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            return true;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds");
            return false;
        }
    }
    
    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
    
    public static void main(String[] args) {
        System.out.println("=== Bank Account Management System ===");
        
        BankAccountAccess account = new BankAccountAccess("ACC123456", "John Doe", 1000.0);
        account.displayAccountDetails();
        
        System.out.println("\n--- Accessing Public Member ---");
        System.out.println("Account Number (direct access): " + account.accountNumber);
        
        System.out.println("\n--- Banking Operations ---");
        account.deposit(500.0);
        System.out.println("Balance after deposit: $" + account.getBalance());
        
        account.withdraw(200.0);
        System.out.println("Balance after withdrawal: $" + account.getBalance());
        
        System.out.println("\n--- Testing Invalid Operations ---");
        account.deposit(-100.0); // Invalid deposit
        account.withdraw(2000.0); // Insufficient funds
    }
}

// Subclass to demonstrate access modifiers
class SavingsAccount extends BankAccountAccess {
    private double interestRate;
    private double minimumBalance;
    
    public SavingsAccount(String accountNumber, String accountHolder, double balance, 
                         double interestRate, double minimumBalance) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
    }
    
    // Method to calculate and add interest
    public void addInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest added: $" + String.format("%.2f", interest));
    }
    
    // Override withdraw to check minimum balance
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (getBalance() - amount) >= minimumBalance) {
            return super.withdraw(amount);
        } else {
            System.out.println("Cannot withdraw. Minimum balance of $" + minimumBalance + " required");
            return false;
        }
    }
    
    public void displaySavingsAccountDetails() {
        System.out.println("=== Savings Account Details ===");
        System.out.println("Account Number: " + accountNumber);     // Public - accessible
        System.out.println("Account Holder: " + accountHolder);     // Protected - accessible in subclass
        System.out.println("Balance: $" + getBalance());            // Private - accessed via public method
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Minimum Balance: $" + minimumBalance);
    }
    
    public double getInterestRate() {
        return interestRate;
    }
    
    public double getMinimumBalance() {
        return minimumBalance;
    }
}