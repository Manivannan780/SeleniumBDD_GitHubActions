package com.test.Stepdefinitions;

import com.test.ConstantValues.Constants;
import com.test.PageObjects.LoginPage_PO;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage_Steps {

	@When("Fill the username and password and Click login {string} {string},{string}")
	public void fill_the_username_and_password_and_click_login(String scenarioIs, String userName, String passWord) {

		if (scenarioIs.equalsIgnoreCase("Invalid UserName")) {
			passWord = Constants.LoginPassword;
			LoginPage_PO.getInstance().enterCredentails(userName, passWord);
		} else if (scenarioIs.equalsIgnoreCase("Invalid Password")) {
			userName = Constants.LoginUserName;
			LoginPage_PO.getInstance().enterCredentails(userName, passWord);

		} else if (scenarioIs.equalsIgnoreCase("Empty Credentials")) {
			System.out.println("Select Login Button");
		} else if (scenarioIs.equalsIgnoreCase("Valid")) {
			userName = Constants.LoginUserName;
			passWord = Constants.LoginPassword;
			LoginPage_PO.getInstance().enterCredentails(userName, passWord);
		}

		LoginPage_PO.getInstance().selectLoginBTN();

	}

	@Then("Check the validation error message is correctly displayed {string}")
	public void check_the_validation_error_message_is_correctly_displayed(String errorMessage) {

		LoginPage_PO.getInstance().checkLoginErrorMessage(errorMessage);

	}

}
