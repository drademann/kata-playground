package kata.primefactors;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import kata.primefactors.support.KnowsIntegerDomain;
import kata.primefactors.support.KnowsPrimeFactorsDomain;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

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

	@Then("^the generator should return no prime factors$")
	public void thenResultingPrimeFactorsShouldBeEmpty() throws Throwable {
		assertThat(primeFactorsDomain.getPrimeFactors()).isEmpty();
	}

	@Then("^the resulting prime factors should be ([0-9,]*)$")
	public void thenResultingPrimeFactorsShouldBe(List<Integer> expectedPrimeFactors) {
		List<Integer> primeFactors = primeFactorsDomain.getPrimeFactors();
		assertThat(primeFactors).isEqualTo(expectedPrimeFactors);
	}
}
