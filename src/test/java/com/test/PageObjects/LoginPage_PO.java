package com.test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class LoginPage_PO extends BasePage_PO {

	private static LoginPage_PO logininstance;

	private LoginPage_PO() {
		System.out.println("Instance Constructor");
	}

	public static LoginPage_PO getInstance() {
		if (logininstance == null)
			logininstance = new LoginPage_PO();
		return logininstance;
	}

	@FindBy(xpath = "//input[@id='user-name']")
	private WebElement userNameInputField;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordInputField;

	@FindBy(xpath = "//input[@id='login-button']")
	private WebElement loginBTN;

	@FindBy(xpath = "//div[@id='login_credentials']")
	private WebElement loginCredentialsSection;

	@FindBy(xpath = "//div[@class='login_password']")
	private WebElement loginPasswordSection;

	@FindBy(css = "h3[data-test='error']")
	private WebElement loginErrorMessage;

	@FindBy(css = "h3[data-test='error'] button[class='error-button']")
	private WebElement loginErrorBTN;

	public void enterCredentails(String userName, String passWord) {
		this.checkLoginInputFieldsIsDisplayed();
		this.enterText(userNameInputField, userName);
		this.enterText(passwordInputField, passWord);
	}

	public void selectLoginBTN() {
		this.clickElement(loginBTN);
	}

	public void checkCurrentURL(String expectedURL) {
		this.validateCurrentURL(expectedURL);
	}

	public void checkLoginInputFieldsIsDisplayed() {
		this.checkVisibility(userNameInputField);
		this.checkVisibility(passwordInputField);
		this.checkVisibility(loginBTN);
	}

	public void checkLoginCredentialsSectionIsDisplayed() {
		this.checkVisibility(loginCredentialsSection);
		this.checkVisibility(loginPasswordSection);
	}

	public void checkloginBTNColor(String expectedColor) {
		this.getBackgroundColor(loginBTN, expectedColor);
	}

	public void checkLoginErrorMessage(String errroMessage) {
		this.checkVisibility(loginErrorBTN);
		this.checkVisibility(loginErrorMessage);
		String loginError = this.getElementText(loginErrorMessage);
		System.out.println(loginError);
		String expectedError = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(errroMessage, loginError);

	}
	
	
	
	

}
