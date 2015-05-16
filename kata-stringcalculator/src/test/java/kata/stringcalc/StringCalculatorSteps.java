package kata.stringcalc;

import cucumber.api.java.en.*;
import kata.stringcalc.support.*;

import static org.fest.assertions.api.Assertions.*;

public class StringCalculatorSteps {

	KnowsStringCalculatorDomain stringCalculatorDomain;

	public StringCalculatorSteps(KnowsStringCalculatorDomain stringCalculatorDomain) {
		this.stringCalculatorDomain = stringCalculatorDomain;
	}

	@Given("^the input string is empty$")
	public void givenInputStringIsEmpty() throws Throwable {
		stringCalculatorDomain.setInput("");
	}

	@When("^calculating the sum$")
	public void whenCalculatingSum() throws Throwable {
		stringCalculatorDomain.setResult(new StringCalculator().calc(stringCalculatorDomain.getInput()));
	}

	@Then("^the result should be (\\d+)$")
	public void the_result_should_be(int expectedResult) throws Throwable {
		assertThat(stringCalculatorDomain.getResult()).isEqualTo(expectedResult);
	}
}
