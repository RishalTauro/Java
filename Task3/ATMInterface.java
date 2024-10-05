
import java.util.Scanner;

public class ATMInterface {

    // User credentials for login (for demo purposes)
    static String userId = "user123";
    static String userPin = "1234";

    // Account balance for demo purposes
    private static double balance = 1000.0;

    public static void main(String[] args) {
        // Login process
        try (Scanner scanner = new Scanner(System.in)) {
            // Login process
            System.out.print("Enter User ID: ");
            String enteredUserId = scanner.nextLine();
            System.out.print("Enter User PIN: ");
            String enteredPin = scanner.nextLine();

            if (authenticateUser(enteredUserId, enteredPin)) {
                boolean quit = false;
                while (!quit) {
                    // Display ATM menu options
                    System.out.println("\nATM Menu:");
                    System.out.println("1. Transactions History");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Deposit");
                    System.out.println("4. Transfer");
                    System.out.println("5. Quit");
                    System.out.print("Select an option: ");
                    int option = scanner.nextInt();

                    switch (option) {
                        case 1 ->
                            showTransactionHistory();
                        case 2 ->
                            withdrawAmount(scanner);
                        case 3 ->
                            depositAmount(scanner);
                        case 4 ->
                            transferAmount(scanner);
                        case 5 -> {
                            quit = true;
                            System.out.println("Thank you for using the ATM. Goodbye!");
                        }
                        default ->
                            System.out.println("Invalid option. Please try again.");
                    }
                }
            } else {
                System.out.println("Authentication failed. Exiting.");
            }
        }
    }

    // Authenticate the user (for demo purposes)
    private static boolean authenticateUser(String enteredUserId, String enteredPin) {
        // Reference the static fields correctly
        return enteredUserId.equals(userId) && enteredPin.equals(userPin);
    }

    // Transaction history (for demo purposes, it's static)
    private static void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        System.out.println("1. Withdrawal: $100");
        System.out.println("2. Deposit: $200");
        System.out.println("3. Transfer: $150");
        // In real applications, this data would be fetched from a database
    }

    // Withdraw money
    private static void withdrawAmount(Scanner scanner) {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
            System.out.println("Remaining balance: $" + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Deposit money
    private static void depositAmount(Scanner scanner) {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Successfully deposited: $" + amount);
        System.out.println("New balance: $" + balance);
    }

    // Transfer money (for demo purposes, static transfer)
    private static void transferAmount(Scanner scanner) {
        System.out.print("Enter amount to transfer: $");
        double amount = scanner.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Successfully transferred: $" + amount);
            System.out.println("Remaining balance: $" + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public static String getUserPin() {
        return userPin;
    }
}
