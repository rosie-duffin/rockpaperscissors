/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Rosie
 */
public class RockPaperScissors {

    // toString method
    @Override
    public String toString() {
        return "RockPaperScissors{" + '}';
    }

    // Default constructor
    public RockPaperScissors() {
    }

    public static void main(String[] args) {

        // Using a while loop to allow user to return to the start of the program
        PLAY_LOOP:
        while (true) {
            // Initialise counters for rounds, wins, losses and draws
            int counter = 0;
            int winCount = 0;
            int loseCount = 0;
            int drawCount = 0;

            System.out.println("Welcome to Rock, Paper, Scissors! How many rounds would you like to play?");

            // Take user input for number of rounds
            Scanner userInput = new Scanner(System.in);
            int rounds = userInput.nextInt();
            // Confirm that rounds is between 1 and 10
            if (rounds < 1 | rounds > 10) {
                System.exit(0);
            } else {
                // Do-while loop to ensure correct number of rounds are played
                do {
                    // Generate computer choice using random number from 0-2
                    Random randomiser = new Random();
                    int computerNum = randomiser.nextInt(3);

                    // Ask use for their choice and take string input
                    System.out.println("Rock, paper, or scissors?");
                    Scanner userInput2 = new Scanner(System.in);
                    String userChoice = userInput2.nextLine();

                    // Initialise userNum in order to convert input to a number to match the computer
                    int userNum = 4;

                    if (userChoice.equalsIgnoreCase("rock")) {
                        userNum = 0;
                    } else if (userChoice.equalsIgnoreCase("paper")) {
                        userNum = 1;
                    } else if (userChoice.equalsIgnoreCase("scissors")) {
                        userNum = 2;
                    } else {
                        System.out.println("Invalid choice - please choose rock, paper, or scissors.");
                    }

                    // Decision control for all possible outcomes of rock, paper, scissors
                    if (userNum != computerNum) {
                        if (userNum == 0 && computerNum == 2) { // User selects rock, computer selects scissors
                            System.out.println("You win! Congrats!");
                            counter++; // Increment round count
                            winCount++; // Increment win count
                        } else if (userNum == 1 && computerNum == 0) { // User selects paper, computer selects rock
                            System.out.println("You win! Congrats!");
                            counter++;
                            winCount++;
                        } else if (userNum == 2 && computerNum == 1) { // User selects scissors, computer selects paper
                            System.out.println("You win! Congrats!");
                            counter++;
                            winCount++;
                        } else if (userNum == 0 && computerNum == 1) { // User selects rock, computer selects paper
                            System.out.println("You lose! Better luck next time!");
                            counter++;
                            loseCount++; // Increment lose count
                        } else if (userNum == 1 && computerNum == 2) { // User selects paper, computer selects scissors
                            System.out.println("You lose! Better luck next time!");
                            counter++;
                            loseCount++;
                        } else if (userNum == 2 && computerNum == 0) { // User selects scissors, computer selects rock
                            System.out.println("You lose! Better luck next time!");
                            counter++;
                            loseCount++;
                        }
                    } else {
                        System.out.println("It's a draw! Let's try again.");
                        counter++;
                        drawCount++; // Increment draw count
                    }

                } while (counter < rounds); // Ensures the chosen number of rounds are played

                // Display wins, losses and draws and overall winner
                System.out.println("Wins: " + winCount);
                System.out.println("Losses: " + loseCount);
                System.out.println("Draws: " + drawCount);
                if (winCount > loseCount && winCount > drawCount) {
                    System.out.println("You're the winner!");
                } else if (winCount < loseCount && loseCount > drawCount) {
                    System.out.println("You're a loser! Sorry.");
                } else {
                    System.out.println("It's a draw! How boring.");
                }

                // Asks user if they want to play again
                System.out.println("Play again?");
                Scanner userInput3 = new Scanner(System.in);
                String answer = userInput3.nextLine();

                // Decides whether to start again or exit the program
                if (answer.equalsIgnoreCase("yes")) {
                    continue PLAY_LOOP; // Label used for readability
                } else {
                    System.exit(0);
                }
            }
        }
    }
}
