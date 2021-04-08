package kata.romannumber;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * Requirements
 *
 * For an integer value n the converter should return a string containing the roman number equivalent.
 *
 * Roman numbers:
 *
 * I (1)
 * V (5)
 * X (10)
 * L (50)
 * C (100)
 * D (500)
 * M (1000)
 */
final class RomanNumberConverterTest {

    @Test
    void givenZero_shouldReturn_EmptyString() {
        assertThat(romanNumberOf(0)).isEqualTo("");
    }

    @Test
    void givenOne_shouldReturn_I() {
        assertThat(romanNumberOf(1)).isEqualTo("I");
    }

    @Test
    void givenTwo_shouldReturn_II() {
        assertThat(romanNumberOf(2)).isEqualTo("II");
    }

    @Test
    void givenThree_shouldReturn_III() {
        assertThat(romanNumberOf(3)).isEqualTo("III");
    }

    @Test
    void givenFour_shouldReturn_IV() {
        assertThat(romanNumberOf(4)).isEqualTo("IV");
    }

    @Test
    void givenFive_shouldReturn_V() {
        assertThat(romanNumberOf(5)).isEqualTo("V");
    }

    @Test
    void givenSix_shouldReturn_VI() {
        assertThat(romanNumberOf(6)).isEqualTo("VI");
    }

    @Test
    void givenNine_shouldReturn_IX() {
        assertThat(romanNumberOf(9)).isEqualTo("IX");
    }

    @Test
    void given42_shouldReturn_XLII() {
        assertThat(romanNumberOf(42)).isEqualTo("XLII");
    }

    @Test
    void assertThat1984_shouldReturn_MCMLXXXIV() {
        assertThat(romanNumberOf(1984)).isEqualTo("MCMLXXXIV");
    }

    @Test
    void assertThat3000_shouldReturn_MMM() {
        assertThat(romanNumberOf(3000)).isEqualTo("MMM");
    }

    private String romanNumberOf(int number) {
        return RomanNumberConverter.convert(number);
    }
}
