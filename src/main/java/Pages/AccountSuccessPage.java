package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonUtilis;
import Utils.ElementUtils;

public class AccountSuccessPage {

	WebDriver driver;
	private ElementUtils elementutils;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//div[@id='content']//following::h1")
	private WebElement accountCreatedMsg;
	
	public String getAccountCreatedMsg() {
		return elementutils.retriveText(accountCreatedMsg, CommonUtilis.EXPLICIT_WAIT_TIME);
		//return accountCreatedMsg.getText();
	}
	
}
