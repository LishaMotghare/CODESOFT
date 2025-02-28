import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}

// Class to represent the ATM machine
public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private void checkBalance() {
        System.out.println("\nYour current balance is: $" + account.getBalance());
    }

    private void withdraw() {
        System.out.print("\nEnter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount > account.getBalance()) {
            System.out.println("Insufficient funds. Please try again.");
        } else {
            account.withdraw(amount);
            System.out.println("\nWithdrawal successful. Your new balance is: $" + account.getBalance());
        }
    }

    private void deposit() {
        System.out.print("\nEnter the amount to deposit: $");
        double amount = scanner.nextDouble();

        account.deposit(amount);
        System.out.println("\nDeposit successful. Your new balance is: $" + account.getBalance());
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // Initial balance: $1000.00
        ATM atm = new ATM(account);
        atm.run();
    }
}


// This Java code implements a simple ATM interface with the following features:

// - Creates a BankAccount class to represent the user's bank account, which stores the account balance.
// - Creates an ATM class to represent the ATM machine, which provides methods for checking balance, withdrawing, and depositing.
// - Validates user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
// - Displays appropriate messages to the user based on their chosen options and the success or failure of their transactions.

