package kata.stringcalc;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class StringCalculatorTest {

	@Test
	public void givenEmptyStringReturnsZero() {
		int result = new StringCalculator().calc("");

		assertThat(result).isEqualTo(0);
	}
}
