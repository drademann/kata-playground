package kata.gameoflife;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <strong>Requirements</strong>
 * <ol>
 * <li>1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.</li>
 * <li>Any live cell with two or three live neighbours lives on to the next generation.</li>
 * <li>Any live cell with more than three live neighbours dies, as if by overcrowding.</li>
 * <li>Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.</li>
 * </ol>
 */
public class GameOfLifeTest {

	@Test
	public void test() {
		// start your tests
		assertThat(true).isTrue();
	}
}
