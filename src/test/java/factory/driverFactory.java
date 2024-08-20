package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utils.CommonUtilis;

public class driverFactory {
	
	 static WebDriver driver =null;
	
	public WebDriver initializeBrowser(String browserName) {
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")){
			driver =  new FirefoxDriver();
		}else if(browserName.equals("edge")){
			driver =  new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtilis.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtilis.IMPLICT_WAIT_TIME));
		return driver;
	}
	
	
	public static WebDriver getDriver() {
		return driver;
	}

}
