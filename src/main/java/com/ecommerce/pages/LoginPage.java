package com.ecommerce.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.utilities.LogManager;
import com.ecommerce.utilities.SeleniumUtils;

public class LoginPage {

    private static final Logger logger =
            LogManager.getLogger(LoginPage.class);

    private final SeleniumUtils seleniumUtils;

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.seleniumUtils = new SeleniumUtils(driver);
    }

    public void enterUsername(String username) {
        seleniumUtils.enterText(usernameField, username);
    }

    public void enterPassword(String password) {
        seleniumUtils.enterText(passwordField, password);
    }

    public void clickLogin() {
        seleniumUtils.click(loginButton);
    }

    public void login(String username, String password) {

        logger.info("Login started");

        enterUsername(username);
        enterPassword(password);
        clickLogin();

        logger.info("Login completed successfully");
    }
}