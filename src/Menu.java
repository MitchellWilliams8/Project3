import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Bank bank;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.bank = new Bank();
    }

    public void runMenu() {
        int choice = 0;
        while (choice != 5) {
            displayMainMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                accessAccount();
            } else if (choice == 2) {
                openNewAccount();
            } else if (choice == 3) {
                createNewCustomer();
            } else if (choice == 4) {
                closeAllAccounts();
            } else if (choice == 5) {
                System.out.println("Exiting the program...");
            } else {
                System.out.println("Invalid entry. Please enter a number between 1 and 5.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\nMain Menu");
        System.out.println("1. Access an account");
        System.out.println("2. Open a new account");
        System.out.println("3. Create a new customer");
        System.out.println("4. Close all accounts");
        System.out.println("5. Exit");
    }

    private void accessAccount() {
        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();
        scanner.nextLine();

        Customer customer = bank.getCustomerByPIN(pin);
        if (customer == null) {
            System.out.println("PIN is not valid.");
            return;
        }

        System.out.println("Accounts for " + customer.getFirstName() + " " + customer.getLastName() + ":");
        System.out.println(customer.getAllAccountsInfo());

        System.out.print("Enter the account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();

        Account account = customer.getAccountByNumber(accountNumber);
        if (account == null) {
            System.out.println("Account number is invalid.");
            return;
        }

        System.out.println("\nAccount Menu");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. View account information");
        System.out.println("4. Exit to main menu");
        System.out.print("Enter your choice: ");
        int accountChoice = scanner.nextInt();
        scanner.nextLine();

        if (accountChoice == 1) {
            System.out.print("Enter the deposit amount: ");
            double depositAmount = scanner.nextDouble();
            account.deposit(depositAmount);
        } else if (accountChoice == 2) {
            System.out.print("Enter the withdrawal amount: ");
            double withdrawalAmount = scanner.nextDouble();
            account.withdraw(withdrawalAmount);
        } else if (accountChoice == 3) {
            System.out.println(account.toString());
        } else if (accountChoice == 4) {

            return;
        } else {
            System.out.println("Invalid entry. Please enter a number between 1 and 4.");
        }
    }

    private void displayAccountMenu() {
        System.out.println("\nAccount Menu");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. View account information");
        System.out.println("4. Exit to main menu");
    }

    private void openNewAccount() {
        System.out.print("Are you a new customer? (yes/no): ");
        String isNewCustomer = scanner.nextLine();

        Customer customer;
        if (isNewCustomer.equalsIgnoreCase("yes")) {
            customer = createNewCustomer();
        } else if (isNewCustomer.equalsIgnoreCase("no")) {
            System.out.print("Enter your PIN: ");
            int pin = scanner.nextInt();
            scanner.nextLine();

            customer = bank.getCustomerByPIN(pin);
            if (customer == null) {
                System.out.println("PIN is not valid.");
                return;
            }
        } else {
            System.out.println("Invalid entry.");
            return;
        }

        System.out.print("Enter the deposit amount for the new account: ");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine();

        Account newAccount = new Account(initialDeposit);
        customer.addAccount(newAccount);
        System.out.println("New Account Opened: " + newAccount.getAccountNumber());
    }

    private Customer createNewCustomer() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();
        scanner.nextLine();

        Customer newCustomer = new Customer(firstName, lastName, pin);
        bank.addCustomer(newCustomer);
        System.out.println("New customer created.");

        return newCustomer;
    }

    private void closeAllAccounts() {
        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();
        scanner.nextLine();

        Customer customer = bank.getCustomerByPIN(pin);
        if (customer == null) {
            System.out.println("PIN is not valid.");
            return;
        }

        bank.removeCustomer(customer);
        System.out.println("Customer has been removed from bank registry.");
    }
}