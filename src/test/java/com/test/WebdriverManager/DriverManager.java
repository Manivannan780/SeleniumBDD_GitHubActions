package com.test.WebdriverManager;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.test.ConstantValues.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);

	private static WebDriver driver = null;
	 

	public static WebDriver getDriver() {
		return driver;
	}

	
	public static void launchBrowser() {

		try {

			switch (Constants.BrowserName) {
			case "Chrome":
				WebDriverManager.chromedriver().setup();
				// System.setProperty(Constants.ChromeDriver, Constants.ChromeDriverLocation);
				LOGGER.info("Launching the Browser " + Constants.BrowserName);
				driver = new ChromeDriver();
	            ChromeOptions chromeOptions = new ChromeOptions();
	            chromeOptions.addArguments("window-size=1920,1080", "headless");
				break;
			case "FireFox":
				WebDriverManager.firefoxdriver().setup();
				LOGGER.info("Launching the Browser " + Constants.BrowserName);
				driver = new FirefoxDriver();
				FirefoxOptions fireFoxOptions = new FirefoxOptions();
				fireFoxOptions.addArguments("window-size=1920,1080", "headless");
				break;
			case "Edge":
				WebDriverManager.edgedriver().setup();
				LOGGER.info("Launching the Browser " + Constants.BrowserName);
				driver = new EdgeDriver();
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.addArguments("window-size=1920,1080", "headless");
				break;
			default:
				WebDriverManager.chromedriver().setup();
				// System.setProperty(Constants.ChromeDriver, Constants.ChromeDriverLocation);
				LOGGER.info("Launching the Browser " + Constants.BrowserName);
				driver = new ChromeDriver();
				ChromeOptions chromeDefaultOptions = new ChromeOptions();
				chromeDefaultOptions.addArguments("window-size=1920,1080", "headless");
				break;
			}

		} catch (Exception e) {

		}

	}
	
	
	
	
	
	
	public static void closeBrowser() {
		
		driver.quit();
	}
	
	

}
