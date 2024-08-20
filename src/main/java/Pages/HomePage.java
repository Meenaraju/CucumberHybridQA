package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonUtilis;
import Utils.ElementUtils;

public class HomePage {
	WebDriver driver;

	private ElementUtils elementutils;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);//HomePage.driver or this
		elementutils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//a[@title ='My Account']")
	private WebElement myAccountDropmenu;
	
	@FindBy(linkText="Login")
	private WebElement LoginOption;
	
	@FindBy(linkText="Register")
	private WebElement RegisterOption;
	
	@FindBy(name="search")
	private WebElement searchBox;
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchBtn;
	
	public void clickOnMyAccount() {
		
		//myAccountDropmenu.click();
		elementutils.clickOnElement(myAccountDropmenu, CommonUtilis.EXPLICIT_WAIT_TIME);
	}
	
	public LoginPage selectLoginOption() {
		//LoginOption.click();
		elementutils.clickOnElement(LoginOption, CommonUtilis.EXPLICIT_WAIT_TIME);
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		elementutils.clickOnElement(RegisterOption, CommonUtilis.EXPLICIT_WAIT_TIME);
		//RegisterOption.click();
		return new RegisterPage(driver);
	}
	
	public void enterSearchText(String searchtext) {
		elementutils.sendTextIntoElements(searchBox, searchtext, CommonUtilis.EXPLICIT_WAIT_TIME);
		//searchBox.sendKeys(searchtext);	
	}
		
		public SearchPage clickSearchBtn() {
			elementutils.clickOnElement(searchBtn, CommonUtilis.EXPLICIT_WAIT_TIME);
		//	searchBtn.click();
			return new SearchPage(driver);
		}
}
