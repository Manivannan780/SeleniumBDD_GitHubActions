package com.test.Stepdefinitions;

import com.test.PageObjects.BasePage_PO;
import com.test.PageObjects.ProductsDetailsPage_PO;
import com.test.PageObjects.ProductsPage_PO;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ProductDetailsPage_Steps extends BasePage_PO {
	
	@And("User clicks the Product title link on the Products page {string}")
	public void user_clicks_the_product_title_link_on_the_products_page(String productName) {
		
		ProductsDetailsPage_PO.getInstance().selectProductTitleLink(productName);
	}
	
	
	@And("Check that Product detail page elements are displayed correctly and interactable")
    public void check_that_product_detail_page_elements_are_displayed_correctly_and_interactable() {

		ProductsDetailsPage_PO.getInstance().checkElementsareDisplayedInProductsDetailsPage();
		
	}
	
	
	@And("User clicks on the Add Cart button on the Products details page")
	public void user_clicks_on_the_add_cart_button_on_the_products_details_page() {
		ProductsDetailsPage_PO.getInstance().selectAddToCartBTNInProductsDetailsPage();
	}
	
	
	@Then("Check if the Add to Cart button has changed to the Remove button after clicking the Add to Cart button on the Products Detail page")
	public void check_if_the_add_to_cart_button_has_changed_to_the_remove_button_after_clicking_the_add_to_cart_button_on_the_products_detail_page() {
		ProductsDetailsPage_PO.getInstance().checkRemoveBTNVisiblityInProductsDetailsPage();
	}
	
	
	@Then("Check if the Product name is displayed correctly {string}")
	public void check_if_the_product_name_is_displayed_correctly(String productName) {		
		ProductsDetailsPage_PO.getInstance().checkProductNameInProductDetailsPage(productName);
	}
	
	
	@Then("Check if the Product Description is displayed correctly {string}")
	public void check_if_the_product_description_is_displayed_correctly(String productDescription) {		
		ProductsDetailsPage_PO.getInstance().checkProductDescriptionInProductDetailsPage(productDescription);
	}
	
	@Then("Check if the Product Price is displayed correctly {string}")
	public void check_if_the_product_price_is_displayed_correctly(String productPrice) {		
		ProductsDetailsPage_PO.getInstance().checkProductPriceInProductDetailsPage(productPrice);
	}
	
	
	@And("User clicks on the product Remove button on the products details page")
	public void user_clicks_on_the_remove_button_on_the_products_details_page() {
		ProductsDetailsPage_PO.getInstance().selectRemoveBTNInProductsDetailsPage();
	}
	
	
	
	@Then("Check if the Remove button has changed to the Add to Cart button after clicking the Remove button on the Products Detail page")
	public void check_if_the_remove_button_has_changed_to_the_add_to_cart_button_after_clicking_the_remove_button_on_the_products_detail_page() {
		ProductsDetailsPage_PO.getInstance().checkAddCARTBTNVisiblityInProductsDetailsPage();	
	}
	
	


}
