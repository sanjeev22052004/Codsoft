import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        playGame();
    }

    static void playGame() {
        int totalScore = 0;
        int rounds = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int roundScore = guessTheNumber(scanner);
            totalScore += roundScore;
            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("\nGame Over. Your total score is " + totalScore + " in " + rounds + " rounds.");
                break;
            }
        }
    }

    static int guessTheNumber(Scanner scanner) {
        int lowerLimit = 1;
        int upperLimit = 100;
        int targetNumber = new Random().nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
        int maxAttempts = 10;
        int attempts = 0;

        while (attempts < maxAttempts) {
            System.out.print("Guess the number between " + lowerLimit + " and " + upperLimit + ": ");

            if (scanner.hasNextInt()) {
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number " + targetNumber +
                            " in " + (attempts + 1) + " attempts.");
                    return 1;  // User won the round
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attempts++;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
            }
        }

        System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + targetNumber + ".");
        return 0;  // User lost the round
    }
}
