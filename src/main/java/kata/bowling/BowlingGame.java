package kata.bowling;

class BowlingGame {

    private static final int MAX_ROLLS = 22;

    private int nextRoll;
    private final int[] rolls = new int[21];

    void roll(int pins) {
        if (nextRoll == MAX_ROLLS) throw new TooManyRollsException();
        rolls[nextRoll++] = pins;
    }

    int rollAt(int rollIndex) { // visible for testing
        return rolls[rollIndex];
    }
}

