54import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // Initialize score and round number
        int score = 0;
        int roundNum = 1;

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Create a Random object to generate random numbers
        Random random = new Random();

        // Game loop
        while (true) {
            // Generate a random number between 1 and 100
            int numberToGuess = random.nextInt(100) + 1;

            // Initialize the number of attempts
            int attempts = 0;

            // Initialize a flag to check if the user wants to play again
            boolean playAgain = true;

            System.out.println("\nRound " + roundNum + ":");

            // Guessing loop
            while (attempts < 6) {
                // Prompt the user to enter their guess
                System.out.print("Guess a number between 1 and 100: ");
                String userGuessStr = scanner.nextLine();

                // Check if the user wants to quit
                if (userGuessStr.equalsIgnoreCase("quit")) {
                    playAgain = false;
                    break;
                }

                // Try to parse the user's guess to an integer
                try {
                    int userGuess = Integer.parseInt(userGuessStr);

                    // Check if the user's guess is in the correct range
                    if (userGuess < 1 || userGuess > 100) {
                        System.out.println("Please enter a number between 1 and 100.");
                        continue;
                    }

                    // Increment the number of attempts
                    attempts++;

                    // Check if the user's guess is correct
                    if (userGuess == numberToGuess) {
                        System.out.println("\nCongratulations! You found the number in " + attempts + " attempts.");
                        score++;
                        break;
                    } else if (userGuess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a whole number.");
                }
            }

            // Check if the user wants to play again
            if (!playAgain) {
                break;
            }

            // Ask the user if they want to play another round
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }

            // Increment the round number
            roundNum++;
        }

        // Print the final score
        System.out.println("\nGame over! Your final score is " + score + " out of " + (roundNum - 1) + ".");
    }
}


// This Java code implements the number guessing game with the following features:

// - Generates a random number between 1 and 100.
// - Prompts the user to enter their guess.
// - Provides feedback on whether the guess is correct, too high, or too low.
// - Limits the number of attempts to 6.
// - Allows the user to play multiple rounds.
// - Displays the user's score based on the number of rounds won.

