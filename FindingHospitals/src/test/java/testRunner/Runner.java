package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;


@CucumberOptions(
		features = {"src/test/java/features/Schedule.feature"},
		dryRun = !true,
		glue = {"feature","steps"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		plugin = {"pretty","html:CucumberReports.html"},
		publish = true
		)

public class Runner extends AbstractTestNGCucumberTests
{
	
}
