import java.util.ArrayList;
import java.util.List;

// Customer class
class Customer {
    private String customerName;
    private final int customerId; // final variable
    private String email;
    private List<BankAccount> accounts; // Association with BankAccount
    private static int totalCustomers = 0;
    
    public Customer(String customerName, int customerId, String email) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.email = email;
        this.accounts = new ArrayList<>();
        totalCustomers++;
    }
    
    // Method to add account (Association)
    public void addAccount(BankAccount account) {
        if (account != null && !accounts.contains(account)) {
            accounts.add(account);
            System.out.println("Account " + account.getAccountNumber() + " added for " + customerName);
        }
    }
    
    // Communication method - view all account balances
    public void viewAllBalances() {
        System.out.println("=== " + customerName + "'s Account Balances ===");
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            double totalBalance = 0;
            for (BankAccount account : accounts) {
                System.out.println("Account " + account.getAccountNumber() + 
                                 ": $" + account.getBalance());
                totalBalance += account.getBalance();
            }
            System.out.println("Total Balance: $" + totalBalance);
        }
    }
    
    // Communication method - transfer between own accounts
    public boolean transferBetweenAccounts(String fromAccount, String toAccount, double amount) {
        BankAccount from = findAccount(fromAccount);
        BankAccount to = findAccount(toAccount);
        
        if (from != null && to != null) {
            if (from.withdraw(amount)) {
                to.deposit(amount);
                System.out.println("Transfer successful: $" + amount + 
                                 " from " + fromAccount + " to " + toAccount);
                return true;
            }
        }
        System.out.println("Transfer failed.");
        return false;
    }
    
    // Helper method to find account
    private BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
    
    // Static method with instanceof check
    public static void displayCustomerInfo(Object obj) {
        if (obj instanceof Customer) {
            Customer customer = (Customer) obj;
            System.out.println("=== Customer Information ===");
            System.out.println("Name: " + customer.customerName);
            System.out.println("ID: " + customer.customerId);
            System.out.println("Email: " + customer.email);
            System.out.println("Number of Accounts: " + customer.accounts.size());
        } else {
            System.out.println("Error: Object is not a Customer instance!");
        }
    }
    
    // Getters
    public String getCustomerName() { return customerName; }
    public int getCustomerId() { return customerId; }
    public String getEmail() { return email; }
    public List<BankAccount> getAccounts() { return new ArrayList<>(accounts); }
    public static int getTotalCustomers() { return totalCustomers; }
}

// Enhanced BankAccount class
class BankAccount {
    private String accountHolderName;
    private final String accountNumber; // final variable
    private double balance;
    private String accountType;
    private static String bankName = "Global Bank";
    private static int totalAccounts = 0;
    
    public BankAccount(String accountHolderName, String accountNumber, 
                      double initialBalance, String accountType) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.accountType = accountType;
        totalAccounts++;
    }
    
    // Communication method - deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited $" + amount + " to account " + accountNumber);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    
    // Communication method - withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdrawn $" + amount + " from account " + accountNumber);
            return true;
        } else if (amount > this.balance) {
            System.out.println("Insufficient balance in account " + accountNumber);
            return false;
        } else {
            System.out.println("Invalid withdrawal amount!");
            return false;
        }
    }
    
    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("=== Account Details ===");
        System.out.println("Bank: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: $" + balance);
    }
    
    // Static method to transfer between different customers' accounts
    public static boolean transferMoney(BankAccount fromAccount, BankAccount toAccount, double amount) {
        if (fromAccount != null && toAccount != null) {
            if (fromAccount.withdraw(amount)) {
                toAccount.deposit(amount);
                System.out.println("Inter-customer transfer successful: $" + amount);
                return true;
            }
        }
        System.out.println("Inter-customer transfer failed.");
        return false;
    }
    
    // Getters
    public String getAccountHolderName() { return accountHolderName; }
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public String getAccountType() { return accountType; }
    public static String getBankName() { return bankName; }
    public static int getTotalAccounts() { return totalAccounts; }
}

// Bank class to manage customers and accounts
class Bank {
    private String bankName;
    private List<Customer> customers; // Association with Customer
    private List<BankAccount> allAccounts; // Association with BankAccount
    
    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
        this.allAccounts = new ArrayList<>();
    }
    
    // Method to add customer (Association)
    public void addCustomer(Customer customer) {
        if (customer != null && !customers.contains(customer)) {
            customers.add(customer);
            System.out.println("Customer " + customer.getCustomerName() + " added to " + bankName);
        }
    }
    
    // Communication method - open account for customer
    public BankAccount openAccount(Customer customer, String accountType, double initialDeposit) {
        String accountNumber = "ACC" + (BankAccount.getTotalAccounts() + 1);
        BankAccount newAccount = new BankAccount(customer.getCustomerName(), 
                                               accountNumber, initialDeposit, accountType);
        
        customer.addAccount(newAccount);
        allAccounts.add(newAccount);
        
        System.out.println("Account opened successfully for " + customer.getCustomerName());
        return newAccount;
    }
    
    // Method to display all customers
    public void displayAllCustomers() {
        System.out.println("=== " + bankName + " Customers ===");
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            for (Customer customer : customers) {
                System.out.println("- " + customer.getCustomerName() + 
                                 " (ID: " + customer.getCustomerId() + 
                                 ", Accounts: " + customer.getAccounts().size() + ")");
            }
        }
    }
    
    // Method to display bank statistics
    public void displayBankStatistics() {
        System.out.println("=== " + bankName + " Statistics ===");
        System.out.println("Total Customers: " + customers.size());
        System.out.println("Total Accounts: " + allAccounts.size());
        
        double totalDeposits = 0;
        for (BankAccount account : allAccounts) {
            totalDeposits += account.getBalance();
        }
        System.out.println("Total Deposits: $" + totalDeposits);
    }
    
    public static void main(String[] args) {
        // Create bank
        Bank globalBank = new Bank("Global Bank");
        
        // Create customers
        Customer customer1 = new Customer("John Doe", 1001, "john@email.com");
        Customer customer2 = new Customer("Alice Smith", 1002, "alice@email.com");
        Customer customer3 = new Customer("Bob Johnson", 1003, "bob@email.com");
        
        // Add customers to bank (Association)
        globalBank.addCustomer(customer1);
        globalBank.addCustomer(customer2);
        globalBank.addCustomer(customer3);
        
        // Open accounts for customers (Communication)
        System.out.println("\n=== Opening Accounts ===");
        BankAccount johnSavings = globalBank.openAccount(customer1, "Savings", 1000.0);
        BankAccount johnChecking = globalBank.openAccount(customer1, "Checking", 500.0);
        BankAccount aliceSavings = globalBank.openAccount(customer2, "Savings", 2000.0);
        BankAccount bobSavings = globalBank.openAccount(customer3, "Savings", 1500.0);
        
        // Demonstrate communication between objects
        System.out.println("\n=== Banking Operations ===");
        customer1.viewAllBalances();
        
        // Transfer between customer's own accounts
        customer1.transferBetweenAccounts(johnSavings.getAccountNumber(), 
                                        johnChecking.getAccountNumber(), 200.0);
        customer1.viewAllBalances();
        
        // Transfer between different customers
        System.out.println("\n=== Inter-Customer Transfer ===");
        BankAccount.transferMoney(aliceSavings, bobSavings, 300.0);
        
        // Display bank information
        System.out.println("\n=== Bank Information ===");
        globalBank.displayAllCustomers();
        globalBank.displayBankStatistics();
        
        // Test instanceof
        System.out.println("\n=== Testing instanceof ===");
        Customer.displayCustomerInfo(customer1);
        Customer.displayCustomerInfo("Not a customer");
        
        System.out.println("\nTotal Customers: " + Customer.getTotalCustomers());
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}
