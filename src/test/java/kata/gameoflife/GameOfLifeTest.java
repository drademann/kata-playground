package kata.gameoflife;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * Requirements
 *
 * Any live cell with fewer than two live neighbours dies, as if caused by under-population.
 * Any live cell with two or three live neighbours lives on to the next generation.
 * Any live cell with more than three live neighbours dies, as if by overcrowding.
 * Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
 */
public class GameOfLifeTest {

    @Test
    public void test() {
        // start your tests
        assertThat(true).isTrue();
    }
}
