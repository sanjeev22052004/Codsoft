import java.util.Scanner;

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

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayOptions() {
        System.out.println("ATM Options:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processUserChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit(scanner);
                break;
            case 3:
                withdraw(scanner);
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private void checkBalance() {
        double balance = userAccount.getBalance();
        System.out.println("Current Balance: $" + balance);
    }

    private void deposit(Scanner scanner) {
        System.out.print("Enter deposit amount: $");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
        System.out.println("Deposit successful. New balance: $" + userAccount.getBalance());
    }

    private void withdraw(Scanner scanner) {
        System.out.print("Enter withdrawal amount: $");
        double amount = scanner.nextDouble();

        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: $" + userAccount.getBalance());
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayOptions();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            atm.processUserChoice(choice, scanner);
        }
    }
}
