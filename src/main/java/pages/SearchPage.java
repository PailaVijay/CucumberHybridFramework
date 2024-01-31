package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	public WebDriver driver;
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[contains(@class,'input-lg')]")
	private WebElement SearchField;
	
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement SearchButton;
	
	@FindBy(xpath="//a[contains(text(),'HP LP3065')]")
	private WebElement ProductDisplay;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement DisplayNoProduct;
	
	public void enterProductInSearchField(String prod)
	{
		SearchField.sendKeys(prod);
	}
	
	public void clickOnSearchButton()
	{
		SearchButton.click();
	}
	
	public String dispalyProductResult()
	{
		return ProductDisplay.getText();
	}
	
	public String noProductAvialMessage()
	{
		return DisplayNoProduct.getText();
	}
}
