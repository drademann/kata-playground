package kata;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

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
	public void emptyString_shouldReturnsZero() {
		assertThat(calculatedSum("")).isEqualTo(0);
	}

	@Test
	public void oneNumber_shouldReturnNumberAsInteger() {
		assertThat(calculatedSum("1")).isEqualTo(1);
	}

	@Test
	public void twoCommaSeparatedNumbers_shouldReturnSumAsInteger() {
		assertThat(calculatedSum("1,2")).isEqualTo(3);
	}

	@Test
	public void multipleCommaSeparatedNumbers_shouldReturnSumAsInteger() {
		assertThat(calculatedSum("1,2,5,20")).isEqualTo(28);
	}

	@Test
	public void lineBreakAsDelimiter_shouldBeAcceptedLikeComma() {
		assertThat(calculatedSum("1\n2,3")).isEqualTo(6);
	}

	@Test
	public void selfDefinedDelimiter_shouldBeAcceptedLikeComma() {
		assertThat(calculatedSum("//;\n1;2\n3")).isEqualTo(6);
	}

	@Test(expected = NegativeNumbersException.class)
	public void givenNegativNumbers_shouldThrowException() {
		calculatedSum("-1,2,-3");
	}

	@Test
	public void givenNegativeNumbers_shouldThrowExceptionContainingNegativeIntegers() {
		try {
			calculatedSum("-1,2, -3");
			fail("should throw exception");
		} catch (NegativeNumbersException nne) {
			assertThat(nne.getNegativeNumbers()).contains(-1, -3);
		}
	}

	private int calculatedSum(String s) {
		return new StringCalculator(s).sum();
	}

	public static class StringCalculator {

		private final String input;

		private String delimiter;
		private Collection<Integer> integers;

		public StringCalculator(String input) {
			this.input = input;
		}

		public int sum() {
			if (isParsable()) {
				delimiter = lookupDelimiter();
				integers = collectIntegers();
				if (containsOnlyPositive())
					return sumIntegers();
			}
			return 0;
		}

		private boolean isParsable() {
			return !input.isEmpty();
		}

		private String lookupDelimiter() {
			String userDefinedDelimiter = "";
			if (input.startsWith("//")) {
				userDefinedDelimiter = input.substring(2, 3);
			}
			return "[,\n" + userDefinedDelimiter + "]";
		}

		private Collection<Integer> collectIntegers() {
			return splittedInput().stream()
					.map(String::trim)
					.filter(this::isNumber)
					.mapToInt(Integer::parseInt)
					.boxed()
					.collect(toList());
		}

		private boolean containsOnlyPositive() {
			List<Integer> negatives = integers.stream().filter(i -> i < 0).collect(toList());
			if (!negatives.isEmpty()) {
				throw new NegativeNumbersException(negatives);
			}
			return true;
		}

		private int sumIntegers() {
			return integers.stream().mapToInt(Integer::intValue).sum();
		}

		private Collection<String> splittedInput() {
			return asList(input.split(delimiter));
		}

		private boolean isNumber(String s) {
			return s != null && !s.isEmpty() && !s.startsWith("//");
		}
	}

	private static final class NegativeNumbersException extends RuntimeException {
		private static final long serialVersionUID = -1L;

		private final List<Integer> negativeNumbers;

		private NegativeNumbersException(List<Integer> negativeNumbers) {
			this.negativeNumbers = new ArrayList<>(negativeNumbers);
		}

		public List<Integer> getNegativeNumbers() {
			return unmodifiableList(negativeNumbers);
		}
	}
}
