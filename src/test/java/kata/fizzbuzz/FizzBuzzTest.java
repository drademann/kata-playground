package kata.fizzbuzz;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    @Test
    public void given_1_2_shouldReturn_1_2() {
        var mapped = FizzBuzz.map(1, 2);

        assertThat(mapped).containsExactly("1", "2");
    }
}
