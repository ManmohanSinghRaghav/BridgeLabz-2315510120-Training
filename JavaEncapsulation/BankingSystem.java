package JavaEncapsulation;
import java.util.*;

// Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    
    // Getters and Setters
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    
    public String getHolderName() { return holderName; }
    public void setHolderName(String holderName) { this.holderName = holderName; }
    
    public double getBalance() { return balance; }
    protected void setBalance(double balance) { this.balance = balance; }
    
    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            return true;
        }
        System.out.println("Insufficient funds or invalid amount");
        return false;
    }
    
    // Abstract method
    public abstract double calculateInterest();
}

// Interface Loanable
interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

// SavingsAccount class
class SavingsAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.04; // 4%
    
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
    
    @Override
    public boolean applyForLoan(double amount) {
        double eligibility = calculateLoanEligibility();
        if (amount <= eligibility) {
            System.out.println("Loan approved for $" + amount);
            return true;
        }
        System.out.println("Loan rejected. Maximum eligible amount: $" + eligibility);
        return false;
    }
    
    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 2; // 2x the balance
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.02; // 2%
    private double overdraftLimit;
    
    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }
    
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
    
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (getBalance() + overdraftLimit) >= amount) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn: $" + amount);
            return true;
        }
        System.out.println("Exceeds overdraft limit");
        return false;
    }
    
    @Override
    public boolean applyForLoan(double amount) {
        double eligibility = calculateLoanEligibility();
        if (amount <= eligibility) {
            System.out.println("Loan approved for $" + amount);
            return true;
        }
        System.out.println("Loan rejected. Maximum eligible amount: $" + eligibility);
        return false;
    }
    
    @Override
    public double calculateLoanEligibility() {
        return (getBalance() + overdraftLimit) * 3; // 3x the available balance
    }
    
    public double getOverdraftLimit() { return overdraftLimit; }
    public void setOverdraftLimit(double overdraftLimit) { this.overdraftLimit = overdraftLimit; }
}

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV001", "John Doe", 10000));
        accounts.add(new CurrentAccount("CUR001", "Jane Smith", 5000, 2000));
        
        // Polymorphism demonstration
        for (BankAccount account : accounts) {
            System.out.println("Account: " + account.getAccountNumber());
            System.out.println("Holder: " + account.getHolderName());
            System.out.println("Balance: $" + account.getBalance());
            System.out.println("Interest: $" + account.calculateInterest());
            
            if (account instanceof Loanable) {
                Loanable loanableAccount = (Loanable) account;
                System.out.println("Loan Eligibility: $" + loanableAccount.calculateLoanEligibility());
                loanableAccount.applyForLoan(15000);
            }
            System.out.println("---");
        }
    }
}
