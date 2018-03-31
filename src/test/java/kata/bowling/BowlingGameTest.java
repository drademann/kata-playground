package kata.bowling;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.stream;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * <strong>Requirements</strong>
 * <p>
 * The game consists of 10 frames.  In each frame the player has two
 * opportunities (rolls) to knock down 10 pins.  The score for the frame is the total
 * number of pins knocked down, plus bonuses for strikes and spares.
 * <p>
 * A spare is when the player knocks down all 10 pins in two tries.  The bonus for
 * that frame is the number of pins knocked down by the next roll.
 * <p>
 * A strike is when the player knocks down all 10 pins on his first try.  The bonus
 * for that frame is the value of the next two balls rolled.
 * <p>
 * In the tenth frame a player who rolls a spare or strike is allowed to roll the extra
 * balls to complete the frame.  However no more than three balls can be rolled in
 * tenth frame.
 * <p>
 * Write a class named <i>Game</i> that has two methods:
 * <p>
 * {@code roll(pins : int)}
 * is called each time the player rolls a ball.  The argument is the number of pins knocked down.
 * <p>
 * {@code score() : int}
 * is called only at the very end of the game.  It returns the total score for that game.
 */
class BowlingGameTest {

    private BowlingGame gameWith(int... rolls) {
        BowlingGame game = new BowlingGame();
        stream(rolls).forEach(game::roll);
        return game;
    }

    @Test
    void givenNewRoll_shouldAddNewPins() {
        assertThat(gameWith(1).rollAt(0)).isEqualTo(1);
    }
}
