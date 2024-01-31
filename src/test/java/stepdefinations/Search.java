package stepdefinations;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;

import pages.SearchPage;

public class Search {
	WebDriver driver;
	SearchPage searchPage;
	@Given("User opens the application")
	public void user_opens_the_application() {
		
	  driver= DriverFactory.getDriver();
	  searchPage= new SearchPage(driver);
	}

	@When("User enters valid product {string} into search field")
	public void user_enters_valid_product_into_search_field(String product) {
		
		searchPage.enterProductInSearchField(product);
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
	  
		searchPage.clickOnSearchButton();	
		
	 
	}

	@Then("User should get the valid product displayed in search results")
	public void user_should_get_the_valid_product_displayed_in_search_results() {
		
	   Assert.assertEquals("HP LP3065", searchPage.dispalyProductResult());
	}

	@When("User enters invalid product {string} into search field")
	public void user_enters_invalid_product_into_search_field(String invalid_Product) {
		searchPage.enterProductInSearchField(invalid_Product);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		Assert.assertEquals("There is no product that matches the search criteria.", searchPage.noProductAvialMessage());
		
	}

	@When("User do not enter any product")
	public void user_do_not_enter_any_product() {
		
	  searchPage.enterProductInSearchField("");

	}

}
