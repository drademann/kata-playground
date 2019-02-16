package kata.primefactor;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("WeakerAccess")
public class PrimeFactorsPropertyTest {

    @Property
    public void multiplyFactors_shouldReturnInputNumber(@ForAll @IntRange(min = 1, max = 65536) int number) {
        List<Integer> factors = PrimeFactors.of(number);

        if (number == 1) {
            assertThat(factors).isEmpty();
        } else {
            int product = factors.stream().reduce((accu, factor) -> accu * factor).orElseThrow(AssertionError::new);
            assertThat(product).isEqualTo(number);
        }
    }
}
