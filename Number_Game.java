import java.util.Random;
import java.util.Scanner;
public class Number_Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowLim = 1;
        int upLim = 100;
        int maxAttempts = 10;
        int totalRounds = 0;
        int totalAttempts = 0;

        boolean playAgain = true;
        while (playAgain) {
            int secretNumber = random.nextInt(upLim - lowLim + 1) + lowLim;
            int attempts = 0;
            boolean roundWon = false;

            System.out.println("The Number is between " + lowLim + " to " + upLim + ".");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < secretNumber) {
                    System.out.println("Number is Small...! Try again.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Number is Big...! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.");
                    roundWon = true;
                    totalAttempts += attempts;
                    totalRounds++;
                    break;
                }
            }

            if (!roundWon) {
                System.out.println("Sorry, you've used up all " + maxAttempts + " attempts. The secret number is" + secretNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game Over! You played " + totalRounds + " rounds and averaged " + ((double) totalAttempts / totalRounds) + " attempts per round.");
        scanner.close();
    }
}
