package kata.stringcalculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <strong>Requirements</strong>
 * <ol>
 * <li>Providing an empty string when calculating
 * then the result is 0.</li>
 *
 * <li>Providing a single number when calculating
 * then the result is the number as integer.</li>
 *
 * <li>Providing two comma separated numbers when calculating
 * then the result is the sum of the numbers.</li>
 *
 * <li>Providing an unknown amount of comma separated numbers when calculating
 * then the result is the sum of all numbers.</li>
 *
 * <li>Providing an input string contains a line break instead of comma as delimiter when calculating
 * then the result is the sum of all numbers.</li>
 *
 * <li>Providing a delimiter is optionally defined on the first line like //; when calculating
 * then the result is the sum of all numbers. (e.g. //;\n1;2 should return 3)</li>
 *
 * <li>Providing a negative number when calculating
 * then throws an exception "negatives not allowed" - and the negative(s) that was passed.</li>
 *
 * <li>Providing numbers bigger than 1000 when calculating
 * then such numbers should be ignored in the calculation.</li>
 *
 * <li>Providing delimiters of any length ("//[delimiter]\n") when calculating
 * then the result is the sum of the numbers. (e.g. "//[xx]\n1xx2xx3" should return 6)</li>
 *
 * <li>Providing multiple delimiters ("//[delim1][delim2]\n") when calculating
 * then the result is the sum of the numbers. (e.g. "//[x][y]\n1x2y3" should return 6)</li>
 *
 * <li>Providing multiple delimiters with variable length when calculating
 * then the result is the sum of the numbers.</li>
 * </ol>
 */
public class StringCalculatorTest {

	@Test
	public void givenEmptyString_shouldReturnZero() {
		assertThat(new StringCalculator("").sum()).isEqualTo(0);
	}

	@Test
	public void givenSingleNumberInString_shouldReturnNumberAsInteger() {
		assertThat(new StringCalculator("1").sum()).isEqualTo(1);
	}

	@Test
	public void givenTwoCommaSeparatedNumbersInString_shouldReturnSumOfNumbers() {
		assertThat(new StringCalculator("1,2").sum()).isEqualTo(3);
	}

	@Test
	public void givenThreeCommaSeparatedNUmbersInString_shouldReturnSumOfNumbers() {
		assertThat(new StringCalculator("1,2,3").sum()).isEqualTo(6);
	}

	@Test
	public void givenInputContainsLineBreaksInsteadComma_shouldStillReturnSum() {
		assertThat(new StringCalculator("1\n2,3").sum()).isEqualTo(6);
	}

	@Test
	public void givenCustomDelimiter_shouldReturnSum() {
		assertThat(new StringCalculator("//;\n1;2").sum()).isEqualTo(3);
	}

}
