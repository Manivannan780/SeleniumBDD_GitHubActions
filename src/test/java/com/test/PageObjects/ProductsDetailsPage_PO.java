package com.test.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.WebdriverManager.DriverManager;

import junit.framework.Assert;

public class ProductsDetailsPage_PO extends BasePage_PO {

	private static ProductsDetailsPage_PO productsDetailPageInstance;

	private ProductsDetailsPage_PO() {
		System.out.println("Private Constructor for Products Details Page PO");
	}

	public static ProductsDetailsPage_PO getInstance() {
		if (productsDetailPageInstance == null) {
			productsDetailPageInstance = new ProductsDetailsPage_PO();
		}

		return productsDetailPageInstance;

	}

	@FindBy(xpath = "//button[text()='ADD TO CART']")
	private WebElement addCartBTNInProductsDetailsPage;

	@FindBy(xpath = "//div[@class='inventory_details_price']")
	private WebElement productPriceInProductsDetailsPage;

	@FindBy(xpath = "//div[@class='inventory_details_desc']")
	private WebElement productDescriptionInProductsDetailsPage;

	@FindBy(xpath = "//div[@class='inventory_details_name']")
	private WebElement productNameInProductsDetailsPage;

	@FindBy(xpath = "//div/button[@class='inventory_details_back_button']")
	private WebElement backBTNInProductsDetailsPage;

	@FindBy(xpath = "//button[text()='REMOVE']")
	private WebElement removeBTNInProductsDetailsPage;
	
	protected String productTitleLink="//div[@class='inventory_item_name'] [contains(text(),\"%s\")]";
	
	
	public void selectProductTitleLink(String productName) {

		String productTitleLocator = this.getStringXpath(this.productTitleLink, productName);
		WebElement productTitleEle=DriverManager.getDriver().findElement(By.xpath(productTitleLocator));
		this.clickElement(productTitleEle);
	}
	
	public void selectAddToCartBTNInProductsDetailsPage() {
		this.clickElement(addCartBTNInProductsDetailsPage);	
	}
	
	
	public void selectRemoveBTNInProductsDetailsPage() {
		this.clickElement(removeBTNInProductsDetailsPage);	
	}
	
	
	public void checkRemoveBTNVisiblityInProductsDetailsPage() {
		this.checkVisibility(removeBTNInProductsDetailsPage);
	}
	
	
	public void checkAddCARTBTNVisiblityInProductsDetailsPage() {
		this.checkVisibility(addCartBTNInProductsDetailsPage);
	}
	
	
	public void checkElementsareDisplayedInProductsDetailsPage() {
		this.checkVisibility(productPriceInProductsDetailsPage);
		this.checkVisibility(productDescriptionInProductsDetailsPage);
		this.checkVisibility(productNameInProductsDetailsPage);
		this.checkVisibility(backBTNInProductsDetailsPage);
	}
	
	
	
	public void checkProductPriceInProductDetailsPage(String productPriceExpected){
		
		String productPriceTextInProductDetailsPage=this.getElementText(productPriceInProductsDetailsPage);
		String expectedProductPriceText=productPriceExpected;
		Assert.assertEquals(expectedProductPriceText,productPriceTextInProductDetailsPage);	
	}
	
	
	public void checkProductNameInProductDetailsPage(String expectedProductName) {

		String productNameTextInProductDetailsPage = this.getElementText(productNameInProductsDetailsPage);
		String expectedProductNameText = expectedProductName;
		Assert.assertEquals(expectedProductNameText, productNameTextInProductDetailsPage);
	}
	

	public void checkProductDescriptionInProductDetailsPage(String expectedProductDescription) {

		String productDescriptionTextInProductDetailsPage = this.getElementText(productDescriptionInProductsDetailsPage);
		String expectedProductDescriptionText = expectedProductDescription;
		Assert.assertEquals(expectedProductDescriptionText, productDescriptionTextInProductDetailsPage);
	}

	
	
	
	
	
	
	
	
	
	

	
	
	
	

}
