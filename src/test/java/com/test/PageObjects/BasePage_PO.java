package com.test.PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.WebdriverManager.DriverManager;

public class BasePage_PO {
	protected WebDriverWait wait;
	Actions actions;
	protected JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

	public BasePage_PO() {
		PageFactory.initElements(DriverManager.getDriver(), this);
		wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
		actions = new Actions(DriverManager.getDriver());
	}

	public void clickElement(WebElement element) {
		scrollToElement(element);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void scrollToElement(WebElement Element) {
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	public void enterText(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(text);
	}

	public void doubleClickElement(WebElement element) {
		scrollToElement(element);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		actions.doubleClick(element).build().perform();
	}

	public void refresh() {
		DriverManager.getDriver().navigate().refresh();
	}

	public String generateXpathWithOption(String optionXpath, String option) {
		return String.format(optionXpath, option);
	}

	public WebElement getSingleElementFromListOfElements(String locator, boolean useXPathLocator, int elementIndex) {
		java.util.List<WebElement> allElements;
		if (useXPathLocator) {
			allElements = DriverManager.getDriver().findElements(By.xpath(locator));
		} else {
			allElements = DriverManager.getDriver().findElements(By.cssSelector(locator));
		}
		if (elementIndex >= 0 && elementIndex < allElements.size()) {
			return allElements.get(elementIndex);
		} else {
			throw new java.util.NoSuchElementException("Element not found at index: " + elementIndex);
		}
	}

	public boolean verifyElementContainsText(WebElement element, String expectedText) {
		String actualText = element.getText().trim();
		return actualText.contains(expectedText.trim());
	}

	public String getElementText(WebElement element) {
		String actualText = element.getText().trim();
		return actualText;
	}

	public void getBackgroundColor(WebElement element, String expectedBackgroundColor) {
		String actualBGColor = element.getCssValue("background-color");
		System.out.println("Background Color - RGBA Format :" + actualBGColor);
		String expectedBGColor = String.format(expectedBackgroundColor);
		if (actualBGColor.equalsIgnoreCase(expectedBGColor)) {
			Assert.assertTrue(actualBGColor.equalsIgnoreCase(expectedBGColor));
		} else {
			Assert.fail("Background color mismatch: Expected " + expectedBGColor + ", Actual: " + actualBGColor);
		}
	}

	public void validateCurrentURL(String expectedURL) {
		String currentURL = DriverManager.getDriver().getCurrentUrl();// driver.getCurrentURL()

		if (currentURL.contains(expectedURL)) {
			System.out.println("Current URL matches the expected URL: " + expectedURL);
		} else {
			System.out.println("Current URL does not match the expected URL: " + expectedURL);
			Assert.fail("Current URL does not match the expected URL: " + expectedURL);
		}
	}

	public void checkVisibility(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} finally {
			Assert.assertTrue("The Element is not visible", element.isDisplayed());
		}
	}

	public String getFirstSelectedOptionTextInDropdown(WebElement element) {
		Select select = new Select(element);
		WebElement selectedOption = select.getFirstSelectedOption();
		String selectedOptionText = selectedOption.getText();
		System.out.println(selectedOptionText);
		return selectedOptionText.trim();
	}

	public boolean isElementSelected(WebElement element) {
		try {
			return element.isSelected();
		} catch (NoSuchElementException e) {
			System.out.println("Error: Element not found! " + e.getMessage());
			return false;
		}
	}

	public List<String> getListofElementsText(String locator, boolean useXpathLocator) {
		List<String> productNames = new ArrayList<>();
		List<WebElement> productElements;
		try {
			if (useXpathLocator) {
				productElements = DriverManager.getDriver().findElements(By.xpath(locator));
			} else {
				productElements = DriverManager.getDriver().findElements(By.cssSelector(locator));
			}

			for (WebElement productElement : productElements) {
				String productName = productElement.getText().trim();
				productNames.add(productName);
			}
		} catch (NoSuchElementException e) {
			System.out.println("No product elements found using the provided locator: " + locator);
		}

		return productNames;
	}

	public boolean verifyListofElementsText(List<String> expectedProductNames, List<String> actualProductNames) {
		if (expectedProductNames.isEmpty()) {
			System.out.println("No expected product names provided for verification.");
			return false;
		}

		for (String expectedName : expectedProductNames) {
			boolean found = false;
			for (String actualName : actualProductNames) {
				if (actualName.toLowerCase().contains(expectedName.toLowerCase())) {
					found = true;
					break;
				}
			}
			Assert.assertTrue("Expected product name '" + expectedName + "' not found in the actual list.", found);
		}

		return true;
	}

	public void isElementEnabled(WebElement element) {

		boolean elementIsEnabled = element.isEnabled();
		Assert.assertTrue("The Element should be Enabled", elementIsEnabled);
	}

	public void isElementDisabled(WebElement element, boolean checkAttributeDisabled) {
		wait.until(ExpectedConditions.visibilityOf(element));
		if (!checkAttributeDisabled) {
			System.out.println("Element Aria-Disabled Attribute Value:" + element.getAttribute("aria-disabled"));
			Assert.assertEquals("true", element.getAttribute("aria-disabled"));
		} else {
			System.out.println("Element Disabled Attribute Value: " + element.getAttribute("disabled"));
			Assert.assertEquals("true", element.getAttribute("disabled"));
		}
	}
	
	
	public void selectDropDownValue(WebElement element, String howTo, String option) {
		wait.until(ExpectedConditions.visibilityOf(element));
		Select select = new Select(element);
		switch (howTo) {
		case "index":
			select.selectByIndex(Integer.parseInt(option));
			break;
		case "value":
			select.selectByValue(option);
			break;
		case "text":
			select.selectByVisibleText(option);
			break;
		default:
			System.out.println("Please provide a valid selection in the feature file");
			break;
		}
    }
	
	
	

	//Logic for Strings are Ascending or Descending order
	
	public boolean isListSortedAscending(List<String> productNames) {
        for (int i = 1; i < productNames.size(); i++) {
            String previousName = productNames.get(i - 1).toLowerCase();
            String currentName = productNames.get(i).toLowerCase();
            System.out.println("Index Value :"+i+" Previous Name :"+previousName+" Current Name :"+currentName);
            System.out.println(currentName.compareTo(previousName));
            if (currentName.compareTo(previousName) < 0) {
                return false;
            }
        }
        return true;
    }
	
	
	
	public boolean isListSortedDescending(List<String> productNames) {
        for (int i = 1; i < productNames.size(); i++) {
            String previousName = productNames.get(i - 1).toLowerCase(); // Optional: Lowercase for case-insensitive comparison
            String currentName = productNames.get(i).toLowerCase();

            if (currentName.compareTo(previousName) > 0) {
                return false;
            }
        }

        return true;
    }
	
	
	


	
	//Sort Validation for Integer and Double Values
	
	public boolean isListSortedAscendingInteger(List<Double> prices) {
		  for (int i = 1; i < prices.size(); i++) {
		    double previousPrice = prices.get(i - 1);
		    double currentPrice = prices.get(i);

		    if (currentPrice < previousPrice) {
		      return false;
		    }
		  }

		  return true;
		}
	

	public boolean isListSortedDescendingInteger(List<Double> prices) {
		  for (int i = 1; i < prices.size(); i++) {
		    double previousPrice = prices.get(i - 1);
		    double currentPrice = prices.get(i);

		    if (currentPrice > previousPrice) {
		      return false;
		    }
		  }

		  return true;
		}
	
	
	

	public String getStringXpath(String elementXpath,String elementText) {
		
		String elementXpathAsString=String.format(elementXpath, elementText);
		return elementXpathAsString;
	}
	
	
	
	
}
