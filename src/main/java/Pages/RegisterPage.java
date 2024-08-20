package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonUtilis;
import Utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementutils;
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confrimPasswordField;
	
	@FindBy(name = "agree")
	private WebElement privacyPolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement newsLetterField;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningDuplicateEmailMsg;

	public void enterFirstName(String firstname) {
		
		elementutils.sendTextIntoElements(firstNameField, firstname, CommonUtilis.EXPLICIT_WAIT_TIME);
		//firstNameField.sendKeys(firstname);

	}

	public void enterLastName(String lastname) {
		elementutils.sendTextIntoElements(lastNameField, lastname, CommonUtilis.EXPLICIT_WAIT_TIME);
		//lastNameField.sendKeys(lastname);
	}

	public void enterEmail(String email) {
		elementutils.sendTextIntoElements(emailField, email, CommonUtilis.EXPLICIT_WAIT_TIME);
		//emailField.sendKeys(email);
	}

	public void enterTelephone(String telephone) {
		elementutils.sendTextIntoElements(telephoneField, telephone, CommonUtilis.EXPLICIT_WAIT_TIME);
		//telephoneField.sendKeys(telephone);
	}

	public void enterPassword(String password) {
		elementutils.sendTextIntoElements(passwordField, password, CommonUtilis.EXPLICIT_WAIT_TIME);
		//passwordField.sendKeys(password);
	}

	public void enterConfrimPassword(String password) {
		elementutils.sendTextIntoElements(confrimPasswordField, password, CommonUtilis.EXPLICIT_WAIT_TIME);
		//confrimPasswordField.sendKeys(password);
	}
	
	public void acceptPrivacyPolicy() {
		elementutils.clickOnElement(privacyPolicy, CommonUtilis.EXPLICIT_WAIT_TIME);
	//	privacyPolicy.click();
	}
	
	public AccountSuccessPage clickContinueBtn() {
		elementutils.clickOnElement(continueBtn, CommonUtilis.EXPLICIT_WAIT_TIME);
		//continueBtn.click();
		return new AccountSuccessPage(driver);
	}
	
	public void acceptNewsLetter() {
		elementutils.clickOnElement(newsLetterField, CommonUtilis.EXPLICIT_WAIT_TIME);
		//newsLetterField.click();
	}
	
	public String getWarningDuplicateEmailMsg() {
		return elementutils.retriveText(warningDuplicateEmailMsg, CommonUtilis.EXPLICIT_WAIT_TIME);
		//return warningDuplicateEmailMsg.getText();
	}


}
