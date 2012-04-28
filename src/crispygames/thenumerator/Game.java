package crispygames.thenumerator;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * This is the base for a simple guess the number game. It is responsible for running the game loop, getting input, and checking for a correct answer.
 * @author Christopher Bregg
 * @version 0.1
 */
public class Game {
	// Constants //////////////////////////////////////
	public static final int NUM_RANGE_BTM = 0;
	public static final int NUM_RANGE_TOP = 10;
	
	// Local Fields /////////////////////////////////////////////////////
	private Random randGenerator;
	private int goalNum;
	private Scanner inputReader;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game playGame = new Game();
		
		playGame.setup();
		playGame.play();
	}

	/**
	 * Setup the game, get ready to play
	 */
	public void setup() {
		randGenerator = new Random();
		inputReader = new Scanner(System.in);
	}
	
	/**
	 * Play the game. This is the main game loop
	 */
	public void play() {
		System.out.println("Welcome to the Numerator");
		System.out.println("The goal of the game is to guess the number I am thinking of.");
		System.out.println("Along the way I will offer hints if you get it wrong.");
		System.out.println("Lets get started");
		
		boolean gameOver = false;
		startGame();
		
		while (!gameOver) {
			int guess = getPlayerGuess();
			
			if (guess > 0) {
				System.out.println("Your guess was too high");
				System.out.println();
			} else if (guess < 0) {
				System.out.println("Your guess was too low");
				System.out.println();
			} else {
				System.out.println("You got it right");
				gameOver = true;
			}
		}
		
		System.out.println("Congratulations!! You beat me");
	}
	
	/**
	 * Get ready to play a round
	 */
	public void startGame() {
		goalNum = getRandomNum(NUM_RANGE_BTM, NUM_RANGE_TOP);
	}
	
	/**
	 * Shutdown the game. This cleans up any used resources.
	 */
	public void shutdown() {
		randGenerator = null;
		
		inputReader.close();
		inputReader = null;
	}
	
	/**
	 * Get a guess from the player
	 * 
	 * @return The player's guess
	 */
	public int getPlayerGuess() {
		int playerGuess;
		
		while (true) {
			try {
				System.out.println("Enter a guess between " + NUM_RANGE_BTM + " and " + NUM_RANGE_TOP);
				System.out.print(">");
				playerGuess = inputReader.nextInt();
				
				return playerGuess;
			} catch (InputMismatchException e) {
				System.out.println("You must enter a valid number");
				System.out.println();
				continue;
			}
		}
	}
	
	/**
	 * Check the supplied number against the stored "correct" number.
	 * Returns a value indicating if the number is too high, or too low, or matches.
	 * 
	 * @param playerGuess The number to be checked against the correct number
	 * @return A value indicating if the guess is too high, or too low, or correct. -1 = too low, 0 = match, 1 = too high
	 */
	public int checkGuess(int playerGuess) {
		if (playerGuess > goalNum) {
			return 1;
		} else if (playerGuess < goalNum) {
			return -1;
		} else {
			return 0;
		}
	}
	
	/**
	 * Generate a random number in the supplied range, and return it. The range will be interpreted as inclusive, not exclusive.
	 * 
	 * @param lowValue The bottom of the allowable range
	 * @param highValue The top of the allowable range
	 * @return The generated random number
	 */
	public int getRandomNum(int lowValue, int highValue) {
		int numRange = highValue - lowValue;
		int randNum;
		
		// increment by 1 so that the highvalue is inclusive
		// Add the low value so that range starts at the low value, and goes up to the high value
		randNum = randGenerator.nextInt(numRange + 1) + lowValue;
		
		return randNum;
	}
}