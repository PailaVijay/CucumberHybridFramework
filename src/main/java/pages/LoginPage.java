package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
   public  WebDriver driver;
	
    
    public LoginPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    }
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement getEmailId;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement getPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement ClickOnLoginButton;
	
	
	
	
	public void setEmailId(String email)
	{
		getEmailId.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		getPassword.sendKeys(password);
	}
	
	public void clickOnLoginButton()
	{
		ClickOnLoginButton.click();
	}
	
	
	
}
