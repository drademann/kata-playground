package kata.primefactors;

import cucumber.api.java.en.*;
import kata.primefactors.support.*;

public class IntegerSteps {

	KnowsIntegerDomain integerDomain;

	public IntegerSteps(KnowsIntegerDomain integerDomain) {
		this.integerDomain = integerDomain;
	}

	@Given("^I have an integer value of (\\d+)$")
	public void givenIntegerValue(int n) {
		integerDomain.setValue(n);
	}
}
