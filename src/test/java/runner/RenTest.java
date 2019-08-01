package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(
		features = "src/test/java/features/Login.feature",
		glue = "stepImpl",
		monochrome = true,
		tags = "@smoke"
		/*,dryRun = true
		,snippets = SnippetType.CAMELCASE
*/		)
		

@RunWith(Cucumber.class)
public class RenTest {

}
