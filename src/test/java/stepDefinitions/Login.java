package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utils.CommonUtilis;
import factory.driverFactory;

public class Login {

	WebDriver driver;
	private HomePage homepage;
	private LoginPage loginpage;
	private AccountPage accountpage;
	private CommonUtilis commonutilis;

	@Given("user navigates to login page")
	public void user_navigates_to_login_page() {
		
		//if getdriver method is non static then create object for the classs like pageclass
		driver = driverFactory.getDriver();

		homepage = new HomePage(driver);
		homepage.clickOnMyAccount();

		loginpage = homepage.selectLoginOption();

	}

	@When("^user enters valid email address (.*) into email field$")
	public void user_enters_valid_email_address_into_email_field(String validemail) {

		loginpage.enterEmailAddress(validemail);

	}

	@And("^user enters the vaild password (.+) into password field$")
	public void user_enters_the_vaild_password_into_password_field(String validpassword) {

		loginpage.enterPassword(validpassword);

	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() {

		accountpage = loginpage.clickOnLoginBtn();

	}

	@Then("user should get successfully logged in")
	public void user_should_get_successfully_logged_in() {

		Assert.assertTrue(accountpage.verifyEditInfoDisplay());
	}

	@When("user enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		commonutilis = new CommonUtilis();
		loginpage.enterEmailAddress(commonutilis.getEmailwithTimestamp());
	}

	@And("user enters the invalid password {string} into password field")
	public void user_enters_the_invalid_password_into_password_field(String invalidPassword) {
		loginpage.enterPassword(invalidPassword);
	}

	@Then("user should get a warning message about credentials mismatch")
	public void user_should_get_a_warning_message_about_credentials_mismatch() {
		Assert.assertTrue(loginpage.getWarningMsg().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("user donot enter email address into email field")
	public void user_donot_enter_email_address_into_email_field() {

		loginpage.enterEmailAddress(" ");

	}

	@And("user donot enter password into password field")
	public void user_donot_enter_password_into_password_field() {
		loginpage.enterPassword(" ");
	}

}
