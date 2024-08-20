package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonUtilis;
import Utils.ElementUtils;

public class AccountPage {

	WebDriver driver;
	private ElementUtils elementutils;
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
	}
	
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInfo;
	
	public boolean verifyEditInfoDisplay() {
		return elementutils.displayStatusOfElement(editYourAccountInfo, CommonUtilis.EXPLICIT_WAIT_TIME);
		//return editYourAccountInfo.isDisplayed();
	}
}
