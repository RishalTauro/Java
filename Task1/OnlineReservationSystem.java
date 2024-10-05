import java.util.HashMap;
import java.util.Scanner;

public class OnlineReservationSystem {
    // HashMaps to store user login details and reservations
    static HashMap<String, String> users = new HashMap<>();
    static HashMap<String, String> reservations = new HashMap<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Preloaded users (you can remove this if unnecessary)
            users.put("user1", "password1");
            users.put("user2", "password2");

            System.out.println("Welcome to the Online Reservation System");

            boolean exit = false;
            while (!exit) {
                System.out.println("\nMain Menu:");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1 -> register(scanner);  // Call to register method
                    case 2 -> login(scanner);  // Call to login method
                    case 3 -> {
                        exit = true;
                        System.out.println("Exiting the system.");
                    }
                    default -> System.out.println("Invalid option, please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Method to handle user registration
    public static void register(Scanner scanner) {
        System.out.print("Enter a new username: ");
        String username = scanner.nextLine();
        
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Try a different one.");
            return;
        }

        System.out.print("Enter a new password: ");
        String password = scanner.nextLine();

        // Save the new user
        users.put(username, password);
        System.out.println("Registration successful! You can now log in.");
    }

    // Method to handle user login
    public static void login(Scanner scanner) {
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful!");
            boolean loggedIn = true;
            while (loggedIn) {
                System.out.println("\nMenu:");
                System.out.println("1. Make a Reservation");
                System.out.println("2. Cancel a Reservation");
                System.out.println("3. Logout");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (option) {
                    case 1 -> makeReservation(scanner);
                    case 2 -> cancelReservation(scanner);
                    case 3 -> {
                        loggedIn = false;
                        System.out.println("Logged out successfully.");
                    }
                    default -> System.out.println("Invalid option, please try again.");
                }
            }
        } else {
            System.out.println("Login failed. Incorrect username or password.");
        }
    }

    // Method to handle reservation
    public static void makeReservation(Scanner scanner) {
        System.out.print("Enter PNR Number: ");
        String pnr = scanner.nextLine();
        System.out.print("Enter Train Number: ");
        String trainNumber = scanner.nextLine();
        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter Date of Journey (DD/MM/YYYY): ");
        String date = scanner.nextLine();

        reservations.put(pnr, "Train: " + trainNumber + ", Destination: " + destination + ", Date: " + date);
        System.out.println("Reservation successful! PNR: " + pnr);
    }

    // Method to handle cancellation
    public static void cancelReservation(Scanner scanner) {
        System.out.print("Enter PNR Number: ");
        String pnr = scanner.nextLine();

        if (reservations.containsKey(pnr)) {
            reservations.remove(pnr);
            System.out.println("Reservation canceled successfully.");
        } else {
            System.out.println("PNR not found.");
        }
    }
}
