import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;
    private int pin;
    private List<Account> accounts;

    public Customer(String firstName, String lastName, int pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public Account getAccountByNumber(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public String getAllAccountsInfo() {
        StringBuilder info = new StringBuilder();
        for (Account account : accounts) {
            info.append(account.toString()).append("\n");
        }
        return info.toString();
    }

    public String toString() {
        return "Name: " + firstName + " " + lastName + ", PIN: " + pin;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPin() {
        return pin;
    }
}