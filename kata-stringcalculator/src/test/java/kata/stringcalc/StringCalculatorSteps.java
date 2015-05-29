package kata.stringcalc;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import kata.stringcalc.support.KnowsStringCalculatorDomain;
import kata.stringcalc.support.KnowsStringInputDomain;

import static org.fest.assertions.api.Assertions.assertThat;

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
