package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import util.Hooks;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resource",
		glue = {"stepDefinitions","Hooks"},
		//publish = true,
		tags="not @de",
		plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

		//monochrome=true
		
		)

public class extendRunner {

}
