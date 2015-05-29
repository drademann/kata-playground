package kata.stringcalc;

import cucumber.api.java.en.Given;
import kata.stringcalc.support.KnowsStringInputDomain;

public class StringInputSteps {

	KnowsStringInputDomain stringInputDomain;

	public StringInputSteps(KnowsStringInputDomain stringInputDomain) {
		this.stringInputDomain = stringInputDomain;
	}

	@Given("^the input string is empty$")
	public void givenInputStringIsEmpty() throws Throwable {
		stringInputDomain.setInput("");
	}

	@Given("^the input string is \"(.*)\"")
	public void givenInputString(String input) {
		stringInputDomain.setInput(input);
	}
}
