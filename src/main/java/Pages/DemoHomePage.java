package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonUtilis;
import Utils.ElementUtils;

public class DemoHomePage {
	WebDriver driver;
	private ElementUtils elementutils;
	
	public DemoHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
	}
	
	@FindBy(id="Welcome")
	private WebElement welcomeMsg;
	
	public boolean getWelcomeMsg() {
		//System.out.print("----->"+welcomeMsg.getText());
		//return welcomeMsg.isDisplayed();
		System.out.print("----->"+elementutils.retriveText(welcomeMsg, CommonUtilis.EXPLICIT_WAIT_TIME));
		return elementutils.displayStatusOfElement(welcomeMsg, CommonUtilis.EXPLICIT_WAIT_TIME);
	}

}
