package kata.stringcalc;

import cucumber.api.java.en.*;
import kata.stringcalc.support.*;

import static org.fest.assertions.api.Assertions.*;

public class StringCalculatorSteps {

	KnowsStringInputDomain stringInputDomain;
	KnowsStringCalculatorDomain stringCalculatorDomain;

	public StringCalculatorSteps(KnowsStringInputDomain stringInputDomain, KnowsStringCalculatorDomain stringCalculatorDomain) {
		this.stringInputDomain = stringInputDomain;
		this.stringCalculatorDomain = stringCalculatorDomain;
	}

	@When("^calculating the sum$")
	public void whenCalculatingSum() throws Throwable {
		stringCalculatorDomain.setResult(new StringCalculator().calc(stringInputDomain.getInput()));
	}

	@Then("^the result should be (\\d+)$")
	public void the_result_should_be(int expectedResult) throws Throwable {
		assertThat(stringCalculatorDomain.getResult()).isEqualTo(expectedResult);
	}
}
