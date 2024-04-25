public class Account {
    private double balance;
    private int accountNumber;
    private String test;
    private static int numberOfAccounts = 1000;

    public Account(double initialDeposit) {
        this.balance = initialDeposit;
        this.accountNumber = ++numberOfAccounts;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited amount: " + amount + ", Updated balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn amount: " + amount + ", Updated balance: " + balance);
        }
    }

    public String toString() {
        return "Account Number: " + accountNumber + ", Balance: " + balance;
    }


    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
