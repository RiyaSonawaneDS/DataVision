import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attempts = 10; // Number of attempts allowed
        int score = 0; // Initialize score

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between " + minRange + " and " + maxRange);

        boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            int remainingAttempts = attempts;

            while (remainingAttempts > 0) {
                System.out.print("Enter your guess (Attempts left: " + remainingAttempts + "): ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number: " + numberToGuess);
                    score++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }

                remainingAttempts--;
            }

            if (remainingAttempts == 0) {
                System.out.println("Oops! You've used all your attempts. The number was: " + numberToGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();
            if (!playChoice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing! Your score is: " + score);
    }
}
