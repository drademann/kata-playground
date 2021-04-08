package kata.fizzbuzz;

import org.junit.jupiter.api.Test;

import static kata.fizzbuzz.FizzBuzz.map;
import static org.assertj.core.api.Assertions.assertThat;

/*
 * Requirements
 *
 * Given a list of numbers it
 *
 * should return "Fizz" if a number is divisible by 3
 * should return "Buzz" if a number is divisible by 5
 * the number in all other cases.
 */
final class FizzBuzzTest {

    @Test
    void given_1_2_shouldReturn_1_2() {
        var mapped = map(1, 2);

        assertThat(mapped).containsExactly("1", "2");
    }

    @Test
    void given_3_shouldReturn_Fizz() {
        var mapped = map(3);

        assertThat(mapped).containsExactly("Fizz");
    }

    @Test
    void given_5_shouldReturn_Buzz() {
        var mapped = map(5);

        assertThat(mapped).containsExactly("Buzz");
    }

    @Test
    void given_ListOfNumbers_shouldMapAccordingly() {
        var mapped = map(1, 2, 3, 4, 5, 6);

        assertThat(mapped).containsExactly("1", "2", "Fizz", "4", "Buzz", "Fizz");
    }
}
