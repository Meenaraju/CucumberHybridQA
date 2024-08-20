package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonUtilis;
import Utils.ElementUtils;

public class DemoPage {
	
	WebDriver driver;
	private ElementUtils elementutils;
	public DemoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
	}
	
	@FindBy(linkText="Sign In")
	private WebElement sigInField;
	
	@FindBy(name="username")
	private WebElement userNameField;
	
	@FindBy(name="password")
	private WebElement passwordField;
	
	@FindBy(name="signon")
	private WebElement logInBtn;
	
	@FindBy(xpath="//ul[@class='messages']/li")
	private WebElement warningMsg;
	
	public void clickOnSignin() {
		elementutils.clickOnElement(sigInField, CommonUtilis.EXPLICIT_WAIT_TIME);
		//sigInField.click();
	}

	public void enterUserName(String username) {
		//userNameField.sendKeys(username);
		elementutils.sendTextIntoElements(userNameField, username, CommonUtilis.EXPLICIT_WAIT_TIME);
	}
	
	public void enterPassword(String password) {
		//passwordField.clear();
		//passwordField.sendKeys(password);
		elementutils.sendTextIntoElements(passwordField, password, CommonUtilis.EXPLICIT_WAIT_TIME);
	}
	
	public DemoHomePage clickOnLoginBtn() {
		elementutils.clickOnElement(logInBtn, CommonUtilis.EXPLICIT_WAIT_TIME);
		//logInBtn.click();
		return new DemoHomePage(driver);
	}
	
	public String getWarningMsg() {
		//System.out.print("----->"+warningMsg.getText());
		//return warningMsg.getText();
		
		System.out.print("----->"+elementutils.retriveText(warningMsg, CommonUtilis.EXPLICIT_WAIT_TIME));
		return elementutils.retriveText(warningMsg, CommonUtilis.EXPLICIT_WAIT_TIME);
	}
}
