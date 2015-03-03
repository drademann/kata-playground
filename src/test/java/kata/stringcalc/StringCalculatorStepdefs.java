package kata.stringcalc;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StringCalculatorStepdefs {

	// SUT
	private StringCalculator stringCalculator;

	private int result;

	@Given("^a string calculator$")
	public void a_string_calculator() throws Throwable {
		stringCalculator = new StringCalculator();
	}

	@When("^getting an empty string$")
	public void getting_an_empty_string() throws Throwable {
		result = stringCalculator.calc("");
	}

	@Then("^it should return (\\d+)$")
	public void should_return(int expectedResult) throws Throwable {
		assert expectedResult == result : "expected result is " + expectedResult + " but was " + result;
	}
}
