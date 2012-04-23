package crispygames.thenumerator;

import java.util.Random;

/**
 * This is the base for a simple guess the number game. It is responsible for running the game loop, getting input, and checking for a correct answer.
 * @author Christopher Bregg
 * @version 0.1
 */
public class Game {

	// Local Fields /////////////////////////////////////////////////////
	private Random randGenerator;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Setup the game, get ready to play
	 */
	public void setup() {
		randGenerator = new Random();
	}
	
	/**
	 * Play the game. This is the main game loop
	 */
	public void play() {
		
	}
	
	/**
	 * Shutdown the game. This cleans up any used resources.
	 */
	public void shutdown() {
		
	}
	
	/**
	 * Get a guess from the player
	 * 
	 * @return The player's guess
	 */
	public int getPlayerGuess() {
		return 0;
	}
	
	/**
	 * Check the supplied number against the stored "correct" number.
	 * Returns a value indicating if the number is too high, or too low, or matches.
	 * 
	 * @param playerGuess The number to be checked against the correct number
	 * @return A value indicating if the guess is too high, or too low, or correct. -1 = too low, 0 = match, 1 = too high
	 */
	public int checkGuess(int playerGuess) {
		return 0;
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
