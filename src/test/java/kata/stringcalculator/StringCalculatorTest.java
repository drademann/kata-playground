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
 * ** Use the following advanced requirements if you finish the previous steps
 *    in less than 30 minutes.
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

	private int sumOf(String input) {
		return StringCalculator.sum(input);
	}

	@Test
	public void givenEmptyString_shouldReturnZero() {
		assertThat(sumOf("")).isEqualTo(0);
	}

	@Test
	public void givenSingleNumberString_shouldReturnNumber() {
		assertThat(sumOf("1")).isEqualTo(1);
		assertThat(sumOf("2")).isEqualTo(2);
	}

	@Test
	public void givenCommaSeparatedNumbers_shouldReturnSumOfNumbers() {
		assertThat(sumOf("1,2")).isEqualTo(3);
		assertThat(sumOf("1,2,3")).isEqualTo(6);
	}

	@Test
	public void givenLineBreakInString_shouldReturnSumOfNumbers() {
		assertThat(sumOf("1\n2,3")).isEqualTo(6);
	}

	@Test
	public void givenCustomDelimiter_shouldUseDelimiterToReturnSumOfNumbers() {
		assertThat(sumOf("//;\n1;2;3")).isEqualTo(6);
	}

	@Test(expected = IllegalArgumentException.class)
	public void givenNegativeNumbers_shouldThrowIllegalArgumentException() {
		sumOf("-1");
	}

	@Test
	public void givenNumberGreaterThan1000_shouldIgnoreThoseNumber() {
		assertThat(sumOf("1,20,300,4000")).isEqualTo(321);
	}
}
