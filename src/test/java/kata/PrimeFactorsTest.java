package kata;

import org.fest.assertions.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <strong>Requirements</strong>
 * <ul>
 * <li>For an integer value n the generator should return all prime factors as an ordered list.</li>
 * </ul>
 */
public class PrimeFactorsTest {

	@Test
	public void generate_shouldReturnPrimeFactors() {
		Assertions.assertThat(generatePrimeFactors(1)).isEmpty();
	}

	public static List<Integer> generatePrimeFactors(int n) {
		return new ArrayList<>();
	}
}
