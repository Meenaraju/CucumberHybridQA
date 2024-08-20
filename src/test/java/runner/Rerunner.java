package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="@target/Failedrerun.txt",
		glue = {"stepDefinitions","Hooks"},
		publish = true,
		plugin = {"pretty","html:target/CucumberReports/rerunReport.html"}
		)

public class Rerunner {

}
