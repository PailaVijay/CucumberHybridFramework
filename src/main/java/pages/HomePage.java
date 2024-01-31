package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

	public WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils= new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginDropdown;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement noMatchForEmailAndPassword;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement RegisterDropdown;
	
	public void clickMyAccountMenu()
	{
		elementUtils.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void clickOnLoginDropMenu()
	{
		loginDropdown.click();
	}
	
	public boolean loginWarningMessage()
	{
		return elementUtils.displaystatusOfElement(noMatchForEmailAndPassword, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void clickOnRegisterDropdown()
	{
		RegisterDropdown.click();
	}
	
}
