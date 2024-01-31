package stepdefinations;


import java.util.Map;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {

	WebDriver driver;
	RegisterPage registerpage;
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		
	   driver= DriverFactory.getDriver();
	   HomePage hp= new HomePage(driver);
	   hp.clickMyAccountMenu();
	   hp.clickOnRegisterDropdown();   
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		
		registerpage= new RegisterPage(driver);
		
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		registerpage.setFirstName(dataMap.get("FirstName"));
		registerpage.setLastName(dataMap.get("LastName"));
		registerpage.setEmailId(CommonUtils.getEmailWithTimeStamp());
		registerpage.setTelephoneNumber(dataMap.get("Telephone"));
		registerpage.setPassword(dataMap.get("Password"));
		registerpage.setCnfPassword(dataMap.get("ConfirmPassowrd"));    
	}
	

	@When("User select yes for Newsletter")
	public void user_select_yes_for_newsletter() {
		
		registerpage.clickNewslLetter();
	}

	@When("User Click on Privacy Policy checkbox")
	public void user_click_on_privacy_policy_checkbox() {
		registerpage.clickOnPrivacyPolicyCheckBox();
	}

	@When("User Click on continue")
	public void user_click_on_continue() {
	 registerpage=new RegisterPage(driver);
	 registerpage.clickOnContinue();
	}

	@Then("User should get create successfull")
	public void user_should_get_create_successfull() {
		
	  Assert.assertTrue(registerpage.displayUserCreatedSuccessfullMsge());
	}

	@Then("User should get warning message about duplicate email")
	public void User_should_get_warning_message_about_duplicate_email() {
		Assert.assertTrue(registerpage.displayDuplicateEmailMsge());
	}

	@When("User do not enter any details")
	public void user_do_not_enter_any_details() {
	   
		registerpage= new RegisterPage(driver);
	}

	@Then("User should get warning messages for every mandatory fields")
	public void user_should_get_warning_messages_for_every_mandatory_fields() {
		registerpage= new RegisterPage(driver);
		Assert.assertTrue(registerpage.displayPrivacyPolicyWarningMsge().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!",registerpage.displayFnameWarningMsge());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerpage.displayLnameWarningMsge());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",registerpage.displayEmailWarningMsge());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerpage.displayTelephoneWarningMsge());
		Assert.assertEquals("Password must be between 4 and 20 characters!",registerpage.displayPasswordWarningMsge());
	}
	
	@When("User enters the details into below fields with existing email")
	public void user_enters_the_details_into_below_fields_with_existing_email(DataTable dataTable) {
		registerpage= new RegisterPage(driver);
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		registerpage.setFirstName(dataMap.get("FirstName"));
		registerpage.setLastName(dataMap.get("LastName"));
		registerpage.setEmailId(dataMap.get("Email"));
		registerpage.setTelephoneNumber(dataMap.get("Telephone"));
		registerpage.setPassword(dataMap.get("Password"));
		registerpage.setCnfPassword(dataMap.get("ConfirmPassowrd"));
		
	}

}
