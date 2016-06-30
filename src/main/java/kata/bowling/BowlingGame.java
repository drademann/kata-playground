
package kata.bowling;

class BowlingGame {

	private int nextRoll;
	private final int[] rolls = new int[21];

	void roll(int pins) {
		if (nextRoll == 22) throw new TooManyRollsException();
		rolls[nextRoll++] = pins;
	}

	int rollAt(int rollIndex) { // visible for testing
		return rolls[rollIndex];
	}

}

