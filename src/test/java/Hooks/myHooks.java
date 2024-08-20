package Hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.configReader;
import factory.driverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class myHooks {
	
	WebDriver driver;
	private configReader configreader;
	private driverFactory driverfactory;
	
	@Before
	public void setup() {
		
		configreader = new configReader();
		Properties prop = configreader.initializeProperties();
		//or combine above two lines Properties prop = new configReader().initializeProperties();
		String browser = prop.getProperty("browser");
		System.out.println("------>"+browser);
		driverfactory = new driverFactory();
	    driver = driverfactory.initializeBrowser(prop.getProperty("browser"));
	    //driver = driverFactory.getDriver();
		
		
		driver.get(prop.getProperty("url"));
	}
	
	@After
	public void tearDown(Scenario scenario) {
		String scenarioName = scenario.getName().replaceAll(" ", "_");
		if(scenario.isFailed()) {
		byte[] srcScreenshot = 	((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(srcScreenshot, "image/jpeg", scenarioName);
		}
		driver.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario){

	      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	      scenario.attach(screenshot, "image/png", "image"); 
		
	}

}
