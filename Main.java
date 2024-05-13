import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds!");
            return false;
        }
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM Machine");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void executeOption(int option) {
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                System.out.println("Thank you for using the ATM!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option! Please try again.");
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful. Your new balance is: $" + account.getBalance());
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Your new balance is: $" + account.getBalance());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance
        ATM atm = new ATM(userAccount);
        Scanner sc = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int option = sc.nextInt();
            atm.executeOption(option);
            System.out.println();
        }
    }
}