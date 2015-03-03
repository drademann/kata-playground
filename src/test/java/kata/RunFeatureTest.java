package kata;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/resources/kata/stringcalc/",
		glue = "kata.stringcalc")
public class RunFeatureTest extends AbstractTestNGCucumberTests {
}
