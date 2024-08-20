package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Pages.DemoHomePage;
import Pages.DemoPage;
import factory.driverFactory;
import io.cucumber.java.en.*;

public class Demo {
	WebDriver driver;
	private DemoPage demopage;
	private DemoHomePage demohomepage;
	
	@Given("User navigates to sig-in page")
	public void user_navigates_to_sig_in_page() {
	     driver = driverFactory.getDriver();
	     
	     demopage = new DemoPage(driver);
	     demopage.clickOnSignin();
	     
		
	}

	@When("^User enters username (.+) into the field$")
	public void user_enters_username_into_the_field(String username) {
		
		demopage.enterUserName(username);
	    
	}

	@And("^User enters password (.+) into the field$")
	public void user_enters_password_into_the_field(String password) {
		demopage.enterPassword(password);
	}

	@And("Clicks on Login")
	public void clicks_on_login() {
		demohomepage = demopage.clickOnLoginBtn();
	}

	@Then("User landed on home page with welcome message")
	public void user_landed_on_home_page_with_welcome_message() {
	    Assert.assertTrue(demohomepage.getWelcomeMsg());
	}

	@Then("User get a warning message about credentials mismatch")
	public void user_get_a_warning_message_about_credentials_mismatch() {
	  Assert.assertEquals("Invalid username or password. Signon failed.",demopage.getWarningMsg());
	}

}
