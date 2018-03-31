package kata.primefactor;

import java.util.ArrayList;
import java.util.List;

class PrimeFactors {

    static List<Integer> of(int number) {
        int n = number;
        List<Integer> primes = new ArrayList<>();
        for (int candidate = 2; n > 1; candidate++)
            for (; (n % candidate) == 0; n /= candidate)
                primes.add(candidate);
        return primes;
    }
}
