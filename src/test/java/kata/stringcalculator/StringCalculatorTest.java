package kata.stringcalculator;

import org.junit.jupiter.api.Test;

import static kata.stringcalculator.StringCalculator.sumOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
 * Requirements
 *
 * Providing an empty string when calculating
 * then the result is 0.
 *
 * Providing a single number when calculating
 * then the result is the number as integer.
 *
 * Providing two comma separated numbers when calculating
 * then the result is the sum of the numbers.
 *
 * Providing an unknown amount of comma separated numbers when calculating
 * then the result is the sum of all numbers.
 *
 * Providing an input string contains a line break instead of comma as delimiter when calculating
 * then the result is the sum of all numbers.
 *
 * Providing a delimiter is defined on the first line like //; when calculating
 * then the result is the sum of all numbers. (e.g. //;\n1;2 should return 3)
 *
 * Providing a negative number when calculating
 * then throws an exception "negatives not allowed" - and the negative(s) that was passed.
 *
 * Providing numbers bigger than 1000 when calculating
 * then such numbers should be ignored in the calculation.
 *
 *
 * Use the following advanced requirements if you finish the previous steps
 * in less than 30 minutes.
 *
 * Providing delimiters of any length ("//[delimiter]\n") when calculating
 * then the result is the sum of the numbers. (e.g. "//[xx]\n1xx2xx3" should return 6)
 *
 * Providing multiple delimiters ("//[delim1][delim2]\n") when calculating
 * then the result is the sum of the numbers. (e.g. "//[x][y]\n1x2y3" should return 6)
 *
 * Providing multiple delimiters with variable length when calculating
 * then the result is the sum of the numbers.
 */
final class StringCalculatorTest {

    @Test
    void givenEmptyString_shouldReturnZero() {
        assertThat(sumOf("")).isEqualTo(0);
    }

    @Test
    void givenOneNumberInString_shouldReturnNumberAsSum() {
        assertThat(sumOf("1")).isEqualTo(1);
        assertThat(sumOf("42")).isEqualTo(42);
    }

    @Test
    void givenTwoNumbers_shouldReturnSumOfNumbers() {
        assertThat(sumOf("1,2")).isEqualTo(3);
    }

    @Test
    void givenMultipleNumbers_shouldReturnSumOfNumbers() {
        assertThat(sumOf("1,2,3,200")).isEqualTo(206);
    }

    @Test
    void givenStringContainsLineBreaks_shouldTreatThemAsDelmiter() {
        assertThat(sumOf("1\n2,3")).isEqualTo(6);
    }

    @Test
    void givenCustomDelimiter_shouldUseNewDelmiterInstead() {
        assertThat(sumOf("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void givenNegativeNumber_shouldRaiseException() {
        assertThatThrownBy(() -> sumOf("-1")).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenNumbersGreaterThan1000_shouldIgnoreThoseNumbers() {
        assertThat(sumOf("1,1001,2,50000,3,1000")).isEqualTo(1006);
    }
}
