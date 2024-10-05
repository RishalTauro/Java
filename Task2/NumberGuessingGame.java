import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // Create a Random object to generate random numbers
        Random random = new Random();
        
        // Generate a random number between 1 and 100
        int numberToGuess = random.nextInt(100) + 1;
        int numberOfTries = 0;
        try (Scanner input = new Scanner(System.in)) {
            int guess;
            boolean win = false;
            
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Try to guess the number between 1 and 100.");
            
            // Game continues until the user guesses the correct number
            while (!win) {
                System.out.print("Enter your guess: ");
                guess = input.nextInt();
                numberOfTries++;
                
                if (guess == numberToGuess) {
                    win = true;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            System.out.println("Congratulations! You guessed the number in " + numberOfTries + " tries.");
        }
    }
}
