package kata.stringcalc;

import org.junit.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class StringCalculatorTest {

	@Test
	public void givenEmptyStringReturnsZero() {
		int result = new StringCalculator().calc("");

		assertThat(result, equalTo(0));
	}
}
