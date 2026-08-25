package com.ecommerce.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumUtils {

    private final WebDriver driver;
	
    private final WaitUtils waitUtils;

    public SeleniumUtils(WebDriver driver) {
    	this.driver=driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void click(By locator) {
        waitUtils.waitForElementClickable(locator).click();
    }

    public void enterText(By locator, String text) {
        WebElement element = waitUtils.waitForElementVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return waitUtils.waitForElementVisible(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        try {
            return waitUtils.waitForElementVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public void waitUntilVisible(By locator) {
    	waitUtils.waitForVisibility(locator);
    }
    public int getElementsCount(By locator) {
    	return driver.findElements(locator).size();
    }
}