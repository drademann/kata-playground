package kata.primefactor;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * Requirements
 *
 * For an integer value n the generator should return all prime factors as an ordered list.
 */
public class PrimeFactorsTest {

    @Test
    public void generate_shouldReturnPrimeFactors() {
        assertThat(PrimeFactors.of(1)).isEmpty();
        assertThat(PrimeFactors.of(2)).containsExactly(2);
        assertThat(PrimeFactors.of(3)).containsExactly(3);
        assertThat(PrimeFactors.of(4)).containsExactly(2, 2);
        assertThat(PrimeFactors.of(5)).containsExactly(5);
        assertThat(PrimeFactors.of(6)).containsExactly(2, 3);
        assertThat(PrimeFactors.of(8)).containsExactly(2, 2, 2);
        assertThat(PrimeFactors.of(9)).containsExactly(3, 3);
    }
}
