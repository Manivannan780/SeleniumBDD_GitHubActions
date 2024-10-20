package com.test.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.WebdriverManager.DriverManager;

import junit.framework.Assert;

public class ProductsPage_PO extends BasePage_PO {

	private static ProductsPage_PO productsPageinstance;

	private ProductsPage_PO() {
		System.out.println("ProductsPage_PO Instance Constructor");
	}

	public static ProductsPage_PO getInstance() {
		if (productsPageinstance == null) {
			productsPageinstance = new ProductsPage_PO();
		}
		return productsPageinstance;
	}

	@FindBy(xpath = "//div[@class='bm-burger-button']/button")
	private WebElement hamburgerBTNInProductsPage;

	@FindBy(xpath = "//div[@id='inventory_container']//div[@class='inventory_item_name']")
	private WebElement productNamesInProductsPage;

	protected String productsNamesTextInProductsPage = "//div[@id='inventory_container']//div[@class='inventory_item_name']";

	protected String productsPriceTextInProductsPage = "//div[@id='inventory_container']//div[@class='inventory_item_price']";

	@FindBy(css = "div[id='header_container'] div[class='app_logo']")
	private WebElement applicationLogo;

	@FindBy(xpath = "//div[@id='inventory_container']//div[@class='inventory_item_desc']")
	private WebElement productDescriptionInProductsPage;

	@FindBy(xpath = "//div[@id='inventory_container']//div[@class='pricebar']")
	private WebElement productPriceInProductsPage;

	@FindBy(xpath = "//div[@class='inventory_item_name'][text()='Sauce Labs Backpack']")
	private WebElement singleProductName;

	@FindBy(css = "nav a[id='logout_sidebar_link']")
	private WebElement logoutBTN;

	@FindBy(xpath = "//button[text()='ADD TO CART']")
	private WebElement addCartBTNInProductsPage;

	@FindBy(css = "[id='shopping_cart_container'] span[class*='fa-layers-counter']")
	private WebElement productCartCount;

	protected String addToCartBTNElements = "//button[text()='ADD TO CART']";

	protected String removeBTNElements = "//button[text()='REMOVE']";

	
	public void checkProductNameText(String expectedText) {

		String actualText = this.getElementText(singleProductName);
		Assert.assertEquals("Expected text: '" + expectedText + "', Actual text: '" + actualText, expectedText,
				actualText);
	}

	public void checkProductNamesTextIsDisplayed(List<String> expectedProductNames) {

		List<String> productsText = this.getListofElementsText(productsNamesTextInProductsPage, true);
		this.verifyListofElementsText(expectedProductNames, productsText);
	}

	public void checkProductsPageElementsState() {
		this.checkVisibility(applicationLogo);
		this.checkVisibility(singleProductName);
	}

	public void logoutApplication() {
		hamburgerBTNInProductsPage.click();
		this.clickElement(logoutBTN);
	}

	@FindBy(css = "select[class='product_sort_container']")
	private WebElement productSortDropdown;

	public void selectProductsSortDropdown(String selectOptionBy, String option) {
		this.selectDropDownValue(productSortDropdown, selectOptionBy, option);
	}

	public void checkProductsNameIsSorted(String expectedSortOption) {

		boolean isSorted = false;
		List<String> productsText = this.getListofElementsText(productsNamesTextInProductsPage, true);

		if (expectedSortOption.equalsIgnoreCase("A to Z")) {
			isSorted = this.isListSortedAscending(productsText);
		} else if (expectedSortOption.equalsIgnoreCase("Z to A")) {

			isSorted = this.isListSortedDescending(productsText);
		} else {
			System.out.println("Invalid sort option: " + expectedSortOption);
		}

		System.out.println("Products are sorted " + (isSorted ? "as expected" : "incorrectly"));
		Assert.assertTrue("Names are not sorted as Expected", isSorted);
	}

	public void checkProductsPriceIsSorted(String expectedSortOption) {

		boolean isSorted = false;
		List<String> productsText = this.getListofElementsText(productsPriceTextInProductsPage, true);

		List<Double> productsPrice = new ArrayList<>();

		for (String productsPriceText : productsText) {

			String priceString = productsPriceText.substring(1);
			double price = Double.parseDouble(priceString);

			productsPrice.add(price);
		}
		System.out.println("Products Price : " + productsPrice);

		if (expectedSortOption.equalsIgnoreCase("Low to High")) {
			isSorted = this.isListSortedAscendingInteger(productsPrice);
		} else if (expectedSortOption.equalsIgnoreCase("High to Low")) {

			isSorted = this.isListSortedDescendingInteger(productsPrice);
		} else {
			System.out.println("Invalid sort option: " + expectedSortOption);
		}
		System.out.println("Products are sorted " + (isSorted ? "as expected" : "incorrectly"));
		Assert.assertTrue("Names are not sorted as Expected", isSorted);
	}

	public void selectAddToCartBTN() {
		this.clickElement(addCartBTNInProductsPage);
	}

	public void selectAddToCartBTNInProductsPage(String elementIndex) {
		int elementIndexPosition = Integer.parseInt(elementIndex);
		WebElement addCartBTN = this.getSingleElementFromListOfElements(addToCartBTNElements, true,
				elementIndexPosition);
		this.clickElement(addCartBTN);
	}

	public void checkRemoveButtonVisibility(String elementIndex) {
		int elementIndexPosition = Integer.parseInt(elementIndex);
		WebElement removeBTN = this.getSingleElementFromListOfElements(removeBTNElements, true, elementIndexPosition);
		this.checkVisibility(removeBTN);
	}

	public void selectRemoveButtonVisibility(String elementIndex) {
		int elementIndexPosition = Integer.parseInt(elementIndex);
		WebElement removeBTN = this.getSingleElementFromListOfElements(removeBTNElements, true, elementIndexPosition);
		this.clickElement(removeBTN);
	}

	public void validateTheProductCountIsDisplayedInProductCart(String expectedCountText) {

		String productCountText = this.getElementText(productCartCount);
		System.out.println(productCountText);
		Assert.assertEquals(expectedCountText, productCountText);
	}
	
		
	
	

}
