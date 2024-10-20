package com.test.Stepdefinitions;

import java.util.List;

import com.test.ConstantValues.Constants;
import com.test.PageObjects.BasePage_PO;
import com.test.PageObjects.LoginPage_PO;
import com.test.PageObjects.ProductsPage_PO;
import com.test.WebdriverManager.DriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsPage_Steps  {

	@Given("Launch the application")
	public void launch_the_application() {
		DriverManager.getDriver().get(Constants.App_URL);
		System.out.println("Browser Launched");
	}

	@Then("User checks if the login page contents are displayed properly")
	public void user_checks_if_the_login_page_contents_are_displayed_properly() {
		LoginPage_PO.getInstance().checkLoginInputFieldsIsDisplayed();
		LoginPage_PO.getInstance().checkLoginCredentialsSectionIsDisplayed();
		LoginPage_PO.getInstance().checkloginBTNColor("rgb(226, 35, 26)");
	}

	@When("Enter the username and password and click login")
	public void enter_the_username_and_password_and_login() {

		LoginPage_PO.getInstance().enterCredentails(Constants.LoginUserName, Constants.LoginPassword);
		LoginPage_PO.getInstance().selectLoginBTN();
		LoginPage_PO.getInstance().checkCurrentURL("/inventory.html");

	}

	@Then("Check the Products title are displayed")
	public void check_the_products_title_are_displayed() {
		String expectedProductName = "Sauce Labs Backpack";
		ProductsPage_PO.getInstance().checkProductNameText(expectedProductName);
	}

	@Then("Check the Products Names are displayed correctly")
	public void check_the_products_names_are_displayed_correctly(io.cucumber.datatable.DataTable dataTable) {

		List<String> expectedProductNames = dataTable.asList();
		System.out.println(expectedProductNames);
		ProductsPage_PO.getInstance().checkProductNamesTextIsDisplayed(expectedProductNames);

	}

	@Then("Check the Page title and other elements are displayed")
	public void check_the_page_title_and_other_elements_are_displayed() {
		ProductsPage_PO.getInstance().validateCurrentURL("/inventory.html");
		ProductsPage_PO.getInstance().checkProductsPageElementsState();
	}
	

	@And("Logout the Application")
	public void logout_the_application() {

		ProductsPage_PO.getInstance().logoutApplication();
		LoginPage_PO.getInstance().checkLoginInputFieldsIsDisplayed();
		LoginPage_PO.getInstance().checkLoginCredentialsSectionIsDisplayed();
		LoginPage_PO.getInstance().checkloginBTNColor("rgb(226, 35, 26)");
	}

	
	@Then("User selects the products sort dropdown option {string} {string}")
	public void user_selects_the_products_sort_dropdown_option(String selectOptionBy, String option) {
		ProductsPage_PO.getInstance().selectProductsSortDropdown(selectOptionBy, option);
	}
	
	
    @Then ("Check that the product names are sorted based on the user selection in the products dropdown {string}")
    public void check_that_the_product_names_are_sorted_based_on_the_selection_in_the_products_dropdown(String expectedSortOption) {
    	ProductsPage_PO.getInstance().checkProductsNameIsSorted(expectedSortOption);	
    }
    
  
    @Then ("Check that the product prices are sorted based on the user selection in the products dropdown {string}")
    public void check_that_the_product_prices_are_sorted_based_on_the_selection_in_the_products_dropdown(String expectedSortOption) {
    	
    	ProductsPage_PO.getInstance().checkProductsPriceIsSorted(expectedSortOption);
    }
  
	
	@And("User clicks on the Add to Cart button")
	public void user_clicks_on_the_add_to_cart_button() {
		ProductsPage_PO.getInstance().selectAddToCartBTN();
	}
	
	
	@And("User clicks on the Add Cart button On the Products page {string}")
	public void user_clicks_on_the_add_cart_button_on_the_products_page(String elementIndex) {
		ProductsPage_PO.getInstance().selectAddToCartBTNInProductsPage(elementIndex);
	}
	
	
	@Then("Check if the Add to Cart button has changed to the Remove button after clicking the Add to Cart button {string}")
	public void check_if_the_add_to_cart_button_has_changed_to_the_remove_button_after_clicking_the_add_to_cart_button(String elementIndex) {
		
		ProductsPage_PO.getInstance().checkRemoveButtonVisibility(elementIndex);
		
	}
	
	
	@Then("Verify that the cart icon displays the count of products added to the cart {string}")
	public void verify_that_the_cart_icon_displays_the_count_of_products_added_to_the_cart(
			String expectedProductCountText) {
		ProductsPage_PO.getInstance().validateTheProductCountIsDisplayedInProductCart(expectedProductCountText);
		
	}
	
	
	
	
	
	
	
}
