package kata.primefactors;

import org.junit.Test;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class PrimeFactorsTest {

	@Test
	public void testOne() {
		List<Integer> primeFactors = PrimeFactors.generate(1);

		assertThat(primeFactors).isEmpty();
	}
}
