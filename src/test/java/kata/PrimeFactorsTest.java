package kata;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <strong>Requirements</strong>
 * <ul>
 * <li>For an integer value n the generator should return all prime factors as an ordered list.</li>
 * </ul>
 */
public class PrimeFactorsTest {

	@Test
	public void generate_shouldReturnPrimeFactors() {
		assertThat(generatePrimeFactors(1)).isEmpty();
		assertThat(generatePrimeFactors(2)).containsExactly(2);
		assertThat(generatePrimeFactors(3)).containsExactly(3);
		assertThat(generatePrimeFactors(4)).containsExactly(2, 2);
		assertThat(generatePrimeFactors(5)).containsExactly(5);
		assertThat(generatePrimeFactors(6)).containsExactly(2, 3);
		assertThat(generatePrimeFactors(8)).containsExactly(2, 2, 2);
		assertThat(generatePrimeFactors(9)).containsExactly(3, 3);
	}

	public static List<Integer> generatePrimeFactors(int n) {
		List<Integer> primes = new ArrayList<>();
		for (int candidate = 2; n > 1; candidate++)
			for (; n % candidate == 0; n /= candidate)
				primes.add(candidate);
		return primes;
	}
}
