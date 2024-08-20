package stepDefinitions;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Pages.AccountSuccessPage;
import Pages.HomePage;
import Pages.RegisterPage;
import Utils.CommonUtilis;
import factory.driverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;



public class Register {
	
	WebDriver driver;
	private HomePage homepage;
	private RegisterPage registerpage;
	private AccountSuccessPage accountsuccesspage;
	private CommonUtilis commonutilis;
	
	@Given("user navigates to register account page")
	public void user_navigates_to_register_account_page() {
		driver = driverFactory.getDriver();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		registerpage = homepage.selectRegisterOption();
	}

	@When("user enters the details below into the fields")
	public void user_enters_the_details_below_into_the_fields(DataTable dataTable) {
		commonutilis = new CommonUtilis();
		Map<String, String> map = dataTable.asMap(String.class,String.class);
		registerpage.enterFirstName(map.get("firstname"));
		registerpage.enterLastName(map.get("lastname"));
		registerpage.enterEmail(commonutilis.getEmailwithTimestamp());
		registerpage.enterTelephone(map.get("telephone"));
		registerpage.enterPassword(map.get("password"));
		registerpage.enterConfrimPassword(map.get("password"));
	    
	}
	
	@When("user enters the duplicate details into the fields")
	public void user_enters_the_duplicate_details_into_the_fields(DataTable dataTable) {
		
		Map<String, String> map = dataTable.asMap(String.class,String.class);
		
		registerpage.enterFirstName(map.get("firstname"));
		registerpage.enterLastName(map.get("lastname"));
		registerpage.enterEmail(map.get("email"));
		registerpage.enterTelephone(map.get("telephone"));
		registerpage.enterPassword(map.get("password"));
		registerpage.enterConfrimPassword(map.get("password"));
	}

	@And("user selects privacy policy")
	public void user_selects_privacy_policy() {
		registerpage.acceptPrivacyPolicy();
		
	}

	@And("user clicks on continue button")
	public void user_clicks_on_continue_button() {
		accountsuccesspage = registerpage.clickContinueBtn();
		
	}

	@Then("user account should get created successfully")
	public void user_account_should_get_created_successfully() {
		
	   Assert.assertEquals("Your Account Has Been Created!", accountsuccesspage.getAccountCreatedMsg());
	}

	@And("user selects Yes for newsletter")
	public void user_selects_yes_for_newsletter() {
	//	registerpage = new RegisterPage(driver);
		registerpage.acceptNewsLetter();
	  
	}

	@Then("user should get proper warning about duplicate email")
	public void user_should_get_proper_warning_about_duplicate_email() {
		 Assert.assertEquals("Warning: E-Mail Address is already registered!", registerpage.getWarningDuplicateEmailMsg());
	  
	}

	@When("user dont enter any details into the fields")
	public void user_dont_enter_any_details_into_the_fields() {
		//registerpage = new RegisterPage(driver);
	   //Intentionnalyy igniore
	}

	@Then("user should get proper warning for every mandatory fields")
	public void user_should_get_proper_warning_for_every_mandatory_fields() {
		System.out.print("------------------------> "+registerpage.getWarningDuplicateEmailMsg());
		Assert.assertEquals("Warning: You must agree to the Privacy Policy!", registerpage.getWarningDuplicateEmailMsg());
		  
	}




}
