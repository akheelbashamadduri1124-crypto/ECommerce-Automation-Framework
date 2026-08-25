package com.ecommerce.tests;
import com.ecommerce.retry.RetryAnalyzer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.config.ConfigReader;
import com.ecommerce.dataproviders.TestDataProvider;
import com.ecommerce.driver.DriverFactory;
import com.ecommerce.pages.LoginPage;

public class LoginTest extends BaseClass {

    @Test(
        dataProvider = "loginData",
        dataProviderClass = TestDataProvider.class,
        groups = {"smoke","regression"},
        retryAnalyzer=RetryAnalyzer.class
    )
    public void verifyValidLogin(String username, String password) {

        ConfigReader configReader = new ConfigReader();

        DriverFactory.getDriver().get(
                configReader.getProperty("url"));

        LoginPage loginPage =
                new LoginPage(DriverFactory.getDriver());

        loginPage.login(username, password);

        String currentUrl =
                DriverFactory.getDriver().getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("inventory"),
                "Login failed for user: " + username
        );
    }
}