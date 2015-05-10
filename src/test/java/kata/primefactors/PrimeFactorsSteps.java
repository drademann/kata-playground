package kata.primefactors;

import cucumber.api.java.en.*;
import kata.primefactors.support.*;

import java.util.*;

import static org.fest.assertions.api.Assertions.*;

public class PrimeFactorsSteps {

	KnowsPrimeFactorsDomain primeFactorsDomain;
	KnowsIntegerDomain integerDomain;

	public PrimeFactorsSteps(KnowsPrimeFactorsDomain primeFactorsDomain, KnowsIntegerDomain integerDomain) {
		this.primeFactorsDomain = primeFactorsDomain;
		this.integerDomain = integerDomain;
	}

	@When("^generating the prime factors of the integer value$")
	public void whenGeneratingPrimeFactors() {
		int inputIntegerValue = integerDomain.getValue();
		List<Integer> primeFactors = PrimeFactors.generate(inputIntegerValue);
		primeFactorsDomain.setPrimeFactors(primeFactors);
	}

	@Then("^the resulting prime factors should be ([0-9,]*)$")
	public void thenResultingPrimeFactorsShouldBe(List<Integer> expectedPrimeFactors) {
		List<Integer> primeFactors = primeFactorsDomain.getPrimeFactors();
		assertThat(primeFactors).isEqualTo(expectedPrimeFactors);
	}
}
