package kata.stringcalc;

import cucumber.api.java.en.*;

import static org.fest.assertions.api.Assertions.*;

public class StringCalculatorStepDef {

	private String input;

	private int result;

	@Given("^the input string is empty$")
	public void the_input_string_is_empty() throws Throwable {
		input = "";
	}

	@When("^calculating the sum$")
	public void calculating_the_sum() throws Throwable {
		result = new StringCalculator().calc(input);
	}

	@Then("^the result should be (\\d+)$")
	public void the_result_should_be(int expectedResult) throws Throwable {
		assertThat(result).isEqualTo(expectedResult);
	}
}
