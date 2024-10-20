package com.test.Stepdefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.test.CommonOperations.CommonUtils;
import com.test.ConstantValues.Constants;
import com.test.WebdriverManager.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CommonSteps {
	
		
	private static final Logger LOGGER=LogManager.getLogger(CommonSteps.class); 
	
	CommonUtils commonutils=new CommonUtils();
	
	@Before
	public void beforeScenario() {
		
		
		commonutils.loadConfigProperties();
		System.out.println("Properties Loaded");
		try {
			
			if(DriverManager.getDriver()==null) {
				System.out.println("Execution Started The browser is opening");
				DriverManager.launchBrowser();
				commonutils.initElements();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	@AfterStep
	public void af(Scenario scenario) throws IOException, InterruptedException
	{
	    if(scenario.isFailed()) 	
	    {		       
	        scenario.attach(commonutils.getByteScreenshot(), "image/png", scenario.getName());

	    }
		
	}
	
	
//	
//	@After
//	public void afterScenario() {
//		DriverManager.closeBrowser();
//	}
//	
	
}
