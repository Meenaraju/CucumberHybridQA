package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonUtilis;
import Utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementutils;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
	}
	
	@FindBy(id="input-email")
	private WebElement emailAddress;
	
	@FindBy(id="input-password")
	private WebElement Password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	public void enterEmailAddress(String email) {
		elementutils.sendTextIntoElements(emailAddress, email, CommonUtilis.EXPLICIT_WAIT_TIME);
		//emailAddress.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		elementutils.sendTextIntoElements(Password, password, CommonUtilis.EXPLICIT_WAIT_TIME);
		//Password.sendKeys(password);
	}
	
	public AccountPage clickOnLoginBtn() {
		elementutils.clickOnElement(loginBtn, CommonUtilis.EXPLICIT_WAIT_TIME);
		//loginBtn.click();
		return new AccountPage(driver);
	}
	
	public String getWarningMsg() {
		return elementutils.retriveText(warningMessage, CommonUtilis.EXPLICIT_WAIT_TIME);
		//return warningMessage.getText();
	}
	

}
