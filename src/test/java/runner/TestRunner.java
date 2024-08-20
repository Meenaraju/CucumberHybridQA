package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resource",
		glue = {"stepDefinitions","Hooks"},
		publish = true,
		plugin = {"pretty","html:target/CucumberReports/Report.html","rerun:target/Failedrerun.txt"},
		tags="not @de"
		
		)

public class TestRunner {

}
