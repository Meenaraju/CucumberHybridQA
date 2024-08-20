package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonUtilis;
import Utils.ElementUtils;

public class SearchPage {
	
	WebDriver driver;
	private ElementUtils elementutils;
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
	}
	
	
	
	
	@FindBy(linkText="HP LP3065")
	private WebElement validSearchResult;
	
	@FindBy(xpath="//input[contains(@id,'button-search')]//following-sibling::p")
	private WebElement invalidSearchResult;
	
	
	
	public boolean getValidSearchResult() {
		return elementutils.displayStatusOfElement(validSearchResult, CommonUtilis.EXPLICIT_WAIT_TIME);
		//return validSearchResult.isDisplayed();
	}
	
	public String getInvalidSearchResult() {
		return elementutils.retriveText(invalidSearchResult, CommonUtilis.EXPLICIT_WAIT_TIME);
		//return invalidSearchResult.getText();
	}


}
