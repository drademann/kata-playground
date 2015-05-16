package kata.primefactors;

import org.junit.*;

import java.util.*;

import static org.fest.assertions.api.Assertions.*;

public class PrimeFactorsTest {

	@Test
	public void testOne() {
		List<Integer> primeFactors = PrimeFactors.generate(1);

		assertThat(primeFactors).isEmpty();
	}
}
