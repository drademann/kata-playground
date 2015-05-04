package kata.stringcalc;

import org.junit.*;

import static org.fest.assertions.api.Assertions.*;

public class StringCalculatorTest {

	@Test
	public void givenEmptyStringReturnsZero() {
		int result = new StringCalculator().calc("");

		assertThat(result).isEqualTo(0);
	}
}
