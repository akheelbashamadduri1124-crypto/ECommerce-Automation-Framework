package com.ecommerce.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.driver.DriverFactory;
import com.ecommerce.utilities.LogManager;
import com.ecommerce.utilities.SeleniumUtils;

public class CheckOutPage {

    private static final Logger logger =
            LogManager.getLogger(CheckOutPage.class);

    private final SeleniumUtils seleniumUtils;

    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");

    private final By orderConfirmationMessage =
            By.className("complete-header");

    public CheckOutPage(WebDriver driver) {
        this.seleniumUtils = new SeleniumUtils(driver);
    }

    public void enterFirstName(String firstName) {
        seleniumUtils.enterText(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        seleniumUtils.enterText(lastNameField, lastName);
    }

    public void enterPostalCode(String postalCode) {
        seleniumUtils.enterText(postalCodeField, postalCode);
    }

    public void clickContinue() {
        seleniumUtils.click(continueButton);
        logger.info("Checkout information submitted");
        logger.info("Checkout URL after continue:{}",DriverFactory.getDriver().getCurrentUrl());
       // seleniumUtils.waitUntilVisible(finishButton);
    }

    public void clickFinish() {
        seleniumUtils.click(finishButton);
        logger.info("Order finish button clicked");
    }

    public void completeCheckoutInformation(
            String firstName,
            String lastName,
            String postalCode) {

        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
        clickContinue();
    }

    public String getOrderConfirmationMessage() {

        String confirmationMessage =
                seleniumUtils.getText(orderConfirmationMessage);

        logger.info("Order confirmation received: {}",
                confirmationMessage);

        return confirmationMessage;
    }
}