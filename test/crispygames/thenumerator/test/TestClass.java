package crispygames.thenumerator.test;

import crispygames.thenumerator.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestClass {

	@Test
	public void testCheckGuess() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRandomNum() {
		Game tester = new Game();
		tester.setup();
		
		for (int x = 0; x < 100000; x++) {
			int randNum = tester.getRandomNum(10, 20);
			
			assertTrue("num in range, normal values", randNum <= 20 && randNum >= 10);
		}
		
		for (int x = 0; x < 100000; x++) {
			int randNum = tester.getRandomNum(-10, 20);
			
			assertTrue("num in range, negative values", randNum <= 20 && randNum >= -10);
		}
	}

}
