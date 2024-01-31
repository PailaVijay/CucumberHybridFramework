package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	public WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement FirstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement LastNameField;
	
	@FindBy(id="input-email")
	private WebElement EmailIdField;
	
	@FindBy(id="input-telephone")
	private WebElement TelephoneField;
	
	@FindBy(id="input-password")
	private WebElement PasswordField;
	
	@FindBy(id="input-confirm")
	private WebElement ConfirmPasswordField;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	private WebElement NewsLetterRadioBtn;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement privacyPolicyCheckbox;
	
	@FindBy(xpath="//input[contains(@class,'btn-primary')]")
	private WebElement clickOnContinueBtn;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	private WebElement UsercreatedSuccessfullMessage;
	
	@FindBy(xpath="//div[contains( text(),'Warning: E-Mail Address is already registered!')]")
	private WebElement duplicateEmail;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement PrivacyPolicyWarningMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement FnameWarningMessage;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement LnameWarningMessage;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement EmailWarningMessage;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement TelephoneWarningMessage;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement PasswordWarningMessage;
	
	
	public void setFirstName(String Fname)
	{
		FirstNameField.sendKeys(Fname);
	}
	
	public void setLastName(String Lname)
	{
		LastNameField.sendKeys(Lname);
	}
	
	public void setEmailId(String emailId)
	{
		EmailIdField.sendKeys(emailId);
	}
	
	public void setTelephoneNumber(String phno)
	{
		TelephoneField.sendKeys(phno);
	}
	
	public void setPassword(String pswd)
	{
		PasswordField.sendKeys(pswd);
	}
	
	public void setCnfPassword(String cPswd)
	{
		ConfirmPasswordField.sendKeys(cPswd);
	}
	
	public void clickNewslLetter()
	{
		NewsLetterRadioBtn.click();
	}
	
	public void clickOnPrivacyPolicyCheckBox()
	{
		privacyPolicyCheckbox.click();
	}
	
	public void clickOnContinue()
	{
		clickOnContinueBtn.click();
	}
	
	public boolean displayUserCreatedSuccessfullMsge()
	{
		return UsercreatedSuccessfullMessage.isDisplayed();
	}
	
	public boolean displayDuplicateEmailMsge()
	{
		return duplicateEmail.isDisplayed();
	}
	
	public String displayTelephoneWarningMsge()
	{
		return TelephoneWarningMessage.getText();
	}
	
	public String displayPasswordWarningMsge()
	{
		return PasswordWarningMessage.getText();
	}
	
	public String displayEmailWarningMsge()
	{
		return EmailWarningMessage.getText();
	}
	public String displayLnameWarningMsge()
	{
		return LnameWarningMessage.getText();
	}
	public String displayFnameWarningMsge()
	{
		return FnameWarningMessage.getText();
	}
	public String displayPrivacyPolicyWarningMsge()
	{
		return PrivacyPolicyWarningMessage.getText();
	}
	
}
