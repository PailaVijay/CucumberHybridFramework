package stepdefinations;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login  {
	
	public WebDriver driver;
	 LoginPage lp;
	 HomePage hp;
	 AccountPage ap;
	 
    @Given("User has navigate to login page")
	public void user_has_navigate_to_login_page()
	{
    	
    	driver=DriverFactory.getDriver();
    	hp= new HomePage(driver);
    	
    	hp.clickMyAccountMenu();
    	hp.clickOnLoginDropMenu();

	}
    @When("^User has to enter the valid emailId (.+)$")
    public void user_has_to_enter_the_valid_email_id(String emailId) {
       
    	lp= new LoginPage(driver);
    	lp.setEmailId(emailId);
    }

    @When("^User has to enter the valid password (.+)$")
    public void user_has_to_enter_the_valid_password(String password) {
    	lp.setPassword(password);
    }


    @When("User has to click on login button")
    public void user_has_to_click_on_login_button() {
    	
    	lp.clickOnLoginButton();
    }
    

    @Then("User should get logged in and taken to the My Account page")
    public void user_should_get_logged_in_and_taken_to_the_my_account_page() {
    	ap= new AccountPage(driver);
    	Assert.assertTrue(ap.dispalyEditYourAccountInformation());
    	
    } 

    @When("User has to enter invalid emailId")
    public void user_has_to_enter_invalid_email_id() {
    	lp=new LoginPage(driver);
    	lp.setEmailId(CommonUtils.getEmailWithTimeStamp());
    	
    }
    
    @When("User has to enter invalid password {string}")
    public void user_has_to_enter_invalid_password(String invalid_password) {
       
    	lp.setPassword(invalid_password);
    	
    }
    
    @Then("User should get the warning message")
    public void user_should_get_the_warning_message_like() {
       
    	Assert.assertTrue(hp.loginWarningMessage());
    }

    @When("User has to enter valid password {string}")
    public void user_has_to_enter_valid_password(String valid_password) {
    	lp.setPassword(valid_password);
    }

    @When("User has to enter valid emailId {string}")
    public void user_has_to_enter_valid_email_id(String valid_email) {
    	lp= new LoginPage(driver);
    	lp.setEmailId(valid_email);
    }

    @When("User dont enter emailId into the email field")
    public void user_dont_enter_email_id_into_the_email_field() {
    	
    	lp= new LoginPage(driver);
    	lp.setEmailId("");
    }

    @When("User dont enter password into the password field")
    public void user_dont_enter_password_into_the_password_field() {
    	
    	lp.setPassword("");
    	
    }

   
}
