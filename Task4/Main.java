import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

// OnlineExam class for login and profile management
class OnlineExam {
    private String username;
    private String password;

    public OnlineExam() {
        // Initially, no user is registered
        this.username = null;
        this.password = null;
    }

    // Registration method
    public void register(String username, String password) {
        this.username = username;
        this.password = password;
        System.out.println("Registration successful!");
    }

    public boolean isRegistered() {
        return this.username != null && this.password != null;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void updateProfile(String newUsername, String newPassword) {
        this.username = newUsername;
        this.password = newPassword;
        System.out.println("Profile updated successfully!");
    }
}

// MCQTest class to handle MCQ selection and timer functionality
class MCQTest {
    private int selectedAnswer;
    private int timeLimitInSeconds = 60;
    private boolean submitted = false;

    public void selectAnswer(int answer) {
        this.selectedAnswer = answer;
        System.out.println("Answer selected: " + answer);
    }

    public void startTimer() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int seconds = timeLimitInSeconds;

            @Override
            public void run() {
                if (seconds > 0) {
                    System.out.println("Time left: " + seconds-- + " seconds");
                } else {
                    autoSubmit();
                    timer.cancel();
                }
            }
        };
        timer.schedule(task, 0, 1000);
    }

    public void autoSubmit() {
        if (!submitted) {
            submitted = true;
            System.out.println("Time's up! Auto-submitting the exam.");
            // Submit the answer here
        }
    }

    public void submit() {
        submitted = true;
        System.out.println("Exam submitted manually.");
        // Submit logic here
    }

    public int getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(int selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public int getTimeLimitInSeconds() {
        return timeLimitInSeconds;
    }

    public void setTimeLimitInSeconds(int timeLimitInSeconds) {
        this.timeLimitInSeconds = timeLimitInSeconds;
    }
}

// Session class to handle session logout
class Session {
    public void logout() {
        System.out.println("Session closed. You have been logged out.");
    }
}

// Main class to run the entire program
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Initialize the exam system with no registered user
            OnlineExam exam = new OnlineExam();

            // Registration
            System.out.println("Do you want to register a new account? (yes/no)");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.println("Enter username for registration: ");
                String registerUsername = scanner.nextLine();
                System.out.println("Enter password for registration: ");
                String registerPassword = scanner.nextLine();
                exam.register(registerUsername, registerPassword);
            }

            // Login after registration
            if (exam.isRegistered()) {
                System.out.println("Enter username to login: ");
                String username = scanner.nextLine();
                System.out.println("Enter password to login: ");
                String password = scanner.nextLine();

                if (exam.login(username, password)) {
                    System.out.println("Login successful!");

                    // Update profile (optional)
                    System.out.println("Do you want to update your profile? (yes/no)");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        System.out.println("Enter new username: ");
                        String newUsername = scanner.nextLine();
                        System.out.println("Enter new password: ");
                        String newPassword = scanner.nextLine();
                        exam.updateProfile(newUsername, newPassword);
                    }

                    // Start MCQ test
                    MCQTest test = new MCQTest();
                    System.out.println("Select your answer (1-4): ");
                    int answer = scanner.nextInt();
                    test.selectAnswer(answer);

                    // Start timer
                    test.startTimer();

                    // Simulate user manually submitting before time runs out
                    System.out.println("Do you want to submit before the time ends? (yes/no)");
                    if (scanner.next().equalsIgnoreCase("yes")) {
                        test.submit();
                    }

                    // Close session
                    Session session = new Session();
                    session.logout();
                } else {
                    System.out.println("Login failed! Incorrect username or password.");
                }
            } else {
                System.out.println("No user registered! Please register first.");
            }
        }
    }
}
