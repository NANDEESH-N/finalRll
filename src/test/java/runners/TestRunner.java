package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = "steps", dryRun = false, plugin = {
		"html:target/Firstcry_Findstore_report.html", "pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"timeline:test-output-thread/" }, tags = "@FirstCry"

)

public class TestRunner extends AbstractTestNGCucumberTests {	
	
}
