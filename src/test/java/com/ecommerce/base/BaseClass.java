package com.ecommerce.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ecommerce.driver.DriverFactory;

public class BaseClass {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverFactory.initializeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        WebDriver driver = DriverFactory.getDriver();

        if (driver != null) {
            driver.quit();
            DriverFactory.unloadDriver();
        }
    }
}