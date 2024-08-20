package Utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForElement(element,durationInSeconds);
		webElement.click();
	}
	
	public void sendTextIntoElements(WebElement element, String typeText, long durationInSeconds) {
		WebElement webElement = waitForElement(element,durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(typeText);
	}
	
	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		WebElement webElement = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void selectOptionInDropDown(WebElement element, String drpDwnOption, long durationInSeconds) {
		WebElement webElement = waitForElement(element,durationInSeconds);
		Select drpdwn = new Select(webElement);
		drpdwn.selectByVisibleText(drpDwnOption);
	}
	
	public void acceptAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();
	}
	
	public void dismissAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
	}
	
	public Alert waitForAlert(long durationInSeconds) {
		Alert webElement = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		webElement = wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
	}
	
	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
		WebElement webElement =null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
	    webElement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void jsClick(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].click();",webElement);
	}
	
	public void jsTypeText(WebElement element, String typeText, long durationInSeconds) {
		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].value='"+typeText+"'",webElement);
	}
	
	public String retriveText(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForElement(element,durationInSeconds);
		String retrivedText = webElement.getText();
		return retrivedText;
	}
	
	public boolean displayStatusOfElement(WebElement element, long durationInSeconds) {
		
		try {
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		return webElement.isDisplayed();
		}catch(Throwable e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
