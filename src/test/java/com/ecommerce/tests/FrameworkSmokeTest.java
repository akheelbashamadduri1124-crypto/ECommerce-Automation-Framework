package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.driver.DriverFactory;

public class FrameworkSmokeTest extends BaseClass {

    @Test
    public void verifyBrowserLaunch() {

        Assert.assertNotNull(
                DriverFactory.getDriver(),
                "WebDriver was not initialized.");
    }
}